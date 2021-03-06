package com.casgem.rentAcarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.BrandService;
import com.casgem.rentAcarProject.business.requests.brand.CreateBrandRequest;
import com.casgem.rentAcarProject.business.requests.brand.DeleteBrandRequest;
import com.casgem.rentAcarProject.business.requests.brand.UpdateBrandRequest;
import com.casgem.rentAcarProject.business.responses.brands.GetAllBrandResponse;
import com.casgem.rentAcarProject.business.responses.brands.GetBrandResponse;
import com.casgem.rentAcarProject.core.utilities.exceptions.BusinessException;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessDataResult;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.BrandRepository;
import com.casgem.rentAcarProject.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {

	@Autowired // repositorynin somutunu bana ver
	private BrandRepository brandRepository;

	@Autowired
	private ModelMapperService modelMapperService;

	@Autowired
	public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) {
		super();
		this.brandRepository = brandRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateBrandRequest createBrandRequest) {

		checkIfBrandNameExits(createBrandRequest.getName());

		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

		this.brandRepository.save(brand);

		return new SuccessResult("BRAND.ADDED");
	}

	@Override
	public Result delete(DeleteBrandRequest deleteBrandRequest) {

		this.brandRepository.deleteById(deleteBrandRequest.getId());

		return new SuccessResult("BRAND.DELETED");

	}

	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {

		checkIfBrandNameExits(updateBrandRequest.getName());

		Brand brand = this.brandRepository.findById(updateBrandRequest.getId());

		this.brandRepository.save(brand);

		return new SuccessResult("BRAND.UPDATE");
	}

	@Override
	public DataResult<List<GetAllBrandResponse>> getAll() {

		List<Brand> brands = this.brandRepository.findAll();

		List<GetAllBrandResponse> responses = brands.stream()
				
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class))
				
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllBrandResponse>>(responses, "ALL.BRAND.LISTED");
	}
	 
	@Override
	public DataResult<GetBrandResponse> getById(int id) {

		Brand brand = this.brandRepository.findById(id);

		GetBrandResponse responses = this.modelMapperService.forResponse().map(brand, GetBrandResponse.class);

		return new SuccessDataResult<GetBrandResponse>(responses, "BRAND.LISTED");
	}

	// Ayn?? markaya sahip mi kontrol et
	public void checkIfBrandNameExits(String name) {

		Brand currentBrand = this.brandRepository.findByName(name);

		if (currentBrand != null) {

			throw new BusinessException("BRAND.EXITS");

		}
	}

}
