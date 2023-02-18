package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class fraint implements Services {

	@Override
	public String getService() {
		return "Stop";
	}

}
