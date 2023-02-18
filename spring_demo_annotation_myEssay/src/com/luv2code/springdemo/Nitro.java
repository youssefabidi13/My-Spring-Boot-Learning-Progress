package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Nitro implements Services {

	@Override
	public String getService() {
		// TODO Auto-generated method stub
		return "Nitro is activated";
	}

}
