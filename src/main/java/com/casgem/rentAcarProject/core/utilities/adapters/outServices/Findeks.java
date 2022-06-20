package com.casgem.rentAcarProject.core.utilities.adapters.outServices;

public class Findeks {
	public int calculatePersonScore(String identify) {
		
		int max=1900;
		
		int min=650;
		
		int score =(int) Math.floor(Math.random()*(max-min+1)+ min);
		
		System.out.println("Findeks Score : "+score);
		
		return score;
	}

}
