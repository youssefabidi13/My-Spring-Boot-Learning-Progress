package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		//reading spring java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		//Call the method from the bean
		System.out.println(theCoach.getDailyWorkout());
		//Call new methods
		System.out.println(theCoach.getDailyFortune());
		//call our new swim coach methods 
		System.out.println("email : "+ theCoach.getEmail());
		System.out.println("team : "+ theCoach.getTeam());

		//close Context
		context.close();
	}

}
