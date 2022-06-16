package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.users.CreateUserRequest;
import com.casgem.rentAcarProject.business.requests.users.DeleteUserRequest;
import com.casgem.rentAcarProject.business.requests.users.UpdateUserRequest;
import com.casgem.rentAcarProject.business.responses.users.GetAllUserResponse;
import com.casgem.rentAcarProject.business.responses.users.GetUserResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface UserService {
	Result add(CreateUserRequest createUserRequest);
	
	Result update(UpdateUserRequest updateUserRequest);
	
	Result delete(DeleteUserRequest deleteUserRequest);
	
	DataResult<List<GetAllUserResponse>> getAll();
	
	DataResult<GetUserResponse> getById(int id);
}
