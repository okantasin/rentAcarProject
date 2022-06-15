package com.casgem.rentAcarProject;


import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.casgem.rentAcarProject.core.utilities.exceptions.BusinessException;
import com.casgem.rentAcarProject.core.utilities.results.ErrorDataResult;



@SpringBootApplication
@RestControllerAdvice 

public class RentAcarProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentAcarProjectApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@ExceptionHandler  
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) 
	public ErrorDataResult<Object> handleValidationExceptions(MethodArgumentNotValidException  methodArgumentNotValidException) {
		Map<String ,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors,"VALIDATION_ERROR(S)");
		return errorDataResult;
	}
	
	
	
	@ExceptionHandler  
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) 
	public ErrorDataResult<Object> handleBusinessExceptions(BusinessException businessException) {
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(businessException.getMessage(),
				"BUSINESS.EXCEPTION");
		return errorDataResult;
	}

}
