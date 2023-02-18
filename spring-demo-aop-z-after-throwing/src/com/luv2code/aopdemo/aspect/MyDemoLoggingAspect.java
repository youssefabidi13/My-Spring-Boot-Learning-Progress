package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint , Throwable theExc) {
		
		//print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>Executing @AfterThrowing on method : "+ method);
		
		//log the exception
		System.out.println("\n========>The exception is : "+ theExc);

	}
	
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint , 
			List<Account> result) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>Executing @AfterReturning on method : "+ method);
		
		//print out the result of the method call
		System.out.println("\n========>Result is  : "+ result);
		
		
		//let's post-process the data .. let's modify it
		
		
		//convert the account names to uppercase
		convertAccountNamesToUppeCase(result);
		
		System.out.println("\n========>Result is  : "+ result);


	}
	
	private void convertAccountNamesToUppeCase(List<Account> result) {
		
		for (Account tempAccount : result) {
			
			String theUpperName = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(theUpperName);
		}
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
	public void beforeAddAccountAdvide(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>>> Executiong @Before advice on addAccount()");
		
		
		//display the methode signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		//display  method arguments
		Object[] args = theJoinPoint.getArgs();
		
		for(Object o : args ) {
			System.out.println(o);
			
			if (o instanceof Account) {
				//downcast and prit Account specific stuff
				Account theAccount = (Account) o;
				System.out.println("account name : " + theAccount.getName());
				System.out.println("account level : " + theAccount.getLevel());


			}
		}
	}
}
