package com.casgem.rentAcarProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.BrandService;
import com.casgem.rentAcarProject.business.requests.brands.CreateBrandRequest;
import com.casgem.rentAcarProject.business.requests.brands.DeleteBrandRequest;
import com.casgem.rentAcarProject.business.requests.brands.UpdateBrandRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@PostMapping("/add")
	public Result add(@RequestBody CreateBrandRequest createBrandRequest) {

		return this.brandService.add(createBrandRequest);
	}


	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteBrandRequest deleteBrandRequest) {

		return this.brandService.delete(deleteBrandRequest);

	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateBrandRequest updateBrandRequest) {

		return this.brandService.update(updateBrandRequest);

	}

}
