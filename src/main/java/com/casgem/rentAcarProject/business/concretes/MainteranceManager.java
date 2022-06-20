package com.casgem.rentAcarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.MaintenanceService;
import com.casgem.rentAcarProject.business.requests.mainterance.CreateMaintenanceRequest;
import com.casgem.rentAcarProject.business.requests.mainterance.DeleteMaintenanceRequest;
import com.casgem.rentAcarProject.business.requests.mainterance.UpdateMaintenanceRequest;
import com.casgem.rentAcarProject.business.responses.mainterances.GetAllMaintenanceResponse;
import com.casgem.rentAcarProject.business.responses.mainterances.GetMainteranceResponse;
import com.casgem.rentAcarProject.core.utilities.exceptions.BusinessException;
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

	@Autowired
	public MainteranceManager(MaintenanceRepository maintenanceRepository, ModelMapperService modelMapperService,
			CarRepository carRepository) {

		super();

		this.maintenanceRepository = maintenanceRepository;

		this.modelMapperService = modelMapperService;

		this.carRepository = carRepository;

	}

	@Override
	public Result add(CreateMaintenanceRequest createMaintenanceRequest) {

		checkIfstate(createMaintenanceRequest.getId());

		Maintenance maintenance = this.modelMapperService.forRequest().map(createMaintenanceRequest, Maintenance.class);

		Car car = this.carRepository.findById(createMaintenanceRequest.getCarId());

		car.setId(createMaintenanceRequest.getId());

		car.setState(2);

		maintenance.setCar(car);

		this.maintenanceRepository.save(maintenance);

		return new SuccessResult("MAINTENANCE.ADD");

	}

	@Override
	public Result update(UpdateMaintenanceRequest updateMaintenanceRequest) {

		Maintenance maintenanceDatabase = this.maintenanceRepository.findById(updateMaintenanceRequest.getId());

		Maintenance maintenance = this.modelMapperService.forRequest().map(updateMaintenanceRequest, Maintenance.class);
		
		maintenance.setSendDate(maintenanceDatabase.getSendDate());

		this.maintenanceRepository.save(maintenance);

		return new SuccessResult("MAINTENANCE.UPDATE");

	}

	@Override
	public Result delete(DeleteMaintenanceRequest deleteMaintenanceRequest) {

		this.maintenanceRepository.deleteById(deleteMaintenanceRequest.getId());

		return new SuccessResult("MAINTENANCE.DELETED");

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

	public Result updateToState(UpdateMaintenanceRequest updateMaintenanceRequest) {
		Car car = this.carRepository.findById(updateMaintenanceRequest.getCarId());

		if (car.getState() == 1) {

			car.setState(2);

		} else {

			car.setState(1);

		}
		carRepository.save(car);

		return new SuccessResult("STATED.UPDATED");
	}

	public void checkIfstate(int id) {
		Car car = this.carRepository.findById(id);
		if (car.getState() != 1) {
			throw new BusinessException("ALL OF THEM RENTED");
		}

	}

}
