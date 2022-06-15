package com.casgem.rentAcarProject.business.responses.mainterances;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMainteranceResponse {
	
	private LocalDate sendDate;
	private LocalDate returnDate;
	private int carId;

}
