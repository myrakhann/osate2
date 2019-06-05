/**
 */
package org.osate.expr.expr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Meta Class Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.expr.expr.ExprPackage#getMetaClassEnum()
 * @model
 * @generated
 */
public enum MetaClassEnum implements Enumerator
{
  /**
   * The '<em><b>COMPONENT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPONENT_VALUE
   * @generated
   * @ordered
   */
  COMPONENT(0, "COMPONENT", "component"),

  /**
   * The '<em><b>FEATURE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FEATURE_VALUE
   * @generated
   * @ordered
   */
  FEATURE(1, "FEATURE", "feature"),

  /**
   * The '<em><b>CONNECTION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONNECTION_VALUE
   * @generated
   * @ordered
   */
  CONNECTION(2, "CONNECTION", "connection"),

  /**
   * The '<em><b>FLOW</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FLOW_VALUE
   * @generated
   * @ordered
   */
  FLOW(3, "FLOW", "flow"),

  /**
   * The '<em><b>MODE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MODE_VALUE
   * @generated
   * @ordered
   */
  MODE(4, "MODE", "mode"),

  /**
   * The '<em><b>PROPERTY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROPERTY_VALUE
   * @generated
   * @ordered
   */
  PROPERTY(5, "PROPERTY", "property");

  /**
   * The '<em><b>COMPONENT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COMPONENT
   * @model literal="component"
   * @generated
   * @ordered
   */
  public static final int COMPONENT_VALUE = 0;

  /**
   * The '<em><b>FEATURE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FEATURE
   * @model literal="feature"
   * @generated
   * @ordered
   */
  public static final int FEATURE_VALUE = 1;

  /**
   * The '<em><b>CONNECTION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONNECTION
   * @model literal="connection"
   * @generated
   * @ordered
   */
  public static final int CONNECTION_VALUE = 2;

  /**
   * The '<em><b>FLOW</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FLOW
   * @model literal="flow"
   * @generated
   * @ordered
   */
  public static final int FLOW_VALUE = 3;

  /**
   * The '<em><b>MODE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MODE
   * @model literal="mode"
   * @generated
   * @ordered
   */
  public static final int MODE_VALUE = 4;

  /**
   * The '<em><b>PROPERTY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROPERTY
   * @model literal="property"
   * @generated
   * @ordered
   */
  public static final int PROPERTY_VALUE = 5;

  /**
   * An array of all the '<em><b>Meta Class Enum</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final MetaClassEnum[] VALUES_ARRAY =
    new MetaClassEnum[]
    {
      COMPONENT,
      FEATURE,
      CONNECTION,
      FLOW,
      MODE,
      PROPERTY,
    };

  /**
   * A public read-only list of all the '<em><b>Meta Class Enum</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<MetaClassEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Meta Class Enum</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static MetaClassEnum get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      MetaClassEnum result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Meta Class Enum</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static MetaClassEnum getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      MetaClassEnum result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Meta Class Enum</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static MetaClassEnum get(int value)
  {
    switch (value)
    {
      case COMPONENT_VALUE: return COMPONENT;
      case FEATURE_VALUE: return FEATURE;
      case CONNECTION_VALUE: return CONNECTION;
      case FLOW_VALUE: return FLOW;
      case MODE_VALUE: return MODE;
      case PROPERTY_VALUE: return PROPERTY;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private MetaClassEnum(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //MetaClassEnum
