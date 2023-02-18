package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..) )")
	private void forControllerPackage() {}
	
	//do the same for service and dao 
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..) )")
	private void forServicePackage() {}
	 
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..) )")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	
	
	@Before("forAppFlow()")
	public void befor(JoinPoint theJoinPoint) {
		
		//display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=========>> @Before: calling method : "+theMethod);
		
		//display the arguments to the method
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru and display args
		for(Object tempArg : args) {
			myLogger.info("========>> argument: " + tempArg);
		}
	}
	//add@AfterReturning advice

}