package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Speed implements Services {

	@Override
	public String getService() {
		// TODO Auto-generated method stub
		return "now max speed" ;
	}

}
