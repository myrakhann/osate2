/**
 */
package org.osate.alisa2.model.safe2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.alisa2.model.safe2.Accident;
import org.osate.alisa2.model.safe2.AccidentLevel;
import org.osate.alisa2.model.safe2.Hazard;
import org.osate.alisa2.model.safe2.Safe2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accident</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.AccidentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.AccidentImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.AccidentImpl#getAccidentlevel <em>Accidentlevel</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.impl.AccidentImpl#getHazard <em>Hazard</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AccidentImpl extends MinimalEObjectImpl.Container implements Accident {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccidentlevel() <em>Accidentlevel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccidentlevel()
	 * @generated
	 * @ordered
	 */
	protected AccidentLevel accidentlevel;

	/**
	 * The cached value of the '{@link #getHazard() <em>Hazard</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHazard()
	 * @generated
	 * @ordered
	 */
	protected EList<Hazard> hazard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccidentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Safe2Package.Literals.ACCIDENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.ACCIDENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.ACCIDENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccidentLevel getAccidentlevel() {
		if (accidentlevel != null && accidentlevel.eIsProxy()) {
			InternalEObject oldAccidentlevel = (InternalEObject)accidentlevel;
			accidentlevel = (AccidentLevel)eResolveProxy(oldAccidentlevel);
			if (accidentlevel != oldAccidentlevel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Safe2Package.ACCIDENT__ACCIDENTLEVEL, oldAccidentlevel, accidentlevel));
			}
		}
		return accidentlevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccidentLevel basicGetAccidentlevel() {
		return accidentlevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccidentlevel(AccidentLevel newAccidentlevel, NotificationChain msgs) {
		AccidentLevel oldAccidentlevel = accidentlevel;
		accidentlevel = newAccidentlevel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Safe2Package.ACCIDENT__ACCIDENTLEVEL, oldAccidentlevel, newAccidentlevel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccidentlevel(AccidentLevel newAccidentlevel) {
		if (newAccidentlevel != accidentlevel) {
			NotificationChain msgs = null;
			if (accidentlevel != null)
				msgs = ((InternalEObject)accidentlevel).eInverseRemove(this, Safe2Package.ACCIDENT_LEVEL__ACCIDENT, AccidentLevel.class, msgs);
			if (newAccidentlevel != null)
				msgs = ((InternalEObject)newAccidentlevel).eInverseAdd(this, Safe2Package.ACCIDENT_LEVEL__ACCIDENT, AccidentLevel.class, msgs);
			msgs = basicSetAccidentlevel(newAccidentlevel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Safe2Package.ACCIDENT__ACCIDENTLEVEL, newAccidentlevel, newAccidentlevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Hazard> getHazard() {
		if (hazard == null) {
			hazard = new EObjectWithInverseResolvingEList<Hazard>(Hazard.class, this, Safe2Package.ACCIDENT__HAZARD, Safe2Package.HAZARD__ACCIDENT);
		}
		return hazard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Safe2Package.ACCIDENT__ACCIDENTLEVEL:
				if (accidentlevel != null)
					msgs = ((InternalEObject)accidentlevel).eInverseRemove(this, Safe2Package.ACCIDENT_LEVEL__ACCIDENT, AccidentLevel.class, msgs);
				return basicSetAccidentlevel((AccidentLevel)otherEnd, msgs);
			case Safe2Package.ACCIDENT__HAZARD:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHazard()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Safe2Package.ACCIDENT__ACCIDENTLEVEL:
				return basicSetAccidentlevel(null, msgs);
			case Safe2Package.ACCIDENT__HAZARD:
				return ((InternalEList<?>)getHazard()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Safe2Package.ACCIDENT__NAME:
				return getName();
			case Safe2Package.ACCIDENT__DESCRIPTION:
				return getDescription();
			case Safe2Package.ACCIDENT__ACCIDENTLEVEL:
				if (resolve) return getAccidentlevel();
				return basicGetAccidentlevel();
			case Safe2Package.ACCIDENT__HAZARD:
				return getHazard();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Safe2Package.ACCIDENT__NAME:
				setName((String)newValue);
				return;
			case Safe2Package.ACCIDENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case Safe2Package.ACCIDENT__ACCIDENTLEVEL:
				setAccidentlevel((AccidentLevel)newValue);
				return;
			case Safe2Package.ACCIDENT__HAZARD:
				getHazard().clear();
				getHazard().addAll((Collection<? extends Hazard>)newValue);
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
			case Safe2Package.ACCIDENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Safe2Package.ACCIDENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case Safe2Package.ACCIDENT__ACCIDENTLEVEL:
				setAccidentlevel((AccidentLevel)null);
				return;
			case Safe2Package.ACCIDENT__HAZARD:
				getHazard().clear();
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
			case Safe2Package.ACCIDENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Safe2Package.ACCIDENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case Safe2Package.ACCIDENT__ACCIDENTLEVEL:
				return accidentlevel != null;
			case Safe2Package.ACCIDENT__HAZARD:
				return hazard != null && !hazard.isEmpty();
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //AccidentImpl
