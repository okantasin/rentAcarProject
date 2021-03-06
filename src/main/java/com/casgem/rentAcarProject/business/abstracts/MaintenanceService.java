package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.mainterance.CreateMaintenanceRequest;
import com.casgem.rentAcarProject.business.requests.mainterance.DeleteMaintenanceRequest;
import com.casgem.rentAcarProject.business.requests.mainterance.UpdateMaintenanceRequest;
import com.casgem.rentAcarProject.business.responses.mainterances.GetAllMaintenanceResponse;
import com.casgem.rentAcarProject.business.responses.mainterances.GetMainteranceResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface MaintenanceService {
	
	Result add(CreateMaintenanceRequest maintenanceRequest);
	
	Result update(UpdateMaintenanceRequest updateMaintenanceRequest);
	
	Result delete(DeleteMaintenanceRequest deleteCreateMaintenanceRequest);
	
	
	DataResult<List<GetAllMaintenanceResponse>> getAll();
	
	DataResult<GetMainteranceResponse> getById(int id);

}
