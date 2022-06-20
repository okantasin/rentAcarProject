package com.casgem.rentAcarProject.business.requests.additional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdditionalItemRequest {
	private String name;
	private double price;

}
