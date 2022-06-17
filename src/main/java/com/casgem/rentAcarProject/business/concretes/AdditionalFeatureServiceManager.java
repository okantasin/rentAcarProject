package com.casgem.rentAcarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.AdditionalFeatureServiceService;
import com.casgem.rentAcarProject.business.requests.additionalServices.CreateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.DeleteAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.requests.additionalServices.UpdateAdditionalServiceRequest;
import com.casgem.rentAcarProject.business.responses.additionalServices.GetAdditionalServiceResponse;
import com.casgem.rentAcarProject.business.responses.additionalServices.GetAllAdditionalServiceResponse;
import com.casgem.rentAcarProject.core.utilities.exceptions.BusinessException;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessDataResult;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.AdditionalFeatureItemRepository;
import com.casgem.rentAcarProject.dataAccess.abstracts.AdditionalFeatureServiceRepository;
import com.casgem.rentAcarProject.dataAccess.abstracts.RentalRepository;
import com.casgem.rentAcarProject.entities.concretes.AdditionalFeatureItem;
import com.casgem.rentAcarProject.entities.concretes.AdditionalFeatureService;
import com.casgem.rentAcarProject.entities.concretes.Rental;

@Service

public class AdditionalFeatureServiceManager implements AdditionalFeatureServiceService {
	private ModelMapperService modelMapperService;

	private AdditionalFeatureServiceRepository additionalFeatureServiceRepository;

	private AdditionalFeatureItemRepository additionalFeatureItemRepository;

	private RentalRepository rentalRepository;

	@Autowired
	public AdditionalFeatureServiceManager(ModelMapperService modelMapperService,
			AdditionalFeatureServiceRepository additionalFeatureServiceRepository,
			AdditionalFeatureItemRepository additionalFeatureItemRepository, RentalRepository rentalRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.additionalFeatureServiceRepository = additionalFeatureServiceRepository;
		this.additionalFeatureItemRepository = additionalFeatureItemRepository;
		this.rentalRepository = rentalRepository;
	}

	@Override
	public Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		AdditionalFeatureService additionalFeatureService =
				this.modelMapperService.forRequest()
				.map(createAdditionalServiceRequest, AdditionalFeatureService.class);
		Rental rental = this.rentalRepository.
				findById(additionalFeatureService.getRental().getId());
		
		AdditionalFeatureItem item = (AdditionalFeatureItem) this.additionalFeatureItemRepository.findById(additionalFeatureService.getAdditionalFeatureItem().getId());
		double price = item.getPrice();
		int totalDays = rental.getTotalDays();
		double totalPrice = totalDays * price;

		additionalFeatureService.setTotalPrice(totalPrice);
		additionalFeatureService.setTotalDay(totalDays);
		
		//rental.setTotalPrice(totalPrice + rental.getTotalPrice());
		this.additionalFeatureServiceRepository.save(additionalFeatureService);
		return new SuccessResult("ADDITIONAL.SERVICE.ADDED");
	}

	@Override
	public Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {
		
		AdditionalFeatureService additionalFeatureService = this.modelMapperService.forRequest()
				.map(updateAdditionalServiceRequest, AdditionalFeatureService.class);
		Rental rental = this.rentalRepository.findById(additionalFeatureService.getRental().getId());
		
		AdditionalFeatureItem item = this.additionalFeatureItemRepository
				.findById(additionalFeatureService.getAdditionalFeatureItem().getId());
		
		checkIfRentalIdSame(additionalFeatureService,rental.getId());
		
		double price = item.getPrice();
		int totalDays = rental.getTotalDays();
		double totalPrice = totalDays * price;
		additionalFeatureService.setTotalPrice(totalPrice);
		additionalFeatureService.setTotalDay(totalDays);
		
		
		this.additionalFeatureServiceRepository.save(additionalFeatureService);
		return new SuccessResult("SERVICES.UPDATE");
	}

	@Override
	public Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest) {
		this.additionalFeatureServiceRepository.deleteById(deleteAdditionalServiceRequest.getId());
		return new SuccessResult("SERVICE.DELETED");
	}

	@Override
	public DataResult<List<GetAllAdditionalServiceResponse>> getAll() {
		List<AdditionalFeatureService> additionalFeatureServices = this.additionalFeatureServiceRepository.findAll();
		List<GetAllAdditionalServiceResponse> response = additionalFeatureServices.stream()
				.map(service -> this.modelMapperService.forResponse().map(service,
						GetAllAdditionalServiceResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllAdditionalServiceResponse>>(response, "SERVICES.LISTED");
	}

	@Override
	public DataResult<GetAdditionalServiceResponse> getById(int id) {
		AdditionalFeatureService additionalFeatureService = this.additionalFeatureServiceRepository.findById(id);
		GetAdditionalServiceResponse response = this.modelMapperService.forResponse()
				.map(additionalFeatureService, GetAdditionalServiceResponse.class);
		return new SuccessDataResult<GetAdditionalServiceResponse>(response);
	}
	private void checkIfRentalIdSame(AdditionalFeatureService additionalFeatureService,int id) {
		
		Rental rental = this.rentalRepository.findById(id);
		if(rental != additionalFeatureService.getRental() || rental == null) {
			throw new BusinessException("ERROR");
		}
		
}
}
