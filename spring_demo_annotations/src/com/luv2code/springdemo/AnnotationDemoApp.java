package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		//reading spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//get the bean from spring container
		Coach theCoach = context.getBean("thatSillyCoach",Coach.class);
		//Call the method from the bean
		System.out.println(theCoach.getDailyWorkout());
		//close Context
		context.close();
	}

}
