/**
 */
package org.osate.expr.expr;

import org.osate.aadl2.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.VarDecl#isConst <em>Const</em>}</li>
 *   <li>{@link org.osate.expr.expr.VarDecl#getDeclType <em>Decl Type</em>}</li>
 *   <li>{@link org.osate.expr.expr.VarDecl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getVarDecl()
 * @model
 * @generated
 */
public interface VarDecl extends EDeclaration
{
  /**
   * Returns the value of the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Const</em>' attribute.
   * @see #setConst(boolean)
   * @see org.osate.expr.expr.ExprPackage#getVarDecl_Const()
   * @model
   * @generated
   */
  boolean isConst();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.VarDecl#isConst <em>Const</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Const</em>' attribute.
   * @see #isConst()
   * @generated
   */
  void setConst(boolean value);

  /**
   * Returns the value of the '<em><b>Decl Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decl Type</em>' containment reference.
   * @see #setDeclType(Type)
   * @see org.osate.expr.expr.ExprPackage#getVarDecl_DeclType()
   * @model containment="true"
   * @generated
   */
  Type getDeclType();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.VarDecl#getDeclType <em>Decl Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decl Type</em>' containment reference.
   * @see #getDeclType()
   * @generated
   */
  void setDeclType(Type value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Expression)
   * @see org.osate.expr.expr.ExprPackage#getVarDecl_Value()
   * @model containment="true"
   * @generated
   */
  Expression getValue();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.VarDecl#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Expression value);

} // VarDecl
