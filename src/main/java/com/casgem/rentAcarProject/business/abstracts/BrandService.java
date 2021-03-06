package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.brand.CreateBrandRequest;
import com.casgem.rentAcarProject.business.requests.brand.DeleteBrandRequest;
import com.casgem.rentAcarProject.business.requests.brand.UpdateBrandRequest;
import com.casgem.rentAcarProject.business.responses.brands.GetAllBrandResponse;
import com.casgem.rentAcarProject.business.responses.brands.GetBrandResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface BrandService {
	
	Result add(CreateBrandRequest createBrandRequest);
	
	Result delete(DeleteBrandRequest deleteBrandRequest);
	
	Result update(UpdateBrandRequest updateBrandRequest);
	
	DataResult<List<GetAllBrandResponse>> getAll();
	
	DataResult<GetBrandResponse> getById(int id);

}
