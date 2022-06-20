package com.casgem.rentAcarProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.ColorService;
import com.casgem.rentAcarProject.business.requests.color.CreateColorRequest;
import com.casgem.rentAcarProject.business.requests.color.DeleteColorRequest;
import com.casgem.rentAcarProject.business.requests.color.UpdateColorRequest;
import com.casgem.rentAcarProject.business.responses.colors.GetAllColorResponse;
import com.casgem.rentAcarProject.business.responses.colors.GetColorResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

	@Autowired
	private ColorService colorService;

	@PostMapping("/add")
	public Result add(@RequestBody CreateColorRequest createColorRequest) {

		return this.colorService.add(createColorRequest);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) {

		return this.colorService.delete(deleteColorRequest);

	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateColorRequest updateColorRequest) {

		return this.colorService.update(updateColorRequest);

	}
	@GetMapping("/getAll")
	public DataResult<List<GetAllColorResponse>> getAll() {
		return this.colorService.getAll();

	}

	@PostMapping("/getById")
	public DataResult<GetColorResponse> getById(@RequestParam int id) {
		return this.colorService.getById(id);
	}

}
