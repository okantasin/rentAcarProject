package com.casgem.rentAcarProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.MaintenanceService;
import com.casgem.rentAcarProject.business.requests.mainterances.CreateMaintenanceRequest;
import com.casgem.rentAcarProject.business.requests.mainterances.DeleteMaintenanceRequest;
import com.casgem.rentAcarProject.business.requests.mainterances.UpdateMaintenanceRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {
	
	@Autowired
	private MaintenanceService maintenanceService;
	
	
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest ) {
	
		return this.maintenanceService.add(createMaintenanceRequest);
		
	}
	
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteMaintenanceRequest deleteMaintenanceRequest ) {
	
		return this.maintenanceService.delete(deleteMaintenanceRequest);
		
	}
	
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateMaintenanceRequest updateMaintenanceRequest ) {
	
		return this.maintenanceService.update(updateMaintenanceRequest);
		
	}
	
	
	

}
