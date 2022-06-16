package com.casgem.rentAcarProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.CarService;
import com.casgem.rentAcarProject.business.requests.cars.CreateCarRequest;
import com.casgem.rentAcarProject.business.requests.cars.DeleteCarRequest;
import com.casgem.rentAcarProject.business.requests.cars.UpdateCarRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateCarRequest createCarRequest) {
		return this.carService.add(createCarRequest);
		
	}
	
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteCarRequest deleteCarRequest ) {
	
		return this.carService.delete(deleteCarRequest);
		
	}
	
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateCarRequest updateCarRequest ) {
	
		return this.carService.update(updateCarRequest);
		
	}
	
}

