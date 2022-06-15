package com.casgem.rentAcarProject.business.responses.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponse {
	private String firstName;
	private String lastName;
	private long nationalityNumber;
	private String email;
	private int password;
	private int birthDay;


}
