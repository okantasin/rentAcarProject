package com.casgem.rentAcarProject.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import com.casgem.rentAcarProject.business.requests.user.CreateUserRequest;
import com.casgem.rentAcarProject.business.requests.user.DeleteUserRequest;
import com.casgem.rentAcarProject.business.requests.user.UpdateUserRequest;
import com.casgem.rentAcarProject.business.responses.users.GetAllUserResponse;
import com.casgem.rentAcarProject.business.responses.users.GetUserResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface UserService {
	Result add(CreateUserRequest createUserRequest) throws NumberFormatException, RemoteException;
	
	Result update(UpdateUserRequest updateUserRequest);
	
	Result delete(DeleteUserRequest deleteUserRequest);
	
	DataResult<List<GetAllUserResponse>> getAll();
	
	DataResult<List<GetAllUserResponse>> getAll(Integer pageNo, Integer pageSize);
	
	DataResult<GetUserResponse> getById(int id);
}
