package com.casgem.rentAcarProject.business.responses.additionalServices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllAdditioServiceResponse {
	private int totalDays;
	private double totalPrice;
	private int rentalId;
	private int additionalItemId;
}
