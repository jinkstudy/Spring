package aop3_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAdvice {
	
	@Around("execution(public * aop3_annotation.*.*Hello(..))")
	
	//arount라는 method.
	public Object around(ProceedingJoinPoint point) throws Throwable{
		String methodName = point.getSignature().getName();
		System.out.println("[사전작업] : " + methodName);
		Object obj = point.proceed(); //갔다와야하니까 poceed 필요
		System.out.println("<사후작업> : " +methodName);
		return obj;
	}
	
	public void before(JoinPoint point) throws Throwable{
		String methodName = point.getSignature().getName();
		System.out.println("[******사전작업******] : " + methodName);
	}
	
	public void after(JoinPoint point) throws Throwable{
		String methodName = point.getSignature().getName();
		System.out.println("[******사후작업******] : " + methodName);
	}
}
