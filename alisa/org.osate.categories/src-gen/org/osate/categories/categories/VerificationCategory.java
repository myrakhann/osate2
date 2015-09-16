/**
 */
package org.osate.categories.categories;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.categories.categories.VerificationCategory#getSubCategories <em>Sub Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.categories.categories.CategoriesPackage#getVerificationCategory()
 * @model
 * @generated
 */
public interface VerificationCategory extends Category
{
  /**
   * Returns the value of the '<em><b>Sub Categories</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.VerificationCategory}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Categories</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Categories</em>' reference list.
   * @see org.osate.categories.categories.CategoriesPackage#getVerificationCategory_SubCategories()
   * @model
   * @generated
   */
  EList<VerificationCategory> getSubCategories();

} // VerificationCategory