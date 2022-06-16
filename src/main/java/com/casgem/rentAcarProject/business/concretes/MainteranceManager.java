package com.casgem.rentAcarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.MaintenanceService;
import com.casgem.rentAcarProject.business.requests.mainterances.CreateMaintenanceRequest;
import com.casgem.rentAcarProject.business.requests.mainterances.DeleteMaintenanceRequest;
import com.casgem.rentAcarProject.business.requests.mainterances.UpdateMaintenanceRequest;
import com.casgem.rentAcarProject.business.responses.mainterances.GetAllMaintenanceResponse;
import com.casgem.rentAcarProject.business.responses.mainterances.GetMainteranceResponse;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessDataResult;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.CarRepository;
import com.casgem.rentAcarProject.dataAccess.abstracts.MaintenanceRepository;
import com.casgem.rentAcarProject.entities.concretes.Car;
import com.casgem.rentAcarProject.entities.concretes.Maintenance;

@Service
public class MainteranceManager implements MaintenanceService {

	@Autowired
	private MaintenanceRepository maintenanceRepository;

	@Autowired
	private ModelMapperService modelMapperService;

	@Autowired
	private CarRepository carRepository;

	@Override
	public Result add(CreateMaintenanceRequest createMaintenanceRequest) {

		Maintenance maintenance = this.modelMapperService.forRequest().map(createMaintenanceRequest, Maintenance.class);

		Car car = this.carRepository.findById(createMaintenanceRequest.getCarId());

		car.setState(2);

		this.maintenanceRepository.save(maintenance);

		return new SuccessResult("MAINTENANCE.ADD");

	}

	@Override
	public Result update(UpdateMaintenanceRequest updateMaintenanceRequest) {

		Maintenance maintenance = this.maintenanceRepository.findById(updateMaintenanceRequest.getId());

		maintenance = this.modelMapperService.forRequest().map(updateMaintenanceRequest, Maintenance.class);

		this.maintenanceRepository.save(maintenance);

		return new SuccessResult("MAINTENANCE.UPDATE");

	}

	@Override
	public Result delete(DeleteMaintenanceRequest deleteMaintenanceRequest) {

		this.maintenanceRepository.deleteById(deleteMaintenanceRequest.getId());

		return new SuccessResult("MAINTENANCE.DELETED");

	}

	public Result updateState(UpdateMaintenanceRequest updateMaintenanceRequest) {

		Car car = this.carRepository.findById(updateMaintenanceRequest.getCarId());

		if (car.getState() == 1) {

			car.setState(2);

		} else {

			car.setState(1);

		}
		carRepository.save(car);

		return new SuccessResult("STATED.UPDATED");

	}

	@Override
	public DataResult<List<GetAllMaintenanceResponse>> getAll() {

		List<Maintenance> maintenances = this.maintenanceRepository.findAll();

		List<GetAllMaintenanceResponse> responses = maintenances.stream().map(

				maintanece -> this.modelMapperService.forResponse().map(maintanece, GetAllMaintenanceResponse.class))

				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllMaintenanceResponse>>(responses, "ALL MAİNTENANCE LİST");

	}

	@Override
	public DataResult<GetMainteranceResponse> getById(int id) {

		Maintenance maintenance = this.maintenanceRepository.findById(id);

		GetMainteranceResponse responses = this.modelMapperService.forResponse().map(maintenance,

				GetMainteranceResponse.class);

		return new SuccessDataResult<GetMainteranceResponse>(responses, "MAİNTERANCE.GETTING");
	}

}
