package com.casgem.rentAcarProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.casgem.rentAcarProject.business.abstracts.AdditionalFeatureItemService;
import com.casgem.rentAcarProject.business.requests.additionals.CreateAdditionalItemRequest;
import com.casgem.rentAcarProject.business.requests.additionals.DeleteAdditionalItemRequest;
import com.casgem.rentAcarProject.business.requests.additionals.UpdateAdditionalItemRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public class AdditionItemController {
	@Autowired
	private AdditionalFeatureItemService additionalFeatureItemService;

	
	@PostMapping("/add")
	public Result add(@RequestBody CreateAdditionalItemRequest createAdditionalItemRequest ) {
	
		return this.additionalFeatureItemService.add(createAdditionalItemRequest);
		
	}
	
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteAdditionalItemRequest deleteAdditionalServiceRequest ) {
	
		return this.additionalFeatureItemService.delete(deleteAdditionalServiceRequest);
		
	}
	
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateAdditionalItemRequest additionalServiceRequest ) {
	
		return this.additionalFeatureItemService.update(additionalServiceRequest);
		
	}

	


}
