/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.ui.tools;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Context;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.util.ProjectUtil;

public class ToolUtil {
	/**
	 * Looks in ancestors and returns the first BOC which is associated with a ComponentImplementation.
	 * Returns null if any ancestor is not associated with a NamedElement.
	 * @param boc
	 * @return
	 */
	public static BusinessObjectContext findComponentImplementationBoc(final BusinessObjectContext boc) {
		BusinessObjectContext tmp = boc;
		while(tmp != null) {
			if(tmp.getBusinessObject() instanceof ComponentImplementation) {
				return tmp;
			} else if(!(tmp.getBusinessObject() instanceof NamedElement)) {
				return null;
			}

			tmp = tmp.getParent();
		}

		return null;
	}

	private static BusinessObjectContext findContextAncestorBoc(final BusinessObjectContext boc) {
		BusinessObjectContext tmp = boc.getParent();
		while(tmp != null) {
			if(tmp.getBusinessObject() instanceof Context) {
				return tmp;
			}

			tmp = tmp.getParent();
		}

		return null;
	}

	public static Context findContext(final BusinessObjectContext boc) {
		final BusinessObjectContext contextBoc = findContextAncestorBoc(boc);
		return contextBoc == null ? null : (Context)contextBoc.getBusinessObject();
	}

	/**
	 * Finds a context. If the context BOC is the specified owner BOC, null is returned. It is expected that the owner's business object will be a valid context and is a container
	 * of the specified BOC. In such cases the function will return a context only if it is inside the owner business object context.
	 * @param boc
	 * @param ownerBoc
	 * @return
	 */
	public static Context findContextExcludeOwner(final BusinessObjectContext boc,
			final BusinessObjectContext ownerBoc) {
		final BusinessObjectContext contextBoc = findContextAncestorBoc(boc);
		return contextBoc == null || contextBoc == ownerBoc ? null : (Context) contextBoc.getBusinessObject();
	}

	/**
	 * Modifies an eObject to determine if the modification is valid
	 * @param eObject is the eObject to modify
	 * @param getModifiedObject is the modification to perform on the eObject
	 * @return whether the modification is valid
	 */
	public static boolean isValidModification(final EObject eObject, final EObject UNUSEDTODO,
			final Function<ResourceSet, EObject> getModifiedObject) {
		final IProject project = ProjectUtil.getProjectForBoOrThrow(eObject);
		final ResourceSet testResourceSet = ProjectUtil.getLiveResourceSet(project);
		final XtextResource testResource = getXtextResource(testResourceSet, eObject.eResource().getURI());
		final EObject modifiedObject = getModifiedObject.apply(testResourceSet);
		// final LazyLinkingResource resource = (LazyLinkingResource) testResource;

		final Optional<String> serializedSrc = getSerializedSource(modifiedObject);
		if (!serializedSrc.isPresent()) {
			return false;
		}

		System.err.println("A1 : " + modifiedObject);

		return abc(project, serializedSrc.get(), eObject.eResource().getURI(), EcoreUtil.getURI(modifiedObject));
	}

	private static boolean abc(final IProject project, final String src, final URI resourceUri,
			final URI modifiedObjectUri) {
		final ResourceSet testResourceSet = ProjectUtil.getLiveResourceSet(project);
		final XtextResource testResource = (XtextResource) testResourceSet.createResource(resourceUri);

		loadResource(testResource, src);

		if (testResource.validateConcreteSyntax().size() > 0) {
			return false;
		}


		final EObject modifiedObjectNew = testResourceSet.getEObject(modifiedObjectUri, true);
		System.err.println("A2 : " + modifiedObjectNew);

		ComponentImplementation c = (ComponentImplementation) modifiedObjectNew;
		for (EndToEndFlow f : c.getOwnedEndToEndFlows()) {

			for (Mode m : f.getInModes()) {
				System.err.println("M1: " + m);
			}
		}

		// EcoreUtil.resolveAll(modifiedObjectNew);
		// LazyLinkingResource a = (LazyLinkingResource) testResource;
		// a.resolveLazyCrossReferences(null);


		final Diagnostic diagnostic = Diagnostician.INSTANCE.validate(modifiedObjectNew,
				Collections.singletonMap(Diagnostician.VALIDATE_RECURSIVELY, true));
		System.err.println("E1: " + diagnostic + " : " + diagnostic.getSeverity());

		for (final org.eclipse.emf.ecore.resource.Resource.Diagnostic d : testResource.getErrors()) {
			System.err.println("F1: " + d);
		}

		for (final org.eclipse.emf.ecore.resource.Resource.Diagnostic d : testResource.getWarnings()) {
			System.err.println("F2: " + d);
		}

		return true;
	}

	private static Optional<String> getSerializedSource(final EObject modifiedObject) {
		String serializedSrc = null;
		try {
			serializedSrc = ((XtextResource) modifiedObject.eResource()).getSerializer()
					.serialize(modifiedObject.eResource().getContents().get(0));
		} catch (final RuntimeException e) {
			// Error serializing modified object
		}

		return Optional.ofNullable(serializedSrc);
	}

	private static void loadResource(final XtextResource resource, final String src) {
		try {
			resource.load(new ByteArrayInputStream(src.getBytes()), null);
		} catch (final IOException e) {
			throw new RuntimeException("Serialized source cannot be loaded");
		}
	}

	private static XtextResource getXtextResource(final ResourceSet resourceSet, final URI uri) {
		assert resourceSet instanceof XtextResourceSet;

		final XtextResource resource = (XtextResource) resourceSet.getResource(uri, true);
		return resource != null ? resource : (XtextResource) resourceSet.createResource(uri);
	}
}
