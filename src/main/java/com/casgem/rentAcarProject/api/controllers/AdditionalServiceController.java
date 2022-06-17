package com.casgem.rentAcarProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.casgem.rentAcarProject.business.abstracts.AdditionalFeatureServiceService;
import com.casgem.rentAcarProject.business.requests.additionalServices.CreateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.DeleteAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.UpdateAdditionalServiceRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public class AdditionalServiceController {
	
	@Autowired
	private AdditionalFeatureServiceService additionalFeatureServiceService;
	
	
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateAdditionalServiceRequest createMaintenanceRequest ) {
	
		return this.additionalFeatureServiceService.add(createMaintenanceRequest);
		
	}
	
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteAdditionalServiceRequest deleteAdditionalServiceRequest ) {
	
		return this.additionalFeatureServiceService.delete(deleteAdditionalServiceRequest);
		
	}
	
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateAdditionalServiceRequest updateAdditionalServiceRequest ) {
	
		return this.additionalFeatureServiceService.update(updateAdditionalServiceRequest);
		
	}
	

}
