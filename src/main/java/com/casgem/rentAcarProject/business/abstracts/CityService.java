package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.citys.CreateCityRequest;
import com.casgem.rentAcarProject.business.requests.citys.DeleteCityRequest;
import com.casgem.rentAcarProject.business.requests.citys.UpdateCityRequest;
import com.casgem.rentAcarProject.business.responses.citys.GetAllCityResponse;
import com.casgem.rentAcarProject.business.responses.citys.GetCityResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface CityService {

	Result add(CreateCityRequest createCityRequest);
	
	Result delete(DeleteCityRequest deleteCityRequest);
	
	Result update(UpdateCityRequest updateCityRequest);
	
	DataResult<List<GetAllCityResponse>> getAll();
	
	DataResult<GetCityResponse> getById(int id);
}
