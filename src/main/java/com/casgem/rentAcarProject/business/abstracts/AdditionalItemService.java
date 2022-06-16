package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.additionalServices.CreateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.DeleteAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.UpdateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.responses.additionalServices.GetAllAdditioServiceResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface AdditionalItemService {

	Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest);
	
	Result delete(DeleteAdditionalServiceRequest  deleteAdditionalServiceRequest);
	
	Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest);
	
	DataResult<List<GetAllAdditioServiceResponse>> getAll();
	
	DataResult<GetAllAdditioServiceResponse> getById();
}
