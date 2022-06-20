package com.casgem.rentAcarProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.AdditionalFeatureServiceService;
import com.casgem.rentAcarProject.business.requests.additionalService.CreateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalService.DeleteAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalService.UpdateAdditionalServiceRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/additionalServices")
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
