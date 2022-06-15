package com.casgem.rentAcarProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.UserService;
import com.casgem.rentAcarProject.business.requests.users.CreateUserRequest;
import com.casgem.rentAcarProject.business.requests.users.DeleteUserRequest;
import com.casgem.rentAcarProject.business.requests.users.UpdateUserRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateUserRequest createUserRequest ) {
	
		return this.userService.add(createUserRequest);
		
	}
	
	
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteUserRequest deleteUserRequest ) {
	
		return this.userService.delete(deleteUserRequest);
		
	}
	
	
	@PostMapping("/update")
	public Result update(@RequestBody UpdateUserRequest updateUserRequest ) {
	
		return this.userService.update(updateUserRequest);
		
	}


}
