package org.osate.ui;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.provider.InstanceItemProviderAdapterFactory;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.eclipseinterface.OsateResourceManager;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.parsesupport.LocationReference;
import org.osate.aadl2.provider.Aadl2ItemProviderAdapterFactory;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.internal.workspace.AadlWorkspace;


public final class UiUtil {
	public static final int SUCCESS = 0;
	public static final int SILENT_FAILURE = 1;
	public static final int NO_DIAGRAM_FILE = 2;
	public static final int SYNTAX_ERROR = 3;
	
	private static ComposedAdapterFactory adapterFactory = null;
	private static AdapterFactoryLabelProvider labelProvider = null;
	private static AdapterFactoryContentProvider contentProvider = null;
	
    private static boolean openEditor(final IWorkbenchPage page,
			final IFile input, final boolean activate) {
    	final class Result {
    		public volatile boolean value = true;
    	}
    	
    	final Result result = new Result();
    	Display.getDefault().syncExec(new Runnable() {
    		public void run() {
    			try {
					IDE.openEditor(page, input, activate);
				} catch (PartInitException e) {
					OsateUiPlugin.log(e);
					result.value = false;
				}
    		}
    	});
		return result.value;
	}
	
    private static boolean openEditor(final IWorkbenchPage page,
			final IMarker marker, final boolean activate) {
    	final class Result {
    		public volatile boolean value = true;
    	}
    	
    	final Result result = new Result();
    	Display.getDefault().syncExec(new Runnable() {
    		public void run() {
    			try {
					IDE.openEditor(page, marker, activate);
				} catch (PartInitException e) {
					OsateUiPlugin.log(e);
					result.value = false;
				}
    		}
    	});
		return result.value;
	}

	/**
	 * goto aaxl model through the editor associated with aaxl files. assumes
	 * that the text file has been saved and compiled.
	 * 
	 * @param page
	 *            Workbench page
	 * @param root
	 *            Root AObject of model to go to
	 * @param linenumber
	 *            line number in text whose locationin the object should be the
	 *            target
	 */
	public static void gotoAaxlModel(IWorkbenchPage page, final Element root, int linenumber) {
		if (root == null){
			return;
		}
		Aadl2ResourceImpl res = (Aadl2ResourceImpl)root.eResource();
		Element target = AadlUtil.findElement(root, linenumber);
		if (target != null){
			gotoAaxlModel(page, target);
		}
	}

	
	/**
	 * goto aaxl model through the editor associated with aaxl files. 
	 * @param page Workbench page
	 * @param target AObject that is the target object 
	 */
	public static void gotoAaxlModel(IWorkbenchPage page, final Element target) {
		if (target == null){
			return;
		}
		Aadl2ResourceImpl res = (Aadl2ResourceImpl)target.eResource();
		final IResource ires = OsateResourceManager.convertToIResource(res);
		if (ires != null && ires.exists())
		{
			try {
				IMarker marker_p;
				marker_p = ires.createMarker(AadlConstants.AADLGOTOMARKER);
				marker_p.setAttribute(IMarker.SEVERITY,
						IMarker.SEVERITY_INFO);
				String dest = EcoreUtil.getURI(target).toString();
				marker_p.setAttribute(IMarker.MESSAGE, "Going to "
						+ dest);
				marker_p.setAttribute(AadlConstants.AADLURI, dest);
				openEditor(page, marker_p, OpenStrategy.activateOnOpen());
				// editor opened --- get rid of goto marker
				ires.deleteMarkers(AadlConstants.AADLGOTOMARKER,
						false, IResource.DEPTH_ZERO);
			} catch (final CoreException e) {
				OsateUiPlugin.log(e);
			}
		}
	}

	/**
	 * goto aaxldi model in editor associated with diagram files. 
	 * assumes that the text file has been saved and compiled.
	 * @param page Workbench page
	 * @param root Root AObject of model to go to
	 * @param linenumber line number in text whose locationin the object should be the target
	 */
	public static int gotoAaxldiModel(IWorkbenchPage page, final Element root, int linenumber) {
		Element target = AadlUtil.findElement(root, linenumber);
		if (target == null){
			return SILENT_FAILURE;
		}
		return gotoAaxldiModel(page,target);
	}
	
	/**
	 * goto aaxldi model in editor associated with diagram files. 
	 * assumes that the text file has been saved and compiled.
	 * @param page Workbench page
	 * @param target AObject that is the target object 
	 */
	public static int gotoAaxldiModel(IWorkbenchPage page, Element target) {
		if (target == null){
			return SILENT_FAILURE;
		}
		if (target instanceof InstanceObject){
			target = AadlUtil.getInstanceOrigin((InstanceObject)target);
			if (target == null){
				return SILENT_FAILURE;
			}
		}
		Aadl2ResourceImpl res = (Aadl2ResourceImpl)target.eResource();
		final IResource ires = OsateResourceManager.convertToIResource(res);
		if (ires == null){
			return SILENT_FAILURE;
		}
		IFile aaxlFile = (IFile) ires;
		IPath p = aaxlFile.getFullPath();
		p = p.removeFileExtension().addFileExtension( "aaxldi");
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IResource diaFile =  myWorkspaceRoot.getFile(p);
		if (!diaFile.exists()) {
			return NO_DIAGRAM_FILE;
		}
		if (ires != null && ires.exists())
		{
			try {
				IMarker marker_p;
				marker_p = diaFile.createMarker(EValidator.MARKER);
				marker_p.setAttribute(IMarker.SEVERITY,
						IMarker.SEVERITY_INFO);
				String dest = EcoreUtil.getURI(target).toString();
				marker_p.setAttribute(IMarker.MESSAGE, "Going to "
						+ dest);
				marker_p.setAttribute(AadlConstants.AADLURI, dest);
				openEditor(page, marker_p, OpenStrategy.activateOnOpen());
				// editor opened --- get rid of goto marker
				diaFile.deleteMarkers(EValidator.MARKER,
						false, IResource.DEPTH_ZERO);
			} catch (CoreException e) {
				OsateUiPlugin.log(e);
			}
		}
		return SUCCESS;
	}

	/**
	 * go to the source text location corresponding to the location of the specified AObject
	 * The method will ensure that the source text is up to date with the model file
	 */
	public static void gotoSourceText(IWorkbenchPage page, Element obj) {
		if (obj instanceof InstanceObject){
			obj = AadlUtil.getInstanceOrigin((InstanceObject)obj);
			if (obj == null){
				return;
			}
		}
		final IResource aaxlResource = OsateResourceManager.convertToIResource(obj.eResource());
		if (aaxlResource == null || !aaxlResource.exists() ){
			return;
		}
		final IResource aadlResource = AadlWorkspace.getAadlWorkspace().getAadlProject(aaxlResource).getAadlFile((IFile)aaxlResource);
		LocationReference loc = obj.getLocationReference();
		if (loc != null ) {
			try {
				final IMarker marker_p =
					aadlResource.createMarker(AadlConstants.AADLTEXTGOTOMARKER);
				marker_p.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
				String dest = EcoreUtil.getURI(obj).toString();
				marker_p.setAttribute(IMarker.MESSAGE, "Going to " + dest);
				marker_p.setAttribute(IMarker.LINE_NUMBER, loc.getLine());
				
				openEditor(page, marker_p, OpenStrategy.activateOnOpen());
				
				// editor opened --- get rid of goto marker
				aadlResource.deleteMarkers(AadlConstants.AADLTEXTGOTOMARKER,
						false, IResource.DEPTH_ZERO);
			} catch (CoreException e) {
				OsateUiPlugin.log(e);
			}
		}
	}

	/**
	 * Open an object editor for the given model object. Ensures that the editor
	 * is the front editor, and is the active workbench component. Enters
	 * entries into the Eclipse log if the editor could not be opened.
	 * 
	 * @param obj
	 *            The object to open the editor for. The editor is opened on the
	 *            resource that contains the object.
	 * @return The editing domain for the Resource if the editor was opened;
	 *         <code>null</code> if the editor was not able to be opened.
	 */
	public static final EditingDomain openEditorFor(final Element obj) {
		final IFile file =
			(IFile) OsateResourceManager.convertToIResource(obj.eResource());
		if (file != null) {
			if (openEditor(OsateUiPlugin.getActiveWorkbenchPage(), file, true)) {
				return AdapterFactoryEditingDomain.getEditingDomainFor(obj);
			} else {
				return null;
			}
		} else {
			OsateUiPlugin.logErrorMessage("Couldn't find IResource for " + obj.eResource());
			return null;
		}
	}
	
	/**
	 * Execute the given command using the editing domain for the given model
	 * object. This is preferrable to calling
	 * <code>editingDomain.getCommandStack().execute(command)</code> directly
	 * because it makes sure that the appropriate resource is locked in the
	 * eclipse workspace. The command is not executed if the Eclipse IResource
	 * for the given object cannot be found, or if the editing domain is not
	 * found. In either of these cases a error message is written to the Eclipse
	 * log.
	 * 
	 * @param obj
	 *            The AADL model object from which the editing domain is
	 *            derived.
	 * @param command
	 *            The editor command to execute.
	 */
	public static final void executeCommand(final Element obj, final Command command) {
		final IFile file =
			(IFile) OsateResourceManager.convertToIResource(obj.eResource());
		if (file != null) {
			final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(obj);
			if (editingDomain != null) {
				final IWorkspace workspace = ResourcesPlugin.getWorkspace();
				try {
					workspace.run(new IWorkspaceRunnable() {
						public void run(IProgressMonitor monitor) throws CoreException {
							editingDomain.getCommandStack().execute(command);
						}
					}, file, IWorkspace.AVOID_UPDATE, null);
				} catch (final CoreException e) {
					OsateUiPlugin.log(e);
				}
			} else {
				OsateUiPlugin.logErrorMessage("Couldn't get editing domain for " + obj);
			}
		} else {
			OsateUiPlugin.logErrorMessage("Couldn't find IResource for " + obj.eResource());
		}
	}
	
	/**
	 * Open an object editor for the given model object and executes the
	 * given command in the associated editing domain. Ensures that the editor
	 * is the front editor, and is the active workbench component. Enters
	 * entries into the Eclipse log if the editor could not be opened or if
	 * the editing domain could not be retreived.  The command is executed 
	 * with the Eclipse IResource for the given object locked.
	 * 
	 * @param obj
	 *            The object to open the editor for. The editor is opened on the
	 *            resource that contains the object.
	 * @param command
	 *            The editor command to execute.
	 */
	public static final void openEditorAndExecute(final Element obj, final Command command) {
		final IFile file =
			(IFile) OsateResourceManager.convertToIResource(obj.eResource());
		if (file != null) {
			if (openEditor(OsateUiPlugin.getActiveWorkbenchPage(), file, true)) {
				final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(obj);
				if (editingDomain != null) {
					final IWorkspace workspace = ResourcesPlugin.getWorkspace();
					try {
						workspace.run(new IWorkspaceRunnable() {
							public void run(IProgressMonitor monitor) throws CoreException {
								editingDomain.getCommandStack().execute(command);
							}
						}, file, IWorkspace.AVOID_UPDATE, null);
					} catch (final CoreException e) {
						OsateUiPlugin.log(e);
					}
				} else {
					OsateUiPlugin.logErrorMessage("Couldn't get editing domain for " + obj);
				}
			}
		} else {
			OsateUiPlugin.logErrorMessage("Couldn't find IResource for " + obj.eResource());
		}
	}
	
	/**
	 * Returns a label provider similar to the one used by the aadl object editor.
	 * Use this method when you want an <code>org.eclipse.jface.viewers.Viewer</code>
	 * to display the same text labels and icons as the object editor.
	 * 
	 * @return A label provider that returns standard labels and icons for AObjects.
	 */
	public static final AdapterFactoryLabelProvider getAObjectLabelProvider()
	{
		if (labelProvider == null)
			labelProvider = new AdapterFactoryLabelProvider(getAdapterFactory());
		return labelProvider;
	}
	
	/**
	 * Returns a content provider similar to the one used by the aadl object editor.
	 * Use this method when you want an <code>org.eclipse.jface.viewers.TreeViewer</code>
	 * to display the same contents as the object editor.
	 * 
	 * @return A content provider that is used for displaying the standard hierarchical contents of an AObject.
	 */
	public static final AdapterFactoryContentProvider getAObjectContentProvider()
	{
		if (contentProvider == null)
			contentProvider = new AdapterFactoryContentProvider(getAdapterFactory());
		return contentProvider;
	}
	
	/**
	 * Returns an adapter factory that can be used to create content providers, label
	 * providers, editing domains, etc.  The adapter factory is composed a
	 * {@link ResourceItemProviderAdapterFactory}, a {@link ComponentItemProviderAdapterFactory},
	 * a {@link FeatureItemProviderAdapterFactory}, a {@link CoreItemProviderAdapterFactory},
	 * an {@link InstanceItemProviderAdapterFactory}, a {@link PropertyItemProviderAdapterFactory},
	 * a {@link FlowItemProviderAdapterFactory}, a {@link ConnectionItemProviderAdapterFactory},
	 * and a {@link ReflectiveItemProviderAdapterFactory}.
	 * 
	 * @return An adapter factory composed of the AADL adapter factories.
	 */
	public static final ComposedAdapterFactory getAdapterFactory()
	{
		if (adapterFactory == null)
		{
			ArrayList<ComposeableAdapterFactory> factories = new ArrayList<ComposeableAdapterFactory>();
			factories.add(new ResourceItemProviderAdapterFactory());
			factories.add(new Aadl2ItemProviderAdapterFactory());
			factories.add(new InstanceItemProviderAdapterFactory());
			factories.add(new ReflectiveItemProviderAdapterFactory());
			adapterFactory = new ComposedAdapterFactory(factories);
		}
		return adapterFactory;
	}
}