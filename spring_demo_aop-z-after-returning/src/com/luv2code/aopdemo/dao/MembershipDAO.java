package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public String addSillyMember() {
		return getClass() + ":DOING MY DB WORK :ADDING AN ACCOUNT to dao";
	}
	
	public void goTosleep() {
		System.out.println(getClass() + ":go to sleeeeep");
	}
}
