/**
 */
package org.osate.expr.expr;

import org.osate.aadl2.UnitLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.UnitExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.osate.expr.expr.UnitExpression#isConvert <em>Convert</em>}</li>
 *   <li>{@link org.osate.expr.expr.UnitExpression#isDrop <em>Drop</em>}</li>
 *   <li>{@link org.osate.expr.expr.UnitExpression#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getUnitExpression()
 * @model
 * @generated
 */
public interface UnitExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see org.osate.expr.expr.ExprPackage#getUnitExpression_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.UnitExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Convert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Convert</em>' attribute.
   * @see #setConvert(boolean)
   * @see org.osate.expr.expr.ExprPackage#getUnitExpression_Convert()
   * @model
   * @generated
   */
  boolean isConvert();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.UnitExpression#isConvert <em>Convert</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Convert</em>' attribute.
   * @see #isConvert()
   * @generated
   */
  void setConvert(boolean value);

  /**
   * Returns the value of the '<em><b>Drop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Drop</em>' attribute.
   * @see #setDrop(boolean)
   * @see org.osate.expr.expr.ExprPackage#getUnitExpression_Drop()
   * @model
   * @generated
   */
  boolean isDrop();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.UnitExpression#isDrop <em>Drop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Drop</em>' attribute.
   * @see #isDrop()
   * @generated
   */
  void setDrop(boolean value);

  /**
   * Returns the value of the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' reference.
   * @see #setUnit(UnitLiteral)
   * @see org.osate.expr.expr.ExprPackage#getUnitExpression_Unit()
   * @model
   * @generated
   */
  UnitLiteral getUnit();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.UnitExpression#getUnit <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitLiteral value);

} // UnitExpression
