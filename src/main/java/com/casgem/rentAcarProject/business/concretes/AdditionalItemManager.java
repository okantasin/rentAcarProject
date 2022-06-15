package com.casgem.rentAcarProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.AdditionalItemService;
import com.casgem.rentAcarProject.business.requests.additionalServices.CreateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.DeleteAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.UpdateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.responses.additionalServices.GetAllAdditioServiceResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@Service

public class AdditionalItemManager implements AdditionalItemService{

	@Override
	public Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<GetAllAdditioServiceResponse>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<GetAllAdditioServiceResponse> getById() {
		// TODO Auto-generated method stub
		return null;
	}

}
