package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.rentals.CreateRentalRequest;
import com.casgem.rentAcarProject.business.requests.rentals.DeleteRentalRequest;
import com.casgem.rentAcarProject.business.requests.rentals.UpdateRentalRequest;
import com.casgem.rentAcarProject.business.responses.rentals.GetAllRentalResponse;
import com.casgem.rentAcarProject.business.responses.rentals.GetRentalResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface RentalService {
	Result add(CreateRentalRequest createRentalRequest);
	
	Result delete(DeleteRentalRequest deleteRentalRequest);
	
	Result update(UpdateRentalRequest updateRentalRequest);
	
	DataResult<List<GetAllRentalResponse>> getAll();
	
	DataResult<GetRentalResponse> getById(int id);
	
}
