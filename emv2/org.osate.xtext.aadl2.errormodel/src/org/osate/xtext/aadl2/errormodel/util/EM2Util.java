package org.osate.xtext.aadl2.errormodel.util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EBSMUseContext;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeUseContext;

public class EM2Util {
	
	public static String ErrorModelAnnexName = "EMV2";

	/**
	 * get error propagations object in the classifier containing the element object.
	 * The extends hierarchy and the type in the case of an implementation are searched for the error propagations declaration
	 * This object contains the list of propagations and error flows.
	 * @param element declarative model element or error annex element
	 * @return ErrorPropagations
	 */
	public static ErrorPropagations getContainingErrorPropagations(EObject element) {
		ErrorPropagations result = null;
		Classifier cl = AadlUtil.getContainingClassifier(element);
		if (cl == null) return null;
		ErrorModelSubclause ems = getErrorModelSubclause(cl);
		if (ems != null) result = ems.getPropagation();
		if (result != null) return result;
		if (cl instanceof ComponentImplementation){
			ems = getErrorModelSubclause(((ComponentImplementation)cl).getType());
			if (ems != null) result = ems.getPropagation();
			if (result != null) return result;
		}
		if (!Aadl2Util.isNull(cl.getExtended())){
			return  getContainingErrorPropagations(cl.getExtended());
		}
		return null;
	}
	
	/**
	 * find the error propagation point of the specified name
	 * @param eps List of error propagations
	 * @param eppName Name of error propagation point we are looking for
	 * @param pd Directiontype
	 * @param isNot boolean Error Containment
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findErrorPropagation(ErrorPropagations eps, String eppName, DirectionType pd, boolean isNot){
		for (ErrorPropagation ep : eps.getPropagations()) {
			Feature f = ep.getFeature();
			if (ep.isNot() == isNot && ep.getDirection() == pd && !Aadl2Util.isNull(f)&&(eppName.equalsIgnoreCase(f.getName())||eppName.equalsIgnoreCase(ep.getKind()))){
				return ep;
			}
		}
		return null;
	}
	
	/**
	 * find the outgoing error propagation point of the specified name
	 * @param eps List of error propagations
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findIncomingErrorPropagation(ErrorPropagations eps, String eppName){
		return findErrorPropagation(eps, eppName, DirectionType.IN,false);
	}
	
	/**
	 * find the outgoing error propagation point of the specified name
	 * @param eps List of error propagations
	 * @param eppName Name of error propagation point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findOutgoingErrorPropagation(ErrorPropagations eps, String eppName){
		return findErrorPropagation(eps, eppName, DirectionType.OUT,false);
	}
	
	/**
	 * find the outgoing error containment point of the specified name
	 * @param eps List of error propagations
	 * @param eppName Name of error containment point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findIncomingErrorContainment(ErrorPropagations eps, String eppName){
		return findErrorPropagation(eps, eppName, DirectionType.IN,true);
	}
	
	/**
	 * find the outgoing error containment point of the specified name
	 * @param eps List of error propagations
	 * @param eppName Name of error containment point we are looking for
	 * @return ErrorPropagation
	 */
	public static ErrorPropagation findOutgoingErrorContainment(ErrorPropagations eps, String eppName){
		return findErrorPropagation(eps, eppName, DirectionType.OUT,true);
	}
	
	/**
	 * Get outgoing error propagation associated with feature instance
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingErrorPropagation(FeatureInstance fi){
		ComponentInstance ci = fi.getContainingComponentInstance();
		ErrorPropagations eps = EM2Util.getContainingErrorPropagations(ci.getComponentClassifier());
		ErrorPropagation ep = EM2Util.findOutgoingErrorPropagation(eps, fi.getName());
		return ep;
	}
	
	/**
	 * Get incoming error propagation associated with feature instance
	 * @param fi feature instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingErrorPropagation(FeatureInstance fi){
		ComponentInstance ci = fi.getContainingComponentInstance();
		ErrorPropagations eps = EM2Util.getContainingErrorPropagations(ci.getComponentClassifier());
		ErrorPropagation ep = EM2Util.findIncomingErrorPropagation(eps, fi.getName());
		return ep;
	}
	
	/**
	 * Get incoming error propagation associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getIncomingAccessErrorPropagation(ComponentInstance ci){
		ErrorPropagations eps = EM2Util.getContainingErrorPropagations(ci.getComponentClassifier());
		ErrorPropagation ep = EM2Util.findIncomingErrorPropagation(eps, "access");
		return ep;
	}
	
	/**
	 * Get outgoing error propagation associated with component instance access
	 * @param ci component instance
	 * @return error propagation
	 */
	public static ErrorPropagation getOutgoingAccessErrorPropagation(ComponentInstance ci){
		ErrorPropagations eps = EM2Util.getContainingErrorPropagations(ci.getComponentClassifier());
		ErrorPropagation ep = EM2Util.findOutgoingErrorPropagation(eps, "access");
		return ep;
	}

	/**
	 * find the error flow whose incoming error propagation point is incie
	 * @param eps List of error propagations
	 * @param incie connection instance end, which can be a component instance or feature instance
	 * @return ErrorFlow
	 */
	public static ErrorFlow findErrorFlow(ErrorPropagations eps, InstanceObject incie){
		for (ErrorFlow ef : eps.getFlows()) {
			Feature f = null;
			if (ef instanceof ErrorPath){
				ErrorPath ep = (ErrorPath)ef;
				 f = ep.getIncoming().getFeature();
			} else if (ef instanceof ErrorSink){
				ErrorSink es = (ErrorSink)ef;
				 f = es.getIncoming().getFeature();
			}
			if (incie instanceof FeatureInstance){
				if (((FeatureInstance)incie).getFeature().equals(f)){
					return ef;
				}
			}
		}
		return null;
	}

	/**
	 * find the error flow whose outgoing error propagation point is incie
	 * @param eps List of error propagations
	 * @param incie connection instance end, which can be a component instance or feature instance
	 * @return ErrorFlow
	 */
	public static ErrorFlow findReverseErrorFlow(ErrorPropagations eps, InstanceObject incie){
		for (ErrorFlow ef : eps.getFlows()) {
			Feature f = null;
			if (ef instanceof ErrorPath){
				ErrorPath ep = (ErrorPath)ef;
				 f = ep.getOutgoing().getFeature();
			} else if (ef instanceof ErrorSource){
				ErrorSource es = (ErrorSource)ef;
				 f = es.getOutgoing().getFeature();
			}
			if (incie instanceof FeatureInstance){
				if (((FeatureInstance)incie).getFeature().equals(f)){
					return ef;
				}
			}
		}
		return null;
	}

	
	/**
	 * return list of error sources
	 * @param eps error propagations
	 * @return EList<ErrorSource> list of error sources
	 */
	public static EList<ErrorSource> getErrorSources(ErrorPropagations eps){
		EList<ErrorSource> result = new BasicEList<ErrorSource>();
		EList<ErrorFlow> flows = eps.getFlows();
		for (ErrorFlow errorFlow : flows) {
			if (errorFlow instanceof ErrorSource)
				result.add((ErrorSource)errorFlow);
		}
		return result;
	}

	/**
	 * get the EM object that contains the condition expression.
	 * Traverses up the expression tree to the enclosing EM object
	 * @param element
	 * @return Error Model object that contains the expression
	 */
	public static EObject getConditionOwner(EObject element) {
		EObject container = element;
		while (container != null && (container instanceof ConditionExpression))
			container = container.eContainer();
		return container ;
	}

	/**
	 * get the state machine that contains the EM element 
	 * @param element
	 * @return ErrorBehaviorStateMachine object or null if element is not inside an EBSM
	 */
	public static ErrorBehaviorStateMachine getContainingErrorBehaviorStateMachine(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof ErrorBehaviorStateMachine))
			container = container.eContainer();
		return (ErrorBehaviorStateMachine) container;
	}

	/**
	 * get the enclosing error model library.
	 * Returns null if the element is not in a error model library
	 * @param element
	 * @return ErrorModelLibrary or null
	 */
	public static ErrorModelLibrary getContainingErrorModelLibrary(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof ErrorModelLibrary))
			container = container.eContainer();
		return (ErrorModelLibrary) container;
	}


	/**
	 * get the enclosing type use context
	 * A type use context is is the object that contains use references to error model/type libraries 
	 * @param element
	 * @return Type transformation set, type mapping set, error propagations object, EBSM, 
	 * component error behavior, composite error behavior
	 * or null if not in any
	 */
	public static TypeUseContext getContainingTypeUseContext(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof TypeUseContext))
			container = container.eContainer();
		return (TypeUseContext) container;
	}
	
	/**
	 * get containing error model subclause
	 * @param element
	 * @return ErrorModelSubclause or null
	 */
	public static ErrorModelSubclause getContainingErrorAnnexSubclause(EObject element){
		EObject container = element;
		while (container != null && !(container instanceof ErrorModelSubclause))
			container = container.eContainer();
		return (ErrorModelSubclause) container;
	}
	
	/**
	 * get containing component error behavior specification
	 * @param element
	 * @return ComponentErrorBehavior or null
	 */
	public static ComponentErrorBehavior getContainingComponentErrorBehavior(EObject element){
		EObject container = element;
		while (container != null && !(container instanceof ComponentErrorBehavior))
			container = container.eContainer();
		return (ComponentErrorBehavior) container;
	}

	/**
	 * get the error model subclause for the specified classifier.
	 * Looks for it in classifier being extended if not found.
	 * If not found there then look for it in the component type if the classifier was an implementation.
	 * @param cl CLassifier
	 * @return
	 */
	public static ErrorModelSubclause getErrorModelSubclause(Classifier cl){
		EList<AnnexSubclause> asl = cl.getOwnedAnnexSubclauses();
		for (AnnexSubclause al : asl){
			if (al instanceof ErrorModelSubclause){
				return ((ErrorModelSubclause)al);
			}
		}
		if (!Aadl2Util.isNull(cl.getExtended())){
			return getErrorModelSubclause(cl.getExtended());
		}
		if (cl instanceof ComponentImplementation){
			return getErrorModelSubclause(((ComponentImplementation)cl).getType());
		}
		return null;
	}

	/**
	 * extract the item name from a qualified name, the identifier after the last ::
	 * @param qualname String Qualified name
	 * @return String item name 
	 */
	public static String getItemName(String qualname){
		final int idx = qualname.lastIndexOf("::");
		if (idx != -1) {
			return qualname.substring(idx + 2);
		}
		return qualname;
	}

	/**
	 * extract the package name of a qualified name, everything up to the last :: or null
	 * @param qualname
	 * @return String
	 */
	public static String getPackageName(String qualname){
		final int idx = qualname.lastIndexOf("::");
		if (idx != -1) {
			return qualname.substring(0, idx);
		}
		return null;
	}
	
	public static String getPrintName(NamedElement ne){
		if (ne.getName() != null) return ne.getName();
		if (ne instanceof ErrorPropagation){
			ErrorPropagation ep = (ErrorPropagation)ne;
		if (!Aadl2Util.isNull(ep.getFeature())) return ep.getFeature().getName();
		if (ep.getKind() != null) return ep.getKind();
		}
		return "";
	}
	
	public static String getPrintName(TypeSet ts){
			return getPrintableName(ts, ", ");
	}
	
	
	public static String getPrintName(ErrorModelLibrary eml){
			return AadlUtil.getContainingPackage(eml).getName();
	}

	
	public static String getTableName(TypeSet ts){
			return getPrintableName(ts, "/");
	}
	
	public static String getPrintableName(TypeSet ts,String separator){
		if (ts == null) return "";
		String res ="{";
		EList<TypeToken> te = ts.getElementType();
		boolean docomma = false;
		for (TypeToken typeSetElement : te) {
			 EList<ErrorType> et = typeSetElement.getType();
			if (docomma) res = res+separator; else docomma = true;
			if (et != null&& !et.isEmpty()){
				boolean doproduct = false;
				for (ErrorType errorType : et) {
					if (doproduct) res = res+"+"; else doproduct = true;
					res = res + errorType.getName();
				}
			}
		}
		return res+"}";
	}
	
	public static String getPrintName(TypeToken tu){
		if (tu == null) return "{}";
		String res ="{";
		EList<ErrorType> te = tu.getType();
		boolean docomma = false;
		for (ErrorType et : te) {
			if (docomma) res = res+"+"; else docomma = true;
			res = res + et.getName();
		}
		return res+"}";
	}
	
	public static String getPrintName(EList<TypeToken> tul){
		String res ="(";
		for (TypeToken tu : tul) {
			res = res + "\n "+getPrintName(tu);
		}
		return res+"\n)";
	}

	/**
	 * get the EBSM referenced in the enclosing context, i.e., by the
	 * component error behavior or composite error behavior declaration
	 * @param element model object contained in a component or composite error behavior declaration
	 * @return ErrorBehaviorStateMachine or null
	 */
	public static ErrorBehaviorStateMachine getUsedErrorBehaviorStateMachine(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof EBSMUseContext|| container instanceof ErrorModelSubclause))
			container = container.eContainer();
		if (container == null) return null;
		return getUseBehavior((EBSMUseContext) container);
	}

	/**
	 * resolve the errortype if it is an alias, otherwise return the error type
	 * @param et ErrorType that may be an alias
	 * @return ErrorType without alias
	 */
	public static ErrorType resolveAlias(ErrorType et){
		if (Aadl2Util.isNull(et)) return null;
		while (!Aadl2Util.isNull(et.getAliasedType())){
			et = et.getAliasedType();
		}
		return et;
	}

	/**
	 * resolve the typeset if it is an alias, otherwise return the typeset
	 * @param typeset TypeSet
	 * @return TypeSet resolved TypeSet
	 */
	public static TypeSet resolveAlias(TypeSet typeset){
		if (Aadl2Util.isNull(typeset)) return null;
		if (!Aadl2Util.isNull(typeset.getReference())){
			typeset = typeset.getReference();
		}
		while (!Aadl2Util.isNull(typeset.getAliasedType())){
			typeset = typeset.getAliasedType();
		}
		return typeset;
	}
	
	/**
	 * find the actual ErrorTypes following the alias link
	 * @param et
	 * @return
	 */
	public static ErrorTypes resolveAlias(ErrorTypes et){
		if (Aadl2Util.isNull(et)) return null;
		return (et instanceof ErrorType)?EM2Util.resolveAlias((ErrorType)et):EM2Util.resolveAlias((TypeSet)et);
	}
	
	/**
	 * get UseBehavior, i.e., the referenced error behavior state machine
	 * @param context
	 * @return ErrorBehaviorStateMachine
	 */
	public static ErrorBehaviorStateMachine getUseBehavior(EBSMUseContext context){
		if (context instanceof ComponentErrorBehavior) return ((ComponentErrorBehavior)context).getUseBehavior();
		if (context instanceof CompositeErrorBehavior) return ((CompositeErrorBehavior)context).getUseBehavior();
		if (context instanceof ErrorPropagations) return ((ErrorPropagations)context).getUseBehavior();
		if (context instanceof ErrorModelSubclause) return ((ErrorModelSubclause)context).getUseBehavior();
		return null;
	}
	
	/**
	 * get list of ErrorModelLibraries listed in UseTypes
	 * @param context Type use context
	 * @return EList<ErrorModelLibrary>
	 */
	public static EList<ErrorModelLibrary> getUseTypes(TypeUseContext context){
		if (context instanceof ComponentErrorBehavior) return ((ComponentErrorBehavior)context).getUseTypes();
		if (context instanceof CompositeErrorBehavior) return ((CompositeErrorBehavior)context).getUseTypes();
		if (context instanceof TypeTransformationSet) return ((TypeTransformationSet)context).getUseTypes();
		if (context instanceof TypeMappingSet) return ((TypeMappingSet)context).getUseTypes();
		if (context instanceof ErrorPropagations) return ((ErrorPropagations)context).getUseTypes();
		if (context instanceof ErrorBehaviorStateMachine) return ((ErrorBehaviorStateMachine)context).getUseTypes();
		return null;
	}
	
	/**
	 * find the model object that contains the condition expression
	 * @param ce Condition Expression
	 * @return EObject
	 */
	public static EObject getConditionExpressionContext(ConditionExpression ce){
		EObject res = ce;
		while (res instanceof ConditionExpression){
			res = res.eContainer();
		}
		return res;
	}
	
	/** return list of property associations that meet the property name
	 * 
	 * @param props property association list from the properties section
	 * @param propertyName name of property
	 * @return EList<PropertyAssociation>
	 */
	public static EList<PropertyAssociation> getProperty(EList<PropertyAssociation> props,String propertyName){
		EList<PropertyAssociation> result = new BasicEList<PropertyAssociation>();
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)){
				result.add(propertyAssociation);
			}
		}
		return result;
	}
	
	/**
	 * retrieve an error model property (such as Hazard) attached to an error model element.
	 * @param props list of property associations from the properties section in the error model
	 * @param propertyName name of property we are looking for
	 * @param target the error model element (first item in teh containment path)
	 * @return property association
	 */
	public static PropertyAssociation getProperty(EList<PropertyAssociation> props,String propertyName, Element target){
		PropertyAssociation result = null;
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)){
				if (EM2Util.isErrorModelElementProperty(propertyAssociation, target))
				return propertyAssociation;
			}
		}
		return result;
	}
	
	/**
	 * determine whether the property applies to specified error model element or items reachable from it by containment path
	 * The eme is assumed to be first element in the containment path 
	 * Items reachable from the eme can be an error type
	 * @param propertyAssociation
	 * @param eme Error Model element
	 * @return true if eme is the first element on one of the containment paths
	 */
	public static boolean isErrorModelElementProperty(PropertyAssociation propertyAssociation, Element eme){
		EList<ContainedNamedElement> applies = propertyAssociation.getAppliesTos();
		for (ContainedNamedElement containedNamedElement : applies) {
			EList<ContainmentPathElement> cpes = containedNamedElement.getContainmentPathElements();
			if (!cpes.isEmpty()){
				ContainmentPathElement cpe = cpes.get(0);
				NamedElement appliestome = cpe.getNamedElement();
				if ( eme == appliestome){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * get list of error types, one for each containment path
	 * We assume that each path is of length one
	 * @param pa PropertyAssociation
	 * @return EList<ErrorType>
	 */
	public static EList<ErrorType> getContainmentErrorType(PropertyAssociation pa){
		EList<ErrorType> result = new BasicEList<ErrorType>();
		EList<ContainedNamedElement> applies = pa.getAppliesTos();
		for (ContainedNamedElement containedNamedElement : applies) {
			EList<ContainmentPathElement> cpes = containedNamedElement.getContainmentPathElements();
			if (cpes.size()==1){
				ContainmentPathElement cpe = cpes.get(0);
				NamedElement appliestome = cpe.getNamedElement();
				if (appliestome instanceof ErrorType)
					result.add((ErrorType)appliestome);
			}
		}
		return result;
	}
	
	/**
	 * get list of error types, one for each containment path that points to an error propagation
	 * We assume that each path is of length one
	 * @param pa PropertyAssociation
	 * @param ep ErrorPropagation
	 * @return EList<ErrorType>
	 */
	public static EList<ErrorType> getContainmentErrorType(PropertyAssociation pa,NamedElement ep){
		EList<ErrorType> result = new BasicEList<ErrorType>();
		EList<ContainedNamedElement> applies = pa.getAppliesTos();
		for (ContainedNamedElement containedNamedElement : applies) {
			EList<ContainmentPathElement> cpes = containedNamedElement.getContainmentPathElements();
			if (cpes.size()==2&& cpes.get(0).getNamedElement()==ep){
				ContainmentPathElement cpe = cpes.get(1);
				NamedElement appliestome = cpe.getNamedElement();
				if (appliestome instanceof ErrorType)
					result.add((ErrorType)appliestome);
			}
		}
		return result;
	}

	
	public static BasicPropertyAssociation getRecordField(EList<BasicPropertyAssociation> props,String fieldName){
		for (BasicPropertyAssociation propertyAssociation : props) {
			BasicProperty prop = propertyAssociation.getProperty();
			String name = prop.getName();
			if (fieldName.equalsIgnoreCase(name)){
				return propertyAssociation;
			}
		}
		return null;
	}
	
	public static boolean hasErrorPropagations(ComponentInstance ci){
		return hasErrorPropagations(ci.getComponentClassifier());
	}

	public static boolean hasErrorPropagations(ComponentClassifier cl){
		return EM2Util.getContainingErrorPropagations(cl) != null;
	}
	
	public static boolean hasComponentErrorBehavior(ComponentInstance ci){
		return hasComponentErrorBehavior(ci.getComponentClassifier());
	}
	
	public static boolean hasComponentErrorBehavior(ComponentClassifier cl){
		ErrorModelSubclause emsc = getErrorModelSubclause(cl);
		return emsc.getComponentBehavior() != null;
	}
	
	public static boolean hasCompositeErrorBehavior(ComponentInstance ci){
		return hasCompositeErrorBehavior(ci.getComponentClassifier());
	}
	
	public static boolean hasCompositeErrorBehavior(ComponentClassifier cl){
		ErrorModelSubclause emsc = getErrorModelSubclause(cl);
		return emsc.getCompositeBehavior() != null;
	}
	
	public static ErrorPropagations getErrorPropagations(ComponentInstance ci){
		return getErrorPropagations(ci.getComponentClassifier());
	}

	public static ErrorPropagations getErrorPropagations(ComponentClassifier cl){
		return EM2Util.getContainingErrorPropagations(cl);
	}
	
	public static ComponentErrorBehavior getComponentErrorBehavior(ComponentInstance ci){
		return getComponentErrorBehavior(ci.getComponentClassifier());
	}
	
	public static ComponentErrorBehavior getComponentErrorBehavior(ComponentClassifier cl){
		ErrorModelSubclause emsc = getErrorModelSubclause(cl);
		return emsc.getComponentBehavior();
	}
	
	public static CompositeErrorBehavior getCompositeErrorBehavior(ComponentInstance ci){
		return getCompositeErrorBehavior(ci.getComponentClassifier());
	}
	
	public static CompositeErrorBehavior getCompositeErrorBehavior(ComponentClassifier cl){
		ErrorModelSubclause emsc = getErrorModelSubclause(cl);
		return emsc.getCompositeBehavior();
	}
	
	/**
	 * retrieve list of component instances that have error propagations specified
	 * For process component instances do not recurse below and include the component instance
	 * even if no error propagation is attached.
	 * Foe other component instances include the component instance if it does not have children even if it does not include
	 * error propagations
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getComponentInstancesWithErrorPropagations(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EM2Util.hasErrorPropagations((ComponentInstance)obj)
							|| ((ComponentInstance)obj).getComponentInstances().isEmpty()
							|| ((ComponentInstance)obj).getCategory() == ComponentCategory.PROCESS
							));
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}
	
	/**
	 * retrieve list of component instances that have error propagations specified
	 * For process component instances or component instance without children, do not recurse below and do not include the component instance
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getComponentInstancesWithErrorPropagationsOnly(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EM2Util.hasErrorPropagations((ComponentInstance)obj)
							));
			}
			@Override
			protected boolean processStop (Element theElement) {
				if (suchThat((Element) theElement)) {
					if (theElement instanceof NamedElement){
						//{ System.out.println(((NamedElement) theElement).getName());}
						action((Element) theElement);
						return true;
					}
				}
				if (((ComponentInstance)theElement).getCategory() == ComponentCategory.PROCESS)	{
					return true;
				} else {
					return false;
				}
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}
	
	/**
	 * retrieve list of component instances that have component error behavior specified
	 * For process component instances do not recurse below and include the component instance
	 * even if no error propagation is attached.
	 * Foe other component instances include the component instance if it does not have children even if it does not include
	 * error propagations
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getComponentInstancesWithComponentErrorBehavior(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EM2Util.hasComponentErrorBehavior((ComponentInstance)obj)
							|| ((ComponentInstance)obj).getComponentInstances().isEmpty()
							|| ((ComponentInstance)obj).getCategory() == ComponentCategory.PROCESS
							));
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}
	
	
	/**
	 * retrieve list of component instances that have component error behavior specified
	 * For process component instances or component instance without children, do not recurse below and do not include the component instance
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getComponentInstancesWithComponentErrorBehaviorOnly(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EM2Util.hasComponentErrorBehavior((ComponentInstance)obj)
							));
			}
			@Override
			protected boolean processStop (Element theElement) {
				if (suchThat((Element) theElement)) {
					if (theElement instanceof NamedElement){
						//{ System.out.println(((NamedElement) theElement).getName());}
						action((Element) theElement);
						return true;
					}
				}
				if (((ComponentInstance)theElement).getCategory() == ComponentCategory.PROCESS)	{
					return true;
				} else {
					return false;
				}
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}

	
	/**
	 * retrieve list of component instances that have composite error behavior specified
	 * For process component instances do not recurse below and include the component instance
	 * even if no error propagation is attached.
	 * Foe other component instances include the component instance if it does not have children even if it does not include
	 * error propagations
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getCompositeInstancesWithComponentErrorBehavior(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EM2Util.hasCompositeErrorBehavior((ComponentInstance)obj)
							|| ((ComponentInstance)obj).getComponentInstances().isEmpty()
							|| ((ComponentInstance)obj).getCategory() == ComponentCategory.PROCESS
							));
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}
	
	/**
	 * retrieve list of component instances that have composite error behavior specified
	 * For process component instances or component instance without children, do not recurse below and do not include the component instance
	 * @param ci ComponentInstance
	 * @return EList of leaf component instances
	 */
	public static EList<ComponentInstance> getComponentInstancesWithhasCompositeErrorBehaviorOnly(ComponentInstance ci){
		EList result = new ForAllElement(){
			@Override
			protected boolean suchThat(Element obj) {
				return (obj instanceof ComponentInstance&&
					(EM2Util.hasCompositeErrorBehavior((ComponentInstance)obj)
							));
			}
			@Override
			protected boolean processStop (Element theElement) {
				if (suchThat((Element) theElement)) {
					if (theElement instanceof NamedElement){
						//{ System.out.println(((NamedElement) theElement).getName());}
						action((Element) theElement);
						return true;
					}
				}
				if (((ComponentInstance)theElement).getCategory() == ComponentCategory.PROCESS)	{
					return true;
				} else {
					return false;
				}
			}
		}.processPreOrderComponentInstanceStop(ci);
		return result ;
	}

}
