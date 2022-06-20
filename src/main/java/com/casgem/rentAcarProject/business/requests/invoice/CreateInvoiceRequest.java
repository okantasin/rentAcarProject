package com.casgem.rentAcarProject.business.requests.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest {
	
	private int id;
	
	private int invoiceNumber;
	
	private double totalPrice;
	
	private int rentalId;
	
	private int additionalFeatureServiceId;

}
