package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call method to find the accounts
		List<Account> theAccounts = null;
		
		try {
			//add a boolean flag to simulate exception
			boolean tripWire = true; 
			theAccountDAO.findAccount(tripWire);
		}catch(Exception exc) {
			System.out.println("\n\nMain Program ... exc : " + exc);
		}
		
		
		//display the accounts
		System.out.println("\n\n Main Programm : AfterThrowingDemoApp");
		System.out.println("-----------------");
		System.out.println(theAccounts);
		System.out.println("\n");



		//close the context
		context.close();
		
	}

}
