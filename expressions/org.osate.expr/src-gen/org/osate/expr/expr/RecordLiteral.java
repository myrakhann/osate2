/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.RecordLiteral#getFieldValues <em>Field Values</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getRecordLiteral()
 * @model
 * @generated
 */
public interface RecordLiteral extends Literal
{
  /**
   * Returns the value of the '<em><b>Field Values</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.expr.expr.FieldValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field Values</em>' containment reference list.
   * @see org.osate.expr.expr.ExprPackage#getRecordLiteral_FieldValues()
   * @model containment="true"
   * @generated
   */
  EList<FieldValue> getFieldValues();

} // RecordLiteral
