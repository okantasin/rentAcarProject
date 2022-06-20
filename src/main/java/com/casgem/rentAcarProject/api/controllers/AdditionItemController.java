package com.casgem.rentAcarProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.AdditionalFeatureItemService;
import com.casgem.rentAcarProject.business.requests.additional.CreateAdditionalItemRequest;
import com.casgem.rentAcarProject.business.requests.additional.DeleteAdditionalItemRequest;
import com.casgem.rentAcarProject.business.requests.additional.UpdateAdditionalItemRequest;
import com.casgem.rentAcarProject.business.responses.additionals.GetAllAdditionalItemResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/additionalItems")
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

	@GetMapping("/getAll")
	public DataResult<List<GetAllAdditionalItemResponse>> getAll(){
		return this.additionalFeatureItemService.getAll();
		
	}
	
	


}
