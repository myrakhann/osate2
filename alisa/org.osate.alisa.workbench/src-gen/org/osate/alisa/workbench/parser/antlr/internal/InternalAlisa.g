/*
* generated by Xtext
*/
grammar InternalAlisa;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.osate.alisa.workbench.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.osate.alisa.workbench.parser.antlr.internal; 

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
import org.osate.alisa.workbench.services.AlisaGrammarAccess;

}

@parser::members {

 	private AlisaGrammarAccess grammarAccess;
 	
    public InternalAlisaParser(TokenStream input, AlisaGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "AlisaWorkArea";	
   	}
   	
   	@Override
   	protected AlisaGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleAlisaWorkArea
entryRuleAlisaWorkArea returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAlisaWorkAreaRule()); }
	 iv_ruleAlisaWorkArea=ruleAlisaWorkArea 
	 { $current=$iv_ruleAlisaWorkArea.current; } 
	 EOF 
;

// Rule AlisaWorkArea
ruleAlisaWorkArea returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='alisa' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAlisaWorkAreaAccess().getAlisaKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getAlisaWorkAreaAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAlisaWorkAreaRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getAlisaWorkAreaAccess().getCasesAssuranceCasePlanParserRuleCall_2_0()); 
	    }
		lv_cases_2_0=ruleAssuranceCasePlan		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAlisaWorkAreaRule());
	        }
       		add(
       			$current, 
       			"cases",
        		lv_cases_2_0, 
        		"AssuranceCasePlan");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
;





// Entry rule entryRuleAssuranceCasePlan
entryRuleAssuranceCasePlan returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAssuranceCasePlanRule()); }
	 iv_ruleAssuranceCasePlan=ruleAssuranceCasePlan 
	 { $current=$iv_ruleAssuranceCasePlan.current; } 
	 EOF 
;

// Rule AssuranceCasePlan
ruleAssuranceCasePlan returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='case' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAssuranceCasePlanAccess().getCaseKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getAssuranceCasePlanAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceCasePlanRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2='for' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAssuranceCasePlanAccess().getForKeyword_2());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceCasePlanRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCasePlanAccess().getSystemComponentImplementationCrossReference_3_0()); 
	    }
		ruleAadlClassifierReference		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getAssuranceCasePlanAccess().getLeftSquareBracketKeyword_4());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getAssuranceCasePlanRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getAssuranceCasePlanAccess().getPlansVerificationPlanCrossReference_5_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_6=']' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getAssuranceCasePlanAccess().getRightSquareBracketKeyword_6());
    }
)
;







// Entry rule entryRuleDescription
entryRuleDescription returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDescriptionRule()); }
	 iv_ruleDescription=ruleDescription 
	 { $current=$iv_ruleDescription.current; } 
	 EOF 
;

// Rule Description
ruleDescription returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{ 
	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
	    }
		lv_description_0_0=ruleDescriptionElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDescriptionRule());
	        }
       		add(
       			$current, 
       			"description",
        		lv_description_0_0, 
        		"DescriptionElement");
	        afterParserOrEnumRuleCall();
	    }

)
)+
;





// Entry rule entryRuleDescriptionElement
entryRuleDescriptionElement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDescriptionElementRule()); }
	 iv_ruleDescriptionElement=ruleDescriptionElement 
	 { $current=$iv_ruleDescriptionElement.current; } 
	 EOF 
;

// Rule DescriptionElement
ruleDescriptionElement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_text_0_0=RULE_STRING
		{
			newLeafNode(lv_text_0_0, grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getDescriptionElementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"text",
        		lv_text_0_0, 
        		"STRING");
	    }

)
)
    |(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getDescriptionElementRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 
	}

)
))
;





// Entry rule entryRuleReferencePath
entryRuleReferencePath returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getReferencePathRule()); }
	 iv_ruleReferencePath=ruleReferencePath 
	 { $current=$iv_ruleReferencePath.current; } 
	 EOF 
;

// Rule ReferencePath
ruleReferencePath returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getReferencePathRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
	}

)
)(	otherlv_1='.' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
	    }
		lv_subpath_2_0=ruleReferencePath		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReferencePathRule());
	        }
       		set(
       			$current, 
       			"subpath",
        		lv_subpath_2_0, 
        		"ReferencePath");
	        afterParserOrEnumRuleCall();
	    }

)
)))
;











// Entry rule entryRuleMultiLineString
entryRuleMultiLineString returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getMultiLineStringRule()); } 
	 iv_ruleMultiLineString=ruleMultiLineString 
	 { $current=$iv_ruleMultiLineString.current.getText(); }  
	 EOF 
;

// Rule MultiLineString
ruleMultiLineString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='\'\'\'' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMultiLineStringAccess().getApostropheApostropheApostropheKeyword_0()); 
    }
(    this_STRING_1=RULE_STRING    {
		$current.merge(this_STRING_1);
    }

    { 
    newLeafNode(this_STRING_1, grammarAccess.getMultiLineStringAccess().getSTRINGTerminalRuleCall_1()); 
    }
)*
	kw='\'\'\'' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getMultiLineStringAccess().getApostropheApostropheApostropheKeyword_2()); 
    }
)
    ;





// Entry rule entryRuleValueString
entryRuleValueString returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getValueStringRule()); } 
	 iv_ruleValueString=ruleValueString 
	 { $current=$iv_ruleValueString.current.getText(); }  
	 EOF 
;

// Rule ValueString
ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getValueStringAccess().getSTRINGTerminalRuleCall()); 
    }

    ;





// Entry rule entryRuleAadlClassifierReference
entryRuleAadlClassifierReference returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); } 
	 iv_ruleAadlClassifierReference=ruleAadlClassifierReference 
	 { $current=$iv_ruleAadlClassifierReference.current.getText(); }  
	 EOF 
;

// Rule AadlClassifierReference
ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
    }

	kw='::' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_0_1()); 
    }
)*    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
    }
    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_2_1()); 
    }
)?)
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
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
    ;







// Rule IssueType
ruleIssueType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='error' 
	{
        $current = grammarAccess.getIssueTypeAccess().getERROREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='warning' 
	{
        $current = grammarAccess.getIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='info' 
	{
        $current = grammarAccess.getIssueTypeAccess().getINFOEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getIssueTypeAccess().getINFOEnumLiteralDeclaration_2()); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


