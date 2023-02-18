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
	
	//for getters
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter(){}

	//for setter
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter(){}

	//create point : include package .. exclude getter / setter 
	@Pointcut("forDaoPackage() && !(setter() || getter())")
	private void forDaoPackageNoGetterNoSetter(){}

	//let's start with an @Before advice
	//@Before("execution(public void add*())")

	@Before("forDaoPackageNoGetterNoSetter()")
	public void beforeAddAccountAdvide() {
		
		System.out.println("\n=====>>>> Executiong @Before advice on addAccount()");

	}
	
	@Before("forDaoPackageNoGetterNoSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====> Performing API analytics");
	}
}
