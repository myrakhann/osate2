/**
 */
package org.osate.verify.verify.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.categories.categories.VerificationCategory;

import org.osate.verify.verify.AtomicConditionExpr;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Condition Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.AtomicConditionExprImpl#getCat <em>Cat</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AtomicConditionExprImpl extends ConditionExprImpl implements AtomicConditionExpr
{
  /**
   * The cached value of the '{@link #getCat() <em>Cat</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCat()
   * @generated
   * @ordered
   */
  protected VerificationCategory cat;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AtomicConditionExprImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return VerifyPackage.Literals.ATOMIC_CONDITION_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationCategory getCat()
  {
    if (cat != null && cat.eIsProxy())
    {
      InternalEObject oldCat = (InternalEObject)cat;
      cat = (VerificationCategory)eResolveProxy(oldCat);
      if (cat != oldCat)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.ATOMIC_CONDITION_EXPR__CAT, oldCat, cat));
      }
    }
    return cat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationCategory basicGetCat()
  {
    return cat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCat(VerificationCategory newCat)
  {
    VerificationCategory oldCat = cat;
    cat = newCat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.ATOMIC_CONDITION_EXPR__CAT, oldCat, cat));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case VerifyPackage.ATOMIC_CONDITION_EXPR__CAT:
        if (resolve) return getCat();
        return basicGetCat();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VerifyPackage.ATOMIC_CONDITION_EXPR__CAT:
        setCat((VerificationCategory)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case VerifyPackage.ATOMIC_CONDITION_EXPR__CAT:
        setCat((VerificationCategory)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case VerifyPackage.ATOMIC_CONDITION_EXPR__CAT:
        return cat != null;
    }
    return super.eIsSet(featureID);
  }

} //AtomicConditionExprImpl
