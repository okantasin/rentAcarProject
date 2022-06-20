package com.casgem.rentAcarProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.CityService;
import com.casgem.rentAcarProject.business.requests.city.CreateCityRequest;
import com.casgem.rentAcarProject.business.requests.city.DeleteCityRequest;
import com.casgem.rentAcarProject.business.requests.city.UpdateCityRequest;
import com.casgem.rentAcarProject.business.responses.citys.GetAllCityResponse;
import com.casgem.rentAcarProject.business.responses.citys.GetCityResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/cities")
public class CityController {
	@Autowired
	private CityService cityService;

	@PostMapping("/add")
	public Result add(@RequestBody CreateCityRequest createCityRequest) {

		return this.cityService.add(createCityRequest);

	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteCityRequest deleteCityRequest) {

		return this.cityService.delete(deleteCityRequest);

	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateCityRequest updateCityRequest) {

		return this.cityService.update(updateCityRequest);

	}

	@GetMapping("/getAll")
	public DataResult<List<GetAllCityResponse>> getAll() {
		return this.cityService.getAll();

	}

	@PostMapping("/getById")
	public DataResult<GetCityResponse> getById(@RequestParam int id) {
		return this.cityService.getById(id);
	}

}
