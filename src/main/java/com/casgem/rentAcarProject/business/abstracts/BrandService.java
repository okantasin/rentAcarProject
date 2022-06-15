package com.casgem.rentAcarProject.business.abstracts;

import com.casgem.rentAcarProject.business.requests.brands.CreateBrandRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface BrandService {
	
	Result add(CreateBrandRequest createBrandRequest);

}
