/*
 * generated by Xtext
 */
package org.osate.xtext.aadl2.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractAadl2SyntacticSequencer extends AbstractSyntacticSequencer {

	protected Aadl2GrammarAccess grammarAccess;
	protected AbstractElementAlias match_AadlPackage___PropertiesKeyword_3_0_NoneKeyword_3_1_1_0_SemicolonKeyword_3_1_1_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (Aadl2GrammarAccess) access;
		match_AadlPackage___PropertiesKeyword_3_0_NoneKeyword_3_1_1_0_SemicolonKeyword_3_1_1_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAadlPackageAccess().getPropertiesKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getAadlPackageAccess().getNoneKeyword_3_1_1_0()), new TokenAlias(false, false, grammarAccess.getAadlPackageAccess().getSemicolonKeyword_3_1_1_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getAbstractImplementationKeywordsRule())
			return getAbstractImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getAppliesToKeywordsRule())
			return getAppliesToKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getBusAccessKeywordsRule())
			return getBusAccessKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getBusImplementationKeywordsRule())
			return getBusImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getDataAccessKeywordsRule())
			return getDataAccessKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getDataImplementationKeywordsRule())
			return getDataImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getDataPortKeywordsRule())
			return getDataPortKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getDeviceImplementationKeywordsRule())
			return getDeviceImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEndToEndFlowKeywordsRule())
			return getEndToEndFlowKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEventDataKeywordsRule())
			return getEventDataKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEventDataPortKeywordsRule())
			return getEventDataPortKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEventPortKeywordsRule())
			return getEventPortKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getFULLINAMERule())
			return getFULLINAMEToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getFeatureGroupKeywordsRule())
			return getFeatureGroupKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getInBindingKeywordsRule())
			return getInBindingKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getInModesKeywordsRule())
			return getInModesKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getInternalFeaturesKeywordsRule())
			return getInternalFeaturesKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getInverseOfKeywordsRule())
			return getInverseOfKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getListOfKeywordsRule())
			return getListOfKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getMemoryImplementationKeywordsRule())
			return getMemoryImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getPNAMERule())
			return getPNAMEToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getProcessImplementationKeywordsRule())
			return getProcessImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getProcessorFeaturesKeywordsRule())
			return getProcessorFeaturesKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getProcessorImplementationKeywordsRule())
			return getProcessorImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getRangeOfKeywordsRule())
			return getRangeOfKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getRefinedToKeywordsRule())
			return getRefinedToKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getRequiresModesKeywordsRule())
			return getRequiresModesKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getSTARRule())
			return getSTARToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getSubprogramAccessKeywordsRule())
			return getSubprogramAccessKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getSubprogramGroupAccessKeywordsRule())
			return getSubprogramGroupAccessKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getSubprogramGroupImplementationKeywordsRule())
			return getSubprogramGroupImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getSubprogramGroupKeywordsRule())
			return getSubprogramGroupKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getSubprogramImplementationKeywordsRule())
			return getSubprogramImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getSystemImplementationKeywordsRule())
			return getSystemImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getThreadGroupImplementationKeywordsRule())
			return getThreadGroupImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getThreadGroupKeywordsRule())
			return getThreadGroupKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getThreadImplementationKeywordsRule())
			return getThreadImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getVirtualBusImplementationKeywordsRule())
			return getVirtualBusImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getVirtualBusKeywordsRule())
			return getVirtualBusKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getVirtualProcessorImplementationKeywordsRule())
			return getVirtualProcessorImplementationKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getVirtualProcessorKeywordsRule())
			return getVirtualProcessorKeywordsToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * AbstractImplementationKeywords:
	 * 	'abstract' 'implementation'
	 * ;
	 */
	protected String getAbstractImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "abstractimplementation";
	}
	
	/**
	 * AppliesToKeywords:
	 * 	'applies' 'to'
	 * ;
	 */
	protected String getAppliesToKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "appliesto";
	}
	
	/**
	 * BusAccessKeywords:
	 * 	'bus' 'access'
	 * ;
	 */
	protected String getBusAccessKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "busaccess";
	}
	
	/**
	 * BusImplementationKeywords:
	 * 	'bus' 'implementation'
	 * ;
	 */
	protected String getBusImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "busimplementation";
	}
	
	/**
	 * DataAccessKeywords:
	 * 	'data' 'access'
	 * ;
	 */
	protected String getDataAccessKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "dataaccess";
	}
	
	/**
	 * DataImplementationKeywords:
	 * 	'data' 'implementation'
	 * ;
	 */
	protected String getDataImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "dataimplementation";
	}
	
	/**
	 * DataPortKeywords:
	 * 	'data' 'port'
	 * ;
	 */
	protected String getDataPortKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "dataport";
	}
	
	/**
	 * DeviceImplementationKeywords:
	 * 	'device' 'implementation'
	 * ;
	 */
	protected String getDeviceImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "deviceimplementation";
	}
	
	/**
	 * EndToEndFlowKeywords:
	 * 	'end' 'to' 'end' 'flow'
	 * ;
	 */
	protected String getEndToEndFlowKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "endtoendflow";
	}
	
	/**
	 * EventDataKeywords:
	 * 	'event' 'data'
	 * ;
	 */
	protected String getEventDataKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "eventdata";
	}
	
	/**
	 * EventDataPortKeywords:
	 * 	'event' 'data' 'port'
	 * ;
	 */
	protected String getEventDataPortKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "eventdataport";
	}
	
	/**
	 * EventPortKeywords:
	 * 	'event' 'port'
	 * ;
	 */
	protected String getEventPortKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "eventport";
	}
	
	/**
	 * FULLINAME:
	 * 	ID '.' ID;
	 */
	protected String getFULLINAMEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
	}
	
	/**
	 * FeatureGroupKeywords:
	 * 	'feature' 'group'
	 * ;
	 */
	protected String getFeatureGroupKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "featuregroup";
	}
	
	/**
	 * terminal ID:	('a'..'z'
	 *         |'A'..'Z'
	 *         ) ( ('_')? ('a'..'z'
	 *         |'A'..'Z'
	 *         |'0'..'9'))*;
	 */
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * InBindingKeywords:
	 * 	'in' 'binding'
	 * ;
	 */
	protected String getInBindingKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "inbinding";
	}
	
	/**
	 * InModesKeywords:
	 * 	'in' 'modes'
	 * ;
	 */
	protected String getInModesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "inmodes";
	}
	
	/**
	 * InternalFeaturesKeywords:
	 * 	'internal' 'features'
	 * ;
	 */
	protected String getInternalFeaturesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "internalfeatures";
	}
	
	/**
	 * InverseOfKeywords:
	 * 	'inverse' 'of'
	 * ;
	 */
	protected String getInverseOfKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "inverseof";
	}
	
	/**
	 * ListOfKeywords:
	 * 	'list' 'of'
	 * ;
	 */
	protected String getListOfKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "listof";
	}
	
	/**
	 * MemoryImplementationKeywords:
	 * 	'memory' 'implementation'
	 * ;
	 */
	protected String getMemoryImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "memoryimplementation";
	}
	
	/**
	 * PNAME:
	 * 	ID ('::' ID)*;
	 */
	protected String getPNAMEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * ProcessImplementationKeywords:
	 * 	'process' 'implementation'
	 * ;
	 */
	protected String getProcessImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "processimplementation";
	}
	
	/**
	 * ProcessorFeaturesKeywords:
	 * 	'processor' 'features'
	 * ;
	 */
	protected String getProcessorFeaturesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "processorfeatures";
	}
	
	/**
	 * ProcessorImplementationKeywords:
	 * 	'processor' 'implementation'
	 * ;
	 */
	protected String getProcessorImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "processorimplementation";
	}
	
	/**
	 * RangeOfKeywords:
	 * 	'range' 'of'
	 * ;
	 */
	protected String getRangeOfKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "rangeof";
	}
	
	/**
	 * RefinedToKeywords:
	 * 	'refined' 'to'
	 * ;
	 */
	protected String getRefinedToKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "refinedto";
	}
	
	/**
	 * RequiresModesKeywords:
	 * 	'requires' 'modes'
	 * ;
	 */
	protected String getRequiresModesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "requiresmodes";
	}
	
	/**
	 * STAR : '*';
	 */
	protected String getSTARToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "*";
	}
	
	/**
	 * SubprogramAccessKeywords:
	 * 	'subprogram' 'access'
	 * ;
	 */
	protected String getSubprogramAccessKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "subprogramaccess";
	}
	
	/**
	 * SubprogramGroupAccessKeywords:
	 * 	'subprogram' 'group' 'access'
	 * ;
	 */
	protected String getSubprogramGroupAccessKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "subprogramgroupaccess";
	}
	
	/**
	 * SubprogramGroupImplementationKeywords:
	 * 	'subprogram' 'group' 'implementation'
	 * ;
	 */
	protected String getSubprogramGroupImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "subprogramgroupimplementation";
	}
	
	/**
	 * SubprogramGroupKeywords:
	 * 	'subprogram' 'group'
	 * ;
	 */
	protected String getSubprogramGroupKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "subprogramgroup";
	}
	
	/**
	 * SubprogramImplementationKeywords:
	 * 	'subprogram' 'implementation'
	 * ;
	 */
	protected String getSubprogramImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "subprogramimplementation";
	}
	
	/**
	 * SystemImplementationKeywords:
	 * 	'system' 'implementation'
	 * ;
	 */
	protected String getSystemImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "systemimplementation";
	}
	
	/**
	 * ThreadGroupImplementationKeywords:
	 * 	'thread' 'group' 'implementation'
	 * ;
	 */
	protected String getThreadGroupImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "threadgroupimplementation";
	}
	
	/**
	 * ThreadGroupKeywords:
	 * 	'thread' 'group'
	 * ;
	 */
	protected String getThreadGroupKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "threadgroup";
	}
	
	/**
	 * ThreadImplementationKeywords:
	 * 	'thread' 'implementation'
	 * ;
	 */
	protected String getThreadImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "threadimplementation";
	}
	
	/**
	 * VirtualBusImplementationKeywords:
	 * 	'virtual' 'bus' 'implementation'
	 * ;
	 */
	protected String getVirtualBusImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "virtualbusimplementation";
	}
	
	/**
	 * VirtualBusKeywords:
	 * 	'virtual' 'bus'
	 * ;
	 */
	protected String getVirtualBusKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "virtualbus";
	}
	
	/**
	 * VirtualProcessorImplementationKeywords:
	 * 	'virtual' 'processor' 'implementation'
	 * ;
	 */
	protected String getVirtualProcessorImplementationKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "virtualprocessorimplementation";
	}
	
	/**
	 * VirtualProcessorKeywords:
	 * 	'virtual' 'processor'
	 * ;
	 */
	protected String getVirtualProcessorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "virtualprocessor";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_AadlPackage___PropertiesKeyword_3_0_NoneKeyword_3_1_1_0_SemicolonKeyword_3_1_1_1__q.equals(syntax))
				emit_AadlPackage___PropertiesKeyword_3_0_NoneKeyword_3_1_1_0_SemicolonKeyword_3_1_1_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ('properties' 'none' ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedPrivateSection=PrivatePackageSection (ambiguity) 'end' PNAME ';' (rule end)
	 *     ownedPublicSection=PublicPackageSection (ambiguity) 'end' PNAME ';' (rule end)
	 */
	protected void emit_AadlPackage___PropertiesKeyword_3_0_NoneKeyword_3_1_1_0_SemicolonKeyword_3_1_1_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
