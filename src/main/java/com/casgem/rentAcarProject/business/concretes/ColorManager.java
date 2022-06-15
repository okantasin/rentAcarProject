package com.casgem.rentAcarProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.ColorService;
import com.casgem.rentAcarProject.business.requests.colors.CreateColorRequest;
import com.casgem.rentAcarProject.business.requests.colors.DeleteColorRequest;
import com.casgem.rentAcarProject.business.requests.colors.UpdateColorRequest;
import com.casgem.rentAcarProject.business.responses.colors.GetAllColorResponse;
import com.casgem.rentAcarProject.business.responses.colors.GetColorResponse;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.ColorRepository;
import com.casgem.rentAcarProject.entities.concretes.Color;

@Service
public class ColorManager implements ColorService{
	
	@Autowired
	private ColorRepository colorRepository;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateColorRequest createColorRequest) {
		
		Color color = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
		this.colorRepository.save(color);
		return  new SuccessResult("COLOR.ADDED");
	}

	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(UpdateColorRequest updateColorRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<GetAllColorResponse>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<GetColorResponse> getById() {
		// TODO Auto-generated method stub
		return null;
	}

}
