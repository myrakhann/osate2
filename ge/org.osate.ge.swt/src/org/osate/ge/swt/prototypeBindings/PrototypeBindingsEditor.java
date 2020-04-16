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
package org.osate.ge.swt.prototypeBindings;

import java.util.Objects;
import java.util.function.Consumer;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.util.SwtTestUtil;

// TODO: Edits bindings from the specified children.
/**
 * View for editing prototype bindings
 *
 * @param <B> is the type of the prototype bindings
 * @param <D> is the type of the direction options.
 * @param <T> is the type of the type options.
 * @param <C> is the type of the classifiers.
 */
public class PrototypeBindingsEditor<B, D, T, C> extends Composite {
	private final PrototypeBindingsModel<B, D, T, C> model;
	private final B parentBinding;
	private final Consumer<ChangeEvent> changeListener = e -> refresh();

	public PrototypeBindingsEditor(final Composite parent, final PrototypeBindingsModel<B, D, T, C> model,
			B parentBinding) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.parentBinding = parentBinding;
		this.setBackground(parent.getBackground());
		this.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		model.changed().addListener(changeListener);
		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			for (final Control child : getChildren()) {
				child.dispose();
			}

			model.getChildren(parentBinding).forEachOrdered(b -> {
				// Label
				final CLabel label = new CLabel(this, SWT.BORDER);
				label.setBackground(getBackground());
				label.setText(model.getLabel(b));
				label.setLayoutData(
						GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.CENTER).create()); // TODO

				// TODO: Other, etc to make things look nice

				// TODO: Create component for editing the binding... Separate component
				new PrototypeBindingActualEditor<>(this, model, b);
			});

			requestLayout();
		}
	}

	public static void main(String[] args) {
		SwtTestUtil.run(shell -> {
			new PrototypeBindingsEditor<>(shell, new TestPrototypeBindingsModel(), null);
		});
	}
}
