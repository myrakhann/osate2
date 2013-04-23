/**
 * AADL-Utils
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource ;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element ;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.util.Aadl2ResourceImpl ;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService ;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/**
 * Toolbox to extract property values from AADL components instances.
 */
public class PropertyUtils {
  
  /*
  *
  * <copyright>
  * Copyright  2012 by Carnegie Mellon University, all rights reserved.
  *
  * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
  * at http://www.eclipse.org/org/documents/epl-v10.html.
  *
  * NO WARRANTY
  *
  * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
  * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
  * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
  * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
  * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
  * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
  * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
  * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
  * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
  *
  * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
  * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
  * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
  * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
  * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
  * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
  *
  * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
  * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
  * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
  * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
  * under the contract clause at 252.227.7013.
  * </copyright>
  */
  /**
   * Same as : {@link  org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService#getPropertiesLinkingService(Element)}
   * <br><br>
   * keep this method because it is tagged deprecated and when using the default
   * constructor PropertiesLinkingService doesn't find any propertyset.
   */
  public static PropertiesLinkingService getPropertiesLinkingService(Element context)
  {
    PropertiesLinkingService result = null ;
    
    if (result == null) {
      if (context.eResource() instanceof Aadl2ResourceImpl){
        Element root = context.getElementRoot();
        if (root instanceof SystemInstance){
          SystemImplementation si = ((SystemInstance)root).getSystemImplementation();
          LazyLinkingResource r = (LazyLinkingResource)si.eResource();
          result = (PropertiesLinkingService)r.getLinkingService();
        }
      } else {
        LazyLinkingResource r = (LazyLinkingResource)context.eResource();
        result = (PropertiesLinkingService)r.getLinkingService();
      }
    }
    return result;
  }
  
  public static PropertyAssociation findProperty(String propertyName, NamedElement owner) {
		for (PropertyAssociation pa : owner.getOwnedPropertyAssociations()) {
			if (pa.getProperty().getName() == null) {
				continue;
			}

			if (pa.getProperty().getName().equalsIgnoreCase(propertyName)) {
				return pa;
			}
		}

		if(owner.eContainer()!=null && owner.eContainer() instanceof NamedElement)
		{
			for (PropertyAssociation pa : ((NamedElement)owner.eContainer()).getOwnedPropertyAssociations()) {
				if (pa.getProperty().getName() == null) {
					continue;
				}

				if (pa.getProperty().getName().equalsIgnoreCase(propertyName) && 
						isInAppliesTo(pa, owner)) {
					return pa;
				}
			}
		}
		if (owner instanceof ComponentInstance) {
			ComponentInstance inst = (ComponentInstance) owner;
			ComponentImplementation impl = inst.getContainingComponentImpl();
			return findProperty(propertyName, impl);
		} else if (owner instanceof ComponentImplementation) {
			ComponentImplementation impl = (ComponentImplementation) owner;
			ComponentType type = impl.getType();
			return findProperty(propertyName, type);
		}

		return null;
	}
	
	private static boolean isInAppliesTo(PropertyAssociation pa, NamedElement owner)
	{
		for (ContainedNamedElement cne: pa.getAppliesTos())
		{
			for(ContainmentPathElement cpe: cne.getContainmentPathElements())
			{
				if(cpe.getNamedElement().equals(owner))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Extract integer value from a specified property.
	 * 
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 * @throws Exception
	 *             thrown if property does not exist or if is not an integer.
	 */
	public static long getIntValue(NamedElement i, String propertyName) throws Exception {
		PropertyAssociation pa = findProperty(propertyName, i);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof IntegerLiteral) {
						IntegerLiteral il = (IntegerLiteral) expr;
						final UnitLiteral unit = il.getUnit();
						if (unit != null) {
							if (pa.getProperty().getPropertyType() instanceof AadlInteger) {
								// XXX: Ms and Bytes are chosen for base units;
								// this is specific for POK
								AadlInteger ai = (AadlInteger) pa.getProperty().getPropertyType();
								if (ai.getUnitsType().getName().equalsIgnoreCase(AadlProject.SIZE_UNITS))
									unit.setBaseUnit(GetProperties.findUnitLiteral(p,
											                                  AadlProject.B_LITERAL));
								if (ai.getUnitsType().getName().equalsIgnoreCase(AadlProject.TIME_UNITS))
									unit.setBaseUnit(GetProperties.findUnitLiteral(p,
											AadlProject.MS_LITERAL));
							}
							// Warning: the cast from double to long is licit
							// only if the result of the conversion is an
							// integer
							return (long) il.getScaledValue(unit.getBaseUnit());
						}

						return ((IntegerLiteral) expr).getValue();
					}
				}
			}
		}

		throw new Exception("Property " + propertyName + " not found for " + i.getName());
	}

	public static RecordValue getRecordValue(NamedElement i, String propertyName) throws Exception {
		PropertyAssociation pa = findProperty(propertyName, i);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof RecordValue) {
						return ((RecordValue) expr);
					}
				}
			}
		}

		throw new Exception("Property " + propertyName + " not found for " + i.getName());
	}

	/**
	 * Extract float value from a specified property.
	 * 
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 * @throws Exception
	 *             thrown if property does not exist or if is not an integer.
	 */
	public static float getFloatValue(NamedElement i, String propertyName, String unit) throws Exception {
		PropertyAssociation pa = findProperty(propertyName, i);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof NumberValue) {
						NumberValue val = (NumberValue) expr;
						float fVal = 0f;

						if (val instanceof IntegerLiteral) {
							fVal = ((IntegerLiteral) val).getValue();
						} else if (val instanceof RealLiteral) {
							fVal = (float) ((RealLiteral) val).getValue();
						}

						return UnitConversion.convertInMs(fVal, val.getUnit().getName());
					}
				}
			}
		}
		// try on a refined NamedElement
		if(i instanceof RefinableElement)
		{
		  RefinableElement re = (RefinableElement) i;
		  if(re.getRefinedElement()!=null)
			return getFloatValue(re.getRefinedElement(), propertyName, unit);
		}
		throw new Exception("Property " + propertyName + " not found for " + i.getName());
	}

	/**
	 * Extract float value from a specified property.
	 * 
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 * @throws Exception
	 *             thrown if property does not exist or if is not an integer.
	 */
	public static float getFloatValue(NamedElement i, String propertyName) throws Exception {
		PropertyAssociation pa = findProperty(propertyName, i);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof IntegerLiteral) {
						return (float) ((IntegerLiteral) expr).getValue();
					} else if (expr instanceof RealLiteral) {
						return (float) ((RealLiteral) expr).getValue();
					}
				}
			}
		}
		// try on a refined NamedElement
		if(i instanceof RefinableElement)
		{
		  RefinableElement re = (RefinableElement) i;
		  if(re.getRefinedElement()!=null)
			return getFloatValue(re.getRefinedElement(), propertyName);
		}
		throw new Exception("Property " + propertyName + " not found for " + i.getName());
	}

	/**
	 * Extract boolean value from a specified property.
	 * 
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 * @throws Exception
	 *             thrown if property does not exist or if is not a Boolean.
	 */
	public static boolean getBooleanValue(NamedElement i, String propertyName) throws Exception {
		PropertyAssociation pa = findProperty(propertyName, i);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof BooleanLiteral) {
						return (boolean) ((BooleanLiteral) expr).getValue();
					}
				}
			}
		}

		throw new Exception("Property " + propertyName + " not found for " + i.getName());
	}

	/**
	 * Extract String value from a specified property.
	 * 
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 * @throws Exception
	 *             thrown if property does not exist or if is not a String.
	 */
	public static String getStringValue(NamedElement i, String propertyName) throws Exception {
		PropertyAssociation pa = findProperty(propertyName, i);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof StringLiteral) {
						return ((StringLiteral) expr).getValue();
					}
				}
			}
		}

		throw new Exception("Property " + propertyName + " not found for " + i.getName());
	}

	/**
	 * Extract String list value from a specified property.
	 * 
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 * @throws Exception
	 *             thrown if property does not exist or if is not a String.
	 */
	public static List<String> getStringListValue(NamedElement i, String propertyName) throws Exception {
		List<String> res = new ArrayList<String>();
		PropertyAssociation pa = findProperty(propertyName, i);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof ListValue) {
						ListValue lv = (ListValue) expr;

						for (PropertyExpression pe : lv.getOwnedListElements()) {
							if (pe instanceof StringLiteral) {
								StringLiteral sl = (StringLiteral) pe;
								res.add(sl.getValue());
							} else if (pe instanceof NamedValue) {
								NamedValue nv = (NamedValue) pe;

								if (nv.getNamedValue() instanceof EnumerationLiteral) {
									EnumerationLiteral el = (EnumerationLiteral) nv.getNamedValue();
									res.add(el.getName());
								}
							}
						}

						if (!res.isEmpty()) {
							return res;
						}
					}
				}
			}
		}

		throw new Exception("Property " + propertyName + " not found for " + i.getName());
	}

	/**
	 * Extract enumeration value from a specified property.
	 * 
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 * @throws Exception
	 *             thrown if property does not exist or if is not an
	 *             enumeration.
	 */
	public static String getEnumValue(NamedElement i, String propertyName) throws Exception {
		PropertyAssociation pa = findProperty(propertyName, i);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof EnumerationLiteral) {
						return ((EnumerationLiteral) expr).getName();
					} else if (expr instanceof NamedValue) {
						NamedValue nv = (NamedValue) expr;

						if (nv.getNamedValue() instanceof EnumerationLiteral) {
							EnumerationLiteral el = (EnumerationLiteral) nv.getNamedValue();
							return el.getName();
						}
					}
				}
			}
		}
		// try on a refined NamedElement
		if(i instanceof RefinableElement)
		{
		  RefinableElement re = (RefinableElement) i;
		  if(re.getRefinedElement()!=null)
			return getEnumValue(re.getRefinedElement(), propertyName);
		}
		throw new Exception("Property " + propertyName + " not found for " + i.getName());
	}

	/**
	 * Extract range value from a specified property.
	 * 
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static RangeValue getRangeValue(NamedElement i, String propertyName) {
		PropertyAssociation pa = findProperty(propertyName, i);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof RangeValue) {
						return (RangeValue) expr;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Extract minimum range value from a specified property.
	 * 
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 * @throws Exception
	 *             thrown if property does not exist or if is not a range.
	 */
	public static float getMinRangeValue(NamedElement i, String propertyName) throws Exception {
		PropertyAssociation pa = findProperty(propertyName, i);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof RangeValue) {
						NumberValue n = ((RangeValue) expr).getMinimumValue();

						if (n instanceof IntegerLiteral) {
							return (float) ((IntegerLiteral) n).getValue();
						} else if (n instanceof RealLiteral) {
							return (float) ((RealLiteral) n).getValue();
						}
					} else if (expr instanceof IntegerLiteral) {
						return (float) ((IntegerLiteral) expr).getValue();
					} else if (expr instanceof RealLiteral) {
						return (float) ((RealLiteral) expr).getValue();
					}
				}
			}
		}

		throw new Exception("Property " + propertyName + " not found for " + i.getName());
	}

	/**
	 * Extract maximum range value from a specified property.
	 * 
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 * @throws Exception
	 *             thrown if property does not exist or if is not a range.
	 */
	public static float getMaxRangeValue(NamedElement i, String propertyName) throws Exception {
		PropertyAssociation pa = findProperty(propertyName, i);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof RangeValue) {
						NumberValue n = ((RangeValue) expr).getMaximumValue();

						if (n instanceof IntegerLiteral) {
							return ((IntegerLiteral) n).getValue();
						} else if (n instanceof RealLiteral) {
							return (float) ((RealLiteral) n).getValue();
						}
					} else if (expr instanceof IntegerLiteral) {
						return ((IntegerLiteral) expr).getValue();
					} else if (expr instanceof RealLiteral) {
						return (float) ((RealLiteral) expr).getValue();
					}
				}
			}
		}

		throw new Exception("Property " + propertyName + " not found for " + i.getName());
	}

	/**
	 * Extract maximum range value from a specified property.
	 * 
	 * @param i
	 *            component instance.
	 * @param propertyName
	 *            property name.
	 * @return property value.
	 */
	public static float getMaxRangeValue(NamedElement i, String propertyName, float defaultValue) {
		try {
			return getMaxRangeValue(i, propertyName);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static ComponentInstance getPropertyComponentRef(String propertyName, NamedElement owner) throws Exception {
		PropertyExpression val = getPropertyValue(propertyName, owner);
		return (ComponentInstance) ((InstanceReferenceValue) val).getReferencedInstanceObject();
	}

	public static PropertyExpression getPropertyValue(String propertyName, NamedElement owner) throws Exception {
		PropertyAssociation assign = findProperty(propertyName, owner);

		if (assign != null) {
			return assign.getOwnedValues().get(0).getOwnedValue();
		}

		throw new Exception("Property " + propertyName + " not found for " + owner.getName());
	}

	public static Classifier getClassifierValue(NamedElement owner, String propertyName) throws Exception {
		PropertyAssociation pa = findProperty(propertyName, owner);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof ClassifierValue) {
						return ((ClassifierValue) expr).getClassifier();
					}
				}
			}
		}

		throw new Exception("Property " + propertyName + " not found for " + owner.getName());
	}

	public static PropertyAssociation createIntegerAssignment(String propertyName, long value) {
		Property property = Aadl2Factory.eINSTANCE.createProperty();
		PropertyAssociation assignment = Aadl2Factory.eINSTANCE.createPropertyAssociation();
		ModalPropertyValue modalPropertyValue = Aadl2Factory.eINSTANCE.createModalPropertyValue();
		IntegerLiteral propertyValue = Aadl2Factory.eINSTANCE.createIntegerLiteral();
		property.setName(propertyName);
		propertyValue.setValue(value);
		modalPropertyValue.setOwnedValue(propertyValue);
		assignment.setProperty(property);
		assignment.getOwnedValues().add(modalPropertyValue);
		return assignment;
	}

	public static boolean setFloatValue(NamedElement e, String propertyName, float value) {
		PropertyAssociation pa = findProperty(propertyName, e);

		if (pa != null) {
			RealLiteral r = Aadl2Factory.eINSTANCE.createRealLiteral();
			r.setValue(value);
			r.setUnit(getUnit(pa));
			pa.getOwnedValues().get(0).setOwnedValue(r);
			return true;
		}

		return false;
	}

	private static UnitLiteral getUnit(PropertyAssociation pa) {
		PropertyExpression e = pa.getOwnedValues().get(0).getOwnedValue();
		if (e instanceof NumberValue) {
		  return ((NumberValue) e).getUnit();
		} else if (e instanceof RangeValue) {
		  return ((RangeValue) e).getMaximumValue().getUnit();
		} else {
		  return null;
		}
	}
	
  public static List<ComponentInstance> getComponentInstanceList(NamedElement object,
                        String propertyName)
  {
    List<ComponentInstance> res = new ArrayList<ComponentInstance>() ;
    PropertyAssociation pa = findProperty(propertyName, object) ;

    if(pa != null)
    {
      Property p = pa.getProperty() ;

      if(p.getName().equals(propertyName))
      {
        List<ModalPropertyValue> values = pa.getOwnedValues() ;

        if(values.size() == 1)
        {
          ModalPropertyValue v = values.get(0) ;
          PropertyExpression expr = v.getOwnedValue() ;

          if(expr instanceof ListValue)
          {
            ListValue lv = (ListValue) expr ;

            for(PropertyExpression pe : lv.getOwnedListElements())
            {
              if(pe instanceof InstanceReferenceValue)
              {
                InstanceReferenceValue c = ((InstanceReferenceValue) pe) ;
                res.add((ComponentInstance)c.getReferencedInstanceObject()) ;
              }
            }
          }
        }
      }
    }

    return res ;
  }
  
  public static List<Subcomponent> getSubcomponentList(NamedElement object,
                                                       String propertyName) throws Exception
  {
    List<Subcomponent> res = new ArrayList<Subcomponent>() ;
    PropertyAssociation pa = findProperty(propertyName, object) ;
    if (pa == null)
      throw new Exception("Could not find property " + propertyName + " on " + object.getName() + " component.");
    else {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) 
      {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof ListValue) {
            ListValue lv = (ListValue) expr;
            
            for(PropertyExpression pe : lv.getOwnedListElements())
            {
              if(pe instanceof ReferenceValue)
              {
                ReferenceValue c = ((ReferenceValue) pe) ;
                for(ContainmentPathElement cpe :
                  c.getContainmentPathElements())
                {
                  res.add((Subcomponent) cpe.getNamedElement()) ;
                }
              }
            }
          }
        }
      }
      return res;
    }
  }
  

	public static List<Long> getIntListValue(NamedElement object, String propertyName) throws Exception {
		List<Long> res = new ArrayList<Long>();
		PropertyAssociation pa = findProperty(propertyName, object);

		if (pa == null)
			throw new Exception("Could not find property " + propertyName + " on " + object.getName() + " component.");
		else {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof ListValue) {
						ListValue lv = (ListValue) expr;

						for (PropertyExpression pe : lv.getOwnedListElements()) {
							if (pe instanceof IntegerLiteral) {
								Long c = ((IntegerLiteral) pe).getValue();
								res.add(c);
							}
						}
					}
				}
			}
		}
		// try on a refined NamedElement
		if(object instanceof RefinableElement)
		{
		  RefinableElement re = (RefinableElement) object;
		  if(re.getRefinedElement()!=null)
			res.addAll(getIntListValue((ProcessorSubcomponent)re.getRefinedElement(), propertyName));
		}
		return res;
	}

	public static List<Subcomponent> getSubcomponentList(ProcessorSubcomponent object, String propertyName) {
		List<Subcomponent> res = new ArrayList<Subcomponent>();
		PropertyAssociation pa = findProperty(propertyName, object);

		if (pa != null) {
			Property p = pa.getProperty();

			if (p.getName().equalsIgnoreCase(propertyName)) {
				List<ModalPropertyValue> values = pa.getOwnedValues();

				if (values.size() == 1) {
					ModalPropertyValue v = values.get(0);
					PropertyExpression expr = v.getOwnedValue();

					if (expr instanceof ListValue) {
						ListValue lv = (ListValue) expr;

						for (PropertyExpression pe : lv.getOwnedListElements()) {
							if (pe instanceof ReferenceValue) {
								ReferenceValue c = ((ReferenceValue) pe);
								ContainmentPathElement cpe = c.getContainmentPathElements().get(c.getContainmentPathElements().size()-1);
								res.add((Subcomponent) cpe.getNamedElement());
							}
						}
					}
				}
			}
		}
		// try on a refined NamedElement
		if(object instanceof RefinableElement)
		{
		  RefinableElement re = (RefinableElement) object;
		  if(re.getRefinedElement()!=null)
			res.addAll(getSubcomponentList((ProcessorSubcomponent)re.getRefinedElement(), propertyName));
		}
		return res;
	}
	
	 /**
   * Returns the list of property expressions (PropertyExpression) associated
   * to a given property name within a given component and its ancestor if the
   * given component is a component implementation. The returned list'size 
   * is > 1 when the given component associated to the given classifier has
   * refined the given property.
   * 
   * @param cc the given component
   * @param propertyName the given property
   * @return the list of property expressions. The list may be empty.
   */
  public static EList<PropertyExpression> getPropertyExpression(Classifier cc,
                                                  String propertyName)
    {
    EList<PropertyExpression> result = new BasicEList<PropertyExpression>();
 
    EList<PropertyAssociation> lpa = getPropertyAssociations(cc,
                                                         propertyName) ;
    
    for (PropertyAssociation pa : lpa)
    {
      result.addAll(getPropertyExpression(pa)) ;
    }

    // If no property value is found, search within parent container if only
    // the given component is a component implementation. Recursive call.
    if(result.isEmpty() && cc instanceof ComponentImplementation )
    {
      cc = ((ComponentImplementation) cc).getType() ;
      result = getPropertyExpression(cc, propertyName) ;
    }

    return result ;
    }
  
  /**
   * Returns the property association which match
   * the given propertyName if it is defined
   * 
   * @param cc a given component classifier
   * @param propertyName a given property name
   * @return the property association
   */
  public static PropertyAssociation getPropertyAssociation(Classifier cc,
                                                           String propertyName)
  {
    Property p = null ;

    // FIXME : TODO : improve function, get properties from component type
    // too
    if(!cc.isNoProperties())
    {
      for(PropertyAssociation pa : cc.getAllPropertyAssociations())
      {
        p = pa.getProperty() ;
        if(p.getName().equalsIgnoreCase(propertyName))
        {
          return pa ;
        }
      }
    }
    return null ;
  }
  
  public static PropertyAssociation getPropertyAssociation(NamedElement c,
		  												   String propertyName)
  {
	Property p = null ;
	  
    for(PropertyAssociation pa : c.getOwnedPropertyAssociations())
    {
      p = pa.getProperty();
      if(p.getName().equalsIgnoreCase(propertyName))
      {
        return pa ;
      }
    }
    return null;
  }

  /**
   * Returns the list of property association which match
   * the given propertyName if several property association
   * is defined
   * 
   * @param cc a given component classifier
   * @param propertyName a given property name
   * @return the list of property association which match
   * the given propertyName
   */
  public static EList<PropertyAssociation> getPropertyAssociations(
                                                                  Classifier cc,
                                                            String propertyName)
  {
    Property p = null ;
    EList<PropertyAssociation> lpa = null ;

    EList<PropertyAssociation> lparesult = 
                                   new BasicEList<PropertyAssociation>() ;
    
    // FIXME : TODO : improve function, get properties from component type
    // too
    if(cc != null && !cc.isNoProperties())
    {
      lpa = cc.getAllPropertyAssociations() ;

      for(PropertyAssociation pa : lpa)
      {
        p = pa.getProperty() ;
        // Sometime, properties don't have name.
        if(p.getName() != null && p.getName().
                                     equalsIgnoreCase(propertyName))
        {
          lparesult.add(pa) ;
        }
      }
      if(lparesult.isEmpty() && cc.getExtended() != null)
      	lparesult.addAll(getPropertyAssociations(cc.getExtended(), propertyName));
    }
    return lparesult ;
  }

  /**
   * Returns the list of PropertyExpression objects binded to the 
   * given PropertyAssociation.
   * 
   * @param pa the given property association
   * @return the list of property expressions
   */

  public static EList<PropertyExpression> getPropertyExpression(
                                                   PropertyAssociation pa)
  {
    EList<ModalPropertyValue> lmpv = null ;
    EList<PropertyExpression> result = new BasicEList<PropertyExpression>();

    lmpv = pa.getOwnedValues() ;

    for(ModalPropertyValue mpv : lmpv)  
    {
      result.add(mpv.getOwnedValue());
    }
    return result ;
  }
}
