package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount,boolean vipFlag) {
		System.out.println(getClass() + ":DOING MY DB WORK :ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println("yeaaaah good");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + " : getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " : setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " : getSeviceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : setSeviceCode()");
		this.serviceCode = serviceCode;
	}
	
	//add a new method : findAccounts
	
	
	public List<Account> findAccount(boolean tripWire){
		
		//simulate ana exception
		
		if (tripWire) {
			throw new RuntimeException("no soop for you !!!!");
		}
		List<Account> myAccounts =new ArrayList<>() ;
		
		//create simple account 
		
		Account temp1 = new Account("John" , "Silver");
		Account temp2= new Account("madhu" , "Platinium");
		Account temp3= new Account("Luca" , "Gold");

		//add them to our account list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		
		return myAccounts; 
	}
}



























