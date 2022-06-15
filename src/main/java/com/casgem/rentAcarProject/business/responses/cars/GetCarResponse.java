package com.casgem.rentAcarProject.business.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarResponse {
	private String description;
	private double dailyPrice;
	private int brandId;
	private int colorId;
	private int state;
	private int cityId;
}
