package com.casgem.rentAcarProject.business.requests.citys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCityRequest {
	private int id;
	private String name;

}
