/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

/*
* generated by Xtext
*/
package org.osate.reqspec.ui.outline

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.osate.alisa.common.common.Description
import org.osate.alisa.common.common.DescriptionElement

import static extension org.osate.alisa.common.util.CommonUtilExtension.*

/**
 * Customization of the default outline structure.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
class ReqSpecOutlineTreeProvider extends DefaultOutlineTreeProvider {
	 
	override _createChildren(IOutlineNode parentNode, EObject modelElement) {
		modelElement.eContents().forEach [childElement |
			if (!DescriptionElement.isInstance(childElement)){
				createNode(parentNode, childElement)
			}
		]
	}
	
	override _createNode(IOutlineNode parentNode, EObject modelElement) {
		var text = textDispatcher.invoke(modelElement)
		val isLeaf = isLeafDispatcher.invoke(modelElement)
		if (text == null && isLeaf)
			return;
		if (text == null && Description.isInstance(modelElement)){
			text = (modelElement as Description).toText(null)
//			text = "description"
		}
		val image = imageDispatcher.invoke(modelElement)
		createEObjectNode(parentNode, modelElement, image, text, isLeaf)
	}

	
}
