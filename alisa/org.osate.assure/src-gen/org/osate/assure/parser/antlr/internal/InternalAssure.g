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
grammar InternalAssure;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.osate.assure.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.osate.assure.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.assure.services.AssureGrammarAccess;

}

@parser::members {

 	private AssureGrammarAccess grammarAccess;
 	
    public InternalAssureParser(TokenStream input, AssureGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "AssuranceCase";	
   	}
   	
   	@Override
   	protected AssureGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleAssuranceCase
entryRuleAssuranceCase returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAssuranceCaseRule()); }
	 iv_ruleAssuranceCase=ruleAssuranceCase 
	 { $current=$iv_ruleAssuranceCase.current; } 
	 EOF 
;

// Rule AssuranceCase
ruleAssuranceCase returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='case' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAssuranceCaseAccess().getCaseKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseAccess().getNameQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='for' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAssuranceCaseAccess().getForKeyword_2_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceCaseRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseAccess().getTargetAssurancePlanCrossReference_2_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_4='system' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getAssuranceCaseAccess().getSystemKeyword_3_0());
    }
(
(
		lv_targetSystem_5_0=RULE_ID
		{
			newLeafNode(lv_targetSystem_5_0, grammarAccess.getAssuranceCaseAccess().getTargetSystemIDTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceCaseRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"targetSystem",
        		lv_targetSystem_5_0, 
        		"ID");
	    }

)
))?	otherlv_6='[' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getAssuranceCaseAccess().getLeftSquareBracketKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseAccess().getMetricsMetricsParserRuleCall_5_0()); 
	    }
		lv_metrics_7_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_7_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_8='message' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getAssuranceCaseAccess().getMessageKeyword_6_0());
    }
(
(
		lv_message_9_0=RULE_STRING
		{
			newLeafNode(lv_message_9_0, grammarAccess.getAssuranceCaseAccess().getMessageSTRINGTerminalRuleCall_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceCaseRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_9_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseAccess().getClaimResultClaimResultParserRuleCall_7_0()); 
	    }
		lv_claimResult_10_0=ruleClaimResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
	        }
       		add(
       			$current, 
       			"claimResult",
        		lv_claimResult_10_0, 
        		"ClaimResult");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCaseAccess().getSubAssuranceCaseAssuranceCaseParserRuleCall_8_0()); 
	    }
		lv_subAssuranceCase_11_0=ruleAssuranceCase		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAssuranceCaseRule());
	        }
       		add(
       			$current, 
       			"subAssuranceCase",
        		lv_subAssuranceCase_11_0, 
        		"AssuranceCase");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_12=']' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getAssuranceCaseAccess().getRightSquareBracketKeyword_9());
    }
)
;





// Entry rule entryRuleClaimResult
entryRuleClaimResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getClaimResultRule()); }
	 iv_ruleClaimResult=ruleClaimResult 
	 { $current=$iv_ruleClaimResult.current; } 
	 EOF 
;

// Rule ClaimResult
ruleClaimResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='claim' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getClaimResultAccess().getClaimKeyword_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getClaimResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getClaimResultAccess().getTargetRequirementCrossReference_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='[' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getClaimResultAccess().getLeftSquareBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimResultAccess().getMetricsMetricsParserRuleCall_3_0()); 
	    }
		lv_metrics_3_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_3_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4='message' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getClaimResultAccess().getMessageKeyword_4_0());
    }
(
(
		lv_message_5_0=RULE_STRING
		{
			newLeafNode(lv_message_5_0, grammarAccess.getClaimResultAccess().getMessageSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getClaimResultRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_5_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimResultAccess().getSubClaimResultClaimResultParserRuleCall_5_0()); 
	    }
		lv_subClaimResult_6_0=ruleClaimResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimResultRule());
	        }
       		add(
       			$current, 
       			"subClaimResult",
        		lv_subClaimResult_6_0, 
        		"ClaimResult");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getClaimResultAccess().getVerificationActivityResultVerificationExprParserRuleCall_6_0()); 
	    }
		lv_verificationActivityResult_7_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClaimResultRule());
	        }
       		add(
       			$current, 
       			"verificationActivityResult",
        		lv_verificationActivityResult_7_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_8=']' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getClaimResultAccess().getRightSquareBracketKeyword_7());
    }
)
;





// Entry rule entryRuleConditionResult
entryRuleConditionResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConditionResultRule()); }
	 iv_ruleConditionResult=ruleConditionResult 
	 { $current=$iv_ruleConditionResult.current; } 
	 EOF 
;

// Rule ConditionResult
ruleConditionResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((	otherlv_0='precondition' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getConditionResultAccess().getPreconditionKeyword_0_0_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getConditionResultAccess().getPreconditionResultAction_0_0_1(),
            $current);
    }
))
    |(	otherlv_2='validation' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getConditionResultAccess().getValidationKeyword_0_1_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getConditionResultAccess().getValidationResultAction_0_1_1(),
            $current);
    }
)))(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConditionResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getConditionResultAccess().getTargetVerificationConditionCrossReference_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_5='[' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getConditionResultAccess().getLeftSquareBracketKeyword_2());
    }
	otherlv_6='executionstate' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getConditionResultAccess().getExecutionstateKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConditionResultAccess().getExecutionStateVerificationExecutionStateEnumRuleCall_4_0()); 
	    }
		lv_executionState_7_0=ruleVerificationExecutionState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConditionResultRule());
	        }
       		set(
       			$current, 
       			"executionState",
        		lv_executionState_7_0, 
        		"VerificationExecutionState");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_8='resultstate' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getConditionResultAccess().getResultstateKeyword_5());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConditionResultAccess().getResultStateVerificationResultStateEnumRuleCall_6_0()); 
	    }
		lv_resultState_9_0=ruleVerificationResultState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConditionResultRule());
	        }
       		set(
       			$current, 
       			"resultState",
        		lv_resultState_9_0, 
        		"VerificationResultState");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_10='issues' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getConditionResultAccess().getIssuesKeyword_7_0());
    }
	otherlv_11='[' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getConditionResultAccess().getLeftSquareBracketKeyword_7_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConditionResultAccess().getIssuesResultIssueParserRuleCall_7_2_0()); 
	    }
		lv_issues_12_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConditionResultRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_12_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_13=']' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getConditionResultAccess().getRightSquareBracketKeyword_7_3());
    }
)?(	otherlv_14='report' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getConditionResultAccess().getReportKeyword_8_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getConditionResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getConditionResultAccess().getResultReportResultReportCrossReference_8_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getConditionResultAccess().getMetricsMetricsParserRuleCall_9_0()); 
	    }
		lv_metrics_16_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConditionResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_16_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_17='message' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getConditionResultAccess().getMessageKeyword_10_0());
    }
(
(
		lv_message_18_0=RULE_STRING
		{
			newLeafNode(lv_message_18_0, grammarAccess.getConditionResultAccess().getMessageSTRINGTerminalRuleCall_10_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getConditionResultRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_18_0, 
        		"STRING");
	    }

)
))?	otherlv_19=']' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getConditionResultAccess().getRightSquareBracketKeyword_11());
    }
)
;





// Entry rule entryRuleVerificationActivityResult
entryRuleVerificationActivityResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerificationActivityResultRule()); }
	 iv_ruleVerificationActivityResult=ruleVerificationActivityResult 
	 { $current=$iv_ruleVerificationActivityResult.current; } 
	 EOF 
;

// Rule VerificationActivityResult
ruleVerificationActivityResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='verification' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVerificationActivityResultAccess().getVerificationKeyword_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getVerificationActivityResultAccess().getVerificationActivityResultAction_1(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationActivityResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getTargetVerificationActivityCrossReference_2_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='[' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getVerificationActivityResultAccess().getLeftSquareBracketKeyword_3());
    }
	otherlv_4='executionstate' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getVerificationActivityResultAccess().getExecutionstateKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getExecutionStateVerificationExecutionStateEnumRuleCall_5_0()); 
	    }
		lv_executionState_5_0=ruleVerificationExecutionState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		set(
       			$current, 
       			"executionState",
        		lv_executionState_5_0, 
        		"VerificationExecutionState");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_6='resultstate' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getVerificationActivityResultAccess().getResultstateKeyword_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getResultStateVerificationResultStateEnumRuleCall_7_0()); 
	    }
		lv_resultState_7_0=ruleVerificationResultState		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		set(
       			$current, 
       			"resultState",
        		lv_resultState_7_0, 
        		"VerificationResultState");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_8='issues' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getVerificationActivityResultAccess().getIssuesKeyword_8_0());
    }
	otherlv_9='[' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getVerificationActivityResultAccess().getLeftSquareBracketKeyword_8_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getIssuesResultIssueParserRuleCall_8_2_0()); 
	    }
		lv_issues_10_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_10_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_11=']' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getVerificationActivityResultAccess().getRightSquareBracketKeyword_8_3());
    }
)?(	otherlv_12='report' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getVerificationActivityResultAccess().getReportKeyword_9_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationActivityResultRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getResultReportResultReportCrossReference_9_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getMetricsMetricsParserRuleCall_10_0()); 
	    }
		lv_metrics_14_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_14_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_15='message' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getVerificationActivityResultAccess().getMessageKeyword_11_0());
    }
(
(
		lv_message_16_0=RULE_STRING
		{
			newLeafNode(lv_message_16_0, grammarAccess.getVerificationActivityResultAccess().getMessageSTRINGTerminalRuleCall_11_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVerificationActivityResultRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_16_0, 
        		"STRING");
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getVerificationActivityResultAccess().getConditionResultConditionResultParserRuleCall_12_0()); 
	    }
		lv_conditionResult_17_0=ruleConditionResult		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVerificationActivityResultRule());
	        }
       		set(
       			$current, 
       			"conditionResult",
        		lv_conditionResult_17_0, 
        		"ConditionResult");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_18=']' 
    {
    	newLeafNode(otherlv_18, grammarAccess.getVerificationActivityResultAccess().getRightSquareBracketKeyword_13());
    }
)
;







// Entry rule entryRuleVerificationExpr
entryRuleVerificationExpr returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVerificationExprRule()); }
	 iv_ruleVerificationExpr=ruleVerificationExpr 
	 { $current=$iv_ruleVerificationExpr.current; } 
	 EOF 
;

// Rule VerificationExpr
ruleVerificationExpr returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getVerificationExprAccess().getVerificationActivityResultParserRuleCall_0()); 
    }
    this_VerificationActivityResult_0=ruleVerificationActivityResult
    { 
        $current = $this_VerificationActivityResult_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVerificationExprAccess().getElseResultParserRuleCall_1()); 
    }
    this_ElseResult_1=ruleElseResult
    { 
        $current = $this_ElseResult_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getVerificationExprAccess().getThenResultParserRuleCall_2()); 
    }
    this_ThenResult_2=ruleThenResult
    { 
        $current = $this_ThenResult_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleElseResult
entryRuleElseResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getElseResultRule()); }
	 iv_ruleElseResult=ruleElseResult 
	 { $current=$iv_ruleElseResult.current; } 
	 EOF 
;

// Rule ElseResult
ruleElseResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='else' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getElseResultAccess().getElseKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getFirstVerificationExprParserRuleCall_1_0()); 
	    }
		lv_first_1_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		add(
       			$current, 
       			"first",
        		lv_first_1_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+(	otherlv_2='error' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getElseResultAccess().getErrorKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getErrorVerificationExprParserRuleCall_2_1_0()); 
	    }
		lv_error_3_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		add(
       			$current, 
       			"error",
        		lv_error_3_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+)?(	otherlv_4='fail' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getElseResultAccess().getFailKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getFailVerificationExprParserRuleCall_3_1_0()); 
	    }
		lv_fail_5_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		add(
       			$current, 
       			"fail",
        		lv_fail_5_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+)?(	otherlv_6='timeout' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getElseResultAccess().getTimeoutKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getTimeoutVerificationExprParserRuleCall_4_1_0()); 
	    }
		lv_timeout_7_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		add(
       			$current, 
       			"timeout",
        		lv_timeout_7_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+)?	otherlv_8='[' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getElseResultAccess().getLeftSquareBracketKeyword_5());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getDidFailElseTypeEnumRuleCall_6_0()); 
	    }
		lv_didFail_9_0=ruleElseType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		set(
       			$current, 
       			"didFail",
        		lv_didFail_9_0, 
        		"ElseType");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getElseResultAccess().getMetricsMetricsParserRuleCall_7_0()); 
	    }
		lv_metrics_10_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getElseResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_10_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_11=']' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getElseResultAccess().getRightSquareBracketKeyword_8());
    }
)
;





// Entry rule entryRuleThenResult
entryRuleThenResult returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getThenResultRule()); }
	 iv_ruleThenResult=ruleThenResult 
	 { $current=$iv_ruleThenResult.current; } 
	 EOF 
;

// Rule ThenResult
ruleThenResult returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='then' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getThenResultAccess().getThenKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getThenResultAccess().getFirstVerificationExprParserRuleCall_1_0()); 
	    }
		lv_first_1_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getThenResultRule());
	        }
       		add(
       			$current, 
       			"first",
        		lv_first_1_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_2='do' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getThenResultAccess().getDoKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getThenResultAccess().getSecondVerificationExprParserRuleCall_3_0()); 
	    }
		lv_second_3_0=ruleVerificationExpr		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getThenResultRule());
	        }
       		add(
       			$current, 
       			"second",
        		lv_second_3_0, 
        		"VerificationExpr");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getThenResultAccess().getLeftSquareBracketKeyword_4());
    }
(
(
		lv_didThenFail_5_0=	'thenfailed' 
    {
        newLeafNode(lv_didThenFail_5_0, grammarAccess.getThenResultAccess().getDidThenFailThenfailedKeyword_5_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getThenResultRule());
	        }
       		setWithLastConsumed($current, "didThenFail", true, "thenfailed");
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getThenResultAccess().getMetricsMetricsParserRuleCall_6_0()); 
	    }
		lv_metrics_6_0=ruleMetrics		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getThenResultRule());
	        }
       		set(
       			$current, 
       			"metrics",
        		lv_metrics_6_0, 
        		"Metrics");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7=']' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getThenResultAccess().getRightSquareBracketKeyword_7());
    }
)
;





// Entry rule entryRuleMetrics
entryRuleMetrics returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMetricsRule()); }
	 iv_ruleMetrics=ruleMetrics 
	 { $current=$iv_ruleMetrics.current; } 
	 EOF 
;

// Rule Metrics
ruleMetrics returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='tbdcount' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMetricsAccess().getTbdcountKeyword_0_0());
    }
(
(
		lv_tbdCount_1_0=RULE_INT
		{
			newLeafNode(lv_tbdCount_1_0, grammarAccess.getMetricsAccess().getTbdCountINTTerminalRuleCall_0_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"tbdCount",
        		lv_tbdCount_1_0, 
        		"INT");
	    }

)
))?(	otherlv_2='successcount' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMetricsAccess().getSuccesscountKeyword_1_0());
    }
(
(
		lv_successCount_3_0=RULE_INT
		{
			newLeafNode(lv_successCount_3_0, grammarAccess.getMetricsAccess().getSuccessCountINTTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"successCount",
        		lv_successCount_3_0, 
        		"INT");
	    }

)
))?(	otherlv_4='failcount' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMetricsAccess().getFailcountKeyword_2_0());
    }
(
(
		lv_failCount_5_0=RULE_INT
		{
			newLeafNode(lv_failCount_5_0, grammarAccess.getMetricsAccess().getFailCountINTTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"failCount",
        		lv_failCount_5_0, 
        		"INT");
	    }

)
))?(	otherlv_6='timeoutcount' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getMetricsAccess().getTimeoutcountKeyword_3_0());
    }
(
(
		lv_timeoutCount_7_0=RULE_INT
		{
			newLeafNode(lv_timeoutCount_7_0, grammarAccess.getMetricsAccess().getTimeoutCountINTTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"timeoutCount",
        		lv_timeoutCount_7_0, 
        		"INT");
	    }

)
))?(	otherlv_8='errorcount' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getMetricsAccess().getErrorcountKeyword_4_0());
    }
(
(
		lv_errorCount_9_0=RULE_INT
		{
			newLeafNode(lv_errorCount_9_0, grammarAccess.getMetricsAccess().getErrorCountINTTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"errorCount",
        		lv_errorCount_9_0, 
        		"INT");
	    }

)
))?(	otherlv_10='didelsecount' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getMetricsAccess().getDidelsecountKeyword_5_0());
    }
(
(
		lv_didelseCount_11_0=RULE_INT
		{
			newLeafNode(lv_didelseCount_11_0, grammarAccess.getMetricsAccess().getDidelseCountINTTerminalRuleCall_5_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"didelseCount",
        		lv_didelseCount_11_0, 
        		"INT");
	    }

)
))?(	otherlv_12='thenskipcount' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getMetricsAccess().getThenskipcountKeyword_6_0());
    }
(
(
		lv_thenskipCount_13_0=RULE_INT
		{
			newLeafNode(lv_thenskipCount_13_0, grammarAccess.getMetricsAccess().getThenskipCountINTTerminalRuleCall_6_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"thenskipCount",
        		lv_thenskipCount_13_0, 
        		"INT");
	    }

)
))?(	otherlv_14='prefailcount' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getMetricsAccess().getPrefailcountKeyword_7_0());
    }
(
(
		lv_preconditionfailCount_15_0=RULE_INT
		{
			newLeafNode(lv_preconditionfailCount_15_0, grammarAccess.getMetricsAccess().getPreconditionfailCountINTTerminalRuleCall_7_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"preconditionfailCount",
        		lv_preconditionfailCount_15_0, 
        		"INT");
	    }

)
))?(	otherlv_16='validfailcount' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getMetricsAccess().getValidfailcountKeyword_8_0());
    }
(
(
		lv_validationfailCount_17_0=RULE_INT
		{
			newLeafNode(lv_validationfailCount_17_0, grammarAccess.getMetricsAccess().getValidationfailCountINTTerminalRuleCall_8_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"validationfailCount",
        		lv_validationfailCount_17_0, 
        		"INT");
	    }

)
))?(	otherlv_18='weight' 
    {
    	newLeafNode(otherlv_18, grammarAccess.getMetricsAccess().getWeightKeyword_9_0());
    }
(
(
		lv_weight_19_0=RULE_INT
		{
			newLeafNode(lv_weight_19_0, grammarAccess.getMetricsAccess().getWeightINTTerminalRuleCall_9_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetricsRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"weight",
        		lv_weight_19_0, 
        		"INT");
	    }

)
))?)
;





// Entry rule entryRuleResultIssue
entryRuleResultIssue returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getResultIssueRule()); }
	 iv_ruleResultIssue=ruleResultIssue 
	 { $current=$iv_ruleResultIssue.current; } 
	 EOF 
;

// Rule ResultIssue
ruleResultIssue returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_0_0()); 
	    }
		lv_issueType_0_0=ruleResultIssueType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultIssueRule());
	        }
       		set(
       			$current, 
       			"issueType",
        		lv_issueType_0_0, 
        		"ResultIssueType");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getResultIssueAccess().getColonKeyword_1_0());
    }
(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getResultIssueAccess().getNameIDTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultIssueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"ID");
	    }

)
))?(
(
		lv_message_3_0=RULE_STRING
		{
			newLeafNode(lv_message_3_0, grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultIssueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_3_0, 
        		"STRING");
	    }

)
)(	otherlv_4='exception' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getResultIssueAccess().getExceptionKeyword_3_0());
    }
(
(
		lv_exceptionType_5_0=RULE_STRING
		{
			newLeafNode(lv_exceptionType_5_0, grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultIssueRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"exceptionType",
        		lv_exceptionType_5_0, 
        		"STRING");
	    }

)
))?(	otherlv_6='target' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getResultIssueAccess().getTargetKeyword_4_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getResultIssueRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_4_1_0()); 
	    }
		ruleURIID		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_8='[' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 
	    }
		lv_issues_9_0=ruleResultIssue		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getResultIssueRule());
	        }
       		add(
       			$current, 
       			"issues",
        		lv_issues_9_0, 
        		"ResultIssue");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_10=']' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2());
    }
)?)
;





// Entry rule entryRuleURIID
entryRuleURIID returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getURIIDRule()); } 
	 iv_ruleURIID=ruleURIID 
	 { $current=$iv_ruleURIID.current.getText(); }  
	 EOF 
;

// Rule URIID
ruleURIID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); 
    }

    ;







// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); } 
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current.getText(); }  
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
    }
(((
	'.' 
)=>
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
    }
)    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
    ;





// Rule ElseType
ruleElseType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='ok' 
	{
        $current = grammarAccess.getElseTypeAccess().getOKEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getElseTypeAccess().getOKEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='fail' 
	{
        $current = grammarAccess.getElseTypeAccess().getFAILEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getElseTypeAccess().getFAILEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='timeout' 
	{
        $current = grammarAccess.getElseTypeAccess().getTIMEOUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getElseTypeAccess().getTIMEOUTEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='error' 
	{
        $current = grammarAccess.getElseTypeAccess().getERROREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getElseTypeAccess().getERROREnumLiteralDeclaration_3()); 
    }
));



// Rule ResultIssueType
ruleResultIssueType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='error' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='warning' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='success' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='info' 
	{
        $current = grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); 
    }
));



// Rule VerificationResultState
ruleVerificationResultState returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='tbd' 
	{
        $current = grammarAccess.getVerificationResultStateAccess().getTBDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getVerificationResultStateAccess().getTBDEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='success' 
	{
        $current = grammarAccess.getVerificationResultStateAccess().getSUCCESSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getVerificationResultStateAccess().getSUCCESSEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='fail' 
	{
        $current = grammarAccess.getVerificationResultStateAccess().getFAILEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getVerificationResultStateAccess().getFAILEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='error' 
	{
        $current = grammarAccess.getVerificationResultStateAccess().getERROREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getVerificationResultStateAccess().getERROREnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='timeout' 
	{
        $current = grammarAccess.getVerificationResultStateAccess().getTIMEOUTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getVerificationResultStateAccess().getTIMEOUTEnumLiteralDeclaration_4()); 
    }
));



// Rule VerificationExecutionState
ruleVerificationExecutionState returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='todo' 
	{
        $current = grammarAccess.getVerificationExecutionStateAccess().getTODOEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getVerificationExecutionStateAccess().getTODOEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='running' 
	{
        $current = grammarAccess.getVerificationExecutionStateAccess().getRUNNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getVerificationExecutionStateAccess().getRUNNINGEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='redo' 
	{
        $current = grammarAccess.getVerificationExecutionStateAccess().getREDOEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getVerificationExecutionStateAccess().getREDOEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='completed' 
	{
        $current = grammarAccess.getVerificationExecutionStateAccess().getCOMPLETEDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getVerificationExecutionStateAccess().getCOMPLETEDEnumLiteralDeclaration_3()); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


