package com.casgem.rentAcarProject.business.responses.rentals;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllRentalResponse {
	private int id;
	private LocalDate pickUpDate;
	private LocalDate returnDate;
	private int totalDays;
	private double totalPrice;
	private int carId;
	private int pickupCityId;
	private int returnCityId;
	private String brandName;
	private String colorName;
	private String cityName;
	private String firstName;
	
	
	

}
