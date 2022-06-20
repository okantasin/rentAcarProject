package com.casgem.rentAcarProject.business.requests.additionalService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdditionalServiceRequest {
	private int id;
	private int rentalId;
	private int additionalItemId;

}
