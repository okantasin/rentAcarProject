package com.casgem.rentAcarProject.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.casgem.rentAcarProject.business.abstracts.CityService;
import com.casgem.rentAcarProject.business.requests.citys.CreateCityRequest;
import com.casgem.rentAcarProject.business.requests.citys.DeleteCityRequest;
import com.casgem.rentAcarProject.business.requests.citys.UpdateCityRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public class CityController {
	
	private CityService cityService;
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateCityRequest createCityRequest ) {
	
		return this.cityService.add(createCityRequest);
		
	}
	
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteCityRequest deleteCityRequest ) {
	
		return this.cityService.delete(deleteCityRequest);
		
	}
	
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateCityRequest updateCityRequest ) {
	
		return this.cityService.update(updateCityRequest);
		
	}
	
}
