package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.cars.CreateCarRequest;
import com.casgem.rentAcarProject.business.requests.cars.DeleteCarRequest;
import com.casgem.rentAcarProject.business.requests.cars.UpdateCarRequest;
import com.casgem.rentAcarProject.business.responses.cars.GetAllCarResponse;
import com.casgem.rentAcarProject.business.responses.cars.GetCarResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface CarService {
	
	Result add(CreateCarRequest createCarRequest);
	
	Result delete(DeleteCarRequest deleteCarRequest);
	
	Result update(UpdateCarRequest updateCarRequest);
	
	DataResult<List<GetAllCarResponse>> getAll();
	
	DataResult<GetCarResponse> getById(int id);

}
