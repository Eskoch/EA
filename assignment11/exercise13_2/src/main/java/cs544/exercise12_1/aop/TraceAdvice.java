package cs544.exercise12_1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

import cs544.exercise12_1.bank.logging.ILogger;
import cs544.exercise12_1.bank.logging.Logger;

@Aspect
public class TraceAdvice {
	private ILogger logger = new Logger();
	@After("execution(* cs544.exercise12_1.bank.dao.*.*(..))") 
	public void tracemethod(JoinPoint joinpoint) {
		String method = joinpoint.getSignature().getName();
		logger.log(method);
	}
	
	@Around("execution(* cs544.exercise12_1.bank.service.*.*(..))")	 
	public Object invoke(ProceedingJoinPoint call) throws Throwable { 
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		
		Object retVal = call.proceed();
		
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		
		System.out.println("Time to execute all methods in the service package is = " + totaltime);
		
		return retVal;
	}
	
	@After("execution(* cs544.exercise12_1.bank.jms.JMSSender.sendJMSMessage(..)) && args(text)") 
	public void logMessage(JoinPoint joinpoint, String text) {
		logger.log(text);
	}
	  
}
