package org.osate.search;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public final class AadlFinder {
	@FunctionalInterface
	public interface FinderConsumer<T> {
		public void found(T objDesc);
	}

	private static final AadlFinder instance = new AadlFinder();

	@Inject
	private IResourceDescriptionsProvider resourcesDescriptionProvider;

	@Inject
	private IReferenceFinder referenceFinder;

	private AadlFinder() {
		final Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(Injector.class);
		injector.injectMembers(this);
	}

	public static AadlFinder getInstance() {
		return instance;
	}

	/**
	 * Get all the {@code EObject}s of the given type in the workspace.
	 */
	public void getAllObjectsOfTypeInWorkspace(final EClass eClass,
			final FinderConsumer<IEObjectDescription> consumer) {
		final IResourceDescriptions resourceDescriptions = resourcesDescriptionProvider
				.getResourceDescriptions(OsateResourceUtil.getResourceSet());
		for (final IEObjectDescription objDesc : resourceDescriptions.getExportedObjectsByType(eClass)) {
			consumer.found(objDesc);
		}
	}

	public EList<IEObjectDescription> getAllObjectsOfTypeInWorkspace(final EClass eClass) {
		final EList<IEObjectDescription> classifiers = new BasicEList<IEObjectDescription>();
		getAllObjectsOfTypeInWorkspace(eClass, objDesc -> classifiers.add(objDesc));
		return classifiers;
	}

	public void getAllReferencesToTypeInWorkspace(final EClass eClass,
			final FinderConsumer<IReferenceDescription> consumer) {
		final ResourceSet resourceSet = OsateResourceUtil.getResourceSet();
		final IResourceDescriptions resourceDescriptions = resourcesDescriptionProvider
				.getResourceDescriptions(resourceSet);
		for (final IResourceDescription rsrcDesc : resourceDescriptions.getAllResourceDescriptions()) {
			final Resource rsrc = resourceSet.getResource(rsrcDesc.getURI(), true);
			referenceFinder.findAllReferences(rsrc, new IReferenceFinder.Acceptor() {
				@Override
				public void accept(final EObject source, final URI sourceURI, final EReference eReference,
						final int index, final EObject targetOrProxy, final URI targetURI) {
					accept(new DefaultReferenceDescription(sourceURI, targetURI, eReference, index, null));
				}

				@Override
				public void accept(final IReferenceDescription refDesc) {
					consumer.found(refDesc);
				}
			}, null);
		}
	}
}
