package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	//let's start with an @Before advice
	//@Before("execution(public void add*())")

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
	public void beforeAddAccountAdvide() {
		
		System.out.println("\n=====>>>> Executiong @Before advice on addAccount()");

	}
}
