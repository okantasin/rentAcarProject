package com.casgem.rentAcarProject.business.requests.rental;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
	private int id;
	private int carId;
	private LocalDate returnDate;
	private int returnCityId;
}
