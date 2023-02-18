package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//getMember ship bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		theMembershipDAO.goTosleep();
		
		//call the business method
		Account myAccount =new Account();
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();
		
		//call the membership method
		System.out.println(theMembershipDAO.addSillyMember());
		
		//close the context
		context.close();
		
	}

}
