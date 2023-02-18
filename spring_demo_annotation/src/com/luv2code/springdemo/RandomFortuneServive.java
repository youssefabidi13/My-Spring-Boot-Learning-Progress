package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneServive implements FortuneService {
	//create an array of string
	private String[] data = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of goodluck",
			"The journey is the reward"
	} ;
	//create a random number  generator
	private Random myRandom = new Random();
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String theFortune =data[index];
		return theFortune;
	}

}
