/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
package org.osate.reqspec.serializer;

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
import org.osate.reqspec.services.ReqSpecGrammarAccess;

@SuppressWarnings("all")
public class ReqSpecSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ReqSpecGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_AParenthesizedExpression_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_DocGoal_CategoryKeyword_5_0_0_q;
	protected AbstractElementAlias match_DocGoal_EvolvesKeyword_5_7_0_q;
	protected AbstractElementAlias match_DocGoal_IssuesKeyword_5_12_0_q;
	protected AbstractElementAlias match_DocGoal_RefinesKeyword_5_5_0_q;
	protected AbstractElementAlias match_DocGoal_StakeholderKeyword_5_9_0_q;
	protected AbstractElementAlias match_DocGoal___ConflictsKeyword_5_6_0_WithKeyword_5_6_1__q;
	protected AbstractElementAlias match_DocGoal___SeeKeyword_5_10_0_DocumentKeyword_5_10_1_RequirementKeyword_5_10_2__q;
	protected AbstractElementAlias match_DocGoal___SeeKeyword_5_11_0_DocumentKeyword_5_11_1__q;
	protected AbstractElementAlias match_DocRequirement_CategoryKeyword_5_0_0_q;
	protected AbstractElementAlias match_DocRequirement_DecomposesKeyword_5_9_0_q;
	protected AbstractElementAlias match_DocRequirement_EvolvesKeyword_5_10_0_q;
	protected AbstractElementAlias match_DocRequirement_IssuesKeyword_5_17_0_q;
	protected AbstractElementAlias match_DocRequirement_RefinesKeyword_5_8_0_q;
	protected AbstractElementAlias match_DocRequirement___DevelopmentKeyword_5_12_0_StakeholderKeyword_5_12_1__q;
	protected AbstractElementAlias match_DocRequirement___SeeKeyword_5_13_0_GoalKeyword_5_13_1__q;
	protected AbstractElementAlias match_DocRequirement___SeeKeyword_5_14_0_DocumentKeyword_5_14_1_GoalKeyword_5_14_2__q;
	protected AbstractElementAlias match_DocRequirement___SeeKeyword_5_15_0_DocumentKeyword_5_15_1_RequirementKeyword_5_15_2__q;
	protected AbstractElementAlias match_DocRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q;
	protected AbstractElementAlias match_Goal_CategoryKeyword_5_0_0_q;
	protected AbstractElementAlias match_Goal_EvolvesKeyword_5_9_0_q;
	protected AbstractElementAlias match_Goal_IssuesKeyword_5_14_0_q;
	protected AbstractElementAlias match_Goal_QualityKeyword_5_1_0_q;
	protected AbstractElementAlias match_Goal_RefinesKeyword_5_7_0_q;
	protected AbstractElementAlias match_Goal_SelectionKeyword_5_2_0_q;
	protected AbstractElementAlias match_Goal_StakeholderKeyword_5_11_0_q;
	protected AbstractElementAlias match_Goal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q;
	protected AbstractElementAlias match_Goal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1_RequirementKeyword_5_12_2__q;
	protected AbstractElementAlias match_Goal___SeeKeyword_5_13_0_DocumentKeyword_5_13_1__q;
	protected AbstractElementAlias match_ReqDocument_IssuesKeyword_4_2_0_q;
	protected AbstractElementAlias match_Requirement_CategoryKeyword_5_0_0_q;
	protected AbstractElementAlias match_Requirement_DecomposesKeyword_5_11_0_q;
	protected AbstractElementAlias match_Requirement_EvolvesKeyword_5_12_0_q;
	protected AbstractElementAlias match_Requirement_IssuesKeyword_5_19_0_q;
	protected AbstractElementAlias match_Requirement_QualityKeyword_5_1_0_q;
	protected AbstractElementAlias match_Requirement_RefinesKeyword_5_10_0_q;
	protected AbstractElementAlias match_Requirement_SelectionKeyword_5_2_0_q;
	protected AbstractElementAlias match_Requirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q;
	protected AbstractElementAlias match_Requirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q;
	protected AbstractElementAlias match_Requirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1_GoalKeyword_5_16_2__q;
	protected AbstractElementAlias match_Requirement___SeeKeyword_5_17_0_DocumentKeyword_5_17_1_RequirementKeyword_5_17_2__q;
	protected AbstractElementAlias match_Requirement___SeeKeyword_5_18_0_DocumentKeyword_5_18_1__q;
	protected AbstractElementAlias match_StakeholderGoals_IssuesKeyword_7_4_0_q;
	protected AbstractElementAlias match_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q;
	protected AbstractElementAlias match_SystemRequirements_IssuesKeyword_7_5_0_q;
	protected AbstractElementAlias match_SystemRequirements___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ReqSpecGrammarAccess) access;
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_DocGoal_CategoryKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getCategoryKeyword_5_0_0());
		match_DocGoal_EvolvesKeyword_5_7_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getEvolvesKeyword_5_7_0());
		match_DocGoal_IssuesKeyword_5_12_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getIssuesKeyword_5_12_0());
		match_DocGoal_RefinesKeyword_5_5_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getRefinesKeyword_5_5_0());
		match_DocGoal_StakeholderKeyword_5_9_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getStakeholderKeyword_5_9_0());
		match_DocGoal___ConflictsKeyword_5_6_0_WithKeyword_5_6_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getConflictsKeyword_5_6_0()), new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getWithKeyword_5_6_1()));
		match_DocGoal___SeeKeyword_5_10_0_DocumentKeyword_5_10_1_RequirementKeyword_5_10_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getSeeKeyword_5_10_0()), new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getDocumentKeyword_5_10_1()), new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getRequirementKeyword_5_10_2()));
		match_DocGoal___SeeKeyword_5_11_0_DocumentKeyword_5_11_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getSeeKeyword_5_11_0()), new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getDocumentKeyword_5_11_1()));
		match_DocRequirement_CategoryKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getCategoryKeyword_5_0_0());
		match_DocRequirement_DecomposesKeyword_5_9_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getDecomposesKeyword_5_9_0());
		match_DocRequirement_EvolvesKeyword_5_10_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getEvolvesKeyword_5_10_0());
		match_DocRequirement_IssuesKeyword_5_17_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getIssuesKeyword_5_17_0());
		match_DocRequirement_RefinesKeyword_5_8_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getRefinesKeyword_5_8_0());
		match_DocRequirement___DevelopmentKeyword_5_12_0_StakeholderKeyword_5_12_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getDevelopmentKeyword_5_12_0()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getStakeholderKeyword_5_12_1()));
		match_DocRequirement___SeeKeyword_5_13_0_GoalKeyword_5_13_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getSeeKeyword_5_13_0()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getGoalKeyword_5_13_1()));
		match_DocRequirement___SeeKeyword_5_14_0_DocumentKeyword_5_14_1_GoalKeyword_5_14_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getSeeKeyword_5_14_0()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getDocumentKeyword_5_14_1()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getGoalKeyword_5_14_2()));
		match_DocRequirement___SeeKeyword_5_15_0_DocumentKeyword_5_15_1_RequirementKeyword_5_15_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getSeeKeyword_5_15_0()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getDocumentKeyword_5_15_1()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getRequirementKeyword_5_15_2()));
		match_DocRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getSeeKeyword_5_16_0()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getDocumentKeyword_5_16_1()));
		match_Goal_CategoryKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0());
		match_Goal_EvolvesKeyword_5_9_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getEvolvesKeyword_5_9_0());
		match_Goal_IssuesKeyword_5_14_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getIssuesKeyword_5_14_0());
		match_Goal_QualityKeyword_5_1_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getQualityKeyword_5_1_0());
		match_Goal_RefinesKeyword_5_7_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getRefinesKeyword_5_7_0());
		match_Goal_SelectionKeyword_5_2_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getSelectionKeyword_5_2_0());
		match_Goal_StakeholderKeyword_5_11_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getStakeholderKeyword_5_11_0());
		match_Goal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getConflictsKeyword_5_8_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getWithKeyword_5_8_1()));
		match_Goal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1_RequirementKeyword_5_12_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getSeeKeyword_5_12_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getDocumentKeyword_5_12_1()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getRequirementKeyword_5_12_2()));
		match_Goal___SeeKeyword_5_13_0_DocumentKeyword_5_13_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getSeeKeyword_5_13_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getDocumentKeyword_5_13_1()));
		match_ReqDocument_IssuesKeyword_4_2_0_q = new TokenAlias(false, true, grammarAccess.getReqDocumentAccess().getIssuesKeyword_4_2_0());
		match_Requirement_CategoryKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getRequirementAccess().getCategoryKeyword_5_0_0());
		match_Requirement_DecomposesKeyword_5_11_0_q = new TokenAlias(false, true, grammarAccess.getRequirementAccess().getDecomposesKeyword_5_11_0());
		match_Requirement_EvolvesKeyword_5_12_0_q = new TokenAlias(false, true, grammarAccess.getRequirementAccess().getEvolvesKeyword_5_12_0());
		match_Requirement_IssuesKeyword_5_19_0_q = new TokenAlias(false, true, grammarAccess.getRequirementAccess().getIssuesKeyword_5_19_0());
		match_Requirement_QualityKeyword_5_1_0_q = new TokenAlias(false, true, grammarAccess.getRequirementAccess().getQualityKeyword_5_1_0());
		match_Requirement_RefinesKeyword_5_10_0_q = new TokenAlias(false, true, grammarAccess.getRequirementAccess().getRefinesKeyword_5_10_0());
		match_Requirement_SelectionKeyword_5_2_0_q = new TokenAlias(false, true, grammarAccess.getRequirementAccess().getSelectionKeyword_5_2_0());
		match_Requirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRequirementAccess().getDevelopmentKeyword_5_14_0()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getStakeholderKeyword_5_14_1()));
		match_Requirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRequirementAccess().getSeeKeyword_5_15_0()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getGoalKeyword_5_15_1()));
		match_Requirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1_GoalKeyword_5_16_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRequirementAccess().getSeeKeyword_5_16_0()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getDocumentKeyword_5_16_1()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getGoalKeyword_5_16_2()));
		match_Requirement___SeeKeyword_5_17_0_DocumentKeyword_5_17_1_RequirementKeyword_5_17_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRequirementAccess().getSeeKeyword_5_17_0()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getDocumentKeyword_5_17_1()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getRequirementKeyword_5_17_2()));
		match_Requirement___SeeKeyword_5_18_0_DocumentKeyword_5_18_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRequirementAccess().getSeeKeyword_5_18_0()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getDocumentKeyword_5_18_1()));
		match_StakeholderGoals_IssuesKeyword_7_4_0_q = new TokenAlias(false, true, grammarAccess.getStakeholderGoalsAccess().getIssuesKeyword_7_4_0());
		match_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getStakeholderGoalsAccess().getSeeKeyword_7_3_0()), new TokenAlias(false, false, grammarAccess.getStakeholderGoalsAccess().getDocumentKeyword_7_3_1()));
		match_SystemRequirements_IssuesKeyword_7_5_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementsAccess().getIssuesKeyword_7_5_0());
		match_SystemRequirements___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementsAccess().getSeeKeyword_7_4_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementsAccess().getDocumentKeyword_7_4_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_AParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_AParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal_CategoryKeyword_5_0_0_q.equals(syntax))
				emit_DocGoal_CategoryKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal_EvolvesKeyword_5_7_0_q.equals(syntax))
				emit_DocGoal_EvolvesKeyword_5_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal_IssuesKeyword_5_12_0_q.equals(syntax))
				emit_DocGoal_IssuesKeyword_5_12_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal_RefinesKeyword_5_5_0_q.equals(syntax))
				emit_DocGoal_RefinesKeyword_5_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal_StakeholderKeyword_5_9_0_q.equals(syntax))
				emit_DocGoal_StakeholderKeyword_5_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal___ConflictsKeyword_5_6_0_WithKeyword_5_6_1__q.equals(syntax))
				emit_DocGoal___ConflictsKeyword_5_6_0_WithKeyword_5_6_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal___SeeKeyword_5_10_0_DocumentKeyword_5_10_1_RequirementKeyword_5_10_2__q.equals(syntax))
				emit_DocGoal___SeeKeyword_5_10_0_DocumentKeyword_5_10_1_RequirementKeyword_5_10_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal___SeeKeyword_5_11_0_DocumentKeyword_5_11_1__q.equals(syntax))
				emit_DocGoal___SeeKeyword_5_11_0_DocumentKeyword_5_11_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement_CategoryKeyword_5_0_0_q.equals(syntax))
				emit_DocRequirement_CategoryKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement_DecomposesKeyword_5_9_0_q.equals(syntax))
				emit_DocRequirement_DecomposesKeyword_5_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement_EvolvesKeyword_5_10_0_q.equals(syntax))
				emit_DocRequirement_EvolvesKeyword_5_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement_IssuesKeyword_5_17_0_q.equals(syntax))
				emit_DocRequirement_IssuesKeyword_5_17_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement_RefinesKeyword_5_8_0_q.equals(syntax))
				emit_DocRequirement_RefinesKeyword_5_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement___DevelopmentKeyword_5_12_0_StakeholderKeyword_5_12_1__q.equals(syntax))
				emit_DocRequirement___DevelopmentKeyword_5_12_0_StakeholderKeyword_5_12_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement___SeeKeyword_5_13_0_GoalKeyword_5_13_1__q.equals(syntax))
				emit_DocRequirement___SeeKeyword_5_13_0_GoalKeyword_5_13_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement___SeeKeyword_5_14_0_DocumentKeyword_5_14_1_GoalKeyword_5_14_2__q.equals(syntax))
				emit_DocRequirement___SeeKeyword_5_14_0_DocumentKeyword_5_14_1_GoalKeyword_5_14_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement___SeeKeyword_5_15_0_DocumentKeyword_5_15_1_RequirementKeyword_5_15_2__q.equals(syntax))
				emit_DocRequirement___SeeKeyword_5_15_0_DocumentKeyword_5_15_1_RequirementKeyword_5_15_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q.equals(syntax))
				emit_DocRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_CategoryKeyword_5_0_0_q.equals(syntax))
				emit_Goal_CategoryKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_EvolvesKeyword_5_9_0_q.equals(syntax))
				emit_Goal_EvolvesKeyword_5_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_IssuesKeyword_5_14_0_q.equals(syntax))
				emit_Goal_IssuesKeyword_5_14_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_QualityKeyword_5_1_0_q.equals(syntax))
				emit_Goal_QualityKeyword_5_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_RefinesKeyword_5_7_0_q.equals(syntax))
				emit_Goal_RefinesKeyword_5_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_SelectionKeyword_5_2_0_q.equals(syntax))
				emit_Goal_SelectionKeyword_5_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_StakeholderKeyword_5_11_0_q.equals(syntax))
				emit_Goal_StakeholderKeyword_5_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q.equals(syntax))
				emit_Goal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1_RequirementKeyword_5_12_2__q.equals(syntax))
				emit_Goal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1_RequirementKeyword_5_12_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal___SeeKeyword_5_13_0_DocumentKeyword_5_13_1__q.equals(syntax))
				emit_Goal___SeeKeyword_5_13_0_DocumentKeyword_5_13_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ReqDocument_IssuesKeyword_4_2_0_q.equals(syntax))
				emit_ReqDocument_IssuesKeyword_4_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement_CategoryKeyword_5_0_0_q.equals(syntax))
				emit_Requirement_CategoryKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement_DecomposesKeyword_5_11_0_q.equals(syntax))
				emit_Requirement_DecomposesKeyword_5_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement_EvolvesKeyword_5_12_0_q.equals(syntax))
				emit_Requirement_EvolvesKeyword_5_12_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement_IssuesKeyword_5_19_0_q.equals(syntax))
				emit_Requirement_IssuesKeyword_5_19_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement_QualityKeyword_5_1_0_q.equals(syntax))
				emit_Requirement_QualityKeyword_5_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement_RefinesKeyword_5_10_0_q.equals(syntax))
				emit_Requirement_RefinesKeyword_5_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement_SelectionKeyword_5_2_0_q.equals(syntax))
				emit_Requirement_SelectionKeyword_5_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q.equals(syntax))
				emit_Requirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q.equals(syntax))
				emit_Requirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1_GoalKeyword_5_16_2__q.equals(syntax))
				emit_Requirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1_GoalKeyword_5_16_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement___SeeKeyword_5_17_0_DocumentKeyword_5_17_1_RequirementKeyword_5_17_2__q.equals(syntax))
				emit_Requirement___SeeKeyword_5_17_0_DocumentKeyword_5_17_1_RequirementKeyword_5_17_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement___SeeKeyword_5_18_0_DocumentKeyword_5_18_1__q.equals(syntax))
				emit_Requirement___SeeKeyword_5_18_0_DocumentKeyword_5_18_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_StakeholderGoals_IssuesKeyword_7_4_0_q.equals(syntax))
				emit_StakeholderGoals_IssuesKeyword_7_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q.equals(syntax))
				emit_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirements_IssuesKeyword_7_5_0_q.equals(syntax))
				emit_SystemRequirements_IssuesKeyword_7_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirements___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q.equals(syntax))
				emit_SystemRequirements___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '#' '[' ']' (rule start)
	 *     (rule start) (ambiguity) '#' '[' elements+=AExpression
	 *     (rule start) (ambiguity) '@' property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 *     (rule start) (ambiguity) 'false' (rule start)
	 *     (rule start) (ambiguity) 'null' (rule start)
	 *     (rule start) (ambiguity) '{' '}' (rule start)
	 *     (rule start) (ambiguity) '{' elements+=AExpression
	 *     (rule start) (ambiguity) feature=OpUnary
	 *     (rule start) (ambiguity) value=AInt
	 *     (rule start) (ambiguity) value=AReal
	 *     (rule start) (ambiguity) value=NoQuoteString
	 *     (rule start) (ambiguity) value?='true'
	 *     (rule start) (ambiguity) variable=[AVariableDeclaration|ID]
	 *     (rule start) (ambiguity) {ABinaryOperation.leftOperand=}
	 */
	protected void emit_AParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '#' '[' ']' ')' (rule start)
	 *     (rule start) (ambiguity) '#' '[' elements+=AExpression
	 *     (rule start) (ambiguity) '@' property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 *     (rule start) (ambiguity) 'false' ')' (rule start)
	 *     (rule start) (ambiguity) 'null' ')' (rule start)
	 *     (rule start) (ambiguity) '{' '}' ')' (rule start)
	 *     (rule start) (ambiguity) '{' elements+=AExpression
	 *     (rule start) (ambiguity) feature=OpUnary
	 *     (rule start) (ambiguity) value=AInt
	 *     (rule start) (ambiguity) value=AReal
	 *     (rule start) (ambiguity) value=NoQuoteString
	 *     (rule start) (ambiguity) value?='true'
	 *     (rule start) (ambiguity) variable=[AVariableDeclaration|ID]
	 *     (rule start) (ambiguity) {ABinaryOperation.leftOperand=}
	 */
	protected void emit_AParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[Category|ID] (ambiguity) category+=[Category|ID]
	 */
	protected void emit_DocGoal_CategoryKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocGoal_EvolvesKeyword_5_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_DocGoal_IssuesKeyword_5_12_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Goal|QualifiedName] (ambiguity) refinesReference+=[Goal|QualifiedName]
	 */
	protected void emit_DocGoal_RefinesKeyword_5_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'stakeholder'?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderReference+=[Stakeholder|QualifiedName] (ambiguity) stakeholderReference+=[Stakeholder|QualifiedName]
	 */
	protected void emit_DocGoal_StakeholderKeyword_5_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('conflicts' 'with')?
	 *
	 * This ambiguous syntax occurs at:
	 *     conflictsReference+=[Goal|QualifiedName] (ambiguity) conflictsReference+=[Goal|QualifiedName]
	 */
	protected void emit_DocGoal___ConflictsKeyword_5_6_0_WithKeyword_5_6_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document' 'requirement')?
	 *
	 * This ambiguous syntax occurs at:
	 *     documentRequirement+=[ContractualElement|QualifiedName] (ambiguity) documentRequirement+=[ContractualElement|QualifiedName]
	 */
	protected void emit_DocGoal___SeeKeyword_5_10_0_DocumentKeyword_5_10_1_RequirementKeyword_5_10_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_DocGoal___SeeKeyword_5_11_0_DocumentKeyword_5_11_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[Category|ID] (ambiguity) category+=[Category|ID]
	 */
	protected void emit_DocRequirement_CategoryKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'decomposes'?
	 *
	 * This ambiguous syntax occurs at:
	 *     decomposesReference+=[Requirement|QualifiedName] (ambiguity) decomposesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocRequirement_DecomposesKeyword_5_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocRequirement_EvolvesKeyword_5_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_DocRequirement_IssuesKeyword_5_17_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Requirement|QualifiedName] (ambiguity) refinesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocRequirement_RefinesKeyword_5_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('development' 'stakeholder')?
	 *
	 * This ambiguous syntax occurs at:
	 *     developmentStakeholder+=[Stakeholder|QualifiedName] (ambiguity) developmentStakeholder+=[Stakeholder|QualifiedName]
	 */
	protected void emit_DocRequirement___DevelopmentKeyword_5_12_0_StakeholderKeyword_5_12_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     goalReference+=[Goal|QualifiedName] (ambiguity) goalReference+=[Goal|QualifiedName]
	 */
	protected void emit_DocRequirement___SeeKeyword_5_13_0_GoalKeyword_5_13_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderRequirementReference+=[Goal|QualifiedName] (ambiguity) stakeholderRequirementReference+=[Goal|QualifiedName]
	 */
	protected void emit_DocRequirement___SeeKeyword_5_14_0_DocumentKeyword_5_14_1_GoalKeyword_5_14_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document' 'requirement')?
	 *
	 * This ambiguous syntax occurs at:
	 *     documentRequirement+=[ContractualElement|QualifiedName] (ambiguity) documentRequirement+=[ContractualElement|QualifiedName]
	 */
	protected void emit_DocRequirement___SeeKeyword_5_15_0_DocumentKeyword_5_15_1_RequirementKeyword_5_15_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_DocRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[RequirementCategory|ID] (ambiguity) category+=[RequirementCategory|ID]
	 */
	protected void emit_Goal_CategoryKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_Goal_EvolvesKeyword_5_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_Goal_IssuesKeyword_5_14_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'quality'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[QualityCategory|ID] (ambiguity) category+=[QualityCategory|ID]
	 */
	protected void emit_Goal_QualityKeyword_5_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Goal|QualifiedName] (ambiguity) refinesReference+=[Goal|QualifiedName]
	 */
	protected void emit_Goal_RefinesKeyword_5_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'selection'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[SelectionCategory|ID] (ambiguity) category+=[SelectionCategory|ID]
	 */
	protected void emit_Goal_SelectionKeyword_5_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'stakeholder'?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderReference+=[Stakeholder|QualifiedName] (ambiguity) stakeholderReference+=[Stakeholder|QualifiedName]
	 */
	protected void emit_Goal_StakeholderKeyword_5_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('conflicts' 'with')?
	 *
	 * This ambiguous syntax occurs at:
	 *     conflictsReference+=[Goal|QualifiedName] (ambiguity) conflictsReference+=[Goal|QualifiedName]
	 */
	protected void emit_Goal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document' 'requirement')?
	 *
	 * This ambiguous syntax occurs at:
	 *     documentRequirement+=[ContractualElement|QualifiedName] (ambiguity) documentRequirement+=[ContractualElement|QualifiedName]
	 */
	protected void emit_Goal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1_RequirementKeyword_5_12_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_Goal___SeeKeyword_5_13_0_DocumentKeyword_5_13_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_ReqDocument_IssuesKeyword_4_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[RequirementCategory|ID] (ambiguity) category+=[RequirementCategory|ID]
	 */
	protected void emit_Requirement_CategoryKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'decomposes'?
	 *
	 * This ambiguous syntax occurs at:
	 *     decomposesReference+=[Requirement|QualifiedName] (ambiguity) decomposesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_Requirement_DecomposesKeyword_5_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_Requirement_EvolvesKeyword_5_12_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_Requirement_IssuesKeyword_5_19_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'quality'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[QualityCategory|ID] (ambiguity) category+=[QualityCategory|ID]
	 */
	protected void emit_Requirement_QualityKeyword_5_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Requirement|QualifiedName] (ambiguity) refinesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_Requirement_RefinesKeyword_5_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'selection'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[SelectionCategory|ID] (ambiguity) category+=[SelectionCategory|ID]
	 */
	protected void emit_Requirement_SelectionKeyword_5_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('development' 'stakeholder')?
	 *
	 * This ambiguous syntax occurs at:
	 *     developmentStakeholder+=[Stakeholder|QualifiedName] (ambiguity) developmentStakeholder+=[Stakeholder|QualifiedName]
	 */
	protected void emit_Requirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     goalReference+=[Goal|QualifiedName] (ambiguity) goalReference+=[Goal|QualifiedName]
	 */
	protected void emit_Requirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderRequirementReference+=[Goal|QualifiedName] (ambiguity) stakeholderRequirementReference+=[Goal|QualifiedName]
	 */
	protected void emit_Requirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1_GoalKeyword_5_16_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document' 'requirement')?
	 *
	 * This ambiguous syntax occurs at:
	 *     documentRequirement+=[ContractualElement|QualifiedName] (ambiguity) documentRequirement+=[ContractualElement|QualifiedName]
	 */
	protected void emit_Requirement___SeeKeyword_5_17_0_DocumentKeyword_5_17_1_RequirementKeyword_5_17_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_Requirement___SeeKeyword_5_18_0_DocumentKeyword_5_18_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_StakeholderGoals_IssuesKeyword_7_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_SystemRequirements_IssuesKeyword_7_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_SystemRequirements___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
