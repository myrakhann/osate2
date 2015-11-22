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
package org.osate.reqspec.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.osate.alisa.common.services.CommonGrammarAccess;

@Singleton
public class ReqSpecGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ReqSpecElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ReqSpec");
		private final Assignment cPartsAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cPartsAlternatives_0 = (Alternatives)cPartsAssignment.eContents().get(0);
		private final RuleCall cPartsSystemRequirementsParserRuleCall_0_0 = (RuleCall)cPartsAlternatives_0.eContents().get(0);
		private final RuleCall cPartsStakeholderGoalsParserRuleCall_0_1 = (RuleCall)cPartsAlternatives_0.eContents().get(1);
		private final RuleCall cPartsReqDocumentParserRuleCall_0_2 = (RuleCall)cPartsAlternatives_0.eContents().get(2);
		private final RuleCall cPartsGlobalConstantsParserRuleCall_0_3 = (RuleCall)cPartsAlternatives_0.eContents().get(3);
		
		//ReqSpec:
		//	parts+=(SystemRequirements | StakeholderGoals | ReqDocument | GlobalConstants)+;
		@Override public ParserRule getRule() { return rule; }

		//parts+=(SystemRequirements | StakeholderGoals | ReqDocument | GlobalConstants)+
		public Assignment getPartsAssignment() { return cPartsAssignment; }

		//SystemRequirements | StakeholderGoals | ReqDocument | GlobalConstants
		public Alternatives getPartsAlternatives_0() { return cPartsAlternatives_0; }

		//SystemRequirements
		public RuleCall getPartsSystemRequirementsParserRuleCall_0_0() { return cPartsSystemRequirementsParserRuleCall_0_0; }

		//StakeholderGoals
		public RuleCall getPartsStakeholderGoalsParserRuleCall_0_1() { return cPartsStakeholderGoalsParserRuleCall_0_1; }

		//ReqDocument
		public RuleCall getPartsReqDocumentParserRuleCall_0_2() { return cPartsReqDocumentParserRuleCall_0_2; }

		//GlobalConstants
		public RuleCall getPartsGlobalConstantsParserRuleCall_0_3() { return cPartsGlobalConstantsParserRuleCall_0_3; }
	}

	public class ReqSpecContainerElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ReqSpecContainer");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSystemRequirementsParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cStakeholderGoalsParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cReqDocumentParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cDocumentSectionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//ReqSpecContainer:
		//	SystemRequirements | StakeholderGoals | ReqDocument | DocumentSection;
		@Override public ParserRule getRule() { return rule; }

		//SystemRequirements | StakeholderGoals | ReqDocument | DocumentSection
		public Alternatives getAlternatives() { return cAlternatives; }

		//SystemRequirements
		public RuleCall getSystemRequirementsParserRuleCall_0() { return cSystemRequirementsParserRuleCall_0; }

		//StakeholderGoals
		public RuleCall getStakeholderGoalsParserRuleCall_1() { return cStakeholderGoalsParserRuleCall_1; }

		//ReqDocument
		public RuleCall getReqDocumentParserRuleCall_2() { return cReqDocumentParserRuleCall_2; }

		//DocumentSection
		public RuleCall getDocumentSectionParserRuleCall_3() { return cDocumentSectionParserRuleCall_3; }
	}

	public class GlobalConstantsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "GlobalConstants");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cConstantsKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameQualifiedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cConstantsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cConstantsValDeclarationParserRuleCall_3_0 = (RuleCall)cConstantsAssignment_3.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//GlobalConstants:
		//	"constants" name=QualifiedName "[" constants+=ValDeclaration* "]";
		@Override public ParserRule getRule() { return rule; }

		//"constants" name=QualifiedName "[" constants+=ValDeclaration* "]"
		public Group getGroup() { return cGroup; }

		//"constants"
		public Keyword getConstantsKeyword_0() { return cConstantsKeyword_0; }

		//name=QualifiedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_1_0() { return cNameQualifiedNameParserRuleCall_1_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//constants+=ValDeclaration*
		public Assignment getConstantsAssignment_3() { return cConstantsAssignment_3; }

		//ValDeclaration
		public RuleCall getConstantsValDeclarationParserRuleCall_3_0() { return cConstantsValDeclarationParserRuleCall_3_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}

	public class ContractualElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ContractualElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cGoalParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDocGoalParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cRequirementParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cDocRequirementParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//ContractualElement:
		//	Goal | DocGoal | Requirement | DocRequirement;
		@Override public ParserRule getRule() { return rule; }

		//Goal | DocGoal | Requirement | DocRequirement
		public Alternatives getAlternatives() { return cAlternatives; }

		//Goal
		public RuleCall getGoalParserRuleCall_0() { return cGoalParserRuleCall_0; }

		//DocGoal
		public RuleCall getDocGoalParserRuleCall_1() { return cDocGoalParserRuleCall_1; }

		//Requirement
		public RuleCall getRequirementParserRuleCall_2() { return cRequirementParserRuleCall_2; }

		//DocRequirement
		public RuleCall getDocRequirementParserRuleCall_3() { return cDocRequirementParserRuleCall_3; }
	}

	public class ReqRootElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ReqRoot");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cStakeholderGoalsParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cReqDocumentParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSystemRequirementsParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//ReqRoot:
		//	StakeholderGoals | ReqDocument | SystemRequirements;
		@Override public ParserRule getRule() { return rule; }

		//StakeholderGoals | ReqDocument | SystemRequirements
		public Alternatives getAlternatives() { return cAlternatives; }

		//StakeholderGoals
		public RuleCall getStakeholderGoalsParserRuleCall_0() { return cStakeholderGoalsParserRuleCall_0; }

		//ReqDocument
		public RuleCall getReqDocumentParserRuleCall_1() { return cReqDocumentParserRuleCall_1; }

		//SystemRequirements
		public RuleCall getSystemRequirementsParserRuleCall_2() { return cSystemRequirementsParserRuleCall_2; }
	}

	public class StakeholderGoalsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StakeholderGoals");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cStakeholderKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cGoalsKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameQualifiedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTitleAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cTitleAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cForKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Alternatives cAlternatives_4_1 = (Alternatives)cGroup_4.eContents().get(1);
		private final Assignment cTargetAssignment_4_1_0 = (Assignment)cAlternatives_4_1.eContents().get(0);
		private final CrossReference cTargetComponentClassifierCrossReference_4_1_0_0 = (CrossReference)cTargetAssignment_4_1_0.eContents().get(0);
		private final RuleCall cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_4_1_0_0_1 = (RuleCall)cTargetComponentClassifierCrossReference_4_1_0_0.eContents().get(1);
		private final Assignment cComponentCategoryAssignment_4_1_1 = (Assignment)cAlternatives_4_1.eContents().get(1);
		private final RuleCall cComponentCategoryComponentCategoryParserRuleCall_4_1_1_0 = (RuleCall)cComponentCategoryAssignment_4_1_1.eContents().get(0);
		private final Assignment cGlobalAssignment_4_1_2 = (Assignment)cAlternatives_4_1.eContents().get(2);
		private final Keyword cGlobalAllKeyword_4_1_2_0 = (Keyword)cGlobalAssignment_4_1_2.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cUseKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cConstantsKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cImportConstantsAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final CrossReference cImportConstantsGlobalConstantsCrossReference_5_2_0 = (CrossReference)cImportConstantsAssignment_5_2.eContents().get(0);
		private final RuleCall cImportConstantsGlobalConstantsQualifiedNameParserRuleCall_5_2_0_1 = (RuleCall)cImportConstantsGlobalConstantsCrossReference_5_2_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final UnorderedGroup cUnorderedGroup_7 = (UnorderedGroup)cGroup.eContents().get(7);
		private final Assignment cDescriptionAssignment_7_0 = (Assignment)cUnorderedGroup_7.eContents().get(0);
		private final RuleCall cDescriptionDescriptionParserRuleCall_7_0_0 = (RuleCall)cDescriptionAssignment_7_0.eContents().get(0);
		private final Assignment cConstantsAssignment_7_1 = (Assignment)cUnorderedGroup_7.eContents().get(1);
		private final RuleCall cConstantsValDeclarationParserRuleCall_7_1_0 = (RuleCall)cConstantsAssignment_7_1.eContents().get(0);
		private final Assignment cContentAssignment_7_2 = (Assignment)cUnorderedGroup_7.eContents().get(2);
		private final RuleCall cContentGoalParserRuleCall_7_2_0 = (RuleCall)cContentAssignment_7_2.eContents().get(0);
		private final Group cGroup_7_3 = (Group)cUnorderedGroup_7.eContents().get(3);
		private final Keyword cSeeKeyword_7_3_0 = (Keyword)cGroup_7_3.eContents().get(0);
		private final Keyword cDocumentKeyword_7_3_1 = (Keyword)cGroup_7_3.eContents().get(1);
		private final Assignment cDocReferenceAssignment_7_3_2 = (Assignment)cGroup_7_3.eContents().get(2);
		private final RuleCall cDocReferenceExternalDocumentParserRuleCall_7_3_2_0 = (RuleCall)cDocReferenceAssignment_7_3_2.eContents().get(0);
		private final Group cGroup_7_4 = (Group)cUnorderedGroup_7.eContents().get(4);
		private final Keyword cIssuesKeyword_7_4_0 = (Keyword)cGroup_7_4.eContents().get(0);
		private final Assignment cIssuesAssignment_7_4_1 = (Assignment)cGroup_7_4.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_7_4_1_0 = (RuleCall)cIssuesAssignment_7_4_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//StakeholderGoals:
		//	"stakeholder" "goals" name=QualifiedName (":" title=STRING)? ("for"
		//	(target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ |
		//	global?="all")) ("use" "constants" importConstants+=[GlobalConstants|QualifiedName]+)? "[" (description=Description?
		//	& constants+=ValDeclaration* & content+=Goal* & ("see" "document" docReference+=ExternalDocument+)? & ("issues"
		//	issues+=STRING+)?) "]";
		@Override public ParserRule getRule() { return rule; }

		//"stakeholder" "goals" name=QualifiedName (":" title=STRING)? ("for"
		//(target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ | global?="all"))
		//("use" "constants" importConstants+=[GlobalConstants|QualifiedName]+)? "[" (description=Description? &
		//constants+=ValDeclaration* & content+=Goal* & ("see" "document" docReference+=ExternalDocument+)? & ("issues"
		//issues+=STRING+)?) "]"
		public Group getGroup() { return cGroup; }

		//"stakeholder"
		public Keyword getStakeholderKeyword_0() { return cStakeholderKeyword_0; }

		//"goals"
		public Keyword getGoalsKeyword_1() { return cGoalsKeyword_1; }

		//name=QualifiedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_2_0() { return cNameQualifiedNameParserRuleCall_2_0; }

		//(":" title=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//":"
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//title=STRING
		public Assignment getTitleAssignment_3_1() { return cTitleAssignment_3_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_3_1_0() { return cTitleSTRINGTerminalRuleCall_3_1_0; }

		//"for" (target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ |
		//global?="all")
		public Group getGroup_4() { return cGroup_4; }

		//"for"
		public Keyword getForKeyword_4_0() { return cForKeyword_4_0; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ | global?="all"
		public Alternatives getAlternatives_4_1() { return cAlternatives_4_1; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference]
		public Assignment getTargetAssignment_4_1_0() { return cTargetAssignment_4_1_0; }

		//[aadl2::ComponentClassifier|AadlClassifierReference]
		public CrossReference getTargetComponentClassifierCrossReference_4_1_0_0() { return cTargetComponentClassifierCrossReference_4_1_0_0; }

		//AadlClassifierReference
		public RuleCall getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_4_1_0_0_1() { return cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_4_1_0_0_1; }

		//componentCategory+=ComponentCategory+
		public Assignment getComponentCategoryAssignment_4_1_1() { return cComponentCategoryAssignment_4_1_1; }

		//ComponentCategory
		public RuleCall getComponentCategoryComponentCategoryParserRuleCall_4_1_1_0() { return cComponentCategoryComponentCategoryParserRuleCall_4_1_1_0; }

		//global?="all"
		public Assignment getGlobalAssignment_4_1_2() { return cGlobalAssignment_4_1_2; }

		//"all"
		public Keyword getGlobalAllKeyword_4_1_2_0() { return cGlobalAllKeyword_4_1_2_0; }

		//("use" "constants" importConstants+=[GlobalConstants|QualifiedName]+)?
		public Group getGroup_5() { return cGroup_5; }

		//"use"
		public Keyword getUseKeyword_5_0() { return cUseKeyword_5_0; }

		//"constants"
		public Keyword getConstantsKeyword_5_1() { return cConstantsKeyword_5_1; }

		//importConstants+=[GlobalConstants|QualifiedName]+
		public Assignment getImportConstantsAssignment_5_2() { return cImportConstantsAssignment_5_2; }

		//[GlobalConstants|QualifiedName]
		public CrossReference getImportConstantsGlobalConstantsCrossReference_5_2_0() { return cImportConstantsGlobalConstantsCrossReference_5_2_0; }

		//QualifiedName
		public RuleCall getImportConstantsGlobalConstantsQualifiedNameParserRuleCall_5_2_0_1() { return cImportConstantsGlobalConstantsQualifiedNameParserRuleCall_5_2_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_6() { return cLeftSquareBracketKeyword_6; }

		//description=Description? & constants+=ValDeclaration* & content+=Goal* & ("see" "document"
		//docReference+=ExternalDocument+)? & ("issues" issues+=STRING+)?
		public UnorderedGroup getUnorderedGroup_7() { return cUnorderedGroup_7; }

		//description=Description?
		public Assignment getDescriptionAssignment_7_0() { return cDescriptionAssignment_7_0; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_7_0_0() { return cDescriptionDescriptionParserRuleCall_7_0_0; }

		//constants+=ValDeclaration*
		public Assignment getConstantsAssignment_7_1() { return cConstantsAssignment_7_1; }

		//ValDeclaration
		public RuleCall getConstantsValDeclarationParserRuleCall_7_1_0() { return cConstantsValDeclarationParserRuleCall_7_1_0; }

		//content+=Goal*
		public Assignment getContentAssignment_7_2() { return cContentAssignment_7_2; }

		//Goal
		public RuleCall getContentGoalParserRuleCall_7_2_0() { return cContentGoalParserRuleCall_7_2_0; }

		//("see" "document" docReference+=ExternalDocument+)?
		public Group getGroup_7_3() { return cGroup_7_3; }

		//"see"
		public Keyword getSeeKeyword_7_3_0() { return cSeeKeyword_7_3_0; }

		//"document"
		public Keyword getDocumentKeyword_7_3_1() { return cDocumentKeyword_7_3_1; }

		//docReference+=ExternalDocument+
		public Assignment getDocReferenceAssignment_7_3_2() { return cDocReferenceAssignment_7_3_2; }

		//ExternalDocument
		public RuleCall getDocReferenceExternalDocumentParserRuleCall_7_3_2_0() { return cDocReferenceExternalDocumentParserRuleCall_7_3_2_0; }

		//("issues" issues+=STRING+)?
		public Group getGroup_7_4() { return cGroup_7_4; }

		//"issues"
		public Keyword getIssuesKeyword_7_4_0() { return cIssuesKeyword_7_4_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_7_4_1() { return cIssuesAssignment_7_4_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_7_4_1_0() { return cIssuesSTRINGTerminalRuleCall_7_4_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_8() { return cRightSquareBracketKeyword_8; }
	}

	public class ReqDocumentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ReqDocument");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDocumentKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameQualifiedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTitleAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cTitleAssignment_2_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final UnorderedGroup cUnorderedGroup_4 = (UnorderedGroup)cGroup.eContents().get(4);
		private final Assignment cDescriptionAssignment_4_0 = (Assignment)cUnorderedGroup_4.eContents().get(0);
		private final RuleCall cDescriptionDescriptionParserRuleCall_4_0_0 = (RuleCall)cDescriptionAssignment_4_0.eContents().get(0);
		private final Assignment cContentAssignment_4_1 = (Assignment)cUnorderedGroup_4.eContents().get(1);
		private final Alternatives cContentAlternatives_4_1_0 = (Alternatives)cContentAssignment_4_1.eContents().get(0);
		private final RuleCall cContentDocGoalParserRuleCall_4_1_0_0 = (RuleCall)cContentAlternatives_4_1_0.eContents().get(0);
		private final RuleCall cContentDocRequirementParserRuleCall_4_1_0_1 = (RuleCall)cContentAlternatives_4_1_0.eContents().get(1);
		private final RuleCall cContentDocumentSectionParserRuleCall_4_1_0_2 = (RuleCall)cContentAlternatives_4_1_0.eContents().get(2);
		private final Group cGroup_4_2 = (Group)cUnorderedGroup_4.eContents().get(2);
		private final Keyword cIssuesKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cIssuesAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_4_2_1_0 = (RuleCall)cIssuesAssignment_4_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//ReqDocument:
		//	"document" name=QualifiedName (":" title=STRING)? "[" (description=Description? & content+=(DocGoal | DocRequirement
		//	| DocumentSection)* & ("issues" issues+=STRING+)?) "]";
		@Override public ParserRule getRule() { return rule; }

		//"document" name=QualifiedName (":" title=STRING)? "[" (description=Description? & content+=(DocGoal | DocRequirement |
		//DocumentSection)* & ("issues" issues+=STRING+)?) "]"
		public Group getGroup() { return cGroup; }

		//"document"
		public Keyword getDocumentKeyword_0() { return cDocumentKeyword_0; }

		//name=QualifiedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_1_0() { return cNameQualifiedNameParserRuleCall_1_0; }

		//(":" title=STRING)?
		public Group getGroup_2() { return cGroup_2; }

		//":"
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//title=STRING
		public Assignment getTitleAssignment_2_1() { return cTitleAssignment_2_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_2_1_0() { return cTitleSTRINGTerminalRuleCall_2_1_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//description=Description? & content+=(DocGoal | DocRequirement | DocumentSection)* & ("issues" issues+=STRING+)?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }

		//description=Description?
		public Assignment getDescriptionAssignment_4_0() { return cDescriptionAssignment_4_0; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_4_0_0() { return cDescriptionDescriptionParserRuleCall_4_0_0; }

		//content+=(DocGoal | DocRequirement | DocumentSection)*
		public Assignment getContentAssignment_4_1() { return cContentAssignment_4_1; }

		//DocGoal | DocRequirement | DocumentSection
		public Alternatives getContentAlternatives_4_1_0() { return cContentAlternatives_4_1_0; }

		//DocGoal
		public RuleCall getContentDocGoalParserRuleCall_4_1_0_0() { return cContentDocGoalParserRuleCall_4_1_0_0; }

		//DocRequirement
		public RuleCall getContentDocRequirementParserRuleCall_4_1_0_1() { return cContentDocRequirementParserRuleCall_4_1_0_1; }

		//DocumentSection
		public RuleCall getContentDocumentSectionParserRuleCall_4_1_0_2() { return cContentDocumentSectionParserRuleCall_4_1_0_2; }

		//("issues" issues+=STRING+)?
		public Group getGroup_4_2() { return cGroup_4_2; }

		//"issues"
		public Keyword getIssuesKeyword_4_2_0() { return cIssuesKeyword_4_2_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_4_2_1() { return cIssuesAssignment_4_2_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_4_2_1_0() { return cIssuesSTRINGTerminalRuleCall_4_2_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class DocumentSectionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DocumentSection");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSectionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cLabelAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cLabelIDTerminalRuleCall_1_0 = (RuleCall)cLabelAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTitleAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cTitleAssignment_2_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final UnorderedGroup cUnorderedGroup_4 = (UnorderedGroup)cGroup.eContents().get(4);
		private final Assignment cDescriptionAssignment_4_0 = (Assignment)cUnorderedGroup_4.eContents().get(0);
		private final RuleCall cDescriptionDescriptionParserRuleCall_4_0_0 = (RuleCall)cDescriptionAssignment_4_0.eContents().get(0);
		private final Assignment cContentAssignment_4_1 = (Assignment)cUnorderedGroup_4.eContents().get(1);
		private final Alternatives cContentAlternatives_4_1_0 = (Alternatives)cContentAssignment_4_1.eContents().get(0);
		private final RuleCall cContentDocGoalParserRuleCall_4_1_0_0 = (RuleCall)cContentAlternatives_4_1_0.eContents().get(0);
		private final RuleCall cContentDocRequirementParserRuleCall_4_1_0_1 = (RuleCall)cContentAlternatives_4_1_0.eContents().get(1);
		private final RuleCall cContentDocumentSectionParserRuleCall_4_1_0_2 = (RuleCall)cContentAlternatives_4_1_0.eContents().get(2);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//DocumentSection:
		//	"section" label=ID (":" title=STRING)? "[" (description=Description? & content+=(DocGoal | DocRequirement |
		//	DocumentSection)*) "]";
		@Override public ParserRule getRule() { return rule; }

		//"section" label=ID (":" title=STRING)? "[" (description=Description? & content+=(DocGoal | DocRequirement |
		//DocumentSection)*) "]"
		public Group getGroup() { return cGroup; }

		//"section"
		public Keyword getSectionKeyword_0() { return cSectionKeyword_0; }

		//label=ID
		public Assignment getLabelAssignment_1() { return cLabelAssignment_1; }

		//ID
		public RuleCall getLabelIDTerminalRuleCall_1_0() { return cLabelIDTerminalRuleCall_1_0; }

		//(":" title=STRING)?
		public Group getGroup_2() { return cGroup_2; }

		//":"
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//title=STRING
		public Assignment getTitleAssignment_2_1() { return cTitleAssignment_2_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_2_1_0() { return cTitleSTRINGTerminalRuleCall_2_1_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//description=Description? & content+=(DocGoal | DocRequirement | DocumentSection)*
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }

		//description=Description?
		public Assignment getDescriptionAssignment_4_0() { return cDescriptionAssignment_4_0; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_4_0_0() { return cDescriptionDescriptionParserRuleCall_4_0_0; }

		//content+=(DocGoal | DocRequirement | DocumentSection)*
		public Assignment getContentAssignment_4_1() { return cContentAssignment_4_1; }

		//DocGoal | DocRequirement | DocumentSection
		public Alternatives getContentAlternatives_4_1_0() { return cContentAlternatives_4_1_0; }

		//DocGoal
		public RuleCall getContentDocGoalParserRuleCall_4_1_0_0() { return cContentDocGoalParserRuleCall_4_1_0_0; }

		//DocRequirement
		public RuleCall getContentDocRequirementParserRuleCall_4_1_0_1() { return cContentDocRequirementParserRuleCall_4_1_0_1; }

		//DocumentSection
		public RuleCall getContentDocumentSectionParserRuleCall_4_1_0_2() { return cContentDocumentSectionParserRuleCall_4_1_0_2; }

		//"]"
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class SystemRequirementsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SystemRequirements");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSystemKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cRequirementsKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameQualifiedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTitleAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cTitleAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cForKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Alternatives cAlternatives_4_1 = (Alternatives)cGroup_4.eContents().get(1);
		private final Assignment cTargetAssignment_4_1_0 = (Assignment)cAlternatives_4_1.eContents().get(0);
		private final CrossReference cTargetComponentClassifierCrossReference_4_1_0_0 = (CrossReference)cTargetAssignment_4_1_0.eContents().get(0);
		private final RuleCall cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_4_1_0_0_1 = (RuleCall)cTargetComponentClassifierCrossReference_4_1_0_0.eContents().get(1);
		private final Assignment cComponentCategoryAssignment_4_1_1 = (Assignment)cAlternatives_4_1.eContents().get(1);
		private final RuleCall cComponentCategoryComponentCategoryParserRuleCall_4_1_1_0 = (RuleCall)cComponentCategoryAssignment_4_1_1.eContents().get(0);
		private final Assignment cGlobalAssignment_4_1_2 = (Assignment)cAlternatives_4_1.eContents().get(2);
		private final Keyword cGlobalAllKeyword_4_1_2_0 = (Keyword)cGlobalAssignment_4_1_2.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cUseKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cConstantsKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cImportConstantsAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final CrossReference cImportConstantsGlobalConstantsCrossReference_5_2_0 = (CrossReference)cImportConstantsAssignment_5_2.eContents().get(0);
		private final RuleCall cImportConstantsGlobalConstantsQualifiedNameParserRuleCall_5_2_0_1 = (RuleCall)cImportConstantsGlobalConstantsCrossReference_5_2_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final UnorderedGroup cUnorderedGroup_7 = (UnorderedGroup)cGroup.eContents().get(7);
		private final Assignment cDescriptionAssignment_7_0 = (Assignment)cUnorderedGroup_7.eContents().get(0);
		private final RuleCall cDescriptionDescriptionParserRuleCall_7_0_0 = (RuleCall)cDescriptionAssignment_7_0.eContents().get(0);
		private final Assignment cConstantsAssignment_7_1 = (Assignment)cUnorderedGroup_7.eContents().get(1);
		private final RuleCall cConstantsValDeclarationParserRuleCall_7_1_0 = (RuleCall)cConstantsAssignment_7_1.eContents().get(0);
		private final Assignment cComputesAssignment_7_2 = (Assignment)cUnorderedGroup_7.eContents().get(2);
		private final RuleCall cComputesComputeDeclarationParserRuleCall_7_2_0 = (RuleCall)cComputesAssignment_7_2.eContents().get(0);
		private final Assignment cContentAssignment_7_3 = (Assignment)cUnorderedGroup_7.eContents().get(3);
		private final RuleCall cContentRequirementParserRuleCall_7_3_0 = (RuleCall)cContentAssignment_7_3.eContents().get(0);
		private final Group cGroup_7_4 = (Group)cUnorderedGroup_7.eContents().get(4);
		private final Keyword cSeeKeyword_7_4_0 = (Keyword)cGroup_7_4.eContents().get(0);
		private final Keyword cDocumentKeyword_7_4_1 = (Keyword)cGroup_7_4.eContents().get(1);
		private final Assignment cDocReferenceAssignment_7_4_2 = (Assignment)cGroup_7_4.eContents().get(2);
		private final RuleCall cDocReferenceExternalDocumentParserRuleCall_7_4_2_0 = (RuleCall)cDocReferenceAssignment_7_4_2.eContents().get(0);
		private final Group cGroup_7_5 = (Group)cUnorderedGroup_7.eContents().get(5);
		private final Keyword cIssuesKeyword_7_5_0 = (Keyword)cGroup_7_5.eContents().get(0);
		private final Assignment cIssuesAssignment_7_5_1 = (Assignment)cGroup_7_5.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_7_5_1_0 = (RuleCall)cIssuesAssignment_7_5_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//SystemRequirements:
		//	"system" "requirements" name=QualifiedName (":" title=STRING)? ("for"
		//	(target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ |
		//	global?="all")) ("use" "constants" importConstants+=[GlobalConstants|QualifiedName]+)? "[" (description=Description?
		//	& constants+=ValDeclaration* & computes+=ComputeDeclaration* & content+=Requirement* & ("see" "document"
		//	docReference+=ExternalDocument+)? & ("issues" issues+=STRING+)?) "]";
		@Override public ParserRule getRule() { return rule; }

		//"system" "requirements" name=QualifiedName (":" title=STRING)? ("for"
		//(target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ | global?="all"))
		//("use" "constants" importConstants+=[GlobalConstants|QualifiedName]+)? "[" (description=Description? &
		//constants+=ValDeclaration* & computes+=ComputeDeclaration* & content+=Requirement* & ("see" "document"
		//docReference+=ExternalDocument+)? & ("issues" issues+=STRING+)?) "]"
		public Group getGroup() { return cGroup; }

		//"system"
		public Keyword getSystemKeyword_0() { return cSystemKeyword_0; }

		//"requirements"
		public Keyword getRequirementsKeyword_1() { return cRequirementsKeyword_1; }

		//name=QualifiedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_2_0() { return cNameQualifiedNameParserRuleCall_2_0; }

		//(":" title=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//":"
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//title=STRING
		public Assignment getTitleAssignment_3_1() { return cTitleAssignment_3_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_3_1_0() { return cTitleSTRINGTerminalRuleCall_3_1_0; }

		//"for" (target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ |
		//global?="all")
		public Group getGroup_4() { return cGroup_4; }

		//"for"
		public Keyword getForKeyword_4_0() { return cForKeyword_4_0; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ | global?="all"
		public Alternatives getAlternatives_4_1() { return cAlternatives_4_1; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference]
		public Assignment getTargetAssignment_4_1_0() { return cTargetAssignment_4_1_0; }

		//[aadl2::ComponentClassifier|AadlClassifierReference]
		public CrossReference getTargetComponentClassifierCrossReference_4_1_0_0() { return cTargetComponentClassifierCrossReference_4_1_0_0; }

		//AadlClassifierReference
		public RuleCall getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_4_1_0_0_1() { return cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_4_1_0_0_1; }

		//componentCategory+=ComponentCategory+
		public Assignment getComponentCategoryAssignment_4_1_1() { return cComponentCategoryAssignment_4_1_1; }

		//ComponentCategory
		public RuleCall getComponentCategoryComponentCategoryParserRuleCall_4_1_1_0() { return cComponentCategoryComponentCategoryParserRuleCall_4_1_1_0; }

		//global?="all"
		public Assignment getGlobalAssignment_4_1_2() { return cGlobalAssignment_4_1_2; }

		//"all"
		public Keyword getGlobalAllKeyword_4_1_2_0() { return cGlobalAllKeyword_4_1_2_0; }

		//("use" "constants" importConstants+=[GlobalConstants|QualifiedName]+)?
		public Group getGroup_5() { return cGroup_5; }

		//"use"
		public Keyword getUseKeyword_5_0() { return cUseKeyword_5_0; }

		//"constants"
		public Keyword getConstantsKeyword_5_1() { return cConstantsKeyword_5_1; }

		//importConstants+=[GlobalConstants|QualifiedName]+
		public Assignment getImportConstantsAssignment_5_2() { return cImportConstantsAssignment_5_2; }

		//[GlobalConstants|QualifiedName]
		public CrossReference getImportConstantsGlobalConstantsCrossReference_5_2_0() { return cImportConstantsGlobalConstantsCrossReference_5_2_0; }

		//QualifiedName
		public RuleCall getImportConstantsGlobalConstantsQualifiedNameParserRuleCall_5_2_0_1() { return cImportConstantsGlobalConstantsQualifiedNameParserRuleCall_5_2_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_6() { return cLeftSquareBracketKeyword_6; }

		//description=Description? & constants+=ValDeclaration* & computes+=ComputeDeclaration* & content+=Requirement* & ("see"
		//"document" docReference+=ExternalDocument+)? & ("issues" issues+=STRING+)?
		public UnorderedGroup getUnorderedGroup_7() { return cUnorderedGroup_7; }

		//description=Description?
		public Assignment getDescriptionAssignment_7_0() { return cDescriptionAssignment_7_0; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_7_0_0() { return cDescriptionDescriptionParserRuleCall_7_0_0; }

		//constants+=ValDeclaration*
		public Assignment getConstantsAssignment_7_1() { return cConstantsAssignment_7_1; }

		//ValDeclaration
		public RuleCall getConstantsValDeclarationParserRuleCall_7_1_0() { return cConstantsValDeclarationParserRuleCall_7_1_0; }

		//computes+=ComputeDeclaration*
		public Assignment getComputesAssignment_7_2() { return cComputesAssignment_7_2; }

		//ComputeDeclaration
		public RuleCall getComputesComputeDeclarationParserRuleCall_7_2_0() { return cComputesComputeDeclarationParserRuleCall_7_2_0; }

		//content+=Requirement*
		public Assignment getContentAssignment_7_3() { return cContentAssignment_7_3; }

		//Requirement
		public RuleCall getContentRequirementParserRuleCall_7_3_0() { return cContentRequirementParserRuleCall_7_3_0; }

		//("see" "document" docReference+=ExternalDocument+)?
		public Group getGroup_7_4() { return cGroup_7_4; }

		//"see"
		public Keyword getSeeKeyword_7_4_0() { return cSeeKeyword_7_4_0; }

		//"document"
		public Keyword getDocumentKeyword_7_4_1() { return cDocumentKeyword_7_4_1; }

		//docReference+=ExternalDocument+
		public Assignment getDocReferenceAssignment_7_4_2() { return cDocReferenceAssignment_7_4_2; }

		//ExternalDocument
		public RuleCall getDocReferenceExternalDocumentParserRuleCall_7_4_2_0() { return cDocReferenceExternalDocumentParserRuleCall_7_4_2_0; }

		//("issues" issues+=STRING+)?
		public Group getGroup_7_5() { return cGroup_7_5; }

		//"issues"
		public Keyword getIssuesKeyword_7_5_0() { return cIssuesKeyword_7_5_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_7_5_1() { return cIssuesAssignment_7_5_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_7_5_1_0() { return cIssuesSTRINGTerminalRuleCall_7_5_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_8() { return cRightSquareBracketKeyword_8; }
	}

	public class DocGoalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DocGoal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cGoalKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTitleAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cTitleAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cForKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Alternatives cAlternatives_3_1 = (Alternatives)cGroup_3.eContents().get(1);
		private final Assignment cTargetDescriptionAssignment_3_1_0 = (Assignment)cAlternatives_3_1.eContents().get(0);
		private final RuleCall cTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0 = (RuleCall)cTargetDescriptionAssignment_3_1_0.eContents().get(0);
		private final Group cGroup_3_1_1 = (Group)cAlternatives_3_1.eContents().get(1);
		private final Assignment cTargetAssignment_3_1_1_0 = (Assignment)cGroup_3_1_1.eContents().get(0);
		private final CrossReference cTargetComponentClassifierCrossReference_3_1_1_0_0 = (CrossReference)cTargetAssignment_3_1_1_0.eContents().get(0);
		private final RuleCall cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_1_0_0_1 = (RuleCall)cTargetComponentClassifierCrossReference_3_1_1_0_0.eContents().get(1);
		private final Assignment cTargetElementAssignment_3_1_1_1 = (Assignment)cGroup_3_1_1.eContents().get(1);
		private final CrossReference cTargetElementNamedElementCrossReference_3_1_1_1_0 = (CrossReference)cTargetElementAssignment_3_1_1_1.eContents().get(0);
		private final RuleCall cTargetElementNamedElementIDTerminalRuleCall_3_1_1_1_0_1 = (RuleCall)cTargetElementNamedElementCrossReference_3_1_1_1_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final UnorderedGroup cUnorderedGroup_5 = (UnorderedGroup)cGroup.eContents().get(5);
		private final Group cGroup_5_0 = (Group)cUnorderedGroup_5.eContents().get(0);
		private final Keyword cCategoryKeyword_5_0_0 = (Keyword)cGroup_5_0.eContents().get(0);
		private final Assignment cCategoryAssignment_5_0_1 = (Assignment)cGroup_5_0.eContents().get(1);
		private final CrossReference cCategoryCategoryCrossReference_5_0_1_0 = (CrossReference)cCategoryAssignment_5_0_1.eContents().get(0);
		private final RuleCall cCategoryCategoryIDTerminalRuleCall_5_0_1_0_1 = (RuleCall)cCategoryCategoryCrossReference_5_0_1_0.eContents().get(1);
		private final Assignment cDescriptionAssignment_5_1 = (Assignment)cUnorderedGroup_5.eContents().get(1);
		private final RuleCall cDescriptionDescriptionParserRuleCall_5_1_0 = (RuleCall)cDescriptionAssignment_5_1.eContents().get(0);
		private final Assignment cConstantsAssignment_5_2 = (Assignment)cUnorderedGroup_5.eContents().get(2);
		private final RuleCall cConstantsValDeclarationParserRuleCall_5_2_0 = (RuleCall)cConstantsAssignment_5_2.eContents().get(0);
		private final Assignment cRationaleAssignment_5_3 = (Assignment)cUnorderedGroup_5.eContents().get(3);
		private final RuleCall cRationaleRationaleParserRuleCall_5_3_0 = (RuleCall)cRationaleAssignment_5_3.eContents().get(0);
		private final Assignment cChangeUncertaintyAssignment_5_4 = (Assignment)cUnorderedGroup_5.eContents().get(4);
		private final RuleCall cChangeUncertaintyUncertaintyParserRuleCall_5_4_0 = (RuleCall)cChangeUncertaintyAssignment_5_4.eContents().get(0);
		private final Group cGroup_5_5 = (Group)cUnorderedGroup_5.eContents().get(5);
		private final Keyword cRefinesKeyword_5_5_0 = (Keyword)cGroup_5_5.eContents().get(0);
		private final Assignment cRefinesReferenceAssignment_5_5_1 = (Assignment)cGroup_5_5.eContents().get(1);
		private final CrossReference cRefinesReferenceGoalCrossReference_5_5_1_0 = (CrossReference)cRefinesReferenceAssignment_5_5_1.eContents().get(0);
		private final RuleCall cRefinesReferenceGoalQualifiedNameParserRuleCall_5_5_1_0_1 = (RuleCall)cRefinesReferenceGoalCrossReference_5_5_1_0.eContents().get(1);
		private final Group cGroup_5_6 = (Group)cUnorderedGroup_5.eContents().get(6);
		private final Keyword cConflictsKeyword_5_6_0 = (Keyword)cGroup_5_6.eContents().get(0);
		private final Keyword cWithKeyword_5_6_1 = (Keyword)cGroup_5_6.eContents().get(1);
		private final Assignment cConflictsReferenceAssignment_5_6_2 = (Assignment)cGroup_5_6.eContents().get(2);
		private final CrossReference cConflictsReferenceGoalCrossReference_5_6_2_0 = (CrossReference)cConflictsReferenceAssignment_5_6_2.eContents().get(0);
		private final RuleCall cConflictsReferenceGoalQualifiedNameParserRuleCall_5_6_2_0_1 = (RuleCall)cConflictsReferenceGoalCrossReference_5_6_2_0.eContents().get(1);
		private final Group cGroup_5_7 = (Group)cUnorderedGroup_5.eContents().get(7);
		private final Keyword cEvolvesKeyword_5_7_0 = (Keyword)cGroup_5_7.eContents().get(0);
		private final Assignment cEvolvesReferenceAssignment_5_7_1 = (Assignment)cGroup_5_7.eContents().get(1);
		private final CrossReference cEvolvesReferenceRequirementCrossReference_5_7_1_0 = (CrossReference)cEvolvesReferenceAssignment_5_7_1.eContents().get(0);
		private final RuleCall cEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_7_1_0_1 = (RuleCall)cEvolvesReferenceRequirementCrossReference_5_7_1_0.eContents().get(1);
		private final Group cGroup_5_8 = (Group)cUnorderedGroup_5.eContents().get(8);
		private final Assignment cDroppedAssignment_5_8_0 = (Assignment)cGroup_5_8.eContents().get(0);
		private final Keyword cDroppedDroppedKeyword_5_8_0_0 = (Keyword)cDroppedAssignment_5_8_0.eContents().get(0);
		private final Assignment cDropRationaleAssignment_5_8_1 = (Assignment)cGroup_5_8.eContents().get(1);
		private final RuleCall cDropRationaleSTRINGTerminalRuleCall_5_8_1_0 = (RuleCall)cDropRationaleAssignment_5_8_1.eContents().get(0);
		private final Group cGroup_5_9 = (Group)cUnorderedGroup_5.eContents().get(9);
		private final Keyword cStakeholderKeyword_5_9_0 = (Keyword)cGroup_5_9.eContents().get(0);
		private final Assignment cStakeholderReferenceAssignment_5_9_1 = (Assignment)cGroup_5_9.eContents().get(1);
		private final CrossReference cStakeholderReferenceStakeholderCrossReference_5_9_1_0 = (CrossReference)cStakeholderReferenceAssignment_5_9_1.eContents().get(0);
		private final RuleCall cStakeholderReferenceStakeholderQualifiedNameParserRuleCall_5_9_1_0_1 = (RuleCall)cStakeholderReferenceStakeholderCrossReference_5_9_1_0.eContents().get(1);
		private final Group cGroup_5_10 = (Group)cUnorderedGroup_5.eContents().get(10);
		private final Keyword cSeeKeyword_5_10_0 = (Keyword)cGroup_5_10.eContents().get(0);
		private final Keyword cDocumentKeyword_5_10_1 = (Keyword)cGroup_5_10.eContents().get(1);
		private final Keyword cRequirementKeyword_5_10_2 = (Keyword)cGroup_5_10.eContents().get(2);
		private final Assignment cDocumentRequirementAssignment_5_10_3 = (Assignment)cGroup_5_10.eContents().get(3);
		private final CrossReference cDocumentRequirementContractualElementCrossReference_5_10_3_0 = (CrossReference)cDocumentRequirementAssignment_5_10_3.eContents().get(0);
		private final RuleCall cDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_10_3_0_1 = (RuleCall)cDocumentRequirementContractualElementCrossReference_5_10_3_0.eContents().get(1);
		private final Group cGroup_5_11 = (Group)cUnorderedGroup_5.eContents().get(11);
		private final Keyword cSeeKeyword_5_11_0 = (Keyword)cGroup_5_11.eContents().get(0);
		private final Keyword cDocumentKeyword_5_11_1 = (Keyword)cGroup_5_11.eContents().get(1);
		private final Assignment cDocReferenceAssignment_5_11_2 = (Assignment)cGroup_5_11.eContents().get(2);
		private final RuleCall cDocReferenceExternalDocumentParserRuleCall_5_11_2_0 = (RuleCall)cDocReferenceAssignment_5_11_2.eContents().get(0);
		private final Group cGroup_5_12 = (Group)cUnorderedGroup_5.eContents().get(12);
		private final Keyword cIssuesKeyword_5_12_0 = (Keyword)cGroup_5_12.eContents().get(0);
		private final Assignment cIssuesAssignment_5_12_1 = (Assignment)cGroup_5_12.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_5_12_1_0 = (RuleCall)cIssuesAssignment_5_12_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//DocGoal returns Goal:
		//	"goal" name=ID (":" title=STRING)? // short string for title
		//	("for" (targetDescription=STRING | target=[aadl2::ComponentClassifier|AadlClassifierReference]
		//	targetElement=[aadl2::NamedElement]?))? "[" (("category" category+=[categories::Category]+)? &
		//	description=Description? & constants+=ValDeclaration* & rationale=Rationale? & changeUncertainty=Uncertainty? &
		//	("refines" refinesReference+=[Goal|QualifiedName]+)? & ("conflicts" "with"
		//	conflictsReference+=[Goal|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
		//	(dropped?="dropped" dropRationale=STRING?)? & ("stakeholder"
		//	stakeholderReference+=[org::Stakeholder|QualifiedName]+)? & ("see" "document" "requirement"
		//	documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//	("issues" issues+=STRING+)?) "]";
		@Override public ParserRule getRule() { return rule; }

		//"goal" name=ID (":" title=STRING)? // short string for title
		//("for" (targetDescription=STRING | target=[aadl2::ComponentClassifier|AadlClassifierReference]
		//targetElement=[aadl2::NamedElement]?))? "[" (("category" category+=[categories::Category]+)? &
		//description=Description? & constants+=ValDeclaration* & rationale=Rationale? & changeUncertainty=Uncertainty? &
		//("refines" refinesReference+=[Goal|QualifiedName]+)? & ("conflicts" "with" conflictsReference+=[Goal|QualifiedName]+)?
		//& ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? & (dropped?="dropped" dropRationale=STRING?)? &
		//("stakeholder" stakeholderReference+=[org::Stakeholder|QualifiedName]+)? & ("see" "document" "requirement"
		//documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//("issues" issues+=STRING+)?) "]"
		public Group getGroup() { return cGroup; }

		//"goal"
		public Keyword getGoalKeyword_0() { return cGoalKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//(":" title=STRING)?
		public Group getGroup_2() { return cGroup_2; }

		//":"
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//title=STRING
		public Assignment getTitleAssignment_2_1() { return cTitleAssignment_2_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_2_1_0() { return cTitleSTRINGTerminalRuleCall_2_1_0; }

		//("for" (targetDescription=STRING | target=[aadl2::ComponentClassifier|AadlClassifierReference]
		//targetElement=[aadl2::NamedElement]?))?
		public Group getGroup_3() { return cGroup_3; }

		//"for"
		public Keyword getForKeyword_3_0() { return cForKeyword_3_0; }

		//targetDescription=STRING | target=[aadl2::ComponentClassifier|AadlClassifierReference]
		//targetElement=[aadl2::NamedElement]?
		public Alternatives getAlternatives_3_1() { return cAlternatives_3_1; }

		//targetDescription=STRING
		public Assignment getTargetDescriptionAssignment_3_1_0() { return cTargetDescriptionAssignment_3_1_0; }

		//STRING
		public RuleCall getTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0() { return cTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference] targetElement=[aadl2::NamedElement]?
		public Group getGroup_3_1_1() { return cGroup_3_1_1; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference]
		public Assignment getTargetAssignment_3_1_1_0() { return cTargetAssignment_3_1_1_0; }

		//[aadl2::ComponentClassifier|AadlClassifierReference]
		public CrossReference getTargetComponentClassifierCrossReference_3_1_1_0_0() { return cTargetComponentClassifierCrossReference_3_1_1_0_0; }

		//AadlClassifierReference
		public RuleCall getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_1_0_0_1() { return cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_1_0_0_1; }

		//targetElement=[aadl2::NamedElement]?
		public Assignment getTargetElementAssignment_3_1_1_1() { return cTargetElementAssignment_3_1_1_1; }

		//[aadl2::NamedElement]
		public CrossReference getTargetElementNamedElementCrossReference_3_1_1_1_0() { return cTargetElementNamedElementCrossReference_3_1_1_1_0; }

		//ID
		public RuleCall getTargetElementNamedElementIDTerminalRuleCall_3_1_1_1_0_1() { return cTargetElementNamedElementIDTerminalRuleCall_3_1_1_1_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//("category" category+=[categories::Category]+)? & description=Description? & constants+=ValDeclaration* &
		//rationale=Rationale? & changeUncertainty=Uncertainty? & ("refines" refinesReference+=[Goal|QualifiedName]+)? &
		//("conflicts" "with" conflictsReference+=[Goal|QualifiedName]+)? & ("evolves"
		//evolvesReference+=[Requirement|QualifiedName]+)? & (dropped?="dropped" dropRationale=STRING?)? & ("stakeholder"
		//stakeholderReference+=[org::Stakeholder|QualifiedName]+)? & ("see" "document" "requirement"
		//documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//("issues" issues+=STRING+)?
		public UnorderedGroup getUnorderedGroup_5() { return cUnorderedGroup_5; }

		//("category" category+=[categories::Category]+)?
		public Group getGroup_5_0() { return cGroup_5_0; }

		//"category"
		public Keyword getCategoryKeyword_5_0_0() { return cCategoryKeyword_5_0_0; }

		//category+=[categories::Category]+
		public Assignment getCategoryAssignment_5_0_1() { return cCategoryAssignment_5_0_1; }

		//[categories::Category]
		public CrossReference getCategoryCategoryCrossReference_5_0_1_0() { return cCategoryCategoryCrossReference_5_0_1_0; }

		//ID
		public RuleCall getCategoryCategoryIDTerminalRuleCall_5_0_1_0_1() { return cCategoryCategoryIDTerminalRuleCall_5_0_1_0_1; }

		//description=Description?
		public Assignment getDescriptionAssignment_5_1() { return cDescriptionAssignment_5_1; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_5_1_0() { return cDescriptionDescriptionParserRuleCall_5_1_0; }

		//constants+=ValDeclaration*
		public Assignment getConstantsAssignment_5_2() { return cConstantsAssignment_5_2; }

		//ValDeclaration
		public RuleCall getConstantsValDeclarationParserRuleCall_5_2_0() { return cConstantsValDeclarationParserRuleCall_5_2_0; }

		//rationale=Rationale?
		public Assignment getRationaleAssignment_5_3() { return cRationaleAssignment_5_3; }

		//Rationale
		public RuleCall getRationaleRationaleParserRuleCall_5_3_0() { return cRationaleRationaleParserRuleCall_5_3_0; }

		//changeUncertainty=Uncertainty?
		public Assignment getChangeUncertaintyAssignment_5_4() { return cChangeUncertaintyAssignment_5_4; }

		//Uncertainty
		public RuleCall getChangeUncertaintyUncertaintyParserRuleCall_5_4_0() { return cChangeUncertaintyUncertaintyParserRuleCall_5_4_0; }

		//("refines" refinesReference+=[Goal|QualifiedName]+)?
		public Group getGroup_5_5() { return cGroup_5_5; }

		//"refines"
		public Keyword getRefinesKeyword_5_5_0() { return cRefinesKeyword_5_5_0; }

		//refinesReference+=[Goal|QualifiedName]+
		public Assignment getRefinesReferenceAssignment_5_5_1() { return cRefinesReferenceAssignment_5_5_1; }

		//[Goal|QualifiedName]
		public CrossReference getRefinesReferenceGoalCrossReference_5_5_1_0() { return cRefinesReferenceGoalCrossReference_5_5_1_0; }

		//QualifiedName
		public RuleCall getRefinesReferenceGoalQualifiedNameParserRuleCall_5_5_1_0_1() { return cRefinesReferenceGoalQualifiedNameParserRuleCall_5_5_1_0_1; }

		//("conflicts" "with" conflictsReference+=[Goal|QualifiedName]+)?
		public Group getGroup_5_6() { return cGroup_5_6; }

		//"conflicts"
		public Keyword getConflictsKeyword_5_6_0() { return cConflictsKeyword_5_6_0; }

		//"with"
		public Keyword getWithKeyword_5_6_1() { return cWithKeyword_5_6_1; }

		//conflictsReference+=[Goal|QualifiedName]+
		public Assignment getConflictsReferenceAssignment_5_6_2() { return cConflictsReferenceAssignment_5_6_2; }

		//[Goal|QualifiedName]
		public CrossReference getConflictsReferenceGoalCrossReference_5_6_2_0() { return cConflictsReferenceGoalCrossReference_5_6_2_0; }

		//QualifiedName
		public RuleCall getConflictsReferenceGoalQualifiedNameParserRuleCall_5_6_2_0_1() { return cConflictsReferenceGoalQualifiedNameParserRuleCall_5_6_2_0_1; }

		//("evolves" evolvesReference+=[Requirement|QualifiedName]+)?
		public Group getGroup_5_7() { return cGroup_5_7; }

		//"evolves"
		public Keyword getEvolvesKeyword_5_7_0() { return cEvolvesKeyword_5_7_0; }

		//evolvesReference+=[Requirement|QualifiedName]+
		public Assignment getEvolvesReferenceAssignment_5_7_1() { return cEvolvesReferenceAssignment_5_7_1; }

		//[Requirement|QualifiedName]
		public CrossReference getEvolvesReferenceRequirementCrossReference_5_7_1_0() { return cEvolvesReferenceRequirementCrossReference_5_7_1_0; }

		//QualifiedName
		public RuleCall getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_7_1_0_1() { return cEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_7_1_0_1; }

		//(dropped?="dropped" dropRationale=STRING?)?
		public Group getGroup_5_8() { return cGroup_5_8; }

		//dropped?="dropped"
		public Assignment getDroppedAssignment_5_8_0() { return cDroppedAssignment_5_8_0; }

		//"dropped"
		public Keyword getDroppedDroppedKeyword_5_8_0_0() { return cDroppedDroppedKeyword_5_8_0_0; }

		//dropRationale=STRING?
		public Assignment getDropRationaleAssignment_5_8_1() { return cDropRationaleAssignment_5_8_1; }

		//STRING
		public RuleCall getDropRationaleSTRINGTerminalRuleCall_5_8_1_0() { return cDropRationaleSTRINGTerminalRuleCall_5_8_1_0; }

		//("stakeholder" stakeholderReference+=[org::Stakeholder|QualifiedName]+)?
		public Group getGroup_5_9() { return cGroup_5_9; }

		//"stakeholder"
		public Keyword getStakeholderKeyword_5_9_0() { return cStakeholderKeyword_5_9_0; }

		//stakeholderReference+=[org::Stakeholder|QualifiedName]+
		public Assignment getStakeholderReferenceAssignment_5_9_1() { return cStakeholderReferenceAssignment_5_9_1; }

		//[org::Stakeholder|QualifiedName]
		public CrossReference getStakeholderReferenceStakeholderCrossReference_5_9_1_0() { return cStakeholderReferenceStakeholderCrossReference_5_9_1_0; }

		//QualifiedName
		public RuleCall getStakeholderReferenceStakeholderQualifiedNameParserRuleCall_5_9_1_0_1() { return cStakeholderReferenceStakeholderQualifiedNameParserRuleCall_5_9_1_0_1; }

		//("see" "document" "requirement" documentRequirement+=[ContractualElement|QualifiedName]+)?
		public Group getGroup_5_10() { return cGroup_5_10; }

		//"see"
		public Keyword getSeeKeyword_5_10_0() { return cSeeKeyword_5_10_0; }

		//"document"
		public Keyword getDocumentKeyword_5_10_1() { return cDocumentKeyword_5_10_1; }

		//"requirement"
		public Keyword getRequirementKeyword_5_10_2() { return cRequirementKeyword_5_10_2; }

		//documentRequirement+=[ContractualElement|QualifiedName]+
		public Assignment getDocumentRequirementAssignment_5_10_3() { return cDocumentRequirementAssignment_5_10_3; }

		//[ContractualElement|QualifiedName]
		public CrossReference getDocumentRequirementContractualElementCrossReference_5_10_3_0() { return cDocumentRequirementContractualElementCrossReference_5_10_3_0; }

		//QualifiedName
		public RuleCall getDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_10_3_0_1() { return cDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_10_3_0_1; }

		//("see" "document" docReference+=ExternalDocument+)?
		public Group getGroup_5_11() { return cGroup_5_11; }

		//"see"
		public Keyword getSeeKeyword_5_11_0() { return cSeeKeyword_5_11_0; }

		//"document"
		public Keyword getDocumentKeyword_5_11_1() { return cDocumentKeyword_5_11_1; }

		//docReference+=ExternalDocument+
		public Assignment getDocReferenceAssignment_5_11_2() { return cDocReferenceAssignment_5_11_2; }

		//ExternalDocument
		public RuleCall getDocReferenceExternalDocumentParserRuleCall_5_11_2_0() { return cDocReferenceExternalDocumentParserRuleCall_5_11_2_0; }

		//("issues" issues+=STRING+)?
		public Group getGroup_5_12() { return cGroup_5_12; }

		//"issues"
		public Keyword getIssuesKeyword_5_12_0() { return cIssuesKeyword_5_12_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_5_12_1() { return cIssuesAssignment_5_12_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_5_12_1_0() { return cIssuesSTRINGTerminalRuleCall_5_12_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class GoalElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Goal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cGoalKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTitleAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cTitleAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cForKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTargetElementAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cTargetElementNamedElementCrossReference_3_1_0 = (CrossReference)cTargetElementAssignment_3_1.eContents().get(0);
		private final RuleCall cTargetElementNamedElementIDTerminalRuleCall_3_1_0_1 = (RuleCall)cTargetElementNamedElementCrossReference_3_1_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final UnorderedGroup cUnorderedGroup_5 = (UnorderedGroup)cGroup.eContents().get(5);
		private final Group cGroup_5_0 = (Group)cUnorderedGroup_5.eContents().get(0);
		private final Keyword cCategoryKeyword_5_0_0 = (Keyword)cGroup_5_0.eContents().get(0);
		private final Assignment cCategoryAssignment_5_0_1 = (Assignment)cGroup_5_0.eContents().get(1);
		private final CrossReference cCategoryRequirementCategoryCrossReference_5_0_1_0 = (CrossReference)cCategoryAssignment_5_0_1.eContents().get(0);
		private final RuleCall cCategoryRequirementCategoryIDTerminalRuleCall_5_0_1_0_1 = (RuleCall)cCategoryRequirementCategoryCrossReference_5_0_1_0.eContents().get(1);
		private final Group cGroup_5_1 = (Group)cUnorderedGroup_5.eContents().get(1);
		private final Keyword cQualityKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cCategoryAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final CrossReference cCategoryQualityCategoryCrossReference_5_1_1_0 = (CrossReference)cCategoryAssignment_5_1_1.eContents().get(0);
		private final RuleCall cCategoryQualityCategoryIDTerminalRuleCall_5_1_1_0_1 = (RuleCall)cCategoryQualityCategoryCrossReference_5_1_1_0.eContents().get(1);
		private final Group cGroup_5_2 = (Group)cUnorderedGroup_5.eContents().get(2);
		private final Keyword cSelectionKeyword_5_2_0 = (Keyword)cGroup_5_2.eContents().get(0);
		private final Assignment cCategoryAssignment_5_2_1 = (Assignment)cGroup_5_2.eContents().get(1);
		private final CrossReference cCategorySelectionCategoryCrossReference_5_2_1_0 = (CrossReference)cCategoryAssignment_5_2_1.eContents().get(0);
		private final RuleCall cCategorySelectionCategoryIDTerminalRuleCall_5_2_1_0_1 = (RuleCall)cCategorySelectionCategoryCrossReference_5_2_1_0.eContents().get(1);
		private final Assignment cDescriptionAssignment_5_3 = (Assignment)cUnorderedGroup_5.eContents().get(3);
		private final RuleCall cDescriptionDescriptionParserRuleCall_5_3_0 = (RuleCall)cDescriptionAssignment_5_3.eContents().get(0);
		private final Assignment cConstantsAssignment_5_4 = (Assignment)cUnorderedGroup_5.eContents().get(4);
		private final RuleCall cConstantsValDeclarationParserRuleCall_5_4_0 = (RuleCall)cConstantsAssignment_5_4.eContents().get(0);
		private final Assignment cRationaleAssignment_5_5 = (Assignment)cUnorderedGroup_5.eContents().get(5);
		private final RuleCall cRationaleRationaleParserRuleCall_5_5_0 = (RuleCall)cRationaleAssignment_5_5.eContents().get(0);
		private final Assignment cChangeUncertaintyAssignment_5_6 = (Assignment)cUnorderedGroup_5.eContents().get(6);
		private final RuleCall cChangeUncertaintyUncertaintyParserRuleCall_5_6_0 = (RuleCall)cChangeUncertaintyAssignment_5_6.eContents().get(0);
		private final Group cGroup_5_7 = (Group)cUnorderedGroup_5.eContents().get(7);
		private final Keyword cRefinesKeyword_5_7_0 = (Keyword)cGroup_5_7.eContents().get(0);
		private final Assignment cRefinesReferenceAssignment_5_7_1 = (Assignment)cGroup_5_7.eContents().get(1);
		private final CrossReference cRefinesReferenceGoalCrossReference_5_7_1_0 = (CrossReference)cRefinesReferenceAssignment_5_7_1.eContents().get(0);
		private final RuleCall cRefinesReferenceGoalQualifiedNameParserRuleCall_5_7_1_0_1 = (RuleCall)cRefinesReferenceGoalCrossReference_5_7_1_0.eContents().get(1);
		private final Group cGroup_5_8 = (Group)cUnorderedGroup_5.eContents().get(8);
		private final Keyword cConflictsKeyword_5_8_0 = (Keyword)cGroup_5_8.eContents().get(0);
		private final Keyword cWithKeyword_5_8_1 = (Keyword)cGroup_5_8.eContents().get(1);
		private final Assignment cConflictsReferenceAssignment_5_8_2 = (Assignment)cGroup_5_8.eContents().get(2);
		private final CrossReference cConflictsReferenceGoalCrossReference_5_8_2_0 = (CrossReference)cConflictsReferenceAssignment_5_8_2.eContents().get(0);
		private final RuleCall cConflictsReferenceGoalQualifiedNameParserRuleCall_5_8_2_0_1 = (RuleCall)cConflictsReferenceGoalCrossReference_5_8_2_0.eContents().get(1);
		private final Group cGroup_5_9 = (Group)cUnorderedGroup_5.eContents().get(9);
		private final Keyword cEvolvesKeyword_5_9_0 = (Keyword)cGroup_5_9.eContents().get(0);
		private final Assignment cEvolvesReferenceAssignment_5_9_1 = (Assignment)cGroup_5_9.eContents().get(1);
		private final CrossReference cEvolvesReferenceRequirementCrossReference_5_9_1_0 = (CrossReference)cEvolvesReferenceAssignment_5_9_1.eContents().get(0);
		private final RuleCall cEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_9_1_0_1 = (RuleCall)cEvolvesReferenceRequirementCrossReference_5_9_1_0.eContents().get(1);
		private final Group cGroup_5_10 = (Group)cUnorderedGroup_5.eContents().get(10);
		private final Assignment cDroppedAssignment_5_10_0 = (Assignment)cGroup_5_10.eContents().get(0);
		private final Keyword cDroppedDroppedKeyword_5_10_0_0 = (Keyword)cDroppedAssignment_5_10_0.eContents().get(0);
		private final Assignment cDropRationaleAssignment_5_10_1 = (Assignment)cGroup_5_10.eContents().get(1);
		private final RuleCall cDropRationaleSTRINGTerminalRuleCall_5_10_1_0 = (RuleCall)cDropRationaleAssignment_5_10_1.eContents().get(0);
		private final Group cGroup_5_11 = (Group)cUnorderedGroup_5.eContents().get(11);
		private final Keyword cStakeholderKeyword_5_11_0 = (Keyword)cGroup_5_11.eContents().get(0);
		private final Assignment cStakeholderReferenceAssignment_5_11_1 = (Assignment)cGroup_5_11.eContents().get(1);
		private final CrossReference cStakeholderReferenceStakeholderCrossReference_5_11_1_0 = (CrossReference)cStakeholderReferenceAssignment_5_11_1.eContents().get(0);
		private final RuleCall cStakeholderReferenceStakeholderQualifiedNameParserRuleCall_5_11_1_0_1 = (RuleCall)cStakeholderReferenceStakeholderCrossReference_5_11_1_0.eContents().get(1);
		private final Group cGroup_5_12 = (Group)cUnorderedGroup_5.eContents().get(12);
		private final Keyword cSeeKeyword_5_12_0 = (Keyword)cGroup_5_12.eContents().get(0);
		private final Keyword cDocumentKeyword_5_12_1 = (Keyword)cGroup_5_12.eContents().get(1);
		private final Keyword cRequirementKeyword_5_12_2 = (Keyword)cGroup_5_12.eContents().get(2);
		private final Assignment cDocumentRequirementAssignment_5_12_3 = (Assignment)cGroup_5_12.eContents().get(3);
		private final CrossReference cDocumentRequirementContractualElementCrossReference_5_12_3_0 = (CrossReference)cDocumentRequirementAssignment_5_12_3.eContents().get(0);
		private final RuleCall cDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_12_3_0_1 = (RuleCall)cDocumentRequirementContractualElementCrossReference_5_12_3_0.eContents().get(1);
		private final Group cGroup_5_13 = (Group)cUnorderedGroup_5.eContents().get(13);
		private final Keyword cSeeKeyword_5_13_0 = (Keyword)cGroup_5_13.eContents().get(0);
		private final Keyword cDocumentKeyword_5_13_1 = (Keyword)cGroup_5_13.eContents().get(1);
		private final Assignment cDocReferenceAssignment_5_13_2 = (Assignment)cGroup_5_13.eContents().get(2);
		private final RuleCall cDocReferenceExternalDocumentParserRuleCall_5_13_2_0 = (RuleCall)cDocReferenceAssignment_5_13_2.eContents().get(0);
		private final Group cGroup_5_14 = (Group)cUnorderedGroup_5.eContents().get(14);
		private final Keyword cIssuesKeyword_5_14_0 = (Keyword)cGroup_5_14.eContents().get(0);
		private final Assignment cIssuesAssignment_5_14_1 = (Assignment)cGroup_5_14.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_5_14_1_0 = (RuleCall)cIssuesAssignment_5_14_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//Goal:
		//	"goal" name=ID (":" title=STRING)? // short string for title
		//	("for" targetElement=[aadl2::NamedElement])? "[" (("category" category+=[categories::RequirementCategory]+)? &
		//	("quality" category+=[categories::QualityCategory]+)? & ("selection" category+=[categories::SelectionCategory]+)? &
		//	description=Description? & constants+=ValDeclaration* & rationale=Rationale? & changeUncertainty=Uncertainty? &
		//	("refines" refinesReference+=[Goal|QualifiedName]+)? & ("conflicts" "with"
		//	conflictsReference+=[Goal|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
		//	(dropped?="dropped" dropRationale=STRING?)? & ("stakeholder"
		//	stakeholderReference+=[org::Stakeholder|QualifiedName]+)? & ("see" "document" "requirement"
		//	documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//	("issues" issues+=STRING+)?) "]";
		@Override public ParserRule getRule() { return rule; }

		//"goal" name=ID (":" title=STRING)? // short string for title
		//("for" targetElement=[aadl2::NamedElement])? "[" (("category" category+=[categories::RequirementCategory]+)? &
		//("quality" category+=[categories::QualityCategory]+)? & ("selection" category+=[categories::SelectionCategory]+)? &
		//description=Description? & constants+=ValDeclaration* & rationale=Rationale? & changeUncertainty=Uncertainty? &
		//("refines" refinesReference+=[Goal|QualifiedName]+)? & ("conflicts" "with" conflictsReference+=[Goal|QualifiedName]+)?
		//& ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? & (dropped?="dropped" dropRationale=STRING?)? &
		//("stakeholder" stakeholderReference+=[org::Stakeholder|QualifiedName]+)? & ("see" "document" "requirement"
		//documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//("issues" issues+=STRING+)?) "]"
		public Group getGroup() { return cGroup; }

		//"goal"
		public Keyword getGoalKeyword_0() { return cGoalKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//(":" title=STRING)?
		public Group getGroup_2() { return cGroup_2; }

		//":"
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//title=STRING
		public Assignment getTitleAssignment_2_1() { return cTitleAssignment_2_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_2_1_0() { return cTitleSTRINGTerminalRuleCall_2_1_0; }

		//("for" targetElement=[aadl2::NamedElement])?
		public Group getGroup_3() { return cGroup_3; }

		//"for"
		public Keyword getForKeyword_3_0() { return cForKeyword_3_0; }

		//targetElement=[aadl2::NamedElement]
		public Assignment getTargetElementAssignment_3_1() { return cTargetElementAssignment_3_1; }

		//[aadl2::NamedElement]
		public CrossReference getTargetElementNamedElementCrossReference_3_1_0() { return cTargetElementNamedElementCrossReference_3_1_0; }

		//ID
		public RuleCall getTargetElementNamedElementIDTerminalRuleCall_3_1_0_1() { return cTargetElementNamedElementIDTerminalRuleCall_3_1_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//("category" category+=[categories::RequirementCategory]+)? & ("quality" category+=[categories::QualityCategory]+)? &
		//("selection" category+=[categories::SelectionCategory]+)? & description=Description? & constants+=ValDeclaration* &
		//rationale=Rationale? & changeUncertainty=Uncertainty? & ("refines" refinesReference+=[Goal|QualifiedName]+)? &
		//("conflicts" "with" conflictsReference+=[Goal|QualifiedName]+)? & ("evolves"
		//evolvesReference+=[Requirement|QualifiedName]+)? & (dropped?="dropped" dropRationale=STRING?)? & ("stakeholder"
		//stakeholderReference+=[org::Stakeholder|QualifiedName]+)? & ("see" "document" "requirement"
		//documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//("issues" issues+=STRING+)?
		public UnorderedGroup getUnorderedGroup_5() { return cUnorderedGroup_5; }

		//("category" category+=[categories::RequirementCategory]+)?
		public Group getGroup_5_0() { return cGroup_5_0; }

		//"category"
		public Keyword getCategoryKeyword_5_0_0() { return cCategoryKeyword_5_0_0; }

		//category+=[categories::RequirementCategory]+
		public Assignment getCategoryAssignment_5_0_1() { return cCategoryAssignment_5_0_1; }

		//[categories::RequirementCategory]
		public CrossReference getCategoryRequirementCategoryCrossReference_5_0_1_0() { return cCategoryRequirementCategoryCrossReference_5_0_1_0; }

		//ID
		public RuleCall getCategoryRequirementCategoryIDTerminalRuleCall_5_0_1_0_1() { return cCategoryRequirementCategoryIDTerminalRuleCall_5_0_1_0_1; }

		//("quality" category+=[categories::QualityCategory]+)?
		public Group getGroup_5_1() { return cGroup_5_1; }

		//"quality"
		public Keyword getQualityKeyword_5_1_0() { return cQualityKeyword_5_1_0; }

		//category+=[categories::QualityCategory]+
		public Assignment getCategoryAssignment_5_1_1() { return cCategoryAssignment_5_1_1; }

		//[categories::QualityCategory]
		public CrossReference getCategoryQualityCategoryCrossReference_5_1_1_0() { return cCategoryQualityCategoryCrossReference_5_1_1_0; }

		//ID
		public RuleCall getCategoryQualityCategoryIDTerminalRuleCall_5_1_1_0_1() { return cCategoryQualityCategoryIDTerminalRuleCall_5_1_1_0_1; }

		//("selection" category+=[categories::SelectionCategory]+)?
		public Group getGroup_5_2() { return cGroup_5_2; }

		//"selection"
		public Keyword getSelectionKeyword_5_2_0() { return cSelectionKeyword_5_2_0; }

		//category+=[categories::SelectionCategory]+
		public Assignment getCategoryAssignment_5_2_1() { return cCategoryAssignment_5_2_1; }

		//[categories::SelectionCategory]
		public CrossReference getCategorySelectionCategoryCrossReference_5_2_1_0() { return cCategorySelectionCategoryCrossReference_5_2_1_0; }

		//ID
		public RuleCall getCategorySelectionCategoryIDTerminalRuleCall_5_2_1_0_1() { return cCategorySelectionCategoryIDTerminalRuleCall_5_2_1_0_1; }

		//description=Description?
		public Assignment getDescriptionAssignment_5_3() { return cDescriptionAssignment_5_3; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_5_3_0() { return cDescriptionDescriptionParserRuleCall_5_3_0; }

		//constants+=ValDeclaration*
		public Assignment getConstantsAssignment_5_4() { return cConstantsAssignment_5_4; }

		//ValDeclaration
		public RuleCall getConstantsValDeclarationParserRuleCall_5_4_0() { return cConstantsValDeclarationParserRuleCall_5_4_0; }

		//rationale=Rationale?
		public Assignment getRationaleAssignment_5_5() { return cRationaleAssignment_5_5; }

		//Rationale
		public RuleCall getRationaleRationaleParserRuleCall_5_5_0() { return cRationaleRationaleParserRuleCall_5_5_0; }

		//changeUncertainty=Uncertainty?
		public Assignment getChangeUncertaintyAssignment_5_6() { return cChangeUncertaintyAssignment_5_6; }

		//Uncertainty
		public RuleCall getChangeUncertaintyUncertaintyParserRuleCall_5_6_0() { return cChangeUncertaintyUncertaintyParserRuleCall_5_6_0; }

		//("refines" refinesReference+=[Goal|QualifiedName]+)?
		public Group getGroup_5_7() { return cGroup_5_7; }

		//"refines"
		public Keyword getRefinesKeyword_5_7_0() { return cRefinesKeyword_5_7_0; }

		//refinesReference+=[Goal|QualifiedName]+
		public Assignment getRefinesReferenceAssignment_5_7_1() { return cRefinesReferenceAssignment_5_7_1; }

		//[Goal|QualifiedName]
		public CrossReference getRefinesReferenceGoalCrossReference_5_7_1_0() { return cRefinesReferenceGoalCrossReference_5_7_1_0; }

		//QualifiedName
		public RuleCall getRefinesReferenceGoalQualifiedNameParserRuleCall_5_7_1_0_1() { return cRefinesReferenceGoalQualifiedNameParserRuleCall_5_7_1_0_1; }

		//("conflicts" "with" conflictsReference+=[Goal|QualifiedName]+)?
		public Group getGroup_5_8() { return cGroup_5_8; }

		//"conflicts"
		public Keyword getConflictsKeyword_5_8_0() { return cConflictsKeyword_5_8_0; }

		//"with"
		public Keyword getWithKeyword_5_8_1() { return cWithKeyword_5_8_1; }

		//conflictsReference+=[Goal|QualifiedName]+
		public Assignment getConflictsReferenceAssignment_5_8_2() { return cConflictsReferenceAssignment_5_8_2; }

		//[Goal|QualifiedName]
		public CrossReference getConflictsReferenceGoalCrossReference_5_8_2_0() { return cConflictsReferenceGoalCrossReference_5_8_2_0; }

		//QualifiedName
		public RuleCall getConflictsReferenceGoalQualifiedNameParserRuleCall_5_8_2_0_1() { return cConflictsReferenceGoalQualifiedNameParserRuleCall_5_8_2_0_1; }

		//("evolves" evolvesReference+=[Requirement|QualifiedName]+)?
		public Group getGroup_5_9() { return cGroup_5_9; }

		//"evolves"
		public Keyword getEvolvesKeyword_5_9_0() { return cEvolvesKeyword_5_9_0; }

		//evolvesReference+=[Requirement|QualifiedName]+
		public Assignment getEvolvesReferenceAssignment_5_9_1() { return cEvolvesReferenceAssignment_5_9_1; }

		//[Requirement|QualifiedName]
		public CrossReference getEvolvesReferenceRequirementCrossReference_5_9_1_0() { return cEvolvesReferenceRequirementCrossReference_5_9_1_0; }

		//QualifiedName
		public RuleCall getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_9_1_0_1() { return cEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_9_1_0_1; }

		//(dropped?="dropped" dropRationale=STRING?)?
		public Group getGroup_5_10() { return cGroup_5_10; }

		//dropped?="dropped"
		public Assignment getDroppedAssignment_5_10_0() { return cDroppedAssignment_5_10_0; }

		//"dropped"
		public Keyword getDroppedDroppedKeyword_5_10_0_0() { return cDroppedDroppedKeyword_5_10_0_0; }

		//dropRationale=STRING?
		public Assignment getDropRationaleAssignment_5_10_1() { return cDropRationaleAssignment_5_10_1; }

		//STRING
		public RuleCall getDropRationaleSTRINGTerminalRuleCall_5_10_1_0() { return cDropRationaleSTRINGTerminalRuleCall_5_10_1_0; }

		//("stakeholder" stakeholderReference+=[org::Stakeholder|QualifiedName]+)?
		public Group getGroup_5_11() { return cGroup_5_11; }

		//"stakeholder"
		public Keyword getStakeholderKeyword_5_11_0() { return cStakeholderKeyword_5_11_0; }

		//stakeholderReference+=[org::Stakeholder|QualifiedName]+
		public Assignment getStakeholderReferenceAssignment_5_11_1() { return cStakeholderReferenceAssignment_5_11_1; }

		//[org::Stakeholder|QualifiedName]
		public CrossReference getStakeholderReferenceStakeholderCrossReference_5_11_1_0() { return cStakeholderReferenceStakeholderCrossReference_5_11_1_0; }

		//QualifiedName
		public RuleCall getStakeholderReferenceStakeholderQualifiedNameParserRuleCall_5_11_1_0_1() { return cStakeholderReferenceStakeholderQualifiedNameParserRuleCall_5_11_1_0_1; }

		//("see" "document" "requirement" documentRequirement+=[ContractualElement|QualifiedName]+)?
		public Group getGroup_5_12() { return cGroup_5_12; }

		//"see"
		public Keyword getSeeKeyword_5_12_0() { return cSeeKeyword_5_12_0; }

		//"document"
		public Keyword getDocumentKeyword_5_12_1() { return cDocumentKeyword_5_12_1; }

		//"requirement"
		public Keyword getRequirementKeyword_5_12_2() { return cRequirementKeyword_5_12_2; }

		//documentRequirement+=[ContractualElement|QualifiedName]+
		public Assignment getDocumentRequirementAssignment_5_12_3() { return cDocumentRequirementAssignment_5_12_3; }

		//[ContractualElement|QualifiedName]
		public CrossReference getDocumentRequirementContractualElementCrossReference_5_12_3_0() { return cDocumentRequirementContractualElementCrossReference_5_12_3_0; }

		//QualifiedName
		public RuleCall getDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_12_3_0_1() { return cDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_12_3_0_1; }

		//("see" "document" docReference+=ExternalDocument+)?
		public Group getGroup_5_13() { return cGroup_5_13; }

		//"see"
		public Keyword getSeeKeyword_5_13_0() { return cSeeKeyword_5_13_0; }

		//"document"
		public Keyword getDocumentKeyword_5_13_1() { return cDocumentKeyword_5_13_1; }

		//docReference+=ExternalDocument+
		public Assignment getDocReferenceAssignment_5_13_2() { return cDocReferenceAssignment_5_13_2; }

		//ExternalDocument
		public RuleCall getDocReferenceExternalDocumentParserRuleCall_5_13_2_0() { return cDocReferenceExternalDocumentParserRuleCall_5_13_2_0; }

		//("issues" issues+=STRING+)?
		public Group getGroup_5_14() { return cGroup_5_14; }

		//"issues"
		public Keyword getIssuesKeyword_5_14_0() { return cIssuesKeyword_5_14_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_5_14_1() { return cIssuesAssignment_5_14_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_5_14_1_0() { return cIssuesSTRINGTerminalRuleCall_5_14_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class RequirementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Requirement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRequirementKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTitleAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cTitleAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cForKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Alternatives cAlternatives_3_1 = (Alternatives)cGroup_3.eContents().get(1);
		private final Group cGroup_3_1_0 = (Group)cAlternatives_3_1.eContents().get(0);
		private final Assignment cTargetAssignment_3_1_0_0 = (Assignment)cGroup_3_1_0.eContents().get(0);
		private final CrossReference cTargetComponentClassifierCrossReference_3_1_0_0_0 = (CrossReference)cTargetAssignment_3_1_0_0.eContents().get(0);
		private final RuleCall cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_0_0_0_1 = (RuleCall)cTargetComponentClassifierCrossReference_3_1_0_0_0.eContents().get(1);
		private final Assignment cTargetElementAssignment_3_1_0_1 = (Assignment)cGroup_3_1_0.eContents().get(1);
		private final CrossReference cTargetElementNamedElementCrossReference_3_1_0_1_0 = (CrossReference)cTargetElementAssignment_3_1_0_1.eContents().get(0);
		private final RuleCall cTargetElementNamedElementIDTerminalRuleCall_3_1_0_1_0_1 = (RuleCall)cTargetElementNamedElementCrossReference_3_1_0_1_0.eContents().get(1);
		private final Assignment cTargetElementAssignment_3_1_1 = (Assignment)cAlternatives_3_1.eContents().get(1);
		private final CrossReference cTargetElementNamedElementCrossReference_3_1_1_0 = (CrossReference)cTargetElementAssignment_3_1_1.eContents().get(0);
		private final RuleCall cTargetElementNamedElementIDTerminalRuleCall_3_1_1_0_1 = (RuleCall)cTargetElementNamedElementCrossReference_3_1_1_0.eContents().get(1);
		private final Assignment cComponentCategoryAssignment_3_1_2 = (Assignment)cAlternatives_3_1.eContents().get(2);
		private final RuleCall cComponentCategoryComponentCategoryParserRuleCall_3_1_2_0 = (RuleCall)cComponentCategoryAssignment_3_1_2.eContents().get(0);
		private final Assignment cGlobalAssignment_3_1_3 = (Assignment)cAlternatives_3_1.eContents().get(3);
		private final Keyword cGlobalAllKeyword_3_1_3_0 = (Keyword)cGlobalAssignment_3_1_3.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final UnorderedGroup cUnorderedGroup_5 = (UnorderedGroup)cGroup.eContents().get(5);
		private final Group cGroup_5_0 = (Group)cUnorderedGroup_5.eContents().get(0);
		private final Keyword cCategoryKeyword_5_0_0 = (Keyword)cGroup_5_0.eContents().get(0);
		private final Assignment cCategoryAssignment_5_0_1 = (Assignment)cGroup_5_0.eContents().get(1);
		private final CrossReference cCategoryRequirementCategoryCrossReference_5_0_1_0 = (CrossReference)cCategoryAssignment_5_0_1.eContents().get(0);
		private final RuleCall cCategoryRequirementCategoryIDTerminalRuleCall_5_0_1_0_1 = (RuleCall)cCategoryRequirementCategoryCrossReference_5_0_1_0.eContents().get(1);
		private final Group cGroup_5_1 = (Group)cUnorderedGroup_5.eContents().get(1);
		private final Keyword cQualityKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cCategoryAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final CrossReference cCategoryQualityCategoryCrossReference_5_1_1_0 = (CrossReference)cCategoryAssignment_5_1_1.eContents().get(0);
		private final RuleCall cCategoryQualityCategoryIDTerminalRuleCall_5_1_1_0_1 = (RuleCall)cCategoryQualityCategoryCrossReference_5_1_1_0.eContents().get(1);
		private final Group cGroup_5_2 = (Group)cUnorderedGroup_5.eContents().get(2);
		private final Keyword cSelectionKeyword_5_2_0 = (Keyword)cGroup_5_2.eContents().get(0);
		private final Assignment cCategoryAssignment_5_2_1 = (Assignment)cGroup_5_2.eContents().get(1);
		private final CrossReference cCategorySelectionCategoryCrossReference_5_2_1_0 = (CrossReference)cCategoryAssignment_5_2_1.eContents().get(0);
		private final RuleCall cCategorySelectionCategoryIDTerminalRuleCall_5_2_1_0_1 = (RuleCall)cCategorySelectionCategoryCrossReference_5_2_1_0.eContents().get(1);
		private final Assignment cDescriptionAssignment_5_3 = (Assignment)cUnorderedGroup_5.eContents().get(3);
		private final RuleCall cDescriptionDescriptionParserRuleCall_5_3_0 = (RuleCall)cDescriptionAssignment_5_3.eContents().get(0);
		private final Assignment cConstantsAssignment_5_4 = (Assignment)cUnorderedGroup_5.eContents().get(4);
		private final RuleCall cConstantsValDeclarationParserRuleCall_5_4_0 = (RuleCall)cConstantsAssignment_5_4.eContents().get(0);
		private final Assignment cComputesAssignment_5_5 = (Assignment)cUnorderedGroup_5.eContents().get(5);
		private final RuleCall cComputesComputeDeclarationParserRuleCall_5_5_0 = (RuleCall)cComputesAssignment_5_5.eContents().get(0);
		private final Assignment cPredicateAssignment_5_6 = (Assignment)cUnorderedGroup_5.eContents().get(6);
		private final RuleCall cPredicateReqPredicateParserRuleCall_5_6_0 = (RuleCall)cPredicateAssignment_5_6.eContents().get(0);
		private final Assignment cRationaleAssignment_5_7 = (Assignment)cUnorderedGroup_5.eContents().get(7);
		private final RuleCall cRationaleRationaleParserRuleCall_5_7_0 = (RuleCall)cRationaleAssignment_5_7.eContents().get(0);
		private final Assignment cChangeUncertaintyAssignment_5_8 = (Assignment)cUnorderedGroup_5.eContents().get(8);
		private final RuleCall cChangeUncertaintyUncertaintyParserRuleCall_5_8_0 = (RuleCall)cChangeUncertaintyAssignment_5_8.eContents().get(0);
		private final Group cGroup_5_9 = (Group)cUnorderedGroup_5.eContents().get(9);
		private final Keyword cMitigatesKeyword_5_9_0 = (Keyword)cGroup_5_9.eContents().get(0);
		private final Alternatives cAlternatives_5_9_1 = (Alternatives)cGroup_5_9.eContents().get(1);
		private final Assignment cExceptionAssignment_5_9_1_0 = (Assignment)cAlternatives_5_9_1.eContents().get(0);
		private final CrossReference cExceptionEObjectCrossReference_5_9_1_0_0 = (CrossReference)cExceptionAssignment_5_9_1_0.eContents().get(0);
		private final RuleCall cExceptionEObjectIDTerminalRuleCall_5_9_1_0_0_1 = (RuleCall)cExceptionEObjectCrossReference_5_9_1_0_0.eContents().get(1);
		private final Assignment cExceptionTextAssignment_5_9_1_1 = (Assignment)cAlternatives_5_9_1.eContents().get(1);
		private final RuleCall cExceptionTextSTRINGTerminalRuleCall_5_9_1_1_0 = (RuleCall)cExceptionTextAssignment_5_9_1_1.eContents().get(0);
		private final Group cGroup_5_10 = (Group)cUnorderedGroup_5.eContents().get(10);
		private final Keyword cRefinesKeyword_5_10_0 = (Keyword)cGroup_5_10.eContents().get(0);
		private final Assignment cRefinesReferenceAssignment_5_10_1 = (Assignment)cGroup_5_10.eContents().get(1);
		private final CrossReference cRefinesReferenceRequirementCrossReference_5_10_1_0 = (CrossReference)cRefinesReferenceAssignment_5_10_1.eContents().get(0);
		private final RuleCall cRefinesReferenceRequirementQualifiedNameParserRuleCall_5_10_1_0_1 = (RuleCall)cRefinesReferenceRequirementCrossReference_5_10_1_0.eContents().get(1);
		private final Group cGroup_5_11 = (Group)cUnorderedGroup_5.eContents().get(11);
		private final Keyword cDecomposesKeyword_5_11_0 = (Keyword)cGroup_5_11.eContents().get(0);
		private final Assignment cDecomposesReferenceAssignment_5_11_1 = (Assignment)cGroup_5_11.eContents().get(1);
		private final CrossReference cDecomposesReferenceRequirementCrossReference_5_11_1_0 = (CrossReference)cDecomposesReferenceAssignment_5_11_1.eContents().get(0);
		private final RuleCall cDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_11_1_0_1 = (RuleCall)cDecomposesReferenceRequirementCrossReference_5_11_1_0.eContents().get(1);
		private final Group cGroup_5_12 = (Group)cUnorderedGroup_5.eContents().get(12);
		private final Keyword cEvolvesKeyword_5_12_0 = (Keyword)cGroup_5_12.eContents().get(0);
		private final Assignment cEvolvesReferenceAssignment_5_12_1 = (Assignment)cGroup_5_12.eContents().get(1);
		private final CrossReference cEvolvesReferenceRequirementCrossReference_5_12_1_0 = (CrossReference)cEvolvesReferenceAssignment_5_12_1.eContents().get(0);
		private final RuleCall cEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_12_1_0_1 = (RuleCall)cEvolvesReferenceRequirementCrossReference_5_12_1_0.eContents().get(1);
		private final Group cGroup_5_13 = (Group)cUnorderedGroup_5.eContents().get(13);
		private final Assignment cDroppedAssignment_5_13_0 = (Assignment)cGroup_5_13.eContents().get(0);
		private final Keyword cDroppedDroppedKeyword_5_13_0_0 = (Keyword)cDroppedAssignment_5_13_0.eContents().get(0);
		private final Assignment cDropRationaleAssignment_5_13_1 = (Assignment)cGroup_5_13.eContents().get(1);
		private final RuleCall cDropRationaleSTRINGTerminalRuleCall_5_13_1_0 = (RuleCall)cDropRationaleAssignment_5_13_1.eContents().get(0);
		private final Group cGroup_5_14 = (Group)cUnorderedGroup_5.eContents().get(14);
		private final Keyword cDevelopmentKeyword_5_14_0 = (Keyword)cGroup_5_14.eContents().get(0);
		private final Keyword cStakeholderKeyword_5_14_1 = (Keyword)cGroup_5_14.eContents().get(1);
		private final Assignment cDevelopmentStakeholderAssignment_5_14_2 = (Assignment)cGroup_5_14.eContents().get(2);
		private final CrossReference cDevelopmentStakeholderStakeholderCrossReference_5_14_2_0 = (CrossReference)cDevelopmentStakeholderAssignment_5_14_2.eContents().get(0);
		private final RuleCall cDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_14_2_0_1 = (RuleCall)cDevelopmentStakeholderStakeholderCrossReference_5_14_2_0.eContents().get(1);
		private final Group cGroup_5_15 = (Group)cUnorderedGroup_5.eContents().get(15);
		private final Keyword cSeeKeyword_5_15_0 = (Keyword)cGroup_5_15.eContents().get(0);
		private final Keyword cGoalKeyword_5_15_1 = (Keyword)cGroup_5_15.eContents().get(1);
		private final Assignment cGoalReferenceAssignment_5_15_2 = (Assignment)cGroup_5_15.eContents().get(2);
		private final CrossReference cGoalReferenceGoalCrossReference_5_15_2_0 = (CrossReference)cGoalReferenceAssignment_5_15_2.eContents().get(0);
		private final RuleCall cGoalReferenceGoalQualifiedNameParserRuleCall_5_15_2_0_1 = (RuleCall)cGoalReferenceGoalCrossReference_5_15_2_0.eContents().get(1);
		private final Group cGroup_5_16 = (Group)cUnorderedGroup_5.eContents().get(16);
		private final Keyword cSeeKeyword_5_16_0 = (Keyword)cGroup_5_16.eContents().get(0);
		private final Keyword cDocumentKeyword_5_16_1 = (Keyword)cGroup_5_16.eContents().get(1);
		private final Keyword cGoalKeyword_5_16_2 = (Keyword)cGroup_5_16.eContents().get(2);
		private final Assignment cStakeholderRequirementReferenceAssignment_5_16_3 = (Assignment)cGroup_5_16.eContents().get(3);
		private final CrossReference cStakeholderRequirementReferenceGoalCrossReference_5_16_3_0 = (CrossReference)cStakeholderRequirementReferenceAssignment_5_16_3.eContents().get(0);
		private final RuleCall cStakeholderRequirementReferenceGoalQualifiedNameParserRuleCall_5_16_3_0_1 = (RuleCall)cStakeholderRequirementReferenceGoalCrossReference_5_16_3_0.eContents().get(1);
		private final Group cGroup_5_17 = (Group)cUnorderedGroup_5.eContents().get(17);
		private final Keyword cSeeKeyword_5_17_0 = (Keyword)cGroup_5_17.eContents().get(0);
		private final Keyword cDocumentKeyword_5_17_1 = (Keyword)cGroup_5_17.eContents().get(1);
		private final Keyword cRequirementKeyword_5_17_2 = (Keyword)cGroup_5_17.eContents().get(2);
		private final Assignment cDocumentRequirementAssignment_5_17_3 = (Assignment)cGroup_5_17.eContents().get(3);
		private final CrossReference cDocumentRequirementContractualElementCrossReference_5_17_3_0 = (CrossReference)cDocumentRequirementAssignment_5_17_3.eContents().get(0);
		private final RuleCall cDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_17_3_0_1 = (RuleCall)cDocumentRequirementContractualElementCrossReference_5_17_3_0.eContents().get(1);
		private final Group cGroup_5_18 = (Group)cUnorderedGroup_5.eContents().get(18);
		private final Keyword cSeeKeyword_5_18_0 = (Keyword)cGroup_5_18.eContents().get(0);
		private final Keyword cDocumentKeyword_5_18_1 = (Keyword)cGroup_5_18.eContents().get(1);
		private final Assignment cDocReferenceAssignment_5_18_2 = (Assignment)cGroup_5_18.eContents().get(2);
		private final RuleCall cDocReferenceExternalDocumentParserRuleCall_5_18_2_0 = (RuleCall)cDocReferenceAssignment_5_18_2.eContents().get(0);
		private final Group cGroup_5_19 = (Group)cUnorderedGroup_5.eContents().get(19);
		private final Keyword cIssuesKeyword_5_19_0 = (Keyword)cGroup_5_19.eContents().get(0);
		private final Assignment cIssuesAssignment_5_19_1 = (Assignment)cGroup_5_19.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_5_19_1_0 = (RuleCall)cIssuesAssignment_5_19_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//Requirement:
		//	"requirement" name=ID (":" title=STRING)? ("for" (target=[aadl2::ComponentClassifier|AadlClassifierReference]
		//	targetElement=[aadl2::NamedElement]? | targetElement=[aadl2::NamedElement] | componentCategory+=ComponentCategory+ |
		//	global?="all"))? "[" (("category" category+=[categories::RequirementCategory]+)? // predicate expression 
		//	//	&('refined' 'to' '['refinedRequirement+=Requirement+ ']')? 
		//	& ("quality" category+=[categories::QualityCategory]+)? & ("selection" category+=[categories::SelectionCategory]+)? &
		//	description=Description? & constants+=ValDeclaration* & computes+=ComputeDeclaration* & predicate=ReqPredicate? &
		//	rationale=Rationale? & changeUncertainty=Uncertainty? & ("mitigates" (exception=[ecore::EObject] |
		//	exceptionText=STRING))? & ("refines" refinesReference+=[Requirement|QualifiedName]+)? & ("decomposes"
		//	decomposesReference+=[Requirement|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
		//	(dropped?="dropped" dropRationale=STRING?)? & ("development" "stakeholder"
		//	developmentStakeholder+=[org::Stakeholder|QualifiedName]+)? & ("see" "goal" goalReference+=[Goal|QualifiedName]+)? &
		//	("see" "document" "goal" stakeholderRequirementReference+=[Goal|QualifiedName]+)? & ("see" "document" "requirement"
		//	documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//	("issues" issues+=STRING+)?) "]";
		@Override public ParserRule getRule() { return rule; }

		//"requirement" name=ID (":" title=STRING)? ("for" (target=[aadl2::ComponentClassifier|AadlClassifierReference]
		//targetElement=[aadl2::NamedElement]? | targetElement=[aadl2::NamedElement] | componentCategory+=ComponentCategory+ |
		//global?="all"))? "[" (("category" category+=[categories::RequirementCategory]+)? // predicate expression 
		////	&('refined' 'to' '['refinedRequirement+=Requirement+ ']')? 
		//& ("quality" category+=[categories::QualityCategory]+)? & ("selection" category+=[categories::SelectionCategory]+)? &
		//description=Description? & constants+=ValDeclaration* & computes+=ComputeDeclaration* & predicate=ReqPredicate? &
		//rationale=Rationale? & changeUncertainty=Uncertainty? & ("mitigates" (exception=[ecore::EObject] |
		//exceptionText=STRING))? & ("refines" refinesReference+=[Requirement|QualifiedName]+)? & ("decomposes"
		//decomposesReference+=[Requirement|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
		//(dropped?="dropped" dropRationale=STRING?)? & ("development" "stakeholder"
		//developmentStakeholder+=[org::Stakeholder|QualifiedName]+)? & ("see" "goal" goalReference+=[Goal|QualifiedName]+)? &
		//("see" "document" "goal" stakeholderRequirementReference+=[Goal|QualifiedName]+)? & ("see" "document" "requirement"
		//documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//("issues" issues+=STRING+)?) "]"
		public Group getGroup() { return cGroup; }

		//"requirement"
		public Keyword getRequirementKeyword_0() { return cRequirementKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//(":" title=STRING)?
		public Group getGroup_2() { return cGroup_2; }

		//":"
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//title=STRING
		public Assignment getTitleAssignment_2_1() { return cTitleAssignment_2_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_2_1_0() { return cTitleSTRINGTerminalRuleCall_2_1_0; }

		//("for" (target=[aadl2::ComponentClassifier|AadlClassifierReference] targetElement=[aadl2::NamedElement]? |
		//targetElement=[aadl2::NamedElement] | componentCategory+=ComponentCategory+ | global?="all"))?
		public Group getGroup_3() { return cGroup_3; }

		//"for"
		public Keyword getForKeyword_3_0() { return cForKeyword_3_0; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference] targetElement=[aadl2::NamedElement]? |
		//targetElement=[aadl2::NamedElement] | componentCategory+=ComponentCategory+ | global?="all"
		public Alternatives getAlternatives_3_1() { return cAlternatives_3_1; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference] targetElement=[aadl2::NamedElement]?
		public Group getGroup_3_1_0() { return cGroup_3_1_0; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference]
		public Assignment getTargetAssignment_3_1_0_0() { return cTargetAssignment_3_1_0_0; }

		//[aadl2::ComponentClassifier|AadlClassifierReference]
		public CrossReference getTargetComponentClassifierCrossReference_3_1_0_0_0() { return cTargetComponentClassifierCrossReference_3_1_0_0_0; }

		//AadlClassifierReference
		public RuleCall getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_0_0_0_1() { return cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_0_0_0_1; }

		//targetElement=[aadl2::NamedElement]?
		public Assignment getTargetElementAssignment_3_1_0_1() { return cTargetElementAssignment_3_1_0_1; }

		//[aadl2::NamedElement]
		public CrossReference getTargetElementNamedElementCrossReference_3_1_0_1_0() { return cTargetElementNamedElementCrossReference_3_1_0_1_0; }

		//ID
		public RuleCall getTargetElementNamedElementIDTerminalRuleCall_3_1_0_1_0_1() { return cTargetElementNamedElementIDTerminalRuleCall_3_1_0_1_0_1; }

		//targetElement=[aadl2::NamedElement]
		public Assignment getTargetElementAssignment_3_1_1() { return cTargetElementAssignment_3_1_1; }

		//[aadl2::NamedElement]
		public CrossReference getTargetElementNamedElementCrossReference_3_1_1_0() { return cTargetElementNamedElementCrossReference_3_1_1_0; }

		//ID
		public RuleCall getTargetElementNamedElementIDTerminalRuleCall_3_1_1_0_1() { return cTargetElementNamedElementIDTerminalRuleCall_3_1_1_0_1; }

		//componentCategory+=ComponentCategory+
		public Assignment getComponentCategoryAssignment_3_1_2() { return cComponentCategoryAssignment_3_1_2; }

		//ComponentCategory
		public RuleCall getComponentCategoryComponentCategoryParserRuleCall_3_1_2_0() { return cComponentCategoryComponentCategoryParserRuleCall_3_1_2_0; }

		//global?="all"
		public Assignment getGlobalAssignment_3_1_3() { return cGlobalAssignment_3_1_3; }

		//"all"
		public Keyword getGlobalAllKeyword_3_1_3_0() { return cGlobalAllKeyword_3_1_3_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//("category" category+=[categories::RequirementCategory]+)? // predicate expression 
		////	&('refined' 'to' '['refinedRequirement+=Requirement+ ']')? 
		//& ("quality" category+=[categories::QualityCategory]+)? & ("selection" category+=[categories::SelectionCategory]+)? &
		//description=Description? & constants+=ValDeclaration* & computes+=ComputeDeclaration* & predicate=ReqPredicate? &
		//rationale=Rationale? & changeUncertainty=Uncertainty? & ("mitigates" (exception=[ecore::EObject] |
		//exceptionText=STRING))? & ("refines" refinesReference+=[Requirement|QualifiedName]+)? & ("decomposes"
		//decomposesReference+=[Requirement|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
		//(dropped?="dropped" dropRationale=STRING?)? & ("development" "stakeholder"
		//developmentStakeholder+=[org::Stakeholder|QualifiedName]+)? & ("see" "goal" goalReference+=[Goal|QualifiedName]+)? &
		//("see" "document" "goal" stakeholderRequirementReference+=[Goal|QualifiedName]+)? & ("see" "document" "requirement"
		//documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//("issues" issues+=STRING+)?
		public UnorderedGroup getUnorderedGroup_5() { return cUnorderedGroup_5; }

		//("category" category+=[categories::RequirementCategory]+)?
		public Group getGroup_5_0() { return cGroup_5_0; }

		//"category"
		public Keyword getCategoryKeyword_5_0_0() { return cCategoryKeyword_5_0_0; }

		//category+=[categories::RequirementCategory]+
		public Assignment getCategoryAssignment_5_0_1() { return cCategoryAssignment_5_0_1; }

		//[categories::RequirementCategory]
		public CrossReference getCategoryRequirementCategoryCrossReference_5_0_1_0() { return cCategoryRequirementCategoryCrossReference_5_0_1_0; }

		//ID
		public RuleCall getCategoryRequirementCategoryIDTerminalRuleCall_5_0_1_0_1() { return cCategoryRequirementCategoryIDTerminalRuleCall_5_0_1_0_1; }

		//("quality" category+=[categories::QualityCategory]+)?
		public Group getGroup_5_1() { return cGroup_5_1; }

		//"quality"
		public Keyword getQualityKeyword_5_1_0() { return cQualityKeyword_5_1_0; }

		//category+=[categories::QualityCategory]+
		public Assignment getCategoryAssignment_5_1_1() { return cCategoryAssignment_5_1_1; }

		//[categories::QualityCategory]
		public CrossReference getCategoryQualityCategoryCrossReference_5_1_1_0() { return cCategoryQualityCategoryCrossReference_5_1_1_0; }

		//ID
		public RuleCall getCategoryQualityCategoryIDTerminalRuleCall_5_1_1_0_1() { return cCategoryQualityCategoryIDTerminalRuleCall_5_1_1_0_1; }

		//("selection" category+=[categories::SelectionCategory]+)?
		public Group getGroup_5_2() { return cGroup_5_2; }

		//"selection"
		public Keyword getSelectionKeyword_5_2_0() { return cSelectionKeyword_5_2_0; }

		//category+=[categories::SelectionCategory]+
		public Assignment getCategoryAssignment_5_2_1() { return cCategoryAssignment_5_2_1; }

		//[categories::SelectionCategory]
		public CrossReference getCategorySelectionCategoryCrossReference_5_2_1_0() { return cCategorySelectionCategoryCrossReference_5_2_1_0; }

		//ID
		public RuleCall getCategorySelectionCategoryIDTerminalRuleCall_5_2_1_0_1() { return cCategorySelectionCategoryIDTerminalRuleCall_5_2_1_0_1; }

		//description=Description?
		public Assignment getDescriptionAssignment_5_3() { return cDescriptionAssignment_5_3; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_5_3_0() { return cDescriptionDescriptionParserRuleCall_5_3_0; }

		//constants+=ValDeclaration*
		public Assignment getConstantsAssignment_5_4() { return cConstantsAssignment_5_4; }

		//ValDeclaration
		public RuleCall getConstantsValDeclarationParserRuleCall_5_4_0() { return cConstantsValDeclarationParserRuleCall_5_4_0; }

		//computes+=ComputeDeclaration*
		public Assignment getComputesAssignment_5_5() { return cComputesAssignment_5_5; }

		//ComputeDeclaration
		public RuleCall getComputesComputeDeclarationParserRuleCall_5_5_0() { return cComputesComputeDeclarationParserRuleCall_5_5_0; }

		//predicate=ReqPredicate?
		public Assignment getPredicateAssignment_5_6() { return cPredicateAssignment_5_6; }

		//ReqPredicate
		public RuleCall getPredicateReqPredicateParserRuleCall_5_6_0() { return cPredicateReqPredicateParserRuleCall_5_6_0; }

		//rationale=Rationale?
		public Assignment getRationaleAssignment_5_7() { return cRationaleAssignment_5_7; }

		//Rationale
		public RuleCall getRationaleRationaleParserRuleCall_5_7_0() { return cRationaleRationaleParserRuleCall_5_7_0; }

		//changeUncertainty=Uncertainty?
		public Assignment getChangeUncertaintyAssignment_5_8() { return cChangeUncertaintyAssignment_5_8; }

		//Uncertainty
		public RuleCall getChangeUncertaintyUncertaintyParserRuleCall_5_8_0() { return cChangeUncertaintyUncertaintyParserRuleCall_5_8_0; }

		//("mitigates" (exception=[ecore::EObject] | exceptionText=STRING))?
		public Group getGroup_5_9() { return cGroup_5_9; }

		//"mitigates"
		public Keyword getMitigatesKeyword_5_9_0() { return cMitigatesKeyword_5_9_0; }

		//exception=[ecore::EObject] | exceptionText=STRING
		public Alternatives getAlternatives_5_9_1() { return cAlternatives_5_9_1; }

		//exception=[ecore::EObject]
		public Assignment getExceptionAssignment_5_9_1_0() { return cExceptionAssignment_5_9_1_0; }

		//[ecore::EObject]
		public CrossReference getExceptionEObjectCrossReference_5_9_1_0_0() { return cExceptionEObjectCrossReference_5_9_1_0_0; }

		//ID
		public RuleCall getExceptionEObjectIDTerminalRuleCall_5_9_1_0_0_1() { return cExceptionEObjectIDTerminalRuleCall_5_9_1_0_0_1; }

		//exceptionText=STRING
		public Assignment getExceptionTextAssignment_5_9_1_1() { return cExceptionTextAssignment_5_9_1_1; }

		//STRING
		public RuleCall getExceptionTextSTRINGTerminalRuleCall_5_9_1_1_0() { return cExceptionTextSTRINGTerminalRuleCall_5_9_1_1_0; }

		//("refines" refinesReference+=[Requirement|QualifiedName]+)?
		public Group getGroup_5_10() { return cGroup_5_10; }

		//"refines"
		public Keyword getRefinesKeyword_5_10_0() { return cRefinesKeyword_5_10_0; }

		//refinesReference+=[Requirement|QualifiedName]+
		public Assignment getRefinesReferenceAssignment_5_10_1() { return cRefinesReferenceAssignment_5_10_1; }

		//[Requirement|QualifiedName]
		public CrossReference getRefinesReferenceRequirementCrossReference_5_10_1_0() { return cRefinesReferenceRequirementCrossReference_5_10_1_0; }

		//QualifiedName
		public RuleCall getRefinesReferenceRequirementQualifiedNameParserRuleCall_5_10_1_0_1() { return cRefinesReferenceRequirementQualifiedNameParserRuleCall_5_10_1_0_1; }

		//("decomposes" decomposesReference+=[Requirement|QualifiedName]+)?
		public Group getGroup_5_11() { return cGroup_5_11; }

		//"decomposes"
		public Keyword getDecomposesKeyword_5_11_0() { return cDecomposesKeyword_5_11_0; }

		//decomposesReference+=[Requirement|QualifiedName]+
		public Assignment getDecomposesReferenceAssignment_5_11_1() { return cDecomposesReferenceAssignment_5_11_1; }

		//[Requirement|QualifiedName]
		public CrossReference getDecomposesReferenceRequirementCrossReference_5_11_1_0() { return cDecomposesReferenceRequirementCrossReference_5_11_1_0; }

		//QualifiedName
		public RuleCall getDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_11_1_0_1() { return cDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_11_1_0_1; }

		//("evolves" evolvesReference+=[Requirement|QualifiedName]+)?
		public Group getGroup_5_12() { return cGroup_5_12; }

		//"evolves"
		public Keyword getEvolvesKeyword_5_12_0() { return cEvolvesKeyword_5_12_0; }

		//evolvesReference+=[Requirement|QualifiedName]+
		public Assignment getEvolvesReferenceAssignment_5_12_1() { return cEvolvesReferenceAssignment_5_12_1; }

		//[Requirement|QualifiedName]
		public CrossReference getEvolvesReferenceRequirementCrossReference_5_12_1_0() { return cEvolvesReferenceRequirementCrossReference_5_12_1_0; }

		//QualifiedName
		public RuleCall getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_12_1_0_1() { return cEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_12_1_0_1; }

		//(dropped?="dropped" dropRationale=STRING?)?
		public Group getGroup_5_13() { return cGroup_5_13; }

		//dropped?="dropped"
		public Assignment getDroppedAssignment_5_13_0() { return cDroppedAssignment_5_13_0; }

		//"dropped"
		public Keyword getDroppedDroppedKeyword_5_13_0_0() { return cDroppedDroppedKeyword_5_13_0_0; }

		//dropRationale=STRING?
		public Assignment getDropRationaleAssignment_5_13_1() { return cDropRationaleAssignment_5_13_1; }

		//STRING
		public RuleCall getDropRationaleSTRINGTerminalRuleCall_5_13_1_0() { return cDropRationaleSTRINGTerminalRuleCall_5_13_1_0; }

		//("development" "stakeholder" developmentStakeholder+=[org::Stakeholder|QualifiedName]+)?
		public Group getGroup_5_14() { return cGroup_5_14; }

		//"development"
		public Keyword getDevelopmentKeyword_5_14_0() { return cDevelopmentKeyword_5_14_0; }

		//"stakeholder"
		public Keyword getStakeholderKeyword_5_14_1() { return cStakeholderKeyword_5_14_1; }

		//developmentStakeholder+=[org::Stakeholder|QualifiedName]+
		public Assignment getDevelopmentStakeholderAssignment_5_14_2() { return cDevelopmentStakeholderAssignment_5_14_2; }

		//[org::Stakeholder|QualifiedName]
		public CrossReference getDevelopmentStakeholderStakeholderCrossReference_5_14_2_0() { return cDevelopmentStakeholderStakeholderCrossReference_5_14_2_0; }

		//QualifiedName
		public RuleCall getDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_14_2_0_1() { return cDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_14_2_0_1; }

		//("see" "goal" goalReference+=[Goal|QualifiedName]+)?
		public Group getGroup_5_15() { return cGroup_5_15; }

		//"see"
		public Keyword getSeeKeyword_5_15_0() { return cSeeKeyword_5_15_0; }

		//"goal"
		public Keyword getGoalKeyword_5_15_1() { return cGoalKeyword_5_15_1; }

		//goalReference+=[Goal|QualifiedName]+
		public Assignment getGoalReferenceAssignment_5_15_2() { return cGoalReferenceAssignment_5_15_2; }

		//[Goal|QualifiedName]
		public CrossReference getGoalReferenceGoalCrossReference_5_15_2_0() { return cGoalReferenceGoalCrossReference_5_15_2_0; }

		//QualifiedName
		public RuleCall getGoalReferenceGoalQualifiedNameParserRuleCall_5_15_2_0_1() { return cGoalReferenceGoalQualifiedNameParserRuleCall_5_15_2_0_1; }

		//("see" "document" "goal" stakeholderRequirementReference+=[Goal|QualifiedName]+)?
		public Group getGroup_5_16() { return cGroup_5_16; }

		//"see"
		public Keyword getSeeKeyword_5_16_0() { return cSeeKeyword_5_16_0; }

		//"document"
		public Keyword getDocumentKeyword_5_16_1() { return cDocumentKeyword_5_16_1; }

		//"goal"
		public Keyword getGoalKeyword_5_16_2() { return cGoalKeyword_5_16_2; }

		//stakeholderRequirementReference+=[Goal|QualifiedName]+
		public Assignment getStakeholderRequirementReferenceAssignment_5_16_3() { return cStakeholderRequirementReferenceAssignment_5_16_3; }

		//[Goal|QualifiedName]
		public CrossReference getStakeholderRequirementReferenceGoalCrossReference_5_16_3_0() { return cStakeholderRequirementReferenceGoalCrossReference_5_16_3_0; }

		//QualifiedName
		public RuleCall getStakeholderRequirementReferenceGoalQualifiedNameParserRuleCall_5_16_3_0_1() { return cStakeholderRequirementReferenceGoalQualifiedNameParserRuleCall_5_16_3_0_1; }

		//("see" "document" "requirement" documentRequirement+=[ContractualElement|QualifiedName]+)?
		public Group getGroup_5_17() { return cGroup_5_17; }

		//"see"
		public Keyword getSeeKeyword_5_17_0() { return cSeeKeyword_5_17_0; }

		//"document"
		public Keyword getDocumentKeyword_5_17_1() { return cDocumentKeyword_5_17_1; }

		//"requirement"
		public Keyword getRequirementKeyword_5_17_2() { return cRequirementKeyword_5_17_2; }

		//documentRequirement+=[ContractualElement|QualifiedName]+
		public Assignment getDocumentRequirementAssignment_5_17_3() { return cDocumentRequirementAssignment_5_17_3; }

		//[ContractualElement|QualifiedName]
		public CrossReference getDocumentRequirementContractualElementCrossReference_5_17_3_0() { return cDocumentRequirementContractualElementCrossReference_5_17_3_0; }

		//QualifiedName
		public RuleCall getDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_17_3_0_1() { return cDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_17_3_0_1; }

		//("see" "document" docReference+=ExternalDocument+)?
		public Group getGroup_5_18() { return cGroup_5_18; }

		//"see"
		public Keyword getSeeKeyword_5_18_0() { return cSeeKeyword_5_18_0; }

		//"document"
		public Keyword getDocumentKeyword_5_18_1() { return cDocumentKeyword_5_18_1; }

		//docReference+=ExternalDocument+
		public Assignment getDocReferenceAssignment_5_18_2() { return cDocReferenceAssignment_5_18_2; }

		//ExternalDocument
		public RuleCall getDocReferenceExternalDocumentParserRuleCall_5_18_2_0() { return cDocReferenceExternalDocumentParserRuleCall_5_18_2_0; }

		//("issues" issues+=STRING+)?
		public Group getGroup_5_19() { return cGroup_5_19; }

		//"issues"
		public Keyword getIssuesKeyword_5_19_0() { return cIssuesKeyword_5_19_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_5_19_1() { return cIssuesAssignment_5_19_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_5_19_1_0() { return cIssuesSTRINGTerminalRuleCall_5_19_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class DocRequirementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DocRequirement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRequirementKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTitleAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cTitleAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cForKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Alternatives cAlternatives_3_1 = (Alternatives)cGroup_3.eContents().get(1);
		private final Assignment cTargetDescriptionAssignment_3_1_0 = (Assignment)cAlternatives_3_1.eContents().get(0);
		private final RuleCall cTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0 = (RuleCall)cTargetDescriptionAssignment_3_1_0.eContents().get(0);
		private final Group cGroup_3_1_1 = (Group)cAlternatives_3_1.eContents().get(1);
		private final Assignment cTargetAssignment_3_1_1_0 = (Assignment)cGroup_3_1_1.eContents().get(0);
		private final CrossReference cTargetComponentClassifierCrossReference_3_1_1_0_0 = (CrossReference)cTargetAssignment_3_1_1_0.eContents().get(0);
		private final RuleCall cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_1_0_0_1 = (RuleCall)cTargetComponentClassifierCrossReference_3_1_1_0_0.eContents().get(1);
		private final Assignment cTargetElementAssignment_3_1_1_1 = (Assignment)cGroup_3_1_1.eContents().get(1);
		private final CrossReference cTargetElementNamedElementCrossReference_3_1_1_1_0 = (CrossReference)cTargetElementAssignment_3_1_1_1.eContents().get(0);
		private final RuleCall cTargetElementNamedElementIDTerminalRuleCall_3_1_1_1_0_1 = (RuleCall)cTargetElementNamedElementCrossReference_3_1_1_1_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final UnorderedGroup cUnorderedGroup_5 = (UnorderedGroup)cGroup.eContents().get(5);
		private final Group cGroup_5_0 = (Group)cUnorderedGroup_5.eContents().get(0);
		private final Keyword cCategoryKeyword_5_0_0 = (Keyword)cGroup_5_0.eContents().get(0);
		private final Assignment cCategoryAssignment_5_0_1 = (Assignment)cGroup_5_0.eContents().get(1);
		private final CrossReference cCategoryCategoryCrossReference_5_0_1_0 = (CrossReference)cCategoryAssignment_5_0_1.eContents().get(0);
		private final RuleCall cCategoryCategoryIDTerminalRuleCall_5_0_1_0_1 = (RuleCall)cCategoryCategoryCrossReference_5_0_1_0.eContents().get(1);
		private final Assignment cDescriptionAssignment_5_1 = (Assignment)cUnorderedGroup_5.eContents().get(1);
		private final RuleCall cDescriptionDescriptionParserRuleCall_5_1_0 = (RuleCall)cDescriptionAssignment_5_1.eContents().get(0);
		private final Assignment cConstantsAssignment_5_2 = (Assignment)cUnorderedGroup_5.eContents().get(2);
		private final RuleCall cConstantsValDeclarationParserRuleCall_5_2_0 = (RuleCall)cConstantsAssignment_5_2.eContents().get(0);
		private final Assignment cComputesAssignment_5_3 = (Assignment)cUnorderedGroup_5.eContents().get(3);
		private final RuleCall cComputesComputeDeclarationParserRuleCall_5_3_0 = (RuleCall)cComputesAssignment_5_3.eContents().get(0);
		private final Assignment cPredicateAssignment_5_4 = (Assignment)cUnorderedGroup_5.eContents().get(4);
		private final RuleCall cPredicateReqPredicateParserRuleCall_5_4_0 = (RuleCall)cPredicateAssignment_5_4.eContents().get(0);
		private final Assignment cRationaleAssignment_5_5 = (Assignment)cUnorderedGroup_5.eContents().get(5);
		private final RuleCall cRationaleRationaleParserRuleCall_5_5_0 = (RuleCall)cRationaleAssignment_5_5.eContents().get(0);
		private final Assignment cChangeUncertaintyAssignment_5_6 = (Assignment)cUnorderedGroup_5.eContents().get(6);
		private final RuleCall cChangeUncertaintyUncertaintyParserRuleCall_5_6_0 = (RuleCall)cChangeUncertaintyAssignment_5_6.eContents().get(0);
		private final Group cGroup_5_7 = (Group)cUnorderedGroup_5.eContents().get(7);
		private final Keyword cMitigatesKeyword_5_7_0 = (Keyword)cGroup_5_7.eContents().get(0);
		private final Alternatives cAlternatives_5_7_1 = (Alternatives)cGroup_5_7.eContents().get(1);
		private final Assignment cExceptionAssignment_5_7_1_0 = (Assignment)cAlternatives_5_7_1.eContents().get(0);
		private final CrossReference cExceptionEObjectCrossReference_5_7_1_0_0 = (CrossReference)cExceptionAssignment_5_7_1_0.eContents().get(0);
		private final RuleCall cExceptionEObjectIDTerminalRuleCall_5_7_1_0_0_1 = (RuleCall)cExceptionEObjectCrossReference_5_7_1_0_0.eContents().get(1);
		private final Assignment cExceptionTextAssignment_5_7_1_1 = (Assignment)cAlternatives_5_7_1.eContents().get(1);
		private final RuleCall cExceptionTextSTRINGTerminalRuleCall_5_7_1_1_0 = (RuleCall)cExceptionTextAssignment_5_7_1_1.eContents().get(0);
		private final Group cGroup_5_8 = (Group)cUnorderedGroup_5.eContents().get(8);
		private final Keyword cRefinesKeyword_5_8_0 = (Keyword)cGroup_5_8.eContents().get(0);
		private final Assignment cRefinesReferenceAssignment_5_8_1 = (Assignment)cGroup_5_8.eContents().get(1);
		private final CrossReference cRefinesReferenceRequirementCrossReference_5_8_1_0 = (CrossReference)cRefinesReferenceAssignment_5_8_1.eContents().get(0);
		private final RuleCall cRefinesReferenceRequirementQualifiedNameParserRuleCall_5_8_1_0_1 = (RuleCall)cRefinesReferenceRequirementCrossReference_5_8_1_0.eContents().get(1);
		private final Group cGroup_5_9 = (Group)cUnorderedGroup_5.eContents().get(9);
		private final Keyword cDecomposesKeyword_5_9_0 = (Keyword)cGroup_5_9.eContents().get(0);
		private final Assignment cDecomposesReferenceAssignment_5_9_1 = (Assignment)cGroup_5_9.eContents().get(1);
		private final CrossReference cDecomposesReferenceRequirementCrossReference_5_9_1_0 = (CrossReference)cDecomposesReferenceAssignment_5_9_1.eContents().get(0);
		private final RuleCall cDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_9_1_0_1 = (RuleCall)cDecomposesReferenceRequirementCrossReference_5_9_1_0.eContents().get(1);
		private final Group cGroup_5_10 = (Group)cUnorderedGroup_5.eContents().get(10);
		private final Keyword cEvolvesKeyword_5_10_0 = (Keyword)cGroup_5_10.eContents().get(0);
		private final Assignment cEvolvesReferenceAssignment_5_10_1 = (Assignment)cGroup_5_10.eContents().get(1);
		private final CrossReference cEvolvesReferenceRequirementCrossReference_5_10_1_0 = (CrossReference)cEvolvesReferenceAssignment_5_10_1.eContents().get(0);
		private final RuleCall cEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_10_1_0_1 = (RuleCall)cEvolvesReferenceRequirementCrossReference_5_10_1_0.eContents().get(1);
		private final Group cGroup_5_11 = (Group)cUnorderedGroup_5.eContents().get(11);
		private final Assignment cDroppedAssignment_5_11_0 = (Assignment)cGroup_5_11.eContents().get(0);
		private final Keyword cDroppedDroppedKeyword_5_11_0_0 = (Keyword)cDroppedAssignment_5_11_0.eContents().get(0);
		private final Assignment cDropRationaleAssignment_5_11_1 = (Assignment)cGroup_5_11.eContents().get(1);
		private final RuleCall cDropRationaleSTRINGTerminalRuleCall_5_11_1_0 = (RuleCall)cDropRationaleAssignment_5_11_1.eContents().get(0);
		private final Group cGroup_5_12 = (Group)cUnorderedGroup_5.eContents().get(12);
		private final Keyword cDevelopmentKeyword_5_12_0 = (Keyword)cGroup_5_12.eContents().get(0);
		private final Keyword cStakeholderKeyword_5_12_1 = (Keyword)cGroup_5_12.eContents().get(1);
		private final Assignment cDevelopmentStakeholderAssignment_5_12_2 = (Assignment)cGroup_5_12.eContents().get(2);
		private final CrossReference cDevelopmentStakeholderStakeholderCrossReference_5_12_2_0 = (CrossReference)cDevelopmentStakeholderAssignment_5_12_2.eContents().get(0);
		private final RuleCall cDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_12_2_0_1 = (RuleCall)cDevelopmentStakeholderStakeholderCrossReference_5_12_2_0.eContents().get(1);
		private final Group cGroup_5_13 = (Group)cUnorderedGroup_5.eContents().get(13);
		private final Keyword cSeeKeyword_5_13_0 = (Keyword)cGroup_5_13.eContents().get(0);
		private final Keyword cGoalKeyword_5_13_1 = (Keyword)cGroup_5_13.eContents().get(1);
		private final Assignment cGoalReferenceAssignment_5_13_2 = (Assignment)cGroup_5_13.eContents().get(2);
		private final CrossReference cGoalReferenceGoalCrossReference_5_13_2_0 = (CrossReference)cGoalReferenceAssignment_5_13_2.eContents().get(0);
		private final RuleCall cGoalReferenceGoalQualifiedNameParserRuleCall_5_13_2_0_1 = (RuleCall)cGoalReferenceGoalCrossReference_5_13_2_0.eContents().get(1);
		private final Group cGroup_5_14 = (Group)cUnorderedGroup_5.eContents().get(14);
		private final Keyword cSeeKeyword_5_14_0 = (Keyword)cGroup_5_14.eContents().get(0);
		private final Keyword cDocumentKeyword_5_14_1 = (Keyword)cGroup_5_14.eContents().get(1);
		private final Keyword cGoalKeyword_5_14_2 = (Keyword)cGroup_5_14.eContents().get(2);
		private final Assignment cStakeholderRequirementReferenceAssignment_5_14_3 = (Assignment)cGroup_5_14.eContents().get(3);
		private final CrossReference cStakeholderRequirementReferenceGoalCrossReference_5_14_3_0 = (CrossReference)cStakeholderRequirementReferenceAssignment_5_14_3.eContents().get(0);
		private final RuleCall cStakeholderRequirementReferenceGoalQualifiedNameParserRuleCall_5_14_3_0_1 = (RuleCall)cStakeholderRequirementReferenceGoalCrossReference_5_14_3_0.eContents().get(1);
		private final Group cGroup_5_15 = (Group)cUnorderedGroup_5.eContents().get(15);
		private final Keyword cSeeKeyword_5_15_0 = (Keyword)cGroup_5_15.eContents().get(0);
		private final Keyword cDocumentKeyword_5_15_1 = (Keyword)cGroup_5_15.eContents().get(1);
		private final Keyword cRequirementKeyword_5_15_2 = (Keyword)cGroup_5_15.eContents().get(2);
		private final Assignment cDocumentRequirementAssignment_5_15_3 = (Assignment)cGroup_5_15.eContents().get(3);
		private final CrossReference cDocumentRequirementContractualElementCrossReference_5_15_3_0 = (CrossReference)cDocumentRequirementAssignment_5_15_3.eContents().get(0);
		private final RuleCall cDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_15_3_0_1 = (RuleCall)cDocumentRequirementContractualElementCrossReference_5_15_3_0.eContents().get(1);
		private final Group cGroup_5_16 = (Group)cUnorderedGroup_5.eContents().get(16);
		private final Keyword cSeeKeyword_5_16_0 = (Keyword)cGroup_5_16.eContents().get(0);
		private final Keyword cDocumentKeyword_5_16_1 = (Keyword)cGroup_5_16.eContents().get(1);
		private final Assignment cDocReferenceAssignment_5_16_2 = (Assignment)cGroup_5_16.eContents().get(2);
		private final RuleCall cDocReferenceExternalDocumentParserRuleCall_5_16_2_0 = (RuleCall)cDocReferenceAssignment_5_16_2.eContents().get(0);
		private final Group cGroup_5_17 = (Group)cUnorderedGroup_5.eContents().get(17);
		private final Keyword cIssuesKeyword_5_17_0 = (Keyword)cGroup_5_17.eContents().get(0);
		private final Assignment cIssuesAssignment_5_17_1 = (Assignment)cGroup_5_17.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_5_17_1_0 = (RuleCall)cIssuesAssignment_5_17_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//DocRequirement returns Requirement:
		//	"requirement" name=ID (":" title=STRING)? ("for" (targetDescription=STRING |
		//	target=[aadl2::ComponentClassifier|AadlClassifierReference] targetElement=[aadl2::NamedElement]?))? "[" (("category"
		//	category+=[categories::Category]+)? // predicate expression 
		//	& description=Description? & constants+=ValDeclaration* & computes+=ComputeDeclaration* & predicate=ReqPredicate? &
		//	rationale=Rationale? & changeUncertainty=Uncertainty? & ("mitigates" (exception=[ecore::EObject] |
		//	exceptionText=STRING))? & ("refines" refinesReference+=[Requirement|QualifiedName]+)? & ("decomposes"
		//	decomposesReference+=[Requirement|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
		//	(dropped?="dropped" dropRationale=STRING?)? & ("development" "stakeholder"
		//	developmentStakeholder+=[org::Stakeholder|QualifiedName]+)? & ("see" "goal" goalReference+=[Goal|QualifiedName]+)? &
		//	("see" "document" "goal" stakeholderRequirementReference+=[Goal|QualifiedName]+)? & ("see" "document" "requirement"
		//	documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//	("issues" issues+=STRING+)?) "]";
		@Override public ParserRule getRule() { return rule; }

		//"requirement" name=ID (":" title=STRING)? ("for" (targetDescription=STRING |
		//target=[aadl2::ComponentClassifier|AadlClassifierReference] targetElement=[aadl2::NamedElement]?))? "[" (("category"
		//category+=[categories::Category]+)? // predicate expression 
		//& description=Description? & constants+=ValDeclaration* & computes+=ComputeDeclaration* & predicate=ReqPredicate? &
		//rationale=Rationale? & changeUncertainty=Uncertainty? & ("mitigates" (exception=[ecore::EObject] |
		//exceptionText=STRING))? & ("refines" refinesReference+=[Requirement|QualifiedName]+)? & ("decomposes"
		//decomposesReference+=[Requirement|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
		//(dropped?="dropped" dropRationale=STRING?)? & ("development" "stakeholder"
		//developmentStakeholder+=[org::Stakeholder|QualifiedName]+)? & ("see" "goal" goalReference+=[Goal|QualifiedName]+)? &
		//("see" "document" "goal" stakeholderRequirementReference+=[Goal|QualifiedName]+)? & ("see" "document" "requirement"
		//documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//("issues" issues+=STRING+)?) "]"
		public Group getGroup() { return cGroup; }

		//"requirement"
		public Keyword getRequirementKeyword_0() { return cRequirementKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//(":" title=STRING)?
		public Group getGroup_2() { return cGroup_2; }

		//":"
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//title=STRING
		public Assignment getTitleAssignment_2_1() { return cTitleAssignment_2_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_2_1_0() { return cTitleSTRINGTerminalRuleCall_2_1_0; }

		//("for" (targetDescription=STRING | target=[aadl2::ComponentClassifier|AadlClassifierReference]
		//targetElement=[aadl2::NamedElement]?))?
		public Group getGroup_3() { return cGroup_3; }

		//"for"
		public Keyword getForKeyword_3_0() { return cForKeyword_3_0; }

		//targetDescription=STRING | target=[aadl2::ComponentClassifier|AadlClassifierReference]
		//targetElement=[aadl2::NamedElement]?
		public Alternatives getAlternatives_3_1() { return cAlternatives_3_1; }

		//targetDescription=STRING
		public Assignment getTargetDescriptionAssignment_3_1_0() { return cTargetDescriptionAssignment_3_1_0; }

		//STRING
		public RuleCall getTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0() { return cTargetDescriptionSTRINGTerminalRuleCall_3_1_0_0; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference] targetElement=[aadl2::NamedElement]?
		public Group getGroup_3_1_1() { return cGroup_3_1_1; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference]
		public Assignment getTargetAssignment_3_1_1_0() { return cTargetAssignment_3_1_1_0; }

		//[aadl2::ComponentClassifier|AadlClassifierReference]
		public CrossReference getTargetComponentClassifierCrossReference_3_1_1_0_0() { return cTargetComponentClassifierCrossReference_3_1_1_0_0; }

		//AadlClassifierReference
		public RuleCall getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_1_0_0_1() { return cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_3_1_1_0_0_1; }

		//targetElement=[aadl2::NamedElement]?
		public Assignment getTargetElementAssignment_3_1_1_1() { return cTargetElementAssignment_3_1_1_1; }

		//[aadl2::NamedElement]
		public CrossReference getTargetElementNamedElementCrossReference_3_1_1_1_0() { return cTargetElementNamedElementCrossReference_3_1_1_1_0; }

		//ID
		public RuleCall getTargetElementNamedElementIDTerminalRuleCall_3_1_1_1_0_1() { return cTargetElementNamedElementIDTerminalRuleCall_3_1_1_1_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//("category" category+=[categories::Category]+)? // predicate expression 
		//& description=Description? & constants+=ValDeclaration* & computes+=ComputeDeclaration* & predicate=ReqPredicate? &
		//rationale=Rationale? & changeUncertainty=Uncertainty? & ("mitigates" (exception=[ecore::EObject] |
		//exceptionText=STRING))? & ("refines" refinesReference+=[Requirement|QualifiedName]+)? & ("decomposes"
		//decomposesReference+=[Requirement|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
		//(dropped?="dropped" dropRationale=STRING?)? & ("development" "stakeholder"
		//developmentStakeholder+=[org::Stakeholder|QualifiedName]+)? & ("see" "goal" goalReference+=[Goal|QualifiedName]+)? &
		//("see" "document" "goal" stakeholderRequirementReference+=[Goal|QualifiedName]+)? & ("see" "document" "requirement"
		//documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
		//("issues" issues+=STRING+)?
		public UnorderedGroup getUnorderedGroup_5() { return cUnorderedGroup_5; }

		//("category" category+=[categories::Category]+)?
		public Group getGroup_5_0() { return cGroup_5_0; }

		//"category"
		public Keyword getCategoryKeyword_5_0_0() { return cCategoryKeyword_5_0_0; }

		//category+=[categories::Category]+
		public Assignment getCategoryAssignment_5_0_1() { return cCategoryAssignment_5_0_1; }

		//[categories::Category]
		public CrossReference getCategoryCategoryCrossReference_5_0_1_0() { return cCategoryCategoryCrossReference_5_0_1_0; }

		//ID
		public RuleCall getCategoryCategoryIDTerminalRuleCall_5_0_1_0_1() { return cCategoryCategoryIDTerminalRuleCall_5_0_1_0_1; }

		//description=Description?
		public Assignment getDescriptionAssignment_5_1() { return cDescriptionAssignment_5_1; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_5_1_0() { return cDescriptionDescriptionParserRuleCall_5_1_0; }

		//constants+=ValDeclaration*
		public Assignment getConstantsAssignment_5_2() { return cConstantsAssignment_5_2; }

		//ValDeclaration
		public RuleCall getConstantsValDeclarationParserRuleCall_5_2_0() { return cConstantsValDeclarationParserRuleCall_5_2_0; }

		//computes+=ComputeDeclaration*
		public Assignment getComputesAssignment_5_3() { return cComputesAssignment_5_3; }

		//ComputeDeclaration
		public RuleCall getComputesComputeDeclarationParserRuleCall_5_3_0() { return cComputesComputeDeclarationParserRuleCall_5_3_0; }

		//predicate=ReqPredicate?
		public Assignment getPredicateAssignment_5_4() { return cPredicateAssignment_5_4; }

		//ReqPredicate
		public RuleCall getPredicateReqPredicateParserRuleCall_5_4_0() { return cPredicateReqPredicateParserRuleCall_5_4_0; }

		//rationale=Rationale?
		public Assignment getRationaleAssignment_5_5() { return cRationaleAssignment_5_5; }

		//Rationale
		public RuleCall getRationaleRationaleParserRuleCall_5_5_0() { return cRationaleRationaleParserRuleCall_5_5_0; }

		//changeUncertainty=Uncertainty?
		public Assignment getChangeUncertaintyAssignment_5_6() { return cChangeUncertaintyAssignment_5_6; }

		//Uncertainty
		public RuleCall getChangeUncertaintyUncertaintyParserRuleCall_5_6_0() { return cChangeUncertaintyUncertaintyParserRuleCall_5_6_0; }

		//("mitigates" (exception=[ecore::EObject] | exceptionText=STRING))?
		public Group getGroup_5_7() { return cGroup_5_7; }

		//"mitigates"
		public Keyword getMitigatesKeyword_5_7_0() { return cMitigatesKeyword_5_7_0; }

		//exception=[ecore::EObject] | exceptionText=STRING
		public Alternatives getAlternatives_5_7_1() { return cAlternatives_5_7_1; }

		//exception=[ecore::EObject]
		public Assignment getExceptionAssignment_5_7_1_0() { return cExceptionAssignment_5_7_1_0; }

		//[ecore::EObject]
		public CrossReference getExceptionEObjectCrossReference_5_7_1_0_0() { return cExceptionEObjectCrossReference_5_7_1_0_0; }

		//ID
		public RuleCall getExceptionEObjectIDTerminalRuleCall_5_7_1_0_0_1() { return cExceptionEObjectIDTerminalRuleCall_5_7_1_0_0_1; }

		//exceptionText=STRING
		public Assignment getExceptionTextAssignment_5_7_1_1() { return cExceptionTextAssignment_5_7_1_1; }

		//STRING
		public RuleCall getExceptionTextSTRINGTerminalRuleCall_5_7_1_1_0() { return cExceptionTextSTRINGTerminalRuleCall_5_7_1_1_0; }

		//("refines" refinesReference+=[Requirement|QualifiedName]+)?
		public Group getGroup_5_8() { return cGroup_5_8; }

		//"refines"
		public Keyword getRefinesKeyword_5_8_0() { return cRefinesKeyword_5_8_0; }

		//refinesReference+=[Requirement|QualifiedName]+
		public Assignment getRefinesReferenceAssignment_5_8_1() { return cRefinesReferenceAssignment_5_8_1; }

		//[Requirement|QualifiedName]
		public CrossReference getRefinesReferenceRequirementCrossReference_5_8_1_0() { return cRefinesReferenceRequirementCrossReference_5_8_1_0; }

		//QualifiedName
		public RuleCall getRefinesReferenceRequirementQualifiedNameParserRuleCall_5_8_1_0_1() { return cRefinesReferenceRequirementQualifiedNameParserRuleCall_5_8_1_0_1; }

		//("decomposes" decomposesReference+=[Requirement|QualifiedName]+)?
		public Group getGroup_5_9() { return cGroup_5_9; }

		//"decomposes"
		public Keyword getDecomposesKeyword_5_9_0() { return cDecomposesKeyword_5_9_0; }

		//decomposesReference+=[Requirement|QualifiedName]+
		public Assignment getDecomposesReferenceAssignment_5_9_1() { return cDecomposesReferenceAssignment_5_9_1; }

		//[Requirement|QualifiedName]
		public CrossReference getDecomposesReferenceRequirementCrossReference_5_9_1_0() { return cDecomposesReferenceRequirementCrossReference_5_9_1_0; }

		//QualifiedName
		public RuleCall getDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_9_1_0_1() { return cDecomposesReferenceRequirementQualifiedNameParserRuleCall_5_9_1_0_1; }

		//("evolves" evolvesReference+=[Requirement|QualifiedName]+)?
		public Group getGroup_5_10() { return cGroup_5_10; }

		//"evolves"
		public Keyword getEvolvesKeyword_5_10_0() { return cEvolvesKeyword_5_10_0; }

		//evolvesReference+=[Requirement|QualifiedName]+
		public Assignment getEvolvesReferenceAssignment_5_10_1() { return cEvolvesReferenceAssignment_5_10_1; }

		//[Requirement|QualifiedName]
		public CrossReference getEvolvesReferenceRequirementCrossReference_5_10_1_0() { return cEvolvesReferenceRequirementCrossReference_5_10_1_0; }

		//QualifiedName
		public RuleCall getEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_10_1_0_1() { return cEvolvesReferenceRequirementQualifiedNameParserRuleCall_5_10_1_0_1; }

		//(dropped?="dropped" dropRationale=STRING?)?
		public Group getGroup_5_11() { return cGroup_5_11; }

		//dropped?="dropped"
		public Assignment getDroppedAssignment_5_11_0() { return cDroppedAssignment_5_11_0; }

		//"dropped"
		public Keyword getDroppedDroppedKeyword_5_11_0_0() { return cDroppedDroppedKeyword_5_11_0_0; }

		//dropRationale=STRING?
		public Assignment getDropRationaleAssignment_5_11_1() { return cDropRationaleAssignment_5_11_1; }

		//STRING
		public RuleCall getDropRationaleSTRINGTerminalRuleCall_5_11_1_0() { return cDropRationaleSTRINGTerminalRuleCall_5_11_1_0; }

		//("development" "stakeholder" developmentStakeholder+=[org::Stakeholder|QualifiedName]+)?
		public Group getGroup_5_12() { return cGroup_5_12; }

		//"development"
		public Keyword getDevelopmentKeyword_5_12_0() { return cDevelopmentKeyword_5_12_0; }

		//"stakeholder"
		public Keyword getStakeholderKeyword_5_12_1() { return cStakeholderKeyword_5_12_1; }

		//developmentStakeholder+=[org::Stakeholder|QualifiedName]+
		public Assignment getDevelopmentStakeholderAssignment_5_12_2() { return cDevelopmentStakeholderAssignment_5_12_2; }

		//[org::Stakeholder|QualifiedName]
		public CrossReference getDevelopmentStakeholderStakeholderCrossReference_5_12_2_0() { return cDevelopmentStakeholderStakeholderCrossReference_5_12_2_0; }

		//QualifiedName
		public RuleCall getDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_12_2_0_1() { return cDevelopmentStakeholderStakeholderQualifiedNameParserRuleCall_5_12_2_0_1; }

		//("see" "goal" goalReference+=[Goal|QualifiedName]+)?
		public Group getGroup_5_13() { return cGroup_5_13; }

		//"see"
		public Keyword getSeeKeyword_5_13_0() { return cSeeKeyword_5_13_0; }

		//"goal"
		public Keyword getGoalKeyword_5_13_1() { return cGoalKeyword_5_13_1; }

		//goalReference+=[Goal|QualifiedName]+
		public Assignment getGoalReferenceAssignment_5_13_2() { return cGoalReferenceAssignment_5_13_2; }

		//[Goal|QualifiedName]
		public CrossReference getGoalReferenceGoalCrossReference_5_13_2_0() { return cGoalReferenceGoalCrossReference_5_13_2_0; }

		//QualifiedName
		public RuleCall getGoalReferenceGoalQualifiedNameParserRuleCall_5_13_2_0_1() { return cGoalReferenceGoalQualifiedNameParserRuleCall_5_13_2_0_1; }

		//("see" "document" "goal" stakeholderRequirementReference+=[Goal|QualifiedName]+)?
		public Group getGroup_5_14() { return cGroup_5_14; }

		//"see"
		public Keyword getSeeKeyword_5_14_0() { return cSeeKeyword_5_14_0; }

		//"document"
		public Keyword getDocumentKeyword_5_14_1() { return cDocumentKeyword_5_14_1; }

		//"goal"
		public Keyword getGoalKeyword_5_14_2() { return cGoalKeyword_5_14_2; }

		//stakeholderRequirementReference+=[Goal|QualifiedName]+
		public Assignment getStakeholderRequirementReferenceAssignment_5_14_3() { return cStakeholderRequirementReferenceAssignment_5_14_3; }

		//[Goal|QualifiedName]
		public CrossReference getStakeholderRequirementReferenceGoalCrossReference_5_14_3_0() { return cStakeholderRequirementReferenceGoalCrossReference_5_14_3_0; }

		//QualifiedName
		public RuleCall getStakeholderRequirementReferenceGoalQualifiedNameParserRuleCall_5_14_3_0_1() { return cStakeholderRequirementReferenceGoalQualifiedNameParserRuleCall_5_14_3_0_1; }

		//("see" "document" "requirement" documentRequirement+=[ContractualElement|QualifiedName]+)?
		public Group getGroup_5_15() { return cGroup_5_15; }

		//"see"
		public Keyword getSeeKeyword_5_15_0() { return cSeeKeyword_5_15_0; }

		//"document"
		public Keyword getDocumentKeyword_5_15_1() { return cDocumentKeyword_5_15_1; }

		//"requirement"
		public Keyword getRequirementKeyword_5_15_2() { return cRequirementKeyword_5_15_2; }

		//documentRequirement+=[ContractualElement|QualifiedName]+
		public Assignment getDocumentRequirementAssignment_5_15_3() { return cDocumentRequirementAssignment_5_15_3; }

		//[ContractualElement|QualifiedName]
		public CrossReference getDocumentRequirementContractualElementCrossReference_5_15_3_0() { return cDocumentRequirementContractualElementCrossReference_5_15_3_0; }

		//QualifiedName
		public RuleCall getDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_15_3_0_1() { return cDocumentRequirementContractualElementQualifiedNameParserRuleCall_5_15_3_0_1; }

		//("see" "document" docReference+=ExternalDocument+)?
		public Group getGroup_5_16() { return cGroup_5_16; }

		//"see"
		public Keyword getSeeKeyword_5_16_0() { return cSeeKeyword_5_16_0; }

		//"document"
		public Keyword getDocumentKeyword_5_16_1() { return cDocumentKeyword_5_16_1; }

		//docReference+=ExternalDocument+
		public Assignment getDocReferenceAssignment_5_16_2() { return cDocReferenceAssignment_5_16_2; }

		//ExternalDocument
		public RuleCall getDocReferenceExternalDocumentParserRuleCall_5_16_2_0() { return cDocReferenceExternalDocumentParserRuleCall_5_16_2_0; }

		//("issues" issues+=STRING+)?
		public Group getGroup_5_17() { return cGroup_5_17; }

		//"issues"
		public Keyword getIssuesKeyword_5_17_0() { return cIssuesKeyword_5_17_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_5_17_1() { return cIssuesAssignment_5_17_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_5_17_1_0() { return cIssuesSTRINGTerminalRuleCall_5_17_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class ReqPredicateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ReqPredicate");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cInformalPredicateParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cPredicateParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cValuePredicateParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//// | InputAssumption | OutputGuarantee| BehaviorEquation;
		//ReqPredicate:
		//	InformalPredicate | Predicate | ValuePredicate;
		@Override public ParserRule getRule() { return rule; }

		//InformalPredicate | Predicate | ValuePredicate
		public Alternatives getAlternatives() { return cAlternatives; }

		//InformalPredicate
		public RuleCall getInformalPredicateParserRuleCall_0() { return cInformalPredicateParserRuleCall_0; }

		//Predicate
		public RuleCall getPredicateParserRuleCall_1() { return cPredicateParserRuleCall_1; }

		//ValuePredicate
		public RuleCall getValuePredicateParserRuleCall_2() { return cValuePredicateParserRuleCall_2; }
	}

	public class InformalPredicateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InformalPredicate");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInformalKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cPredicateKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cDescriptionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cDescriptionSTRINGTerminalRuleCall_2_0 = (RuleCall)cDescriptionAssignment_2.eContents().get(0);
		
		//InformalPredicate:
		//	"informal" "predicate" description=STRING;
		@Override public ParserRule getRule() { return rule; }

		//"informal" "predicate" description=STRING
		public Group getGroup() { return cGroup; }

		//"informal"
		public Keyword getInformalKeyword_0() { return cInformalKeyword_0; }

		//"predicate"
		public Keyword getPredicateKeyword_1() { return cPredicateKeyword_1; }

		//description=STRING
		public Assignment getDescriptionAssignment_2() { return cDescriptionAssignment_2; }

		//STRING
		public RuleCall getDescriptionSTRINGTerminalRuleCall_2_0() { return cDescriptionSTRINGTerminalRuleCall_2_0; }
	}

	public class PredicateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Predicate");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPredicateKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cXpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cXpressionAExpressionParserRuleCall_1_0 = (RuleCall)cXpressionAssignment_1.eContents().get(0);
		
		//Predicate:
		//	"predicate" xpression=AExpression;
		@Override public ParserRule getRule() { return rule; }

		//"predicate" xpression=AExpression
		public Group getGroup() { return cGroup; }

		//"predicate"
		public Keyword getPredicateKeyword_0() { return cPredicateKeyword_0; }

		//xpression=AExpression
		public Assignment getXpressionAssignment_1() { return cXpressionAssignment_1; }

		//AExpression
		public RuleCall getXpressionAExpressionParserRuleCall_1_0() { return cXpressionAExpressionParserRuleCall_1_0; }
	}

	public class ValuePredicateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ValuePredicate");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cValueKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cPredicateKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cXpressionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cXpressionAAndExpressionParserRuleCall_2_0 = (RuleCall)cXpressionAssignment_2.eContents().get(0);
		
		//// intended to be restricted to deal with value limits
		//ValuePredicate:
		//	"value" "predicate" xpression=AAndExpression;
		@Override public ParserRule getRule() { return rule; }

		//"value" "predicate" xpression=AAndExpression
		public Group getGroup() { return cGroup; }

		//"value"
		public Keyword getValueKeyword_0() { return cValueKeyword_0; }

		//"predicate"
		public Keyword getPredicateKeyword_1() { return cPredicateKeyword_1; }

		//xpression=AAndExpression
		public Assignment getXpressionAssignment_2() { return cXpressionAssignment_2; }

		//AAndExpression
		public RuleCall getXpressionAAndExpressionParserRuleCall_2_0() { return cXpressionAAndExpressionParserRuleCall_2_0; }
	}

	public class ExternalDocumentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ExternalDocument");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cDocReferenceAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cDocReferenceDOCPATHParserRuleCall_0_0 = (RuleCall)cDocReferenceAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cNumberSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cDocFragmentAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cDocFragmentDOCFRAGMENTParserRuleCall_1_1_0 = (RuleCall)cDocFragmentAssignment_1_1.eContents().get(0);
		
		////InputAssumption:  'input' 'assumption' (xpression=XExpression |'as' reference=[ecore::EObject|ID]);	
		////OutputGuarantee: 'output''guarantee' (xpression=XExpression |'as' reference=[ecore::EObject|ID]);	
		////BehaviorEquation: 'invariant' (xpression=XExpression |'as' reference=[ecore::EObject|ID]);
		//ExternalDocument:
		//	docReference=DOCPATH ("#" docFragment=DOCFRAGMENT)?;
		@Override public ParserRule getRule() { return rule; }

		//docReference=DOCPATH ("#" docFragment=DOCFRAGMENT)?
		public Group getGroup() { return cGroup; }

		//docReference=DOCPATH
		public Assignment getDocReferenceAssignment_0() { return cDocReferenceAssignment_0; }

		//DOCPATH
		public RuleCall getDocReferenceDOCPATHParserRuleCall_0_0() { return cDocReferenceDOCPATHParserRuleCall_0_0; }

		//("#" docFragment=DOCFRAGMENT)?
		public Group getGroup_1() { return cGroup_1; }

		//"#"
		public Keyword getNumberSignKeyword_1_0() { return cNumberSignKeyword_1_0; }

		//docFragment=DOCFRAGMENT
		public Assignment getDocFragmentAssignment_1_1() { return cDocFragmentAssignment_1_1; }

		//DOCFRAGMENT
		public RuleCall getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0() { return cDocFragmentDOCFRAGMENTParserRuleCall_1_1_0; }
	}

	public class DOCPATHElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DOCPATH");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cSolidusKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cIDTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		
		//// path to external document and its fragment
		//DOCPATH:
		//	(ID "/")* ID "." ID;
		@Override public ParserRule getRule() { return rule; }

		//(ID "/")* ID "." ID
		public Group getGroup() { return cGroup; }

		//(ID "/")*
		public Group getGroup_0() { return cGroup_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }

		//"/"
		public Keyword getSolidusKeyword_0_1() { return cSolidusKeyword_0_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//"."
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }

		//ID
		public RuleCall getIDTerminalRuleCall_3() { return cIDTerminalRuleCall_3; }
	}

	public class DOCFRAGMENTElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DOCFRAGMENT");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//DOCFRAGMENT:
		//	ID ("." ID)*;
		@Override public ParserRule getRule() { return rule; }

		//ID ("." ID)*
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//("." ID)*
		public Group getGroup_1() { return cGroup_1; }

		//"."
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private final ReqSpecElements pReqSpec;
	private final ReqSpecContainerElements pReqSpecContainer;
	private final GlobalConstantsElements pGlobalConstants;
	private final ContractualElementElements pContractualElement;
	private final ReqRootElements pReqRoot;
	private final StakeholderGoalsElements pStakeholderGoals;
	private final ReqDocumentElements pReqDocument;
	private final DocumentSectionElements pDocumentSection;
	private final SystemRequirementsElements pSystemRequirements;
	private final DocGoalElements pDocGoal;
	private final GoalElements pGoal;
	private final RequirementElements pRequirement;
	private final DocRequirementElements pDocRequirement;
	private final ReqPredicateElements pReqPredicate;
	private final InformalPredicateElements pInformalPredicate;
	private final PredicateElements pPredicate;
	private final ValuePredicateElements pValuePredicate;
	private final ExternalDocumentElements pExternalDocument;
	private final DOCPATHElements pDOCPATH;
	private final DOCFRAGMENTElements pDOCFRAGMENT;
	
	private final Grammar grammar;

	private final CommonGrammarAccess gaCommon;

	@Inject
	public ReqSpecGrammarAccess(GrammarProvider grammarProvider,
		CommonGrammarAccess gaCommon) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaCommon = gaCommon;
		this.pReqSpec = new ReqSpecElements();
		this.pReqSpecContainer = new ReqSpecContainerElements();
		this.pGlobalConstants = new GlobalConstantsElements();
		this.pContractualElement = new ContractualElementElements();
		this.pReqRoot = new ReqRootElements();
		this.pStakeholderGoals = new StakeholderGoalsElements();
		this.pReqDocument = new ReqDocumentElements();
		this.pDocumentSection = new DocumentSectionElements();
		this.pSystemRequirements = new SystemRequirementsElements();
		this.pDocGoal = new DocGoalElements();
		this.pGoal = new GoalElements();
		this.pRequirement = new RequirementElements();
		this.pDocRequirement = new DocRequirementElements();
		this.pReqPredicate = new ReqPredicateElements();
		this.pInformalPredicate = new InformalPredicateElements();
		this.pPredicate = new PredicateElements();
		this.pValuePredicate = new ValuePredicateElements();
		this.pExternalDocument = new ExternalDocumentElements();
		this.pDOCPATH = new DOCPATHElements();
		this.pDOCFRAGMENT = new DOCFRAGMENTElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.reqspec.ReqSpec".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	public CommonGrammarAccess getCommonGrammarAccess() {
		return gaCommon;
	}

	
	//ReqSpec:
	//	parts+=(SystemRequirements | StakeholderGoals | ReqDocument | GlobalConstants)+;
	public ReqSpecElements getReqSpecAccess() {
		return pReqSpec;
	}
	
	public ParserRule getReqSpecRule() {
		return getReqSpecAccess().getRule();
	}

	//ReqSpecContainer:
	//	SystemRequirements | StakeholderGoals | ReqDocument | DocumentSection;
	public ReqSpecContainerElements getReqSpecContainerAccess() {
		return pReqSpecContainer;
	}
	
	public ParserRule getReqSpecContainerRule() {
		return getReqSpecContainerAccess().getRule();
	}

	//GlobalConstants:
	//	"constants" name=QualifiedName "[" constants+=ValDeclaration* "]";
	public GlobalConstantsElements getGlobalConstantsAccess() {
		return pGlobalConstants;
	}
	
	public ParserRule getGlobalConstantsRule() {
		return getGlobalConstantsAccess().getRule();
	}

	//ContractualElement:
	//	Goal | DocGoal | Requirement | DocRequirement;
	public ContractualElementElements getContractualElementAccess() {
		return pContractualElement;
	}
	
	public ParserRule getContractualElementRule() {
		return getContractualElementAccess().getRule();
	}

	//ReqRoot:
	//	StakeholderGoals | ReqDocument | SystemRequirements;
	public ReqRootElements getReqRootAccess() {
		return pReqRoot;
	}
	
	public ParserRule getReqRootRule() {
		return getReqRootAccess().getRule();
	}

	//StakeholderGoals:
	//	"stakeholder" "goals" name=QualifiedName (":" title=STRING)? ("for"
	//	(target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ |
	//	global?="all")) ("use" "constants" importConstants+=[GlobalConstants|QualifiedName]+)? "[" (description=Description?
	//	& constants+=ValDeclaration* & content+=Goal* & ("see" "document" docReference+=ExternalDocument+)? & ("issues"
	//	issues+=STRING+)?) "]";
	public StakeholderGoalsElements getStakeholderGoalsAccess() {
		return pStakeholderGoals;
	}
	
	public ParserRule getStakeholderGoalsRule() {
		return getStakeholderGoalsAccess().getRule();
	}

	//ReqDocument:
	//	"document" name=QualifiedName (":" title=STRING)? "[" (description=Description? & content+=(DocGoal | DocRequirement
	//	| DocumentSection)* & ("issues" issues+=STRING+)?) "]";
	public ReqDocumentElements getReqDocumentAccess() {
		return pReqDocument;
	}
	
	public ParserRule getReqDocumentRule() {
		return getReqDocumentAccess().getRule();
	}

	//DocumentSection:
	//	"section" label=ID (":" title=STRING)? "[" (description=Description? & content+=(DocGoal | DocRequirement |
	//	DocumentSection)*) "]";
	public DocumentSectionElements getDocumentSectionAccess() {
		return pDocumentSection;
	}
	
	public ParserRule getDocumentSectionRule() {
		return getDocumentSectionAccess().getRule();
	}

	//SystemRequirements:
	//	"system" "requirements" name=QualifiedName (":" title=STRING)? ("for"
	//	(target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ |
	//	global?="all")) ("use" "constants" importConstants+=[GlobalConstants|QualifiedName]+)? "[" (description=Description?
	//	& constants+=ValDeclaration* & computes+=ComputeDeclaration* & content+=Requirement* & ("see" "document"
	//	docReference+=ExternalDocument+)? & ("issues" issues+=STRING+)?) "]";
	public SystemRequirementsElements getSystemRequirementsAccess() {
		return pSystemRequirements;
	}
	
	public ParserRule getSystemRequirementsRule() {
		return getSystemRequirementsAccess().getRule();
	}

	//DocGoal returns Goal:
	//	"goal" name=ID (":" title=STRING)? // short string for title
	//	("for" (targetDescription=STRING | target=[aadl2::ComponentClassifier|AadlClassifierReference]
	//	targetElement=[aadl2::NamedElement]?))? "[" (("category" category+=[categories::Category]+)? &
	//	description=Description? & constants+=ValDeclaration* & rationale=Rationale? & changeUncertainty=Uncertainty? &
	//	("refines" refinesReference+=[Goal|QualifiedName]+)? & ("conflicts" "with"
	//	conflictsReference+=[Goal|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
	//	(dropped?="dropped" dropRationale=STRING?)? & ("stakeholder"
	//	stakeholderReference+=[org::Stakeholder|QualifiedName]+)? & ("see" "document" "requirement"
	//	documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
	//	("issues" issues+=STRING+)?) "]";
	public DocGoalElements getDocGoalAccess() {
		return pDocGoal;
	}
	
	public ParserRule getDocGoalRule() {
		return getDocGoalAccess().getRule();
	}

	//Goal:
	//	"goal" name=ID (":" title=STRING)? // short string for title
	//	("for" targetElement=[aadl2::NamedElement])? "[" (("category" category+=[categories::RequirementCategory]+)? &
	//	("quality" category+=[categories::QualityCategory]+)? & ("selection" category+=[categories::SelectionCategory]+)? &
	//	description=Description? & constants+=ValDeclaration* & rationale=Rationale? & changeUncertainty=Uncertainty? &
	//	("refines" refinesReference+=[Goal|QualifiedName]+)? & ("conflicts" "with"
	//	conflictsReference+=[Goal|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
	//	(dropped?="dropped" dropRationale=STRING?)? & ("stakeholder"
	//	stakeholderReference+=[org::Stakeholder|QualifiedName]+)? & ("see" "document" "requirement"
	//	documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
	//	("issues" issues+=STRING+)?) "]";
	public GoalElements getGoalAccess() {
		return pGoal;
	}
	
	public ParserRule getGoalRule() {
		return getGoalAccess().getRule();
	}

	//Requirement:
	//	"requirement" name=ID (":" title=STRING)? ("for" (target=[aadl2::ComponentClassifier|AadlClassifierReference]
	//	targetElement=[aadl2::NamedElement]? | targetElement=[aadl2::NamedElement] | componentCategory+=ComponentCategory+ |
	//	global?="all"))? "[" (("category" category+=[categories::RequirementCategory]+)? // predicate expression 
	//	//	&('refined' 'to' '['refinedRequirement+=Requirement+ ']')? 
	//	& ("quality" category+=[categories::QualityCategory]+)? & ("selection" category+=[categories::SelectionCategory]+)? &
	//	description=Description? & constants+=ValDeclaration* & computes+=ComputeDeclaration* & predicate=ReqPredicate? &
	//	rationale=Rationale? & changeUncertainty=Uncertainty? & ("mitigates" (exception=[ecore::EObject] |
	//	exceptionText=STRING))? & ("refines" refinesReference+=[Requirement|QualifiedName]+)? & ("decomposes"
	//	decomposesReference+=[Requirement|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
	//	(dropped?="dropped" dropRationale=STRING?)? & ("development" "stakeholder"
	//	developmentStakeholder+=[org::Stakeholder|QualifiedName]+)? & ("see" "goal" goalReference+=[Goal|QualifiedName]+)? &
	//	("see" "document" "goal" stakeholderRequirementReference+=[Goal|QualifiedName]+)? & ("see" "document" "requirement"
	//	documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
	//	("issues" issues+=STRING+)?) "]";
	public RequirementElements getRequirementAccess() {
		return pRequirement;
	}
	
	public ParserRule getRequirementRule() {
		return getRequirementAccess().getRule();
	}

	//DocRequirement returns Requirement:
	//	"requirement" name=ID (":" title=STRING)? ("for" (targetDescription=STRING |
	//	target=[aadl2::ComponentClassifier|AadlClassifierReference] targetElement=[aadl2::NamedElement]?))? "[" (("category"
	//	category+=[categories::Category]+)? // predicate expression 
	//	& description=Description? & constants+=ValDeclaration* & computes+=ComputeDeclaration* & predicate=ReqPredicate? &
	//	rationale=Rationale? & changeUncertainty=Uncertainty? & ("mitigates" (exception=[ecore::EObject] |
	//	exceptionText=STRING))? & ("refines" refinesReference+=[Requirement|QualifiedName]+)? & ("decomposes"
	//	decomposesReference+=[Requirement|QualifiedName]+)? & ("evolves" evolvesReference+=[Requirement|QualifiedName]+)? &
	//	(dropped?="dropped" dropRationale=STRING?)? & ("development" "stakeholder"
	//	developmentStakeholder+=[org::Stakeholder|QualifiedName]+)? & ("see" "goal" goalReference+=[Goal|QualifiedName]+)? &
	//	("see" "document" "goal" stakeholderRequirementReference+=[Goal|QualifiedName]+)? & ("see" "document" "requirement"
	//	documentRequirement+=[ContractualElement|QualifiedName]+)? & ("see" "document" docReference+=ExternalDocument+)? &
	//	("issues" issues+=STRING+)?) "]";
	public DocRequirementElements getDocRequirementAccess() {
		return pDocRequirement;
	}
	
	public ParserRule getDocRequirementRule() {
		return getDocRequirementAccess().getRule();
	}

	//// | InputAssumption | OutputGuarantee| BehaviorEquation;
	//ReqPredicate:
	//	InformalPredicate | Predicate | ValuePredicate;
	public ReqPredicateElements getReqPredicateAccess() {
		return pReqPredicate;
	}
	
	public ParserRule getReqPredicateRule() {
		return getReqPredicateAccess().getRule();
	}

	//InformalPredicate:
	//	"informal" "predicate" description=STRING;
	public InformalPredicateElements getInformalPredicateAccess() {
		return pInformalPredicate;
	}
	
	public ParserRule getInformalPredicateRule() {
		return getInformalPredicateAccess().getRule();
	}

	//Predicate:
	//	"predicate" xpression=AExpression;
	public PredicateElements getPredicateAccess() {
		return pPredicate;
	}
	
	public ParserRule getPredicateRule() {
		return getPredicateAccess().getRule();
	}

	//// intended to be restricted to deal with value limits
	//ValuePredicate:
	//	"value" "predicate" xpression=AAndExpression;
	public ValuePredicateElements getValuePredicateAccess() {
		return pValuePredicate;
	}
	
	public ParserRule getValuePredicateRule() {
		return getValuePredicateAccess().getRule();
	}

	////InputAssumption:  'input' 'assumption' (xpression=XExpression |'as' reference=[ecore::EObject|ID]);	
	////OutputGuarantee: 'output''guarantee' (xpression=XExpression |'as' reference=[ecore::EObject|ID]);	
	////BehaviorEquation: 'invariant' (xpression=XExpression |'as' reference=[ecore::EObject|ID]);
	//ExternalDocument:
	//	docReference=DOCPATH ("#" docFragment=DOCFRAGMENT)?;
	public ExternalDocumentElements getExternalDocumentAccess() {
		return pExternalDocument;
	}
	
	public ParserRule getExternalDocumentRule() {
		return getExternalDocumentAccess().getRule();
	}

	//// path to external document and its fragment
	//DOCPATH:
	//	(ID "/")* ID "." ID;
	public DOCPATHElements getDOCPATHAccess() {
		return pDOCPATH;
	}
	
	public ParserRule getDOCPATHRule() {
		return getDOCPATHAccess().getRule();
	}

	//DOCFRAGMENT:
	//	ID ("." ID)*;
	public DOCFRAGMENTElements getDOCFRAGMENTAccess() {
		return pDOCFRAGMENT;
	}
	
	public ParserRule getDOCFRAGMENTRule() {
		return getDOCFRAGMENTAccess().getRule();
	}

	//Description:
	//	"description" description+=DescriptionElement+;
	public CommonGrammarAccess.DescriptionElements getDescriptionAccess() {
		return gaCommon.getDescriptionAccess();
	}
	
	public ParserRule getDescriptionRule() {
		return getDescriptionAccess().getRule();
	}

	//DescriptionElement:
	//	text=STRING | showValue=ShowValue | thisTarget?="this" | image=ImageReference;
	public CommonGrammarAccess.DescriptionElementElements getDescriptionElementAccess() {
		return gaCommon.getDescriptionElementAccess();
	}
	
	public ParserRule getDescriptionElementRule() {
		return getDescriptionElementAccess().getRule();
	}

	//Rationale:
	//	"rationale" text=STRING;
	public CommonGrammarAccess.RationaleElements getRationaleAccess() {
		return gaCommon.getRationaleAccess();
	}
	
	public ParserRule getRationaleRule() {
		return getRationaleAccess().getRule();
	}

	//Uncertainty:
	//	"uncertainty" "[" ("volatility" volatility=Number & "costimpact" costimpact=Number & "scheduleimpact"
	//	scheduleimpact=Number & "familiarity" familiarity=Number & "timecriticality" timecriticality=Number & "riskindex"
	//	riskindex=Number & "maturityindex" maturityindex=Number) "]";
	public CommonGrammarAccess.UncertaintyElements getUncertaintyAccess() {
		return gaCommon.getUncertaintyAccess();
	}
	
	public ParserRule getUncertaintyRule() {
		return getUncertaintyAccess().getRule();
	}

	//ValDeclaration returns AVariableDeclaration:
	//	{ValDeclaration} "val" (=> (type=ID name=ID) | name=ID) "=" right=AExpression?;
	public CommonGrammarAccess.ValDeclarationElements getValDeclarationAccess() {
		return gaCommon.getValDeclarationAccess();
	}
	
	public ParserRule getValDeclarationRule() {
		return getValDeclarationAccess().getRule();
	}

	//ComputeDeclaration returns AVariableDeclaration:
	//	{ComputeDeclaration} "compute" (=> (type=ID name=ID) | name=ID);
	public CommonGrammarAccess.ComputeDeclarationElements getComputeDeclarationAccess() {
		return gaCommon.getComputeDeclarationAccess();
	}
	
	public ParserRule getComputeDeclarationRule() {
		return getComputeDeclarationAccess().getRule();
	}

	//APropertyReference returns AExpression:
	//	{APropertyReference} "@" property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE];
	public CommonGrammarAccess.APropertyReferenceElements getAPropertyReferenceAccess() {
		return gaCommon.getAPropertyReferenceAccess();
	}
	
	public ParserRule getAPropertyReferenceRule() {
		return getAPropertyReferenceAccess().getRule();
	}

	//AVariableReference returns AExpression:
	//	{AVariableReference} variable=[AVariableDeclaration];
	public CommonGrammarAccess.AVariableReferenceElements getAVariableReferenceAccess() {
		return gaCommon.getAVariableReferenceAccess();
	}
	
	public ParserRule getAVariableReferenceRule() {
		return getAVariableReferenceAccess().getRule();
	}

	//ShowValue:
	//	ref=[AVariableDeclaration] ("%" unit=[aadl2::UnitLiteral])?;
	public CommonGrammarAccess.ShowValueElements getShowValueAccess() {
		return gaCommon.getShowValueAccess();
	}
	
	public ParserRule getShowValueRule() {
		return getShowValueAccess().getRule();
	}

	//ImageReference:
	//	"img" imgfile=IMGREF;
	public CommonGrammarAccess.ImageReferenceElements getImageReferenceAccess() {
		return gaCommon.getImageReferenceAccess();
	}
	
	public ParserRule getImageReferenceRule() {
		return getImageReferenceAccess().getRule();
	}

	//IMGREF:
	//	(ID "/")* ID "." ID;
	public CommonGrammarAccess.IMGREFElements getIMGREFAccess() {
		return gaCommon.getIMGREFAccess();
	}
	
	public ParserRule getIMGREFRule() {
		return getIMGREFAccess().getRule();
	}

	//// Expressions
	//AExpression returns aadl2::PropertyExpression:
	//	AOrExpression;
	public CommonGrammarAccess.AExpressionElements getAExpressionAccess() {
		return gaCommon.getAExpressionAccess();
	}
	
	public ParserRule getAExpressionRule() {
		return getAExpressionAccess().getRule();
	}

	//AOrExpression returns aadl2::PropertyExpression:
	//	AAndExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpOr) rightOperand=AAndExpression)*;
	public CommonGrammarAccess.AOrExpressionElements getAOrExpressionAccess() {
		return gaCommon.getAOrExpressionAccess();
	}
	
	public ParserRule getAOrExpressionRule() {
		return getAOrExpressionAccess().getRule();
	}

	//OpOr:
	//	"||";
	public CommonGrammarAccess.OpOrElements getOpOrAccess() {
		return gaCommon.getOpOrAccess();
	}
	
	public ParserRule getOpOrRule() {
		return getOpOrAccess().getRule();
	}

	//AAndExpression returns aadl2::PropertyExpression:
	//	AEqualityExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpAnd) rightOperand=AEqualityExpression)*;
	public CommonGrammarAccess.AAndExpressionElements getAAndExpressionAccess() {
		return gaCommon.getAAndExpressionAccess();
	}
	
	public ParserRule getAAndExpressionRule() {
		return getAAndExpressionAccess().getRule();
	}

	//OpAnd:
	//	"&&";
	public CommonGrammarAccess.OpAndElements getOpAndAccess() {
		return gaCommon.getOpAndAccess();
	}
	
	public ParserRule getOpAndRule() {
		return getOpAndAccess().getRule();
	}

	//AEqualityExpression returns aadl2::PropertyExpression:
	//	ARelationalExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpEquality)
	//	rightOperand=ARelationalExpression)*;
	public CommonGrammarAccess.AEqualityExpressionElements getAEqualityExpressionAccess() {
		return gaCommon.getAEqualityExpressionAccess();
	}
	
	public ParserRule getAEqualityExpressionRule() {
		return getAEqualityExpressionAccess().getRule();
	}

	//OpEquality:
	//	"==" | "!=";
	public CommonGrammarAccess.OpEqualityElements getOpEqualityAccess() {
		return gaCommon.getOpEqualityAccess();
	}
	
	public ParserRule getOpEqualityRule() {
		return getOpEqualityAccess().getRule();
	}

	//ARelationalExpression returns aadl2::PropertyExpression:
	//	AOtherOperatorExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpCompare)
	//	rightOperand=AOtherOperatorExpression)*;
	public CommonGrammarAccess.ARelationalExpressionElements getARelationalExpressionAccess() {
		return gaCommon.getARelationalExpressionAccess();
	}
	
	public ParserRule getARelationalExpressionRule() {
		return getARelationalExpressionAccess().getRule();
	}

	//OpCompare:
	//	">=" | "<" "=" | ">" | "<";
	public CommonGrammarAccess.OpCompareElements getOpCompareAccess() {
		return gaCommon.getOpCompareAccess();
	}
	
	public ParserRule getOpCompareRule() {
		return getOpCompareAccess().getRule();
	}

	//AOtherOperatorExpression returns aadl2::PropertyExpression:
	//	AAdditiveExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpOther) rightOperand=AAdditiveExpression)*;
	public CommonGrammarAccess.AOtherOperatorExpressionElements getAOtherOperatorExpressionAccess() {
		return gaCommon.getAOtherOperatorExpressionAccess();
	}
	
	public ParserRule getAOtherOperatorExpressionRule() {
		return getAOtherOperatorExpressionAccess().getRule();
	}

	//OpOther:
	//	"->" | "..<" | ">" ".." | ".." | "=>" | ">" (=> (">" ">") | ">") | "<" (=> ("<" "<") | "<" | "=>") | "<>" | "?:";
	public CommonGrammarAccess.OpOtherElements getOpOtherAccess() {
		return gaCommon.getOpOtherAccess();
	}
	
	public ParserRule getOpOtherRule() {
		return getOpOtherAccess().getRule();
	}

	//AAdditiveExpression returns aadl2::PropertyExpression:
	//	AMultiplicativeExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpAdd)
	//	rightOperand=AMultiplicativeExpression)*;
	public CommonGrammarAccess.AAdditiveExpressionElements getAAdditiveExpressionAccess() {
		return gaCommon.getAAdditiveExpressionAccess();
	}
	
	public ParserRule getAAdditiveExpressionRule() {
		return getAAdditiveExpressionAccess().getRule();
	}

	//OpAdd:
	//	"+" | "-";
	public CommonGrammarAccess.OpAddElements getOpAddAccess() {
		return gaCommon.getOpAddAccess();
	}
	
	public ParserRule getOpAddRule() {
		return getOpAddAccess().getRule();
	}

	//AMultiplicativeExpression returns aadl2::PropertyExpression:
	//	AUnaryOperation (=> ({ABinaryOperation.leftOperand=current} feature=OpMulti) rightOperand=AUnaryOperation)*;
	public CommonGrammarAccess.AMultiplicativeExpressionElements getAMultiplicativeExpressionAccess() {
		return gaCommon.getAMultiplicativeExpressionAccess();
	}
	
	public ParserRule getAMultiplicativeExpressionRule() {
		return getAMultiplicativeExpressionAccess().getRule();
	}

	//OpMulti:
	//	"*" | "**" | "/" | "%";
	public CommonGrammarAccess.OpMultiElements getOpMultiAccess() {
		return gaCommon.getOpMultiAccess();
	}
	
	public ParserRule getOpMultiRule() {
		return getOpMultiAccess().getRule();
	}

	//AUnaryOperation returns aadl2::PropertyExpression:
	//	{AUnaryOperation} feature=OpUnary operand=AUnaryOperation | APrimaryExpression;
	public CommonGrammarAccess.AUnaryOperationElements getAUnaryOperationAccess() {
		return gaCommon.getAUnaryOperationAccess();
	}
	
	public ParserRule getAUnaryOperationRule() {
		return getAUnaryOperationAccess().getRule();
	}

	//OpUnary:
	//	"!" | "-" | "+";
	public CommonGrammarAccess.OpUnaryElements getOpUnaryAccess() {
		return gaCommon.getOpUnaryAccess();
	}
	
	public ParserRule getOpUnaryRule() {
		return getOpUnaryAccess().getRule();
	}

	//APrimaryExpression returns aadl2::PropertyExpression:
	//	ALiteral | AVariableReference | APropertyReference | AParenthesizedExpression;
	public CommonGrammarAccess.APrimaryExpressionElements getAPrimaryExpressionAccess() {
		return gaCommon.getAPrimaryExpressionAccess();
	}
	
	public ParserRule getAPrimaryExpressionRule() {
		return getAPrimaryExpressionAccess().getRule();
	}

	//ALiteral returns aadl2::PropertyExpression:
	//	ASetTerm | AListTerm | ABooleanLiteral | ARealTerm | AIntegerTerm | ANullLiteral | StringTerm;
	public CommonGrammarAccess.ALiteralElements getALiteralAccess() {
		return gaCommon.getALiteralAccess();
	}
	
	public ParserRule getALiteralRule() {
		return getALiteralAccess().getRule();
	}

	//AIntegerTerm returns aadl2::IntegerLiteral:
	//	value=AInt unit=[aadl2::UnitLiteral]?;
	public CommonGrammarAccess.AIntegerTermElements getAIntegerTermAccess() {
		return gaCommon.getAIntegerTermAccess();
	}
	
	public ParserRule getAIntegerTermRule() {
		return getAIntegerTermAccess().getRule();
	}

	//AInt returns aadl2::Integer:
	//	INTEGER_LIT;
	public CommonGrammarAccess.AIntElements getAIntAccess() {
		return gaCommon.getAIntAccess();
	}
	
	public ParserRule getAIntRule() {
		return getAIntAccess().getRule();
	}

	//ARealTerm returns aadl2::RealLiteral:
	//	value=AReal unit=[aadl2::UnitLiteral]?;
	public CommonGrammarAccess.ARealTermElements getARealTermAccess() {
		return gaCommon.getARealTermAccess();
	}
	
	public ParserRule getARealTermRule() {
		return getARealTermAccess().getRule();
	}

	//AReal returns aadl2::Real:
	//	REAL_LIT;
	public CommonGrammarAccess.ARealElements getARealAccess() {
		return gaCommon.getARealAccess();
	}
	
	public ParserRule getARealRule() {
		return getARealAccess().getRule();
	}

	//ANumericRangeTerm returns aadl2::RangeValue:
	//	minimum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
	//	NumAlt ".." maximum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//	NumAlt ("delta" delta= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//	NumAlt)?;
	public CommonGrammarAccess.ANumericRangeTermElements getANumericRangeTermAccess() {
		return gaCommon.getANumericRangeTermAccess();
	}
	
	public ParserRule getANumericRangeTermRule() {
		return getANumericRangeTermAccess().getRule();
	}

	//NumAlt returns aadl2::PropertyExpression:
	//	ARealTerm | AIntegerTerm;
	public CommonGrammarAccess.NumAltElements getNumAltAccess() {
		return gaCommon.getNumAltAccess();
	}
	
	public ParserRule getNumAltRule() {
		return getNumAltAccess().getRule();
	}

	//ASetTerm returns aadl2::PropertyExpression: //	{ASetLiteral} '#' '{' (elements+=AExpression (',' elements+=AExpression )*)? '}'
	//	{ASetLiteral} "{" (elements+=AExpression ("," elements+=AExpression)*)? "}";
	public CommonGrammarAccess.ASetTermElements getASetTermAccess() {
		return gaCommon.getASetTermAccess();
	}
	
	public ParserRule getASetTermRule() {
		return getASetTermAccess().getRule();
	}

	//AListTerm returns aadl2::PropertyExpression:
	//	{AListTerm} "#" "[" (elements+=AExpression ("," elements+=AExpression)*)? "]";
	public CommonGrammarAccess.AListTermElements getAListTermAccess() {
		return gaCommon.getAListTermAccess();
	}
	
	public ParserRule getAListTermRule() {
		return getAListTermAccess().getRule();
	}

	//AParenthesizedExpression returns aadl2::PropertyExpression:
	//	"(" AExpression ")";
	public CommonGrammarAccess.AParenthesizedExpressionElements getAParenthesizedExpressionAccess() {
		return gaCommon.getAParenthesizedExpressionAccess();
	}
	
	public ParserRule getAParenthesizedExpressionRule() {
		return getAParenthesizedExpressionAccess().getRule();
	}

	//ABooleanLiteral returns aadl2::PropertyExpression:
	//	{aadl2::BooleanLiteral} (value?="true" | "false");
	public CommonGrammarAccess.ABooleanLiteralElements getABooleanLiteralAccess() {
		return gaCommon.getABooleanLiteralAccess();
	}
	
	public ParserRule getABooleanLiteralRule() {
		return getABooleanLiteralAccess().getRule();
	}

	//ANullLiteral returns aadl2::PropertyExpression:
	//	{ANullLiteral} "null";
	public CommonGrammarAccess.ANullLiteralElements getANullLiteralAccess() {
		return gaCommon.getANullLiteralAccess();
	}
	
	public ParserRule getANullLiteralRule() {
		return getANullLiteralAccess().getRule();
	}

	//StringTerm returns aadl2::StringLiteral:
	//	value=NoQuoteString;
	public CommonGrammarAccess.StringTermElements getStringTermAccess() {
		return gaCommon.getStringTermAccess();
	}
	
	public ParserRule getStringTermRule() {
		return getStringTermAccess().getRule();
	}

	//NoQuoteString: // remove quotes from string in ValueConverter
	//	STRING;
	public CommonGrammarAccess.NoQuoteStringElements getNoQuoteStringAccess() {
		return gaCommon.getNoQuoteStringAccess();
	}
	
	public ParserRule getNoQuoteStringRule() {
		return getNoQuoteStringAccess().getRule();
	}

	//ComponentCategory returns aadl2::ComponentCategory:
	//	"abstract" | "bus" | "data" | "device" | "memory" | "process" | "processor" | "subprogram" | "subprogram" "group" |
	//	"system" | "thread" "group" | "thread" | "virtual" "bus" | "virtual" "processor";
	public CommonGrammarAccess.ComponentCategoryElements getComponentCategoryAccess() {
		return gaCommon.getComponentCategoryAccess();
	}
	
	public ParserRule getComponentCategoryRule() {
		return getComponentCategoryAccess().getRule();
	}

	//terminal fragment EXPONENT:
	//	("e" | "E") ("+" | "-")? DIGIT+;
	public TerminalRule getEXPONENTRule() {
		return gaCommon.getEXPONENTRule();
	} 

	//terminal fragment INT_EXPONENT:
	//	("e" | "E") "+"? DIGIT+;
	public TerminalRule getINT_EXPONENTRule() {
		return gaCommon.getINT_EXPONENTRule();
	} 

	//terminal REAL_LIT:
	//	DIGIT+ ("_" DIGIT+)* ("." DIGIT+ ("_" DIGIT+)* EXPONENT?);
	public TerminalRule getREAL_LITRule() {
		return gaCommon.getREAL_LITRule();
	} 

	//terminal INTEGER_LIT:
	//	DIGIT+ ("_" DIGIT+)* ("#" BASED_INTEGER "#" INT_EXPONENT? | INT_EXPONENT?);
	public TerminalRule getINTEGER_LITRule() {
		return gaCommon.getINTEGER_LITRule();
	} 

	//terminal fragment DIGIT:
	//	"0".."9";
	public TerminalRule getDIGITRule() {
		return gaCommon.getDIGITRule();
	} 

	//terminal fragment EXTENDED_DIGIT:
	//	"0".."9" | "a".."f" | "A".."F";
	public TerminalRule getEXTENDED_DIGITRule() {
		return gaCommon.getEXTENDED_DIGITRule();
	} 

	//terminal fragment BASED_INTEGER:
	//	EXTENDED_DIGIT ("_"? EXTENDED_DIGIT)*;
	public TerminalRule getBASED_INTEGERRule() {
		return gaCommon.getBASED_INTEGERRule();
	} 

	//// Qualified classifier reference
	//AadlClassifierReference:
	//	ID ("::" ID)+ ("." ID)?;
	public CommonGrammarAccess.AadlClassifierReferenceElements getAadlClassifierReferenceAccess() {
		return gaCommon.getAadlClassifierReferenceAccess();
	}
	
	public ParserRule getAadlClassifierReferenceRule() {
		return getAadlClassifierReferenceAccess().getRule();
	}

	//AADLPROPERTYREFERENCE:
	//	ID ("::" ID)?;
	public CommonGrammarAccess.AADLPROPERTYREFERENCEElements getAADLPROPERTYREFERENCEAccess() {
		return gaCommon.getAADLPROPERTYREFERENCEAccess();
	}
	
	public ParserRule getAADLPROPERTYREFERENCERule() {
		return getAADLPROPERTYREFERENCEAccess().getRule();
	}

	//URIID:
	//	STRING;
	public CommonGrammarAccess.URIIDElements getURIIDAccess() {
		return gaCommon.getURIIDAccess();
	}
	
	public ParserRule getURIIDRule() {
		return getURIIDAccess().getRule();
	}

	//QualifiedName:
	//	ID ("." ID)*;
	public CommonGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaCommon.getQualifiedNameAccess();
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	//Number hidden():
	//	HEX | (INT | DECIMAL) ("." (INT | DECIMAL))?;
	public CommonGrammarAccess.NumberElements getNumberAccess() {
		return gaCommon.getNumberAccess();
	}
	
	public ParserRule getNumberRule() {
		return getNumberAccess().getRule();
	}

	//terminal HEX:
	//	("0x" | "0X") ("0".."9" | "a".."f" | "A".."F" | "_")+ ("#" (("b" | "B") ("i" | "I") | ("l" | "L")))?;
	public TerminalRule getHEXRule() {
		return gaCommon.getHEXRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9" ("0".."9" | "_")*;
	public TerminalRule getINTRule() {
		return gaCommon.getINTRule();
	} 

	//terminal DECIMAL:
	//	INT (("e" | "E") ("+" | "-")? INT)? (("b" | "B") ("i" | "I" | "d" | "D") | ("l" | "L" | "d" | "D" | "f" | "F"))?;
	public TerminalRule getDECIMALRule() {
		return gaCommon.getDECIMALRule();
	} 

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaCommon.getIDRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaCommon.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaCommon.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaCommon.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaCommon.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaCommon.getANY_OTHERRule();
	} 
}
