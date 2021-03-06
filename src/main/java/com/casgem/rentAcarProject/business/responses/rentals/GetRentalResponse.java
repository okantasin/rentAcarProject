package com.casgem.rentAcarProject.business.responses.rentals;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRentalResponse {
	private LocalDate pickupDate;
	private LocalDate returnDate;
	private int totalDays;
	private double totalPrice;
	private int carId;
	private int pickupCityId;
	private int returnCityId;
	

}
