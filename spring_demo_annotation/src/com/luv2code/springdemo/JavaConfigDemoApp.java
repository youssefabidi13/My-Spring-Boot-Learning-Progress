package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		//reading spring java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		//Call the method from the bean
		System.out.println(theCoach.getDailyWorkout());
		//Call new methods
		System.out.println(theCoach.getDailyFortune());
		//close Context
		context.close();
	}

}
