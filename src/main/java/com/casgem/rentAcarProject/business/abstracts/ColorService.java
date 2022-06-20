package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.color.CreateColorRequest;
import com.casgem.rentAcarProject.business.requests.color.DeleteColorRequest;
import com.casgem.rentAcarProject.business.requests.color.UpdateColorRequest;
import com.casgem.rentAcarProject.business.responses.colors.GetAllColorResponse;
import com.casgem.rentAcarProject.business.responses.colors.GetColorResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface ColorService {

	Result add(CreateColorRequest createColorRequest);
	
	Result delete(DeleteColorRequest deleteColorRequest);
	
	Result update(UpdateColorRequest updateColorRequest);
	
	DataResult<List<GetAllColorResponse>> getAll();
	
	DataResult<GetColorResponse> getById(int id);
}
