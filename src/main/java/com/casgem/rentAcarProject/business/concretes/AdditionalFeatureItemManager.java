package com.casgem.rentAcarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.AdditionalFeatureItemService;
import com.casgem.rentAcarProject.business.requests.additionals.CreateAdditionalItemRequest;
import com.casgem.rentAcarProject.business.requests.additionals.DeleteAdditionalItemRequest;
import com.casgem.rentAcarProject.business.requests.additionals.UpdateAdditionalItemRequest;
import com.casgem.rentAcarProject.business.responses.additionals.GetAdditionalItemResponse;
import com.casgem.rentAcarProject.business.responses.additionals.GetAllAdditionalItemResponse;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessDataResult;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.AdditionalFeatureItemRepository;
import com.casgem.rentAcarProject.entities.concretes.AdditionalFeatureItem;

@Service

public class AdditionalFeatureItemManager implements AdditionalFeatureItemService {

	private AdditionalFeatureItemRepository additionalFeatureItemRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public AdditionalFeatureItemManager(AdditionalFeatureItemRepository additionalFeatureItemRepository,
			ModelMapperService modelMapperService) {

		this.additionalFeatureItemRepository = additionalFeatureItemRepository;
		this.modelMapperService = modelMapperService;
	}


	@Override
	public Result add(CreateAdditionalItemRequest createAdditionalItemRequest) {
		AdditionalFeatureItem additionalFeatureItem = this.modelMapperService.forRequest()
				.map(createAdditionalItemRequest, AdditionalFeatureItem.class);

		this.additionalFeatureItemRepository.save(additionalFeatureItem);
		return new SuccessResult("ITEM.ADDED");
	}

	@Override
	public Result delete(DeleteAdditionalItemRequest deleteAdditionalItemRequest) {
		this.additionalFeatureItemRepository.deleteById(deleteAdditionalItemRequest.getId());
		return new SuccessResult("ITEM.DELETED");
	}

	@Override
	public Result update(UpdateAdditionalItemRequest updateAdditionalItemRequest) {
		AdditionalFeatureItem additionalFeatureItem = this.modelMapperService.forRequest()
				.map(updateAdditionalItemRequest, AdditionalFeatureItem.class);
		this.additionalFeatureItemRepository.save(additionalFeatureItem);
		return new SuccessResult("ITEM.UPDATED");
	}


	@Override
	public DataResult<List<GetAllAdditionalItemResponse>> getAll() {
		List<AdditionalFeatureItem> additionalFeatureItems = this.additionalFeatureItemRepository.findAll();
		List<GetAllAdditionalItemResponse> response = additionalFeatureItems.stream().map(
				item -> this.modelMapperService.forResponse().map(item, GetAllAdditionalItemResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllAdditionalItemResponse>>(response,"ITEM.LISTED");
	}


	@Override
	public DataResult<GetAdditionalItemResponse> getById(int id) {
		AdditionalFeatureItem additionalFeatureItem = this.additionalFeatureItemRepository.findById(id);
		GetAdditionalItemResponse  response = this.modelMapperService.forResponse().map(additionalFeatureItem, GetAdditionalItemResponse.class);
		return new SuccessDataResult<GetAdditionalItemResponse>(response);
	}

}
