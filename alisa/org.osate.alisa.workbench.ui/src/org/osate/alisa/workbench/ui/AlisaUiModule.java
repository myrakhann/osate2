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
package org.osate.alisa.workbench.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.osate.alisa.workbench.ui.contentassist.AlisaEObjectHoverProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class AlisaUiModule extends org.osate.alisa.workbench.ui.AbstractAlisaUiModule {
	public AlisaUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return AlisaEObjectHoverProvider.class;
	}

// creates an injection issue 
//	public Class<? extends org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper> bindIHyperlinkHelper() {
//		return org.osate.alisa.common.ui.util.AlisaHyperLinkHelper.class;
//	}
//
	public Class<? extends org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return org.osate.alisa.workbench.ui.linking.AlisaLinkingDiagnosticMessageProvider.class;
	}

}