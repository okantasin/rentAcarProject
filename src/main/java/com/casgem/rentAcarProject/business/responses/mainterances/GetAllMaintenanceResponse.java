package com.casgem.rentAcarProject.business.responses.mainterances;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMaintenanceResponse {
	
	private int id;
	private LocalDate sendDate;
	private LocalDate returnDate;
	private int carId;
	

}
