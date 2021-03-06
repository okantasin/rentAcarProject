package com.casgem.rentAcarProject.business.concretes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.AdditionalFeatureItemService;
import com.casgem.rentAcarProject.business.abstracts.RentalService;
import com.casgem.rentAcarProject.business.requests.rental.CreateRentalRequest;
import com.casgem.rentAcarProject.business.requests.rental.DeleteRentalRequest;
import com.casgem.rentAcarProject.business.requests.rental.UpdateRentalRequest;
import com.casgem.rentAcarProject.business.responses.rentals.GetAllRentalResponse;
import com.casgem.rentAcarProject.business.responses.rentals.GetRentalResponse;
import com.casgem.rentAcarProject.core.utilities.adapters.abstracts.FindeksCheckService;
import com.casgem.rentAcarProject.core.utilities.exceptions.BusinessException;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessDataResult;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.AdditionalFeatureItemRepository;
import com.casgem.rentAcarProject.dataAccess.abstracts.CarRepository;
import com.casgem.rentAcarProject.dataAccess.abstracts.RentalRepository;
import com.casgem.rentAcarProject.dataAccess.abstracts.UserRepository;
import com.casgem.rentAcarProject.entities.concretes.Car;
import com.casgem.rentAcarProject.entities.concretes.Rental;
import com.casgem.rentAcarProject.entities.concretes.User;

@Service

public class RentalManager implements RentalService {

	private RentalRepository rentalRepository;

	private CarRepository carRepository;

	private ModelMapperService modelMapperService;

	@Autowired
	private AdditionalFeatureItemService additionalFeatureItemService;

	@Autowired
	private AdditionalFeatureItemRepository additionalFeatureItemRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FindeksCheckService findeksCheckService;

	public RentalManager(RentalRepository rentalRepository, CarRepository carRepository,
			ModelMapperService modelMapperService) {
		
		this.rentalRepository = rentalRepository;
		
		this.carRepository = carRepository;
		
		this.modelMapperService = modelMapperService;

	}

	@Override
	public Result add(CreateRentalRequest createRentalRequest) {
		
		checkIfDatesAreCorrect(createRentalRequest.getPickUpDate(), createRentalRequest.getReturnDate());
		checkIfCarState(createRentalRequest.getCarId());
		//*************************************************************************************************
		
		Car car = this.carRepository.findById(createRentalRequest.getCarId());
		User user = this.userRepository.findById(createRentalRequest.getUserId());
		
		checkIndividualCustomerFindexScoreAndCarFindexScore(car.getId(), user.getId());
		
		Rental rental = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		car.setState(3);
		
		rental.setTotalPrice(calculateTotalPriceOfRental(rental, car.getDailyPrice()));
		car.setCity(rental.getReturnCityId());
		
		this.rentalRepository.save(rental);

		return new SuccessResult("RENTAL.ADDED");
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {

		this.rentalRepository.deleteById(deleteRentalRequest.getId());

		return new SuccessResult("RENTAL.DELETED");
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {

		checkIfIdExists(updateRentalRequest.getId());

		Rental rental = this.rentalRepository.findById(updateRentalRequest.getId());
		Rental rentMapped = this.modelMapperService.forRequest().map(updateRentalRequest, Rental.class);
		Car car = this.carRepository.findById(updateRentalRequest.getCarId());

		
		rental.setReturnDate(updateRentalRequest.getReturnDate());

		rental.setReturnCityId(rentMapped.getReturnCityId());

		car.setCity(rentMapped.getReturnCityId());

		rental.setTotalPrice(calculateTotalPriceOfRental(rental, car.getDailyPrice()));
	
		this.rentalRepository.save(rental);

		return new SuccessResult("RENTED.UPDATED");
	}

	@Override
	public DataResult<List<GetAllRentalResponse>> getAll() {

		List<Rental> rentals = this.rentalRepository.findAll();

		List<GetAllRentalResponse> responses = rentals.stream().map(rental -> this.modelMapperService.forResponse().map(rental, GetAllRentalResponse.class))

				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllRentalResponse>>(responses, "RENTED CARS LISTED");
	}

	@Override
	public DataResult<GetRentalResponse> getById(int id) {

		Rental rental = this.rentalRepository.findById(id);

		GetRentalResponse responses = this.modelMapperService.forResponse().map(rental, GetRentalResponse.class);

		return new SuccessDataResult<GetRentalResponse>(responses);
	}

	private void checkIfDatesAreCorrect(LocalDate pickUpDate, LocalDate returnDate) {
		if (!pickUpDate.isBefore(returnDate) || pickUpDate.isBefore(LocalDate.now())) {
			throw new BusinessException("DATE.ERROR");
		}
	}

	private void checkIfCarState(int carId) {

		Car car = this.carRepository.findById(carId);

		if (car.getState() != 1) {

			throw new BusinessException("CAR.IS.NOT.AVAILABLE");
		}
	}

	private double calculateTotalPriceOfRental(Rental rental, double carDailyPrice) {

		double totalPrice = 0;

		int daysDifference = (int) ChronoUnit.DAYS.between(rental.getPickUpDate(), rental.getReturnDate());

		totalPrice = (carDailyPrice * daysDifference) + calculatePriceByReturnLocation(rental.getPickUpCityId().getId(), rental.getReturnCityId().getId());

		rental.setTotalDays(daysDifference);

		return totalPrice;
	}

	private double calculatePriceByReturnLocation(int pickUpLocationId, int returnLocationId) {
		double additionalPrice = 0;
		if (pickUpLocationId != returnLocationId) {
			additionalPrice = 750;
		}
		return additionalPrice;
	}

	private void checkIfIdExists(int id) {

		Rental rental = this.rentalRepository.findById(id);

		if (rental == null) {

			throw new BusinessException("THERE.IS.NOT.RENTED.CAR");

		}
	}

	private void checkIndividualCustomerFindexScoreAndCarFindexScore(int carId, int userId) {

		Car car = this.carRepository.findById(carId);

		User user = this.userRepository.findById(userId);

		int userFindexScore = this.findeksCheckService.checkPerson(user.getNationalityNumber());

		System.out.println("Car score " + car.getMinFindeksScore());

		if (userFindexScore < car.getMinFindeksScore()) {

			throw new BusinessException("FINDEKS.SCORE.IS.NOT.ENOUGH");

		}

	}

}
