package com.casgem.rentAcarProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.CarService;
import com.casgem.rentAcarProject.business.requests.cars.CreateCarRequest;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.CarRepository;
import com.casgem.rentAcarProject.entities.concretes.Car;

@Service
public class CarManager implements CarService{
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private ModelMapperService modelMapperService;
	

	@Override
	public Result add(CreateCarRequest createCarRequest) {
		
	Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
	this.carRepository.save(car);
	return  new SuccessResult("CAR.ADDED");
	}
}
