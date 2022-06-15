package com.casgem.rentAcarProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.BrandService;
import com.casgem.rentAcarProject.business.requests.brands.CreateBrandRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;

	/*
	 * public BrandController(BrandService brandService) { super();
	 * this.brandService = brandService; }
	 */
	
	@PostMapping("/add")
	public Result add(@RequestBody  CreateBrandRequest createBrandRequest) {
		
		return this.brandService.add(createBrandRequest);
	}

}
