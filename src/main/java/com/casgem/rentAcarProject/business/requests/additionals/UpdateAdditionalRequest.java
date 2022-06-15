package com.casgem.rentAcarProject.business.requests.additionals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdditionalRequest {
	private int id;
	private String name;
	private double price;

}
