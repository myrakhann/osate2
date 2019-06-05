/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexSubclause;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.ExprSubclause#getDecls <em>Decls</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getExprSubclause()
 * @model
 * @generated
 */
public interface ExprSubclause extends EObject, AnnexSubclause
{
  /**
   * Returns the value of the '<em><b>Decls</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.expr.expr.EDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decls</em>' containment reference list.
   * @see org.osate.expr.expr.ExprPackage#getExprSubclause_Decls()
   * @model containment="true"
   * @generated
   */
  EList<EDeclaration> getDecls();

} // ExprSubclause
