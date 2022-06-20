package com.casgem.rentAcarProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.RentalService;
import com.casgem.rentAcarProject.business.requests.rental.CreateRentalRequest;
import com.casgem.rentAcarProject.business.requests.rental.DeleteRentalRequest;
import com.casgem.rentAcarProject.business.requests.rental.UpdateRentalRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

	@Autowired
	private RentalService rentalService;

	@PostMapping("/add")
	public Result add(@RequestBody CreateRentalRequest createRentalRequest) {
		return this.rentalService.add(createRentalRequest);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteRentalRequest deleteRentalRequest) {
		return this.rentalService.delete(deleteRentalRequest);
	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateRentalRequest updateRentalRequest) {
		return this.rentalService.update(updateRentalRequest);

	}

	@GetMapping("/getall")
	public Result getAll() {
		return this.rentalService.getAll();
	}

	@GetMapping("/getById")
	public Result getById(int id) {
		return this.rentalService.getById(id);
	}
}
