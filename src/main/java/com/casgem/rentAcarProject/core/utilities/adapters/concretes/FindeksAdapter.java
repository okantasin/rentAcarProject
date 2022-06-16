package com.casgem.rentAcarProject.core.utilities.adapters.concretes;

import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.core.utilities.adapters.abstracts.FindeksCheckService;
import com.casgem.rentAcarProject.core.utilities.adapters.outServices.Findeks;

@Service
public class FindeksAdapter implements FindeksCheckService {

	Findeks findeks = new Findeks();
	
	@Override
	public int checkPerson(String identity) {
		
		int score = findeks.calculatePersonScore(identity);
		
		return score;
	}

}
