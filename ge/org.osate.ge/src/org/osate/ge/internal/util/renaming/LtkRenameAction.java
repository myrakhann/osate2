package org.osate.ge.internal.util.renaming;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ltk.ui.refactoring.RefactoringUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.ModelChangeNotifier.Lock;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.util.RenameUtil;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class LtkRenameAction implements AgeAction {
	private final ProjectProvider projectProvider;
	private final ModelChangeNotifier modelChangeNotifier;
	private final BusinessObjectSupplier boSupplier;
	private final String originalName;
	private final String newName;

	public static interface BusinessObjectSupplier {
		/**
		 * Returns the business object that should be renamed based on its current name
		 * @param currentName is the current name of the object
		 * @return the business object to rename
		 */
		EObject getBusinessObject(final String currentName);
	}

	public LtkRenameAction(final ProjectProvider projectProvider, final ModelChangeNotifier modelChangeNotifier,
			final BusinessObjectSupplier boSupplier,
			final String newName, final String originalName) {
		this.projectProvider = Objects.requireNonNull(projectProvider, "projectProvider must not be null");
		this.modelChangeNotifier = Objects.requireNonNull(modelChangeNotifier, "modelChangeNotifier must not be null");
		this.boSupplier = Objects.requireNonNull(boSupplier, "boSupplier must not be null");
		this.newName = newName;
		this.originalName = originalName;
	}

	@Override
	public boolean canExecute() {
		return boSupplier.getBusinessObject(originalName) != null && newName != null;
	}

	@Override
	public boolean isValid() {
		return boSupplier.getBusinessObject(originalName) != null;
	}

	@Override
	public AgeAction execute() {
		final EObject bo = (EObject) boSupplier.getBusinessObject(originalName);
		if (bo == null) {
			throw new RuntimeException("Unable to retrieve business object to rename.");
		}

		return renameWithLtk(bo, newName)
				? new LtkRenameAction(projectProvider, modelChangeNotifier, boSupplier, originalName, newName)
						: null;
	}

	/**
	 * Returns true if the rename occurred
	 * @param bo
	 * @param value
	 * @return
	 */
	private boolean renameWithLtk(final EObject bo, final String value) {
		// TODO: Remove when issue regarding Xtext Dirty State has been resolved.
		// https://github.com/osate/osate-ge/issues/210
		// This works around the issue by saving the resource before trying to refactor.
		if (bo instanceof EObject) {
			final EObject eObj = bo;
			if (eObj.eResource() != null) {
				// Get the IResource for the current BO
				final IResource boRes = ResourcesPlugin.getWorkspace().getRoot()
						.getFile(new Path(eObj.eResource().getURI().toPlatformString(true)));

				// Find and save the edit part
				if (boRes != null && PlatformUI.getWorkbench() != null) {
					for (final IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows()) {
						for (final IWorkbenchPage page : window.getPages()) {
							for (final IEditorReference editorRef : page.getEditorReferences()) {
								if (editorRef.isDirty()) {
									final IEditorPart editorPart = editorRef.getEditor(false);
									if (editorPart instanceof XtextEditor) {
										final IResource editorRes = ((XtextEditor) editorPart).getResource();
										if (boRes.equals(editorRes)) {
											page.saveEditor(editorPart, false);
										}
									}
								}
							}
						}
					}
				}
			}
		}

		// Lock the diagram to treat all model change notifications as part of the current action.
		try (Lock lock = modelChangeNotifier.lock()) {
			// Rename the element using LTK
			final ProcessorBasedRefactoring renameRefactoring = RenameUtil.getRenameRefactoring(bo);
			final RefactoringStatus refactoringStatus = prepareAndCheck(renameRefactoring, value);
			if (!refactoringStatus.isOK()) {
				final Dialog dlg = RefactoringUI.createRefactoringStatusDialog(refactoringStatus,
						Display.getCurrent().getActiveShell(), "Refactoring", false);
				if (dlg.open() != Window.OK) {
					// Abort
					return false;
				}
			}

			try {
				final Change change = renameRefactoring.createChange(new NullProgressMonitor());
				new WorkspaceModifyOperation() {
					@Override
					protected void execute(IProgressMonitor monitor)
							throws CoreException, InvocationTargetException, InterruptedException {
						// Prevent model notification changes from being sent until after the refactoring

						// Perform the modification
						change.perform(monitor);

						// Build the project to prevent reference resolver from using old objects.
						try {
							projectProvider.getProject().build(IncrementalProjectBuilder.INCREMENTAL_BUILD,
									new NullProgressMonitor());
						} catch (CoreException e) {
							// Ignore any errors that occur while building the project
							e.printStackTrace();
						}

						final String languageName = getLanguageName();
						// Force reconciliation
						for (final IEditorReference editorRef : PlatformUI.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage().getEditorReferences()) {
							final IEditorPart editor = editorRef.getEditor(false);
							if (editor instanceof XtextEditor) {
								final XtextEditor xtextEditor = (XtextEditor) editor;

								// Only force reconciliation for AADL editors
								if (Objects.equals(xtextEditor.getLanguageName(), languageName)) {
									final SyncUtil syncUtil = Aadl2Activator.getInstance()
											.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2)
											.getInstance(SyncUtil.class);

									// Only waiting once will result in the reconciler processing a change outside the lock.
									// Doing it twice appears to wait for pending runs of the reconciler.
									syncUtil.waitForReconciler(xtextEditor);
									syncUtil.waitForReconciler(xtextEditor);
								}
							}
						}

						// Build the project to prevent reference resolver from using old objects.
						try {
							projectProvider.getProject().build(IncrementalProjectBuilder.INCREMENTAL_BUILD,
									new NullProgressMonitor());
						} catch (CoreException e) {
							// Ignore any errors that occur while building the project
							e.printStackTrace();
						}

					}
				}.run(null);

			} catch (final Exception e) {
				throw new RuntimeException(e);
			}
		}
		return true;
	}

	/**
	 * Sets the new name of the refactoring's processor. Check arguments and initial conditions. Returns true if rename can proceed.
	 * @param refactoring
	 * @param newName
	 * @return
	 */
	private static RefactoringStatus prepareAndCheck(final ProcessorBasedRefactoring refactoring,
			final String newName) {
		try {
			if (refactoring == null) {
				return RefactoringStatus.createFatalErrorStatus("Refactoring is null");
			}

			final RefactoringProcessor refactoringProcessor = refactoring.getProcessor();
			if (!(refactoringProcessor instanceof AbstractRenameProcessor)) {
				return RefactoringStatus
						.createFatalErrorStatus("refactoringProcessor is not an AbstractRenameProcessor");
			}

			// Set the name
			((AbstractRenameProcessor) refactoringProcessor).setNewName(newName);
			final RefactoringStatus initialStatus = refactoring.checkInitialConditions(new NullProgressMonitor());
			if (!initialStatus.isOK()) {
				return initialStatus;
			}

			final RefactoringStatus finalStatus = refactoring.checkFinalConditions(new NullProgressMonitor());
			if (!finalStatus.isOK()) {
				return finalStatus;
			}
		} catch (final CoreException ex) {
			return RefactoringStatus.create(ex.getStatus());
		}

		return new RefactoringStatus();
	}

	private static class LanguageNameRetriever {
		@Inject
		@Named(org.eclipse.xtext.Constants.LANGUAGE_NAME)
		public String languageName;
	}

	/**
	 * Retrieves the language name by injecting it into a new object.
	 * @return
	 */
	private static String getLanguageName() {
		final Injector injector = Objects.requireNonNull(
				Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2),
				"Unable to retrieve injector");

		final LanguageNameRetriever obj = injector.getInstance(LanguageNameRetriever.class);
		return obj.languageName;
	}
}