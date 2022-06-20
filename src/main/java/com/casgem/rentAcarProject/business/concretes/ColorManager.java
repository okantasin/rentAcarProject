package com.casgem.rentAcarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.ColorService;
import com.casgem.rentAcarProject.business.requests.color.CreateColorRequest;
import com.casgem.rentAcarProject.business.requests.color.DeleteColorRequest;
import com.casgem.rentAcarProject.business.requests.color.UpdateColorRequest;
import com.casgem.rentAcarProject.business.responses.colors.GetAllColorResponse;
import com.casgem.rentAcarProject.business.responses.colors.GetColorResponse;
import com.casgem.rentAcarProject.core.utilities.exceptions.BusinessException;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessDataResult;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.ColorRepository;
import com.casgem.rentAcarProject.entities.concretes.Color;

@Service
public class ColorManager implements ColorService {

	@Autowired
	private ColorRepository colorRepository;

	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateColorRequest createColorRequest) {
		
        checkIfColorNameExits(createColorRequest.getName());
		
        Color color = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
		
        this.colorRepository.save(color);
		
        return new SuccessResult("COLOR.ADDED");
	}

	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {

		this.colorRepository.deleteById(deleteColorRequest.getId());

		return new SuccessResult("COLOR.DELETED");
	}

	@Override
	public Result update(UpdateColorRequest updateColorRequest) {

		checkIfColorNameExits(updateColorRequest.getName());

		Color color = this.colorRepository.findById(updateColorRequest.getId());

		this.colorRepository.save(color);

		return new SuccessResult("COLOR.UPDATE");
	}

	@Override
	public DataResult<List<GetAllColorResponse>> getAll() {
		List<Color> colors = this.colorRepository.findAll();

		List<GetAllColorResponse> responses = colors.stream().map(

				color -> this.modelMapperService.forResponse()

						.map(color, GetAllColorResponse.class))

				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllColorResponse>>(responses,"ALL.COLOR.LİSTED");
	}

	@Override
	public DataResult<GetColorResponse> getById(int id) {
		Color color = this.colorRepository.findById(id);

		GetColorResponse responses = this.modelMapperService.forResponse().map(color, GetColorResponse.class);

		return new SuccessDataResult<GetColorResponse>(responses,"COLOR.LISTED");
	}

	public void checkIfColorNameExits(String name) {
		
		Color currentColor = this.colorRepository.findByName(name);

		if (currentColor != null) {

			throw new BusinessException("COLOR.EXITS");

		}
	}

}
