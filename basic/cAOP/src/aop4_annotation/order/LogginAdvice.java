package aop4_annotation.order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class LogginAdvice {
	
	@Around("execution(public * *(..))")
	//arount라는 method.
	public Object around(ProceedingJoinPoint point) throws Throwable{
		String methodName = point.getSignature().getName();
		System.out.println("[사전작업] : " + methodName);
		Object obj = point.proceed(); //갔다와야하니까 poceed 필요
		System.out.println("<사후작업> : " +methodName);
		return obj;
	}
}
	
