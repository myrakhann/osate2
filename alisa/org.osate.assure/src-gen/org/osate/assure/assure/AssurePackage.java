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
package org.osate.assure.assure;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.assure.assure.AssureFactory
 * @model kind="package"
 * @generated
 */
public interface AssurePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "assure";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/assure/Assure";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "assure";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AssurePackage eINSTANCE = org.osate.assure.assure.impl.AssurePackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.AssureResultImpl <em>Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AssureResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssureResult()
   * @generated
   */
  int ASSURE_RESULT = 5;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURE_RESULT__METRICS = 0;

  /**
   * The number of structural features of the '<em>Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURE_RESULT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.AssuranceCaseResultImpl <em>Assurance Case Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AssuranceCaseResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssuranceCaseResult()
   * @generated
   */
  int ASSURANCE_CASE_RESULT = 0;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_CASE_RESULT__METRICS = ASSURE_RESULT__METRICS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_CASE_RESULT__NAME = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_CASE_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Model Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_CASE_RESULT__MODEL_RESULT = ASSURE_RESULT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Assurance Case Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_CASE_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.ModelResultImpl <em>Model Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.ModelResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getModelResult()
   * @generated
   */
  int MODEL_RESULT = 1;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_RESULT__METRICS = ASSURE_RESULT__METRICS;

  /**
   * The feature id for the '<em><b>Plan</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_RESULT__PLAN = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_RESULT__TARGET = ASSURE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Claim Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_RESULT__CLAIM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Subsystem Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_RESULT__SUBSYSTEM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Sub Assurance Case</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_RESULT__SUB_ASSURANCE_CASE = ASSURE_RESULT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Model Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.SubsystemResultImpl <em>Subsystem Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.SubsystemResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getSubsystemResult()
   * @generated
   */
  int SUBSYSTEM_RESULT = 2;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSYSTEM_RESULT__METRICS = ASSURE_RESULT__METRICS;

  /**
   * The feature id for the '<em><b>Target System</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSYSTEM_RESULT__TARGET_SYSTEM = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSYSTEM_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Claim Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSYSTEM_RESULT__CLAIM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Subsystem Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSYSTEM_RESULT__SUBSYSTEM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Subsystem Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSYSTEM_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.ClaimResultImpl <em>Claim Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.ClaimResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getClaimResult()
   * @generated
   */
  int CLAIM_RESULT = 3;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__METRICS = ASSURE_RESULT__METRICS;

  /**
   * The feature id for the '<em><b>Target Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__TARGET_REFERENCE = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Model Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__MODEL_ELEMENT = ASSURE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Sub Claim Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__SUB_CLAIM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Verification Activity Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT = ASSURE_RESULT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Claim Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationResultImpl <em>Verification Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.VerificationResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResult()
   * @generated
   */
  int VERIFICATION_RESULT = 4;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__METRICS = ASSURE_RESULT__METRICS;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__EXECUTION_STATE = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Result State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__RESULT_STATE = ASSURE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__ISSUES = ASSURE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Result Report</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__RESULT_REPORT = ASSURE_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Verification Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationExprImpl <em>Verification Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.VerificationExprImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationExpr()
   * @generated
   */
  int VERIFICATION_EXPR = 6;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_EXPR__METRICS = ASSURE_RESULT__METRICS;

  /**
   * The number of structural features of the '<em>Verification Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_EXPR_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.ElseResultImpl <em>Else Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.ElseResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getElseResult()
   * @generated
   */
  int ELSE_RESULT = 7;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_RESULT__METRICS = VERIFICATION_EXPR__METRICS;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_RESULT__FIRST = VERIFICATION_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Error</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_RESULT__ERROR = VERIFICATION_EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Fail</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_RESULT__FAIL = VERIFICATION_EXPR_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Timeout</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_RESULT__TIMEOUT = VERIFICATION_EXPR_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Did Fail</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_RESULT__DID_FAIL = VERIFICATION_EXPR_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Else Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_RESULT_FEATURE_COUNT = VERIFICATION_EXPR_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.ThenResultImpl <em>Then Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.ThenResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getThenResult()
   * @generated
   */
  int THEN_RESULT = 8;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THEN_RESULT__METRICS = VERIFICATION_EXPR__METRICS;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THEN_RESULT__FIRST = VERIFICATION_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Second</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THEN_RESULT__SECOND = VERIFICATION_EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Did Then Fail</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THEN_RESULT__DID_THEN_FAIL = VERIFICATION_EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Then Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THEN_RESULT_FEATURE_COUNT = VERIFICATION_EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.MetricsImpl <em>Metrics</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.MetricsImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getMetrics()
   * @generated
   */
  int METRICS = 9;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS__TBD_COUNT = 0;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS__SUCCESS_COUNT = 1;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS__FAIL_COUNT = 2;

  /**
   * The feature id for the '<em><b>Timeout Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS__TIMEOUT_COUNT = 3;

  /**
   * The feature id for the '<em><b>Error Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS__ERROR_COUNT = 4;

  /**
   * The feature id for the '<em><b>Didelse Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS__DIDELSE_COUNT = 5;

  /**
   * The feature id for the '<em><b>Thenskip Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS__THENSKIP_COUNT = 6;

  /**
   * The feature id for the '<em><b>Preconditionfail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS__PRECONDITIONFAIL_COUNT = 7;

  /**
   * The feature id for the '<em><b>Validationfail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS__VALIDATIONFAIL_COUNT = 8;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS__WEIGHT = 9;

  /**
   * The feature id for the '<em><b>Execution Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS__EXECUTION_TIME = 10;

  /**
   * The number of structural features of the '<em>Metrics</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METRICS_FEATURE_COUNT = 11;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.QualifiedVerificationPlanElementReferenceImpl <em>Qualified Verification Plan Element Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.QualifiedVerificationPlanElementReferenceImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedVerificationPlanElementReference()
   * @generated
   */
  int QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE = 10;

  /**
   * The feature id for the '<em><b>Verification Plan</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN = 0;

  /**
   * The feature id for the '<em><b>Requirement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT = 1;

  /**
   * The number of structural features of the '<em>Qualified Verification Plan Element Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.QualifiedClaimReferenceImpl <em>Qualified Claim Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.QualifiedClaimReferenceImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedClaimReference()
   * @generated
   */
  int QUALIFIED_CLAIM_REFERENCE = 11;

  /**
   * The feature id for the '<em><b>Verification Plan</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_CLAIM_REFERENCE__VERIFICATION_PLAN = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN;

  /**
   * The feature id for the '<em><b>Requirement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_CLAIM_REFERENCE__REQUIREMENT = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT;

  /**
   * The number of structural features of the '<em>Qualified Claim Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_CLAIM_REFERENCE_FEATURE_COUNT = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.QualifiedVAReferenceImpl <em>Qualified VA Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.QualifiedVAReferenceImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedVAReference()
   * @generated
   */
  int QUALIFIED_VA_REFERENCE = 12;

  /**
   * The feature id for the '<em><b>Verification Plan</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_VA_REFERENCE__VERIFICATION_PLAN = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN;

  /**
   * The feature id for the '<em><b>Requirement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_VA_REFERENCE__REQUIREMENT = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT;

  /**
   * The feature id for the '<em><b>Verification Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Qualified VA Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_VA_REFERENCE_FEATURE_COUNT = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.NestedClaimReferenceImpl <em>Nested Claim Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.NestedClaimReferenceImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getNestedClaimReference()
   * @generated
   */
  int NESTED_CLAIM_REFERENCE = 13;

  /**
   * The feature id for the '<em><b>Requirement</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_CLAIM_REFERENCE__REQUIREMENT = 0;

  /**
   * The feature id for the '<em><b>Sub</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_CLAIM_REFERENCE__SUB = 1;

  /**
   * The number of structural features of the '<em>Nested Claim Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_CLAIM_REFERENCE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.PreconditionResultImpl <em>Precondition Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.PreconditionResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getPreconditionResult()
   * @generated
   */
  int PRECONDITION_RESULT = 14;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__METRICS = VERIFICATION_RESULT__METRICS;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__EXECUTION_STATE = VERIFICATION_RESULT__EXECUTION_STATE;

  /**
   * The feature id for the '<em><b>Result State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__RESULT_STATE = VERIFICATION_RESULT__RESULT_STATE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__ISSUES = VERIFICATION_RESULT__ISSUES;

  /**
   * The feature id for the '<em><b>Result Report</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__RESULT_REPORT = VERIFICATION_RESULT__RESULT_REPORT;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__MESSAGE = VERIFICATION_RESULT__MESSAGE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__TARGET = VERIFICATION_RESULT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Precondition Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT_FEATURE_COUNT = VERIFICATION_RESULT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.ValidationResultImpl <em>Validation Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.ValidationResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getValidationResult()
   * @generated
   */
  int VALIDATION_RESULT = 15;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__METRICS = VERIFICATION_RESULT__METRICS;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__EXECUTION_STATE = VERIFICATION_RESULT__EXECUTION_STATE;

  /**
   * The feature id for the '<em><b>Result State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__RESULT_STATE = VERIFICATION_RESULT__RESULT_STATE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__ISSUES = VERIFICATION_RESULT__ISSUES;

  /**
   * The feature id for the '<em><b>Result Report</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__RESULT_REPORT = VERIFICATION_RESULT__RESULT_REPORT;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__MESSAGE = VERIFICATION_RESULT__MESSAGE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__TARGET = VERIFICATION_RESULT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Validation Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT_FEATURE_COUNT = VERIFICATION_RESULT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationActivityResultImpl <em>Verification Activity Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.VerificationActivityResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationActivityResult()
   * @generated
   */
  int VERIFICATION_ACTIVITY_RESULT = 16;

  /**
   * The feature id for the '<em><b>Metrics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__METRICS = VERIFICATION_RESULT__METRICS;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE = VERIFICATION_RESULT__EXECUTION_STATE;

  /**
   * The feature id for the '<em><b>Result State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__RESULT_STATE = VERIFICATION_RESULT__RESULT_STATE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__ISSUES = VERIFICATION_RESULT__ISSUES;

  /**
   * The feature id for the '<em><b>Result Report</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__RESULT_REPORT = VERIFICATION_RESULT__RESULT_REPORT;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__MESSAGE = VERIFICATION_RESULT__MESSAGE;

  /**
   * The feature id for the '<em><b>Target Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__TARGET_REFERENCE = VERIFICATION_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Precondition Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT = VERIFICATION_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Validation Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__VALIDATION_RESULT = VERIFICATION_RESULT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Verification Activity Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT_FEATURE_COUNT = VERIFICATION_RESULT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.ElseType <em>Else Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.ElseType
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getElseType()
   * @generated
   */
  int ELSE_TYPE = 17;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.VerificationResultState <em>Verification Result State</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.VerificationResultState
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResultState()
   * @generated
   */
  int VERIFICATION_RESULT_STATE = 18;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.VerificationExecutionState <em>Verification Execution State</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.VerificationExecutionState
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationExecutionState()
   * @generated
   */
  int VERIFICATION_EXECUTION_STATE = 19;


  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.AssuranceCaseResult <em>Assurance Case Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assurance Case Result</em>'.
   * @see org.osate.assure.assure.AssuranceCaseResult
   * @generated
   */
  EClass getAssuranceCaseResult();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssuranceCaseResult#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.assure.assure.AssuranceCaseResult#getName()
   * @see #getAssuranceCaseResult()
   * @generated
   */
  EAttribute getAssuranceCaseResult_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssuranceCaseResult#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.AssuranceCaseResult#getMessage()
   * @see #getAssuranceCaseResult()
   * @generated
   */
  EAttribute getAssuranceCaseResult_Message();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.AssuranceCaseResult#getModelResult <em>Model Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Model Result</em>'.
   * @see org.osate.assure.assure.AssuranceCaseResult#getModelResult()
   * @see #getAssuranceCaseResult()
   * @generated
   */
  EReference getAssuranceCaseResult_ModelResult();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.ModelResult <em>Model Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Result</em>'.
   * @see org.osate.assure.assure.ModelResult
   * @generated
   */
  EClass getModelResult();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.ModelResult#getPlan <em>Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Plan</em>'.
   * @see org.osate.assure.assure.ModelResult#getPlan()
   * @see #getModelResult()
   * @generated
   */
  EReference getModelResult_Plan();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.ModelResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.ModelResult#getTarget()
   * @see #getModelResult()
   * @generated
   */
  EReference getModelResult_Target();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.ModelResult#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.ModelResult#getMessage()
   * @see #getModelResult()
   * @generated
   */
  EAttribute getModelResult_Message();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ModelResult#getClaimResult <em>Claim Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Claim Result</em>'.
   * @see org.osate.assure.assure.ModelResult#getClaimResult()
   * @see #getModelResult()
   * @generated
   */
  EReference getModelResult_ClaimResult();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ModelResult#getSubsystemResult <em>Subsystem Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subsystem Result</em>'.
   * @see org.osate.assure.assure.ModelResult#getSubsystemResult()
   * @see #getModelResult()
   * @generated
   */
  EReference getModelResult_SubsystemResult();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ModelResult#getSubAssuranceCase <em>Sub Assurance Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub Assurance Case</em>'.
   * @see org.osate.assure.assure.ModelResult#getSubAssuranceCase()
   * @see #getModelResult()
   * @generated
   */
  EReference getModelResult_SubAssuranceCase();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.SubsystemResult <em>Subsystem Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subsystem Result</em>'.
   * @see org.osate.assure.assure.SubsystemResult
   * @generated
   */
  EClass getSubsystemResult();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.SubsystemResult#getTargetSystem <em>Target System</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target System</em>'.
   * @see org.osate.assure.assure.SubsystemResult#getTargetSystem()
   * @see #getSubsystemResult()
   * @generated
   */
  EReference getSubsystemResult_TargetSystem();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.SubsystemResult#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.SubsystemResult#getMessage()
   * @see #getSubsystemResult()
   * @generated
   */
  EAttribute getSubsystemResult_Message();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.SubsystemResult#getClaimResult <em>Claim Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Claim Result</em>'.
   * @see org.osate.assure.assure.SubsystemResult#getClaimResult()
   * @see #getSubsystemResult()
   * @generated
   */
  EReference getSubsystemResult_ClaimResult();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.SubsystemResult#getSubsystemResult <em>Subsystem Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subsystem Result</em>'.
   * @see org.osate.assure.assure.SubsystemResult#getSubsystemResult()
   * @see #getSubsystemResult()
   * @generated
   */
  EReference getSubsystemResult_SubsystemResult();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.ClaimResult <em>Claim Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Claim Result</em>'.
   * @see org.osate.assure.assure.ClaimResult
   * @generated
   */
  EClass getClaimResult();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.assure.assure.ClaimResult#getTargetReference <em>Target Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target Reference</em>'.
   * @see org.osate.assure.assure.ClaimResult#getTargetReference()
   * @see #getClaimResult()
   * @generated
   */
  EReference getClaimResult_TargetReference();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.ClaimResult#getModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Model Element</em>'.
   * @see org.osate.assure.assure.ClaimResult#getModelElement()
   * @see #getClaimResult()
   * @generated
   */
  EReference getClaimResult_ModelElement();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.ClaimResult#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.ClaimResult#getMessage()
   * @see #getClaimResult()
   * @generated
   */
  EAttribute getClaimResult_Message();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ClaimResult#getSubClaimResult <em>Sub Claim Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub Claim Result</em>'.
   * @see org.osate.assure.assure.ClaimResult#getSubClaimResult()
   * @see #getClaimResult()
   * @generated
   */
  EReference getClaimResult_SubClaimResult();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ClaimResult#getVerificationActivityResult <em>Verification Activity Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Verification Activity Result</em>'.
   * @see org.osate.assure.assure.ClaimResult#getVerificationActivityResult()
   * @see #getClaimResult()
   * @generated
   */
  EReference getClaimResult_VerificationActivityResult();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.VerificationResult <em>Verification Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Result</em>'.
   * @see org.osate.assure.assure.VerificationResult
   * @generated
   */
  EClass getVerificationResult();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getExecutionState <em>Execution State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Execution State</em>'.
   * @see org.osate.assure.assure.VerificationResult#getExecutionState()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_ExecutionState();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getResultState <em>Result State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Result State</em>'.
   * @see org.osate.assure.assure.VerificationResult#getResultState()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_ResultState();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.VerificationResult#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Issues</em>'.
   * @see org.osate.assure.assure.VerificationResult#getIssues()
   * @see #getVerificationResult()
   * @generated
   */
  EReference getVerificationResult_Issues();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.VerificationResult#getResultReport <em>Result Report</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Result Report</em>'.
   * @see org.osate.assure.assure.VerificationResult#getResultReport()
   * @see #getVerificationResult()
   * @generated
   */
  EReference getVerificationResult_ResultReport();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.VerificationResult#getMessage()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_Message();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.AssureResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result</em>'.
   * @see org.osate.assure.assure.AssureResult
   * @generated
   */
  EClass getAssureResult();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.assure.assure.AssureResult#getMetrics <em>Metrics</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Metrics</em>'.
   * @see org.osate.assure.assure.AssureResult#getMetrics()
   * @see #getAssureResult()
   * @generated
   */
  EReference getAssureResult_Metrics();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.VerificationExpr <em>Verification Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Expr</em>'.
   * @see org.osate.assure.assure.VerificationExpr
   * @generated
   */
  EClass getVerificationExpr();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.ElseResult <em>Else Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Else Result</em>'.
   * @see org.osate.assure.assure.ElseResult
   * @generated
   */
  EClass getElseResult();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ElseResult#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>First</em>'.
   * @see org.osate.assure.assure.ElseResult#getFirst()
   * @see #getElseResult()
   * @generated
   */
  EReference getElseResult_First();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ElseResult#getError <em>Error</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Error</em>'.
   * @see org.osate.assure.assure.ElseResult#getError()
   * @see #getElseResult()
   * @generated
   */
  EReference getElseResult_Error();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ElseResult#getFail <em>Fail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fail</em>'.
   * @see org.osate.assure.assure.ElseResult#getFail()
   * @see #getElseResult()
   * @generated
   */
  EReference getElseResult_Fail();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ElseResult#getTimeout <em>Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Timeout</em>'.
   * @see org.osate.assure.assure.ElseResult#getTimeout()
   * @see #getElseResult()
   * @generated
   */
  EReference getElseResult_Timeout();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.ElseResult#getDidFail <em>Did Fail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Did Fail</em>'.
   * @see org.osate.assure.assure.ElseResult#getDidFail()
   * @see #getElseResult()
   * @generated
   */
  EAttribute getElseResult_DidFail();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.ThenResult <em>Then Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Then Result</em>'.
   * @see org.osate.assure.assure.ThenResult
   * @generated
   */
  EClass getThenResult();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ThenResult#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>First</em>'.
   * @see org.osate.assure.assure.ThenResult#getFirst()
   * @see #getThenResult()
   * @generated
   */
  EReference getThenResult_First();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ThenResult#getSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Second</em>'.
   * @see org.osate.assure.assure.ThenResult#getSecond()
   * @see #getThenResult()
   * @generated
   */
  EReference getThenResult_Second();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.ThenResult#isDidThenFail <em>Did Then Fail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Did Then Fail</em>'.
   * @see org.osate.assure.assure.ThenResult#isDidThenFail()
   * @see #getThenResult()
   * @generated
   */
  EAttribute getThenResult_DidThenFail();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.Metrics <em>Metrics</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Metrics</em>'.
   * @see org.osate.assure.assure.Metrics
   * @generated
   */
  EClass getMetrics();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getTbdCount <em>Tbd Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tbd Count</em>'.
   * @see org.osate.assure.assure.Metrics#getTbdCount()
   * @see #getMetrics()
   * @generated
   */
  EAttribute getMetrics_TbdCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getSuccessCount <em>Success Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Success Count</em>'.
   * @see org.osate.assure.assure.Metrics#getSuccessCount()
   * @see #getMetrics()
   * @generated
   */
  EAttribute getMetrics_SuccessCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getFailCount <em>Fail Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fail Count</em>'.
   * @see org.osate.assure.assure.Metrics#getFailCount()
   * @see #getMetrics()
   * @generated
   */
  EAttribute getMetrics_FailCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getTimeoutCount <em>Timeout Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Timeout Count</em>'.
   * @see org.osate.assure.assure.Metrics#getTimeoutCount()
   * @see #getMetrics()
   * @generated
   */
  EAttribute getMetrics_TimeoutCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getErrorCount <em>Error Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Error Count</em>'.
   * @see org.osate.assure.assure.Metrics#getErrorCount()
   * @see #getMetrics()
   * @generated
   */
  EAttribute getMetrics_ErrorCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getDidelseCount <em>Didelse Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Didelse Count</em>'.
   * @see org.osate.assure.assure.Metrics#getDidelseCount()
   * @see #getMetrics()
   * @generated
   */
  EAttribute getMetrics_DidelseCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getThenskipCount <em>Thenskip Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Thenskip Count</em>'.
   * @see org.osate.assure.assure.Metrics#getThenskipCount()
   * @see #getMetrics()
   * @generated
   */
  EAttribute getMetrics_ThenskipCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getPreconditionfailCount <em>Preconditionfail Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Preconditionfail Count</em>'.
   * @see org.osate.assure.assure.Metrics#getPreconditionfailCount()
   * @see #getMetrics()
   * @generated
   */
  EAttribute getMetrics_PreconditionfailCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getValidationfailCount <em>Validationfail Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Validationfail Count</em>'.
   * @see org.osate.assure.assure.Metrics#getValidationfailCount()
   * @see #getMetrics()
   * @generated
   */
  EAttribute getMetrics_ValidationfailCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getWeight <em>Weight</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Weight</em>'.
   * @see org.osate.assure.assure.Metrics#getWeight()
   * @see #getMetrics()
   * @generated
   */
  EAttribute getMetrics_Weight();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getExecutionTime <em>Execution Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Execution Time</em>'.
   * @see org.osate.assure.assure.Metrics#getExecutionTime()
   * @see #getMetrics()
   * @generated
   */
  EAttribute getMetrics_ExecutionTime();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.QualifiedVerificationPlanElementReference <em>Qualified Verification Plan Element Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Verification Plan Element Reference</em>'.
   * @see org.osate.assure.assure.QualifiedVerificationPlanElementReference
   * @generated
   */
  EClass getQualifiedVerificationPlanElementReference();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.QualifiedVerificationPlanElementReference#getVerificationPlan <em>Verification Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Verification Plan</em>'.
   * @see org.osate.assure.assure.QualifiedVerificationPlanElementReference#getVerificationPlan()
   * @see #getQualifiedVerificationPlanElementReference()
   * @generated
   */
  EReference getQualifiedVerificationPlanElementReference_VerificationPlan();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.assure.assure.QualifiedVerificationPlanElementReference#getRequirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Requirement</em>'.
   * @see org.osate.assure.assure.QualifiedVerificationPlanElementReference#getRequirement()
   * @see #getQualifiedVerificationPlanElementReference()
   * @generated
   */
  EReference getQualifiedVerificationPlanElementReference_Requirement();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.QualifiedClaimReference <em>Qualified Claim Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Claim Reference</em>'.
   * @see org.osate.assure.assure.QualifiedClaimReference
   * @generated
   */
  EClass getQualifiedClaimReference();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.QualifiedVAReference <em>Qualified VA Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified VA Reference</em>'.
   * @see org.osate.assure.assure.QualifiedVAReference
   * @generated
   */
  EClass getQualifiedVAReference();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.QualifiedVAReference#getVerificationActivity <em>Verification Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Verification Activity</em>'.
   * @see org.osate.assure.assure.QualifiedVAReference#getVerificationActivity()
   * @see #getQualifiedVAReference()
   * @generated
   */
  EReference getQualifiedVAReference_VerificationActivity();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.NestedClaimReference <em>Nested Claim Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Claim Reference</em>'.
   * @see org.osate.assure.assure.NestedClaimReference
   * @generated
   */
  EClass getNestedClaimReference();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.NestedClaimReference#getRequirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Requirement</em>'.
   * @see org.osate.assure.assure.NestedClaimReference#getRequirement()
   * @see #getNestedClaimReference()
   * @generated
   */
  EReference getNestedClaimReference_Requirement();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.assure.assure.NestedClaimReference#getSub <em>Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub</em>'.
   * @see org.osate.assure.assure.NestedClaimReference#getSub()
   * @see #getNestedClaimReference()
   * @generated
   */
  EReference getNestedClaimReference_Sub();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.PreconditionResult <em>Precondition Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Precondition Result</em>'.
   * @see org.osate.assure.assure.PreconditionResult
   * @generated
   */
  EClass getPreconditionResult();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.PreconditionResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.PreconditionResult#getTarget()
   * @see #getPreconditionResult()
   * @generated
   */
  EReference getPreconditionResult_Target();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.ValidationResult <em>Validation Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Validation Result</em>'.
   * @see org.osate.assure.assure.ValidationResult
   * @generated
   */
  EClass getValidationResult();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.ValidationResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.ValidationResult#getTarget()
   * @see #getValidationResult()
   * @generated
   */
  EReference getValidationResult_Target();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.VerificationActivityResult <em>Verification Activity Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Activity Result</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult
   * @generated
   */
  EClass getVerificationActivityResult();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.assure.assure.VerificationActivityResult#getTargetReference <em>Target Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target Reference</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getTargetReference()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_TargetReference();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.assure.assure.VerificationActivityResult#getPreconditionResult <em>Precondition Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Precondition Result</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getPreconditionResult()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_PreconditionResult();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.assure.assure.VerificationActivityResult#getValidationResult <em>Validation Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Validation Result</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getValidationResult()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_ValidationResult();

  /**
   * Returns the meta object for enum '{@link org.osate.assure.assure.ElseType <em>Else Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Else Type</em>'.
   * @see org.osate.assure.assure.ElseType
   * @generated
   */
  EEnum getElseType();

  /**
   * Returns the meta object for enum '{@link org.osate.assure.assure.VerificationResultState <em>Verification Result State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Verification Result State</em>'.
   * @see org.osate.assure.assure.VerificationResultState
   * @generated
   */
  EEnum getVerificationResultState();

  /**
   * Returns the meta object for enum '{@link org.osate.assure.assure.VerificationExecutionState <em>Verification Execution State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Verification Execution State</em>'.
   * @see org.osate.assure.assure.VerificationExecutionState
   * @generated
   */
  EEnum getVerificationExecutionState();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AssureFactory getAssureFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.AssuranceCaseResultImpl <em>Assurance Case Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.AssuranceCaseResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssuranceCaseResult()
     * @generated
     */
    EClass ASSURANCE_CASE_RESULT = eINSTANCE.getAssuranceCaseResult();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_CASE_RESULT__NAME = eINSTANCE.getAssuranceCaseResult_Name();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_CASE_RESULT__MESSAGE = eINSTANCE.getAssuranceCaseResult_Message();

    /**
     * The meta object literal for the '<em><b>Model Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_CASE_RESULT__MODEL_RESULT = eINSTANCE.getAssuranceCaseResult_ModelResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.ModelResultImpl <em>Model Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.ModelResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getModelResult()
     * @generated
     */
    EClass MODEL_RESULT = eINSTANCE.getModelResult();

    /**
     * The meta object literal for the '<em><b>Plan</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_RESULT__PLAN = eINSTANCE.getModelResult_Plan();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_RESULT__TARGET = eINSTANCE.getModelResult_Target();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_RESULT__MESSAGE = eINSTANCE.getModelResult_Message();

    /**
     * The meta object literal for the '<em><b>Claim Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_RESULT__CLAIM_RESULT = eINSTANCE.getModelResult_ClaimResult();

    /**
     * The meta object literal for the '<em><b>Subsystem Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_RESULT__SUBSYSTEM_RESULT = eINSTANCE.getModelResult_SubsystemResult();

    /**
     * The meta object literal for the '<em><b>Sub Assurance Case</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_RESULT__SUB_ASSURANCE_CASE = eINSTANCE.getModelResult_SubAssuranceCase();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.SubsystemResultImpl <em>Subsystem Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.SubsystemResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getSubsystemResult()
     * @generated
     */
    EClass SUBSYSTEM_RESULT = eINSTANCE.getSubsystemResult();

    /**
     * The meta object literal for the '<em><b>Target System</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBSYSTEM_RESULT__TARGET_SYSTEM = eINSTANCE.getSubsystemResult_TargetSystem();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBSYSTEM_RESULT__MESSAGE = eINSTANCE.getSubsystemResult_Message();

    /**
     * The meta object literal for the '<em><b>Claim Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBSYSTEM_RESULT__CLAIM_RESULT = eINSTANCE.getSubsystemResult_ClaimResult();

    /**
     * The meta object literal for the '<em><b>Subsystem Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBSYSTEM_RESULT__SUBSYSTEM_RESULT = eINSTANCE.getSubsystemResult_SubsystemResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.ClaimResultImpl <em>Claim Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.ClaimResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getClaimResult()
     * @generated
     */
    EClass CLAIM_RESULT = eINSTANCE.getClaimResult();

    /**
     * The meta object literal for the '<em><b>Target Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__TARGET_REFERENCE = eINSTANCE.getClaimResult_TargetReference();

    /**
     * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__MODEL_ELEMENT = eINSTANCE.getClaimResult_ModelElement();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAIM_RESULT__MESSAGE = eINSTANCE.getClaimResult_Message();

    /**
     * The meta object literal for the '<em><b>Sub Claim Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__SUB_CLAIM_RESULT = eINSTANCE.getClaimResult_SubClaimResult();

    /**
     * The meta object literal for the '<em><b>Verification Activity Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT = eINSTANCE.getClaimResult_VerificationActivityResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.VerificationResultImpl <em>Verification Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.VerificationResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResult()
     * @generated
     */
    EClass VERIFICATION_RESULT = eINSTANCE.getVerificationResult();

    /**
     * The meta object literal for the '<em><b>Execution State</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__EXECUTION_STATE = eINSTANCE.getVerificationResult_ExecutionState();

    /**
     * The meta object literal for the '<em><b>Result State</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__RESULT_STATE = eINSTANCE.getVerificationResult_ResultState();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_RESULT__ISSUES = eINSTANCE.getVerificationResult_Issues();

    /**
     * The meta object literal for the '<em><b>Result Report</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_RESULT__RESULT_REPORT = eINSTANCE.getVerificationResult_ResultReport();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__MESSAGE = eINSTANCE.getVerificationResult_Message();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.AssureResultImpl <em>Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.AssureResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssureResult()
     * @generated
     */
    EClass ASSURE_RESULT = eINSTANCE.getAssureResult();

    /**
     * The meta object literal for the '<em><b>Metrics</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURE_RESULT__METRICS = eINSTANCE.getAssureResult_Metrics();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.VerificationExprImpl <em>Verification Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.VerificationExprImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationExpr()
     * @generated
     */
    EClass VERIFICATION_EXPR = eINSTANCE.getVerificationExpr();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.ElseResultImpl <em>Else Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.ElseResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getElseResult()
     * @generated
     */
    EClass ELSE_RESULT = eINSTANCE.getElseResult();

    /**
     * The meta object literal for the '<em><b>First</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE_RESULT__FIRST = eINSTANCE.getElseResult_First();

    /**
     * The meta object literal for the '<em><b>Error</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE_RESULT__ERROR = eINSTANCE.getElseResult_Error();

    /**
     * The meta object literal for the '<em><b>Fail</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE_RESULT__FAIL = eINSTANCE.getElseResult_Fail();

    /**
     * The meta object literal for the '<em><b>Timeout</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE_RESULT__TIMEOUT = eINSTANCE.getElseResult_Timeout();

    /**
     * The meta object literal for the '<em><b>Did Fail</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELSE_RESULT__DID_FAIL = eINSTANCE.getElseResult_DidFail();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.ThenResultImpl <em>Then Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.ThenResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getThenResult()
     * @generated
     */
    EClass THEN_RESULT = eINSTANCE.getThenResult();

    /**
     * The meta object literal for the '<em><b>First</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THEN_RESULT__FIRST = eINSTANCE.getThenResult_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THEN_RESULT__SECOND = eINSTANCE.getThenResult_Second();

    /**
     * The meta object literal for the '<em><b>Did Then Fail</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THEN_RESULT__DID_THEN_FAIL = eINSTANCE.getThenResult_DidThenFail();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.MetricsImpl <em>Metrics</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.MetricsImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getMetrics()
     * @generated
     */
    EClass METRICS = eINSTANCE.getMetrics();

    /**
     * The meta object literal for the '<em><b>Tbd Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METRICS__TBD_COUNT = eINSTANCE.getMetrics_TbdCount();

    /**
     * The meta object literal for the '<em><b>Success Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METRICS__SUCCESS_COUNT = eINSTANCE.getMetrics_SuccessCount();

    /**
     * The meta object literal for the '<em><b>Fail Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METRICS__FAIL_COUNT = eINSTANCE.getMetrics_FailCount();

    /**
     * The meta object literal for the '<em><b>Timeout Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METRICS__TIMEOUT_COUNT = eINSTANCE.getMetrics_TimeoutCount();

    /**
     * The meta object literal for the '<em><b>Error Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METRICS__ERROR_COUNT = eINSTANCE.getMetrics_ErrorCount();

    /**
     * The meta object literal for the '<em><b>Didelse Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METRICS__DIDELSE_COUNT = eINSTANCE.getMetrics_DidelseCount();

    /**
     * The meta object literal for the '<em><b>Thenskip Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METRICS__THENSKIP_COUNT = eINSTANCE.getMetrics_ThenskipCount();

    /**
     * The meta object literal for the '<em><b>Preconditionfail Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METRICS__PRECONDITIONFAIL_COUNT = eINSTANCE.getMetrics_PreconditionfailCount();

    /**
     * The meta object literal for the '<em><b>Validationfail Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METRICS__VALIDATIONFAIL_COUNT = eINSTANCE.getMetrics_ValidationfailCount();

    /**
     * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METRICS__WEIGHT = eINSTANCE.getMetrics_Weight();

    /**
     * The meta object literal for the '<em><b>Execution Time</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METRICS__EXECUTION_TIME = eINSTANCE.getMetrics_ExecutionTime();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.QualifiedVerificationPlanElementReferenceImpl <em>Qualified Verification Plan Element Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.QualifiedVerificationPlanElementReferenceImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedVerificationPlanElementReference()
     * @generated
     */
    EClass QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE = eINSTANCE.getQualifiedVerificationPlanElementReference();

    /**
     * The meta object literal for the '<em><b>Verification Plan</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN = eINSTANCE.getQualifiedVerificationPlanElementReference_VerificationPlan();

    /**
     * The meta object literal for the '<em><b>Requirement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT = eINSTANCE.getQualifiedVerificationPlanElementReference_Requirement();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.QualifiedClaimReferenceImpl <em>Qualified Claim Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.QualifiedClaimReferenceImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedClaimReference()
     * @generated
     */
    EClass QUALIFIED_CLAIM_REFERENCE = eINSTANCE.getQualifiedClaimReference();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.QualifiedVAReferenceImpl <em>Qualified VA Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.QualifiedVAReferenceImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedVAReference()
     * @generated
     */
    EClass QUALIFIED_VA_REFERENCE = eINSTANCE.getQualifiedVAReference();

    /**
     * The meta object literal for the '<em><b>Verification Activity</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY = eINSTANCE.getQualifiedVAReference_VerificationActivity();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.NestedClaimReferenceImpl <em>Nested Claim Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.NestedClaimReferenceImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getNestedClaimReference()
     * @generated
     */
    EClass NESTED_CLAIM_REFERENCE = eINSTANCE.getNestedClaimReference();

    /**
     * The meta object literal for the '<em><b>Requirement</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_CLAIM_REFERENCE__REQUIREMENT = eINSTANCE.getNestedClaimReference_Requirement();

    /**
     * The meta object literal for the '<em><b>Sub</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_CLAIM_REFERENCE__SUB = eINSTANCE.getNestedClaimReference_Sub();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.PreconditionResultImpl <em>Precondition Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.PreconditionResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getPreconditionResult()
     * @generated
     */
    EClass PRECONDITION_RESULT = eINSTANCE.getPreconditionResult();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRECONDITION_RESULT__TARGET = eINSTANCE.getPreconditionResult_Target();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.ValidationResultImpl <em>Validation Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.ValidationResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getValidationResult()
     * @generated
     */
    EClass VALIDATION_RESULT = eINSTANCE.getValidationResult();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALIDATION_RESULT__TARGET = eINSTANCE.getValidationResult_Target();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.VerificationActivityResultImpl <em>Verification Activity Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.VerificationActivityResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationActivityResult()
     * @generated
     */
    EClass VERIFICATION_ACTIVITY_RESULT = eINSTANCE.getVerificationActivityResult();

    /**
     * The meta object literal for the '<em><b>Target Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__TARGET_REFERENCE = eINSTANCE.getVerificationActivityResult_TargetReference();

    /**
     * The meta object literal for the '<em><b>Precondition Result</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT = eINSTANCE.getVerificationActivityResult_PreconditionResult();

    /**
     * The meta object literal for the '<em><b>Validation Result</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__VALIDATION_RESULT = eINSTANCE.getVerificationActivityResult_ValidationResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.ElseType <em>Else Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.ElseType
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getElseType()
     * @generated
     */
    EEnum ELSE_TYPE = eINSTANCE.getElseType();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.VerificationResultState <em>Verification Result State</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.VerificationResultState
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResultState()
     * @generated
     */
    EEnum VERIFICATION_RESULT_STATE = eINSTANCE.getVerificationResultState();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.VerificationExecutionState <em>Verification Execution State</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.VerificationExecutionState
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationExecutionState()
     * @generated
     */
    EEnum VERIFICATION_EXECUTION_STATE = eINSTANCE.getVerificationExecutionState();

  }

} //AssurePackage
