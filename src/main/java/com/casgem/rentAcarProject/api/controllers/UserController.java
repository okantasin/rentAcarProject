package com.casgem.rentAcarProject.api.controllers;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casgem.rentAcarProject.business.abstracts.UserService;
import com.casgem.rentAcarProject.business.requests.user.CreateUserRequest;
import com.casgem.rentAcarProject.business.requests.user.DeleteUserRequest;
import com.casgem.rentAcarProject.business.requests.user.UpdateUserRequest;
import com.casgem.rentAcarProject.business.responses.users.GetAllUserResponse;
import com.casgem.rentAcarProject.business.responses.users.GetUserResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public Result add(@RequestBody CreateUserRequest createUserRequest) throws NumberFormatException, RemoteException {

		return this.userService.add(createUserRequest);

	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteUserRequest deleteUserRequest) {

		return this.userService.delete(deleteUserRequest);

	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateUserRequest updateUserRequest) {

		return this.userService.update(updateUserRequest);

	}

	@GetMapping("/getAll")
	public DataResult<List<GetAllUserResponse>> getAll() {
		return this.userService.getAll();

	}

	@PostMapping("/getById")
	public DataResult<GetUserResponse> getById(@RequestParam int id) {
		return this.userService.getById(id);
	}

}
