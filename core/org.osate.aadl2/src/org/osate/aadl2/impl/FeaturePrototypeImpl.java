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
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FeaturePrototype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Prototype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.FeaturePrototypeImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeaturePrototypeImpl#getConstrainingClassifier <em>Constraining Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeaturePrototypeImpl#isIn <em>In</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeaturePrototypeImpl#isOut <em>Out</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeaturePrototypeImpl extends PrototypeImpl implements FeaturePrototype {
	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionType DIRECTION_EDEFAULT = DirectionType.IN;

	/**
	 * The cached value of the '{@link #getConstrainingClassifier() <em>Constraining Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainingClassifier()
	 * @generated
	 * @ordered
	 */
	protected ComponentClassifier constrainingClassifier;

	/**
	 * The default value of the '{@link #isIn() <em>In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIn()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIn() <em>In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIn()
	 * @generated
	 * @ordered
	 */
	protected boolean in = IN_EDEFAULT;

	/**
	 * The default value of the '{@link #isOut() <em>Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOut()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OUT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOut() <em>Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOut()
	 * @generated
	 * @ordered
	 */
	protected boolean out = OUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeaturePrototypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getFeaturePrototype();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DirectionType getDirection() {
		// DONE: implement this method to return the 'Direction' attribute
		if (in) {
			if (out) {
				return DirectionType.IN_OUT;
			} else {
				return DirectionType.IN;
			}
		} else {
			if (out) {
				return DirectionType.OUT;
			} else {
				return DirectionType.IN_OUT;
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentClassifier getConstrainingClassifier() {
		if (constrainingClassifier != null && ((EObject) constrainingClassifier).eIsProxy()) {
			InternalEObject oldConstrainingClassifier = (InternalEObject) constrainingClassifier;
			constrainingClassifier = (ComponentClassifier) eResolveProxy(oldConstrainingClassifier);
			if (constrainingClassifier != oldConstrainingClassifier) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.FEATURE_PROTOTYPE__CONSTRAINING_CLASSIFIER, oldConstrainingClassifier,
							constrainingClassifier));
				}
			}
		}
		return constrainingClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentClassifier basicGetConstrainingClassifier() {
		return constrainingClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstrainingClassifier(ComponentClassifier newConstrainingClassifier) {
		ComponentClassifier oldConstrainingClassifier = constrainingClassifier;
		constrainingClassifier = newConstrainingClassifier;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.FEATURE_PROTOTYPE__CONSTRAINING_CLASSIFIER, oldConstrainingClassifier,
					constrainingClassifier));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIn() {
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIn(boolean newIn) {
		boolean oldIn = in;
		in = newIn;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FEATURE_PROTOTYPE__IN, oldIn, in));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOut() {
		return out;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOut(boolean newOut) {
		boolean oldOut = out;
		out = newOut;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FEATURE_PROTOTYPE__OUT, oldOut, out));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.FEATURE_PROTOTYPE__DIRECTION:
			return getDirection();
		case Aadl2Package.FEATURE_PROTOTYPE__CONSTRAINING_CLASSIFIER:
			if (resolve) {
				return getConstrainingClassifier();
			}
			return basicGetConstrainingClassifier();
		case Aadl2Package.FEATURE_PROTOTYPE__IN:
			return isIn();
		case Aadl2Package.FEATURE_PROTOTYPE__OUT:
			return isOut();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.FEATURE_PROTOTYPE__CONSTRAINING_CLASSIFIER:
			setConstrainingClassifier((ComponentClassifier) newValue);
			return;
		case Aadl2Package.FEATURE_PROTOTYPE__IN:
			setIn((Boolean) newValue);
			return;
		case Aadl2Package.FEATURE_PROTOTYPE__OUT:
			setOut((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.FEATURE_PROTOTYPE__CONSTRAINING_CLASSIFIER:
			setConstrainingClassifier((ComponentClassifier) null);
			return;
		case Aadl2Package.FEATURE_PROTOTYPE__IN:
			setIn(IN_EDEFAULT);
			return;
		case Aadl2Package.FEATURE_PROTOTYPE__OUT:
			setOut(OUT_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.FEATURE_PROTOTYPE__DIRECTION:
			return getDirection() != DIRECTION_EDEFAULT;
		case Aadl2Package.FEATURE_PROTOTYPE__CONSTRAINING_CLASSIFIER:
			return constrainingClassifier != null;
		case Aadl2Package.FEATURE_PROTOTYPE__IN:
			return in != IN_EDEFAULT;
		case Aadl2Package.FEATURE_PROTOTYPE__OUT:
			return out != OUT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (in: ");
		result.append(in);
		result.append(", out: ");
		result.append(out);
		result.append(')');
		return result.toString();
	}

} // FeaturePrototypeImpl
