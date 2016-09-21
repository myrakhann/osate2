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

package org.osate.assure.evaluator

import com.google.inject.ImplementedBy
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr
import com.rockwellcollins.atc.resolute.resolute.NestedDotID
import com.rockwellcollins.atc.resolute.resolute.ProveStatement
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory
import com.rockwellcollins.atc.resolute.resolute.ThisExpr
import it.xsemantics.runtime.RuleEnvironment
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.swt.widgets.Display
import org.junit.runner.JUnitCore
import org.osate.aadl2.Aadl2Factory
import org.osate.aadl2.BooleanLiteral
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.NumberValue
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.StringLiteral
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance
import org.osate.alisa.common.common.CommonFactory
import org.osate.alisa.common.typing.CommonInterpreter
import org.osate.assure.assure.AssuranceCaseResult
import org.osate.assure.assure.ElseResult
import org.osate.assure.assure.ElseType
import org.osate.assure.assure.ModelResult
import org.osate.assure.assure.PreconditionResult
import org.osate.assure.assure.PredicateResult
import org.osate.assure.assure.SubsystemResult
import org.osate.assure.assure.ThenResult
import org.osate.assure.assure.ValidationResult
import org.osate.assure.assure.VerificationActivityResult
import org.osate.assure.assure.VerificationExecutionState
import org.osate.assure.assure.VerificationResult
import org.osate.assure.util.AssureUtilExtension
import org.osate.categories.categories.CategoryFilter
import org.osate.results.results.ResultReport
import org.osate.verify.util.VerificationMethodDispatchers
import org.osate.verify.verify.AgreeMethod
import org.osate.verify.verify.FormalParameter
import org.osate.verify.verify.JUnit4Method
import org.osate.verify.verify.JavaMethod
import org.osate.verify.verify.ManualMethod
import org.osate.verify.verify.PluginMethod
import org.osate.verify.verify.ResoluteMethod
import org.osate.xtext.aadl2.properties.util.PropertyUtils

import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.assure.util.AssureUtilExtension.*
import static extension org.osate.verify.util.VerifyUtilExtension.*

@ImplementedBy(AssureProcessor)
interface IAssureProcessor {
	def void processCase(AssuranceCaseResult assureResult, CategoryFilter filter, IProgressMonitor monitor);

	def void setProgressTreeViewer(TreeViewer viewPage);

	def void setRequirementsCoverageTreeViewer(TreeViewer viewPage);
}

/**
 * performs the processing of verification activities
 * records the result propagating up the counts
 * Will process only those that are TBD
 * It assumes the counts are ok
 */
class AssureProcessor implements IAssureProcessor {

	val interpreter = new CommonInterpreter

	var IProgressMonitor progressmonitor

	var TreeViewer progressTreeViewer
	var TreeViewer requirementsCoverageTreeViewer

	val RuleEnvironment env = new RuleEnvironment
	val computes = new HashMap<String, PropertyExpression>
	val vals = new HashMap<String, Object>

	var long start = 0

	var CategoryFilter filter;

	new() {
		env.add('vals', vals)
		env.add('computes', computes)
	}

	def void startSubTask(VerificationActivityResult vaResult) {
		progressmonitor.subTask(vaResult.target.name) // + " on " + vaResult.claimSubject.name)
		start = System.currentTimeMillis();
	}

	def void doneSubTask(VerificationActivityResult vaResult) {
		progressmonitor.worked(1)
		val stop = System.currentTimeMillis();
		vaResult.metrics.executionTime = (stop - start)

//		val instanceroot = vaResult.assuranceCaseInstanceModel
//		val targetComponent = findTargetSystemComponentInstance(instanceroot, vaResult.enclosingSubsystemResult)
		val targetPath = vaResult.buildCaseModelElementPath
		System.out.println(
			"Evaluation time: " + (stop - start) / 1000.0 + "s :" + vaResult.target.name + " on " + targetPath);
	}

	override processCase(AssuranceCaseResult assureResult, CategoryFilter filter, IProgressMonitor monitor) {
		progressmonitor = monitor
		this.filter = filter;
		val count = AssureUtilExtension.numberVerificationResults(assureResult)
		try {
			progressmonitor.beginTask(assureResult.name, count)
			assureResult.process
		} finally {
			// assureResult.eResource.save(null)
			progressmonitor.done
		}

		updateRequirementsCoverage();
	}

	def dispatch void process(AssuranceCaseResult caseResult) {
		caseResult.modelResult.forEach[modelResult|modelResult.process]
	}

	def dispatch void process(ModelResult modelResult) {
		modelResult.claimResult.forEach[claimResult|claimResult.process]
		modelResult.subsystemResult.forEach[claimResult|claimResult.process]
		modelResult.subAssuranceCase.forEach[subcaseResult|subcaseResult.process]
	}

	def dispatch void process(SubsystemResult caseResult) {
		caseResult.claimResult.forEach[claimResult|claimResult.process]
		caseResult.subsystemResult.forEach[subcaseResult|subcaseResult.process]
	}

	def dispatch void process(org.osate.assure.assure.ClaimResult claimResult) {
		if (claimResult.targetReference.requirement.requirement.evaluateRequirementFilter(filter)) {
			vals.clear
			computes.clear
			claimResult.verificationActivityResult.forEach[vaResult|vaResult.process]
			claimResult.predicateResult?.process
			claimResult.subClaimResult.forEach[subclaimResult|subclaimResult.process]
		}
	}

	def dispatch void process(VerificationActivityResult vaResult) {

		if (vaResult.targetReference.verificationActivity.evaluateVerificationActivityFilter(filter) &&
			vaResult.targetReference.verificationActivity.evaluateVerificationMethodFilter(filter)) {
			startSubTask(vaResult)
			if (vaResult.executionState != VerificationExecutionState.TODO) {
				doneSubTask(vaResult)
				return;
			}
			if (vaResult.preconditionResult != null) {
				vaResult.preconditionResult.process
				if (!vaResult.preconditionResult.isSuccess) {
					doneSubTask(vaResult)
					return
				}
			}
			runVerificationMethod(vaResult)
			if (vaResult.validationResult != null) {
				vaResult.validationResult.process
			}
			doneSubTask(vaResult)
		}
	}

	def dispatch void process(ElseResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.first.hasError) {
			vaResult.recordElse(ElseType.ERROR)
			vaResult.error.forEach[expr|expr.process]
		} else if (vaResult.first.isFailed) {
			vaResult.recordElse(ElseType.FAIL)
			vaResult.fail.forEach[expr|expr.process]
		} else if (vaResult.first.isTimeout) {
			vaResult.recordElse(ElseType.TIMEOUT)
			vaResult.timeout.forEach[expr|expr.process]
		} else {
			vaResult.recordNoElse
		}
	}

	def dispatch void process(ThenResult vaResult) {
		vaResult.first.forEach[expr|expr.process]
		if (vaResult.first.isSuccess) {
			vaResult.recordNoSkip
			vaResult.second.forEach[expr|expr.process]
		} else {
			vaResult.recordSkip
		}
	}

	def dispatch void process(ValidationResult validationResult) {
		runVerificationMethod(validationResult)
	}

	def dispatch void process(PreconditionResult preconditionResult) {
		runVerificationMethod(preconditionResult)
	}

	def dispatch void process(PredicateResult predicateResult) {
		evaluatePredicate(predicateResult)
	}
	
	/**
	 * who needs to understand the method types?
	 * the runVerificationMethod dispatcher may do different catch methods
	 * The dispatchVerificationMethod may know from its label what type it is.
	 * The methods are expected to return boolean for predicate, 
	 * null or bool for analysis with results in marker/diagnostic, or the result report object
	 */
	def void runVerificationMethod(VerificationResult verificationResult) {
		if (progressmonitor.isCanceled)
			throw new OperationCanceledException

		var method = verificationResult.method;
		// target element is the element referred to by the requirement. This may be empty
		val targetElement = verificationResult.caseTargetModelElement
		// the next outer assurance case object that refers to a system implementation. 
		var instanceroot = verificationResult.assuranceCaseInstanceModel
		if (instanceroot == null) {
			setToError(verificationResult, "Could not find instance model", null)
			return
		}
		var ComponentInstance targetComponent = instanceroot
		targetComponent = findTargetSystemComponentInstance(instanceroot, verificationResult.enclosingSubsystemResult)
		if (targetComponent == null) {
			setToError(verificationResult, "Unresolved target system for claim", null)
			return
		}
		var InstanceObject target = targetComponent
		if (targetElement != null) {
			if (targetElement.eIsProxy) {
				setToError(verificationResult, "Unresolved target element for claim", targetComponent)
				return
			}
			val x = targetComponent.findElementInstance(targetElement)
			target = x ?: targetComponent
		}
		// parameters are those specified as part of the method call in the verification activity
		var Iterable<? extends EObject> parameters
		if (verificationResult instanceof VerificationActivityResult) {
			parameters = verificationResult.target.actuals
		} else if (verificationResult instanceof ValidationResult) {
			parameters = method.validation.parameters
			method = method.validation.method
		} else if (verificationResult instanceof PreconditionResult) {
			parameters = method.precondition.parameters
			method = method.precondition.method
		}

		// the actual parameters can be fewer than the formal parameters. i.e., the last few may be optional
		if (parameters.size < method.formals.size) {
			setToError(verificationResult, "Fewer actual parameters than formal parameters for verification activity",
				null)
			return
		}
		val nbParams = method.formals.size
		var i = 0
		// parameterObjects is the list of objects actually passed to the call.
		// This means actual parameter values that are references to "val" are resolved to the value object
		// In this context we also convert from StringLiteral to String if String is expected.
		// Same for RealLiteral, IntegerLiteral, and BooleanLiteral.
		var List<PropertyExpression> parameterObjects = new ArrayList(parameters.size)

		for (p : parameters) {
			var PropertyExpression exp
			// first handle references to formal parameters, as used in precondition and validation calls
			if (p instanceof FormalParameter) {
				val varesult = verificationResult.eContainer as VerificationActivityResult
				val aps = varesult.target.actuals
				val idx = method.formals.indexOf(p)
				if (idx >= 0) {
					exp = aps.get(idx)
				} else {
					setToError(verificationResult,
						"Referenced formal parameter " + p.name + " of method " + method.name +
							" does not have an actual value", null)
					return
				}
			} else if (p instanceof PropertyExpression) {
				exp = p
			} else {
				var formalParam = method.formals.get(i)
				setToError(verificationResult,
					"Actual parameter for " + formalParam.name + " of method " + method.name +
						" does not have an actual value", null)
				return
			}

			val result = interpreter.interpretExpression(env, exp)
			if (result.failed) {
				var formalParam = method.formals.get(i)
				setToError(verificationResult,
					"Could not evaluate expression for " + formalParam.name + " of method " + method.name + ": " +
						result.ruleFailedException, null)
				return
			}
			var actual = result.value

			if (i < nbParams) {
				var formalParam = method.formals.get(i)
				i = i + 1
				if (actual instanceof NumberValue) {
					if (formalParam.unit != null && actual.unit != null &&
						!formalParam.unit.name.equals(actual.unit.name)) {
						actual = AssureUtilExtension.convertValueToUnit(actual, formalParam.unit)
					}
				}
				parameterObjects.add(actual)
			}
		}

		if (verificationResult instanceof VerificationActivityResult) {
			checkProperties(target, verificationResult)
		}

		try {
			val methodtype = method.methodKind
			switch (methodtype) {
				JavaMethod: {
					// The parameters are objects from the Properties Meta model. May need to get converted to Java base types
					val res = executeJavaMethod(verificationResult, methodtype, target, parameterObjects)
					if (verificationResult instanceof VerificationActivityResult) {
						val computeIter = verificationResult.targetReference.verificationActivity.computes.iterator
						method.results.forEach [ variable |
							val data = res.get(variable.name)
							if (data != null) {
								val computeRef = computeIter.next
								computes.put(computeRef.compute.name, toLiteral(data))
							} else {
								setToError(verificationResult, 'No computed value for ' + variable.name)
							}
						]
					}
					verificationResult.eResource.save(null)
					updateProgress(verificationResult)
				}
				PluginMethod: {
					// The parameters are objects from the Properties Meta model. It is up to the plugin interface method to convert to Java base types
					val res = VerificationMethodDispatchers.eInstance.
						dispatchVerificationMethod(methodtype, instanceroot, parameterObjects) // returning the marker or diagnostic id as string
					if (res instanceof String) {
						addMarkersAsResult(verificationResult, target, res, method)
					} else {
						setToError(verificationResult, "Analysis return type is not a string of MarkerType", target);
					}
					verificationResult.eResource.save(null)
					updateProgress(verificationResult)
				}
				ResoluteMethod: {
					// The parameters are objects from the Properties Meta model. Resolute likes them this way
					AssureUtilExtension.initializeResoluteContext(instanceroot);
					val EvaluationContext context = new EvaluationContext(instanceroot, sets, featToConnsMap);
					val ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
					val provecall = createWrapperProveCall(methodtype, targetComponent, parameterObjects)
					if (provecall == null) {
						setToError(verificationResult,
							"Could not find Resolute Function " + verificationResult.method.name)
					} else {

						// using com.rockwellcollins.atc.resolute.analysis.results.ClaimResult
						val ClaimResult proof = interpreter.evaluateProveStatement(provecall) as ClaimResult
						if (proof.valid) {
							setToSuccess(verificationResult)
						} else {
							val proveri = CommonFactory.eINSTANCE.createResultIssue
							proof.doResoluteResults(proveri)
							setToFail(verificationResult, proveri.issues)
						}
					}
					verificationResult.eResource.save(null)
					updateProgress(verificationResult)
				}
				AgreeMethod: {
					AssureUtilExtension.initializeResoluteContext(instanceroot);

					val agreemethod = methodtype

					if (agreemethod.isAll) { // is recursive
						// System.out.println("AgreeMethodAgreeMethodAgreeMethod executeURI ALL   ");
					} else if (agreemethod.singleLayer) {
						System.out.println("AgreeMethodAgreeMethodAgreeMethod executeSystemInstance SINGLE   ");
//						val AgreeVerifySingleHandler verHandler = new AgreeVerifySingleHandler (verificationResult);
					// verHandler.executeSystemInstance(instanceroot, progressTreeViewer);
					// Currently Agree does not work on Flows or Connections so this is valid
//						verHandler.executeSystemInstance(target as ComponentInstance, progressTreeViewer);
					}

				// Should not save here because it is job based
				// verificationResult.eResource.save(null)
				}
				JUnit4Method: {
					val test = VerificationMethodDispatchers.eInstance.findClass(methodtype.classPath);
					val junit = new JUnitCore();
					val result = junit.run(test);
					if (result.failureCount == 0) {
						setToSuccess(verificationResult)
					} else {
						val proveri = CommonFactory.eINSTANCE.createResultIssue
						result.doJUnitResults(proveri)
						setToFail(verificationResult, proveri.issues)
					}
					verificationResult.eResource.save(null)
				}
				ManualMethod: {
					verificationResult.eResource.save(null)
					updateProgress(verificationResult)
				}
			} // end switch on method
		} catch (AssertionError e) {
			setToFail(verificationResult, e);
			verificationResult.eResource.save(null)
			updateProgress(verificationResult)
		} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
			throw e;
		} catch (Throwable e) {
			setToError(verificationResult, e);
			// e.printStackTrace;
			verificationResult.eResource.save(null)
			updateProgress(verificationResult)
		}
	// verificationResult.eResource.save(null)
	}

	def updateRequirementsCoverage() {
		if (requirementsCoverageTreeViewer != null) {
			Display.getDefault().asyncExec(new Runnable() {
				override void run() {
					requirementsCoverageTreeViewer.refresh(true);
				}
			});
		}
	}

	def PropertyExpression toLiteral(Object data) {
		switch data {
			Boolean: {
				val b = Aadl2Factory.eINSTANCE.createBooleanLiteral
				b.value = data
				b
			}
			Integer: {
				val i = Aadl2Factory.eINSTANCE.createIntegerLiteral
				i.value = data
				i
			}
			Double: {
				val r = Aadl2Factory.eINSTANCE.createRealLiteral
				r.value = data
				r
			}
			String: {
				val str = Aadl2Factory.eINSTANCE.createStringLiteral
				str.value = data
				str
			}
			default:
				data as PropertyExpression
		}
	}

	def updateProgress(VerificationResult result) {
		if (progressTreeViewer != null) {
			Display.getDefault().asyncExec(new Runnable() {
				override void run() {
					progressTreeViewer.update(result, null)
				}
			});
		}
	}

	def evaluatePredicate(PredicateResult predicateResult) {
		try {
			val predicate = predicateResult.predicate
			val result = interpreter.interpretExpression(env, predicate.xpression)
			if (result.failed) {
				setToError(predicateResult, "Could not evaluate value predicate: " + result.ruleFailedException, null)
			} else {
				val success = (result.value as BooleanLiteral).getValue
				if (success) {
					setToFail(predicateResult)
				} else {
					setToSuccess(predicateResult)
				}
			}
			predicateResult.eResource.save(null)
			updateProgress(predicateResult)
		} catch (AssertionError e) {
			setToFail(predicateResult, e);
			predicateResult.eResource.save(null)
			updateProgress(predicateResult)
		} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
			throw e;
		} catch (Throwable e) {
			setToError(predicateResult, e);
			predicateResult.eResource.save(null)
			updateProgress(predicateResult)
		}
	}
	
	def executeJavaMethod(VerificationResult verificationResult, JavaMethod methodtype, InstanceObject target,
		List<PropertyExpression> parameters) {
		val returned = VerificationMethodDispatchers.eInstance.workspaceInvoke(methodtype, target, parameters)
		if (returned != null) {
			if (returned instanceof Boolean) {
				if (returned != true) {
					setToFail(verificationResult, "", target);
				} else {
					setToSuccess(verificationResult)
				}
				new HashMap
			} else if (returned instanceof HashMap<?,?>) {
				val report = returned.get("_result_report_") as ResultReport
				if (report != null) {
					verificationResult.resultReport = report
				} else {
					setToSuccess(verificationResult, "", target)
				}
				returned
			} else if (returned instanceof ResultReport) {
				verificationResult.resultReport = returned
				setToSuccess(verificationResult)
				new HashMap
			} else {
				setToError(verificationResult, "No result report from analysis", target);
				new HashMap
			}
		} else {
			new HashMap
		}
	}

	def ProveStatement createWrapperProveCall(ResoluteMethod rm, ComponentInstance ci,
		List<PropertyExpression> params) {
		val found = rm.methodReference
		val factory = ResoluteFactory.eINSTANCE
		if (found == null) return null
		val call = factory.createFnCallExpr
		call.fn = found
		call.args.add(createComponentinstanceReference(ci))
		addParams(call, params)
		val prove = factory.createProveStatement
		prove.expr = call
		prove
	}

	def ThisExpr createComponentinstanceReference(ComponentInstance ci) {
		val factory = ResoluteFactory.eINSTANCE
		var NestedDotID nid = null
		var nci = ci
		while (!(nci instanceof SystemInstance)) {
			val x = factory.createNestedDotID
			x.base = nci.subcomponent
			x.sub = nid
			nid = x
			nci = nci.eContainer as ComponentInstance
		}
		val te = factory.createThisExpr
		te.sub = nid
		te
	}

	def addParams(FnCallExpr call, List<PropertyExpression> params) {
		for (p : params) {
			if (p instanceof RealLiteral) {
				val realval = ResoluteFactory.eINSTANCE.createRealExpr
				realval.^val = p
				call.args.add(realval)
			} else if (p instanceof IntegerLiteral) {
				val intval = ResoluteFactory.eINSTANCE.createIntExpr
				intval.^val = p
				call.args.add(intval)
			} else if (p instanceof StringLiteral) {
				val stringval = ResoluteFactory.eINSTANCE.createStringExpr
				stringval.^val = p
				call.args.add(stringval)
			} else if (p instanceof BooleanLiteral) {
				val stringval = ResoluteFactory.eINSTANCE.createBoolExpr
				stringval.^val = p
				call.args.add(stringval)
			}
		}
	}

	def createWrapperFnCall(ResoluteMethod vr, List<PropertyExpression> params) {
		val found = vr.methodReference
		val factory = ResoluteFactory.eINSTANCE
		val target = factory.createIdExpr
		target.id = vr.caseTargetModelElement
		val call = factory.createFnCallExpr
		call.fn = found
		call.args.add(target)
		addParams(call, params)
		call
	}

	def boolean checkProperties(InstanceObject object, VerificationActivityResult result) {
		val method = result.method
		val properties = method.properties
		val values = result.target.propertyValues

		val iter1 = properties.iterator
		val iter2 = values.iterator
		var success = true;

		while (iter1.hasNext && iter2.hasNext) {
			val property = iter1.next
			val variable = iter2.next

			try {
				val value = variable.value
				if (value instanceof NumberValue) {
					val unit = value.unit
					val reqValue = value.getScaledValue(unit)
					val modelValue = PropertyUtils.getScaledNumberValue(object, property, unit)

					if (reqValue != modelValue) {
						println(
							"Property " + property.getQualifiedName() + ": Value in model (" + modelValue + unit.name +
								") does not match required value (" + reqValue + unit.name + ")")
						result.addErrorIssue(object,
							"Property " + property.getQualifiedName() + ": Value in model (" + modelValue + unit.name +
								") does not match required value (" + reqValue + unit.name + ")")
						result.setToFail
					} else {
						println("   match " + modelValue + " == " + reqValue)
					}
				}
			} catch (Exception e) {
				e.printStackTrace
			}
		}
		return success;
	}

	override void setProgressTreeViewer(TreeViewer treeViewer) {
		progressTreeViewer = treeViewer
	}

	override void setRequirementsCoverageTreeViewer(TreeViewer treeViewer) {
		requirementsCoverageTreeViewer = treeViewer
	}

}

