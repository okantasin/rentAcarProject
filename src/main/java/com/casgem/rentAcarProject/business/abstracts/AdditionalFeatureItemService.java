package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.additional.CreateAdditionalItemRequest;
import com.casgem.rentAcarProject.business.requests.additional.DeleteAdditionalItemRequest;
import com.casgem.rentAcarProject.business.requests.additional.UpdateAdditionalItemRequest;
import com.casgem.rentAcarProject.business.responses.additionals.GetAdditionalItemResponse;
import com.casgem.rentAcarProject.business.responses.additionals.GetAllAdditionalItemResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface AdditionalFeatureItemService {

	Result add(CreateAdditionalItemRequest createAdditionalItemRequest);
	
	Result delete(DeleteAdditionalItemRequest  deleteAdditionalItemRequest);
	
	Result update(UpdateAdditionalItemRequest updateAdditionalItemRequest);
	
	DataResult<List<GetAllAdditionalItemResponse>> getAll();
	
	DataResult<GetAdditionalItemResponse> getById(int id);
}
