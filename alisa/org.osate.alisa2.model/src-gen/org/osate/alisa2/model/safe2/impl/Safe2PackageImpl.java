/**
 */
package org.osate.alisa2.model.safe2.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.alisa2.model.safe2.Accident;
import org.osate.alisa2.model.safe2.AccidentLevel;
import org.osate.alisa2.model.safe2.Constraint;
import org.osate.alisa2.model.safe2.ControlAction;
import org.osate.alisa2.model.safe2.Fundamental;
import org.osate.alisa2.model.safe2.Hazard;
import org.osate.alisa2.model.safe2.Node;
import org.osate.alisa2.model.safe2.Safe2Factory;
import org.osate.alisa2.model.safe2.Safe2Package;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Safe2PackageImpl extends EPackageImpl implements Safe2Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fundamentalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accidentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hazardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accidentLevelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.osate.alisa2.model.safe2.Safe2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Safe2PackageImpl() {
		super(eNS_URI, Safe2Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Safe2Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Safe2Package init() {
		if (isInited) return (Safe2Package)EPackage.Registry.INSTANCE.getEPackage(Safe2Package.eNS_URI);

		// Obtain or create and register package
		Safe2PackageImpl theSafe2Package = (Safe2PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Safe2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Safe2PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Aadl2Package.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		ErrorModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSafe2Package.createPackageContents();

		// Initialize created meta-data
		theSafe2Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSafe2Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Safe2Package.eNS_URI, theSafe2Package);
		return theSafe2Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFundamental() {
		return fundamentalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFundamental_Description() {
		return (EAttribute)fundamentalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccident() {
		return accidentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAccident_Accidentlevel() {
		return (EReference)accidentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAccident_Hazard() {
		return (EReference)accidentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHazard() {
		return hazardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHazard_Accident() {
		return (EReference)hazardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHazard_Constraint() {
		return (EReference)hazardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccidentLevel() {
		return accidentLevelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAccidentLevel_Accident() {
		return (EReference)accidentLevelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_ErrorType() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Element() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Hazard() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlAction() {
		return controlActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Name() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Safe2Factory getSafe2Factory() {
		return (Safe2Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		fundamentalEClass = createEClass(FUNDAMENTAL);
		createEAttribute(fundamentalEClass, FUNDAMENTAL__DESCRIPTION);

		accidentEClass = createEClass(ACCIDENT);
		createEReference(accidentEClass, ACCIDENT__ACCIDENTLEVEL);
		createEReference(accidentEClass, ACCIDENT__HAZARD);

		hazardEClass = createEClass(HAZARD);
		createEReference(hazardEClass, HAZARD__ACCIDENT);
		createEReference(hazardEClass, HAZARD__CONSTRAINT);

		accidentLevelEClass = createEClass(ACCIDENT_LEVEL);
		createEReference(accidentLevelEClass, ACCIDENT_LEVEL__ACCIDENT);

		constraintEClass = createEClass(CONSTRAINT);
		createEReference(constraintEClass, CONSTRAINT__ERROR_TYPE);
		createEReference(constraintEClass, CONSTRAINT__ELEMENT);
		createEReference(constraintEClass, CONSTRAINT__HAZARD);

		controlActionEClass = createEClass(CONTROL_ACTION);

		nodeEClass = createEClass(NODE);
		createEAttribute(nodeEClass, NODE__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ErrorModelPackage theErrorModelPackage = (ErrorModelPackage)EPackage.Registry.INSTANCE.getEPackage(ErrorModelPackage.eNS_URI);
		Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		fundamentalEClass.getESuperTypes().add(this.getNode());
		accidentEClass.getESuperTypes().add(this.getFundamental());
		hazardEClass.getESuperTypes().add(this.getFundamental());
		accidentLevelEClass.getESuperTypes().add(this.getFundamental());
		constraintEClass.getESuperTypes().add(this.getFundamental());
		controlActionEClass.getESuperTypes().add(this.getNode());

		// Initialize classes, features, and operations; add parameters
		initEClass(fundamentalEClass, Fundamental.class, "Fundamental", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFundamental_Description(), ecorePackage.getEString(), "description", null, 0, 1, Fundamental.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accidentEClass, Accident.class, "Accident", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAccident_Accidentlevel(), this.getAccidentLevel(), this.getAccidentLevel_Accident(), "accidentlevel", null, 1, 1, Accident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccident_Hazard(), this.getHazard(), this.getHazard_Accident(), "hazard", null, 1, -1, Accident.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hazardEClass, Hazard.class, "Hazard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHazard_Accident(), this.getAccident(), this.getAccident_Hazard(), "accident", null, 1, 1, Hazard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHazard_Constraint(), this.getConstraint(), this.getConstraint_Hazard(), "constraint", null, 1, -1, Hazard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accidentLevelEClass, AccidentLevel.class, "AccidentLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAccidentLevel_Accident(), this.getAccident(), this.getAccident_Accidentlevel(), "accident", null, 1, -1, AccidentLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraint_ErrorType(), theErrorModelPackage.getErrorType(), null, "errorType", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Element(), theAadl2Package.getNamedElement(), null, "element", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Hazard(), this.getHazard(), this.getHazard_Constraint(), "hazard", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(controlActionEClass, ControlAction.class, "ControlAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNode_Name(), theAadl2Package.getString(), "name", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Safe2PackageImpl
