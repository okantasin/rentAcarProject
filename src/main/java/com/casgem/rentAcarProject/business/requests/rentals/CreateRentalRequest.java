package com.casgem.rentAcarProject.business.requests.rentals;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalRequest {
	
	private int id;
	private LocalDate pickupDate; 
	private LocalDate returnDate;
	private int carId;
	private int pickupCityId;
	private int returnCityId;
	private int userId;

}
