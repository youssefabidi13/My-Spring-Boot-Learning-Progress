package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//Spring will automatically register this bean 
//the bean id ="tennisCoach"

@Component
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneServive")
	private FortuneService fortuneService;
	public TennisCoach() {
		 System.out.println("defaufalt constructor"); 
	}
	
	/*
	 * //Injection with constructor
	 * 
	 * @Autowired public TennisCoach(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */
	/*
	 * //Injection with setter
	 * 
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */
	@Override
	public String getDailyWorkout() {
		return "Practise your backhand volley";
	}
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
