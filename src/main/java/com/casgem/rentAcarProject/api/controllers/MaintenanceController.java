package com.casgem.rentAcarProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.MaintenanceService;
import com.casgem.rentAcarProject.business.requests.mainterance.CreateMaintenanceRequest;
import com.casgem.rentAcarProject.business.requests.mainterance.DeleteMaintenanceRequest;
import com.casgem.rentAcarProject.business.requests.mainterance.UpdateMaintenanceRequest;
import com.casgem.rentAcarProject.business.responses.mainterances.GetAllMaintenanceResponse;
import com.casgem.rentAcarProject.business.responses.mainterances.GetMainteranceResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {

	@Autowired
	private MaintenanceService maintenanceService;

	@PostMapping("/add")
	public Result add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest) {

		return this.maintenanceService.add(createMaintenanceRequest);

	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteMaintenanceRequest deleteMaintenanceRequest) {

		return this.maintenanceService.delete(deleteMaintenanceRequest);

	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateMaintenanceRequest updateMaintenanceRequest) {

		return this.maintenanceService.update(updateMaintenanceRequest);

	}


	@GetMapping("/getAll")
	public DataResult<List<GetAllMaintenanceResponse>> getAll() {
		return this.maintenanceService.getAll();

	}

	@PostMapping("/getById")
	public DataResult<GetMainteranceResponse> getById(@RequestParam int id) {
		return this.maintenanceService.getById(id);
	}

}
