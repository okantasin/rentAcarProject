package com.casgem.rentAcarProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.ColorService;
import com.casgem.rentAcarProject.business.requests.colors.CreateColorRequest;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
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

}
