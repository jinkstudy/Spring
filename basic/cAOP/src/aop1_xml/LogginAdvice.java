package aop1_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogginAdvice {
	
	//arount라는 method.
	public Object around(ProceedingJoinPoint point) throws Throwable{
		String methodName = point.getSignature().getName();
		System.out.println("[사전작업] : " + methodName);
		Object obj = point.proceed(); //갔다와야하니까 poceed 필요
		System.out.println("<사후작업> : " +methodName);
		return obj;
	}
	
}
