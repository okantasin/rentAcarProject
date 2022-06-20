package com.casgem.rentAcarProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.BrandService;
import com.casgem.rentAcarProject.business.requests.brand.CreateBrandRequest;
import com.casgem.rentAcarProject.business.requests.brand.DeleteBrandRequest;
import com.casgem.rentAcarProject.business.requests.brand.UpdateBrandRequest;
import com.casgem.rentAcarProject.business.responses.brands.GetAllBrandResponse;
import com.casgem.rentAcarProject.business.responses.brands.GetBrandResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
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
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllBrandResponse>> getAll(){
		return this.brandService.getAll();
		
	}
	
	@PostMapping("/getById")
	public DataResult<GetBrandResponse> getById(@RequestParam int id) {
		return this.brandService.getById(id);
	}
}

