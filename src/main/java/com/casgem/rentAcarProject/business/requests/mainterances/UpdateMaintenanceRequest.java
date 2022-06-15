package com.casgem.rentAcarProject.business.requests.mainterances;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaintenanceRequest {
	private int id;
	private LocalDate sendDate;
	private  LocalDate returnDate;
	private int carId;
	private int pickupCityId;
	private int returncityId;

}
