package org.osate.assure.util


import org.osate.assure.assure.VerificationActivityResult
import org.osate.verify.verify.SupportedTypes
import org.osate.aadl2.instance.InstanceObject
import static extension org.osate.assure.util.AssureUtilExtension.*
import com.google.inject.ImplementedBy

@ImplementedBy(DefaultVerificationMethodDispatcher)
interface IVerificationMethodDispatcher {
	def void dispatchVerificationMethod(String methodPath, InstanceObject target);
	def void runVerificationMethod(VerificationActivityResult verificationActivityResult);
}

class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher{
	override runVerificationMethod(VerificationActivityResult verificationActivityResult) {
		val method = verificationActivityResult.getTarget().getMethod();
		if (method.getMethodType() == SupportedTypes.SINGLEPREDICATE) {
			val methodpath = method.getMethodPath();
			try { 
				dispatchVerificationMethod(methodpath, verificationActivityResult.caseSubject)
				setToSuccess(verificationActivityResult)
			} catch (AssertionError e) {
				setToFail(verificationActivityResult, e);
			} catch (ThreadDeath e) { // don't catch ThreadDeath by accident
				throw e;
			} catch (Throwable e) {
				setToError(verificationActivityResult, e);
			}
			
			}
	}
	
	
	override dispatchVerificationMethod(String methodPath, InstanceObject target) {
		println("Dispatching "+methodPath + " on "+target.getQualifiedName)
		
	}
	
}