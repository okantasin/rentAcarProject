package com.casgem.rentAcarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.CarService;
import com.casgem.rentAcarProject.business.requests.car.CreateCarRequest;
import com.casgem.rentAcarProject.business.requests.car.DeleteCarRequest;
import com.casgem.rentAcarProject.business.requests.car.UpdateCarRequest;
import com.casgem.rentAcarProject.business.responses.cars.GetAllCarResponse;
import com.casgem.rentAcarProject.business.responses.cars.GetCarResponse;
import com.casgem.rentAcarProject.core.utilities.exceptions.BusinessException;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessDataResult;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.CarRepository;
import com.casgem.rentAcarProject.entities.concretes.Car;

@Service
public class CarManager implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateCarRequest createCarRequest) {
		checIfBrandLimitExceed(createCarRequest.getId());
		
	    checIfBrandLimitExceed(createCarRequest.getBrandId());
	
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		
		this.carRepository.save(car);
		
		return new SuccessResult("CAR.ADDED");
	}

	@Override
	public Result delete(DeleteCarRequest deleteCarRequest) {

		this.carRepository.deleteById(deleteCarRequest.getId());

		return new SuccessResult("CAR.DELETED");
	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {

		checkIfIdExits(updateCarRequest.getId());

		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);

		Car carFromDb = this.carRepository.findById(car.getId());

		car.setState(carFromDb.getState());

		this.carRepository.save(car);

		return new SuccessResult("CAR.UPDATED");
	}

	@Override
	public DataResult<List<GetAllCarResponse>> getAll() {
		
		List<Car> cars = this.carRepository.findAll();
		
		List<GetAllCarResponse> responses = cars.stream()
				
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarResponse.class))
				
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllCarResponse>>(responses,"ALL CARS");
	}

	@Override
	public DataResult<GetCarResponse> getById(int id) {
		
		Car car = this.carRepository.findById(id);
		
		GetCarResponse response = this.modelMapperService.forResponse().map(car, GetCarResponse.class);
		
		return new SuccessDataResult<GetCarResponse>(response);
	}

	public void checkIfIdExits(int id) {

		Car car = this.carRepository.findById(id);

		if (car == null) {

			throw new BusinessException("CAR.NOT.EXITS");

		}
	}

	public void checIfBrandLimitExceed(int id) {
		
		List<Car> result = carRepository.getByBrandId(id);
		
		if (result.size() > 5) {
			
			throw new BusinessException("YOU CAN NOT ADD MORE CAR");
		}
	}
}
