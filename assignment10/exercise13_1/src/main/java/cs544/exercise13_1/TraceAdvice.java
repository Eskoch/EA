package cs544.exercise13_1;

import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class TraceAdvice {
	
	@After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..))") 
	public void tracemethod(JoinPoint joinpoint) {
		Object[] args = joinpoint.getArgs();
		String email = (String)args[0];
		String message = (String)args[1];
		EmailSender emailOb = (EmailSender)joinpoint.getTarget();
		System.out.println(new Date() + " method= "+joinpoint.getSignature().getName()); 
		System.out.println("address= "+email);
		System.out.println("message= "+message);
		System.out.println("outgoing mail server = "+emailOb.getOutgoingMailServer());
	}
	
	@Around("execution(* cs544.exercise13_1.CustomerDAO.save(..))")	 
	public Object invoke(ProceedingJoinPoint call ) throws Throwable { 
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		
		Object retVal = call.proceed();
		
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		
		System.out.println("Time to execute save = " + totaltime);
		
		return retVal;
	}
	  
}
