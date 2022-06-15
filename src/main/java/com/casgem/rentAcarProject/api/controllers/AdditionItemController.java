package com.casgem.rentAcarProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.casgem.rentAcarProject.business.abstracts.AdditionalItemService;
import com.casgem.rentAcarProject.business.requests.additionalServices.CreateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.DeleteAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.UpdateAdditionalServiceRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public class AdditionItemController {
	@Autowired
	private AdditionalItemService additionalItemService;
	
	
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateAdditionalServiceRequest createAdditionalServiceRequest ) {
	
		return this.additionalItemService.add(createAdditionalServiceRequest);
		
	}
	
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteAdditionalServiceRequest deleteAdditionalServiceRequest ) {
	
		return this.additionalItemService.delete(deleteAdditionalServiceRequest);
		
	}
	
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateAdditionalServiceRequest additionalServiceRequest ) {
	
		return this.additionalItemService.update(additionalServiceRequest);
		
	}

	


}
