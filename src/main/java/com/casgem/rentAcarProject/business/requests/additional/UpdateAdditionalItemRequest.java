package com.casgem.rentAcarProject.business.requests.additional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdditionalItemRequest {
	private int id;
	private String name;
	private double price;

}
