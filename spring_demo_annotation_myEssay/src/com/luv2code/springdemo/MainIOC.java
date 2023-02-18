package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainIOC {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Vehicule lamborgini = context.getBean("myCar",Vehicule.class);
		System.out.println(lamborgini.Accelerate());
		System.out.println(lamborgini.getOurService());
		context.close();
	}

}
