package com.casgem.rentAcarProject.business.requests.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
	private int id;
	private String firstName;
	private String lastName;
	private long nationalityNumber;
	private String email;
	private long password;
	private String birthDay;
	

}
