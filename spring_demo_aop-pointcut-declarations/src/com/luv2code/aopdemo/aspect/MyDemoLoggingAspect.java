package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	//this is where we add all of our related advices for logging
	 
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage(){}
	
	//let's start with an @Before advice
	//@Before("execution(public void add*())")

	@Before("forDaoPackage()")
	public void beforeAddAccountAdvide() {
		
		System.out.println("\n=====>>>> Executiong @Before advice on addAccount()");

	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n=====> Performing API analytics");
	}
}
