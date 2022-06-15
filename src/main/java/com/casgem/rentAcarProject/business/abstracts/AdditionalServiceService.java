package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.additionalServices.CreateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.DeleteAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.UpdateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.responses.additionalServices.GetAdditionalServiceResponse;
import com.casgem.rentAcarProject.business.responses.additionalServices.GetAllAdditioServiceResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface AdditionalServiceService {
	Result add(CreateAdditionalServiceRequest additionalServiceRequest);
	Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest);
	Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest);
	
	DataResult<List<GetAllAdditioServiceResponse>> getAll();
	DataResult<GetAdditionalServiceResponse> getById(int id);
}
