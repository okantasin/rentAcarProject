package com.casgem.rentAcarProject.business.requests.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
	private String firstName;
	private String lastName;
	private long nationalityId;
	private String email;
	private int password;
	private int birthDay;

}
