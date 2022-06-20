package com.casgem.rentAcarProject.business.requests.rental;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalRequest {
	
	private int id;
	private LocalDate pickUpDate; 
	private LocalDate returnDate;
	private int carId;
	private int pickUpCityId;
	private int returnCityId;
	private int userId;

	

}
