package com.casgem.rentAcarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.RentalService;
import com.casgem.rentAcarProject.business.requests.rentals.CreateRentalRequest;
import com.casgem.rentAcarProject.business.requests.rentals.DeleteRentalRequest;
import com.casgem.rentAcarProject.business.requests.rentals.UpdateRentalRequest;
import com.casgem.rentAcarProject.business.responses.rentals.GetAllRentalResponse;
import com.casgem.rentAcarProject.business.responses.rentals.GetRentalResponse;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessDataResult;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.RentalRepository;
import com.casgem.rentAcarProject.entities.concretes.Rental;

@Service

public class RentalManager implements RentalService {
	@Autowired
	private RentalRepository rentalRepository;

	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateRentalRequest createRentalRequest) {
		
		Rental rental = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);

		this.rentalRepository.save(rental);
		
		return new SuccessResult("RENTAL.ADDED");
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		
		this.rentalRepository.findById(deleteRentalRequest.getId());
		
		return new SuccessResult("RENTAL.DELETED");
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<GetAllRentalResponse>> getAll() {
		List<Rental> rentals = this.rentalRepository.findAll();
		
		List<GetAllRentalResponse> responses = rentals.stream().map(
				
				rental -> this.modelMapperService.forResponse().map(rental, GetAllRentalResponse.class))
				
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllRentalResponse>>(responses);
	}

	@Override
	public DataResult<GetRentalResponse> getById(int id) {

		Rental rental = this.rentalRepository.findById(id);
		
		GetRentalResponse responses = this.modelMapperService.forResponse().map(rental, GetRentalResponse.class);
		
		
		return new  SuccessDataResult<GetRentalResponse>(responses);
	}

}
