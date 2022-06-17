package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.additionalServices.CreateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.DeleteAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.UpdateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.responses.additionalServices.GetAdditionalServiceResponse;
import com.casgem.rentAcarProject.business.responses.additionalServices.GetAllAdditionalServiceResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface AdditionalFeatureServiceService {
	Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest);
	
	Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest);
	
	Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest);
	
	DataResult<List<GetAllAdditionalServiceResponse>> getAll();
	
	DataResult<GetAdditionalServiceResponse> getById(int id);
}
