package com.casgem.rentAcarProject.business.abstracts;

import com.casgem.rentAcarProject.business.requests.cars.CreateCarRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface CarService {
	
	Result add(CreateCarRequest createCarRequest);

}
