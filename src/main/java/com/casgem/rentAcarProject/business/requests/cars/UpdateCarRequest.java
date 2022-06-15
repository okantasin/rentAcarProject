package com.casgem.rentAcarProject.business.requests.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
	
	private int id;
	
	private String description;
	
	private double dailyPrice;
	
    private int colorId;
	
	private int brandId;
	
	private String plate;
	
	private Integer kilometer;
	
	private int cityId;
}
