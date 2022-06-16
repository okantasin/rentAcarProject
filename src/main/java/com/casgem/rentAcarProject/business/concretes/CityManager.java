package com.casgem.rentAcarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.CityService;
import com.casgem.rentAcarProject.business.requests.citys.CreateCityRequest;
import com.casgem.rentAcarProject.business.requests.citys.DeleteCityRequest;
import com.casgem.rentAcarProject.business.requests.citys.UpdateCityRequest;
import com.casgem.rentAcarProject.business.responses.citys.GetAllCityResponse;
import com.casgem.rentAcarProject.business.responses.citys.GetCityResponse;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessDataResult;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.CityRepository;
import com.casgem.rentAcarProject.entities.concretes.City;

@Service

public class CityManager implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	
	
	@Override
	public Result add(CreateCityRequest createCityRequest) {
		
		City city = this.modelMapperService.forRequest().map(createCityRequest, City.class);
		
		this.cityRepository.save(city);
		
		return new SuccessResult("CİTY.ADDED");
	}

	@Override
	public Result delete(DeleteCityRequest deleteCityRequest) {
		
	 this.cityRepository.deleteById(deleteCityRequest.getId());
	 
		return new SuccessResult("CITY.DELETED");
	}

	@Override
	public Result update(UpdateCityRequest updateCityRequest) {
		
		City city = this.cityRepository.findById(updateCityRequest.getId());
		
		this.cityRepository.save(city);
		
		return new SuccessResult("CİTY.UPDATED");
	}

	@Override
	public DataResult<List<GetAllCityResponse>> getAll() {

		List<City> citys = this.cityRepository.findAll();
		
		List<GetAllCityResponse> responses = citys.stream().map(
				
				city-> this.modelMapperService.forResponse().map(citys, GetAllCityResponse.class)
				
				).collect(Collectors.toList());
				
		return new SuccessDataResult<List<GetAllCityResponse>>(responses);
	}

	@Override
	public DataResult<GetCityResponse> getById(int id) {

		City city = this.cityRepository.findById(id);
		
		GetCityResponse responses=this.modelMapperService.forResponse().map(city, GetCityResponse.class);
		
		return new SuccessDataResult<GetCityResponse>(responses,"ALL CİTY ");
	}

}
