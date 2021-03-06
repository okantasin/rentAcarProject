package com.casgem.rentAcarProject.business.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	
	private int id;
	
	private String description;
	
	private double dailyPrice;
	
    private int colorId;
	
	private int brandId;
	
	private String plate;
	
	private Integer kilometer;
	
	private int cityId;
	
	private int state;
}
