package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCar")
public class Car implements Vehicule {
	@Autowired
	@Qualifier("speed")
	private Services service;

	/*
	 * public Car(Services nitro) { this.nitro = nitro; }
	 */
	@Override
	public String Accelerate() {
		// TODO Auto-generated method stub
		return "Car accelerate now";
	}

	@Override
	public String getOurService() {
		// TODO Auto-generated method stub
		return service.getService();
	}

}
