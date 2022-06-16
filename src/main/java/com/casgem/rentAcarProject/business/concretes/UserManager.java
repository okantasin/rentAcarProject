package com.casgem.rentAcarProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.UserService;
import com.casgem.rentAcarProject.business.requests.users.CreateUserRequest;
import com.casgem.rentAcarProject.business.requests.users.DeleteUserRequest;
import com.casgem.rentAcarProject.business.requests.users.UpdateUserRequest;
import com.casgem.rentAcarProject.business.responses.users.GetAllUserResponse;
import com.casgem.rentAcarProject.business.responses.users.GetUserResponse;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessDataResult;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.UserRepository;
import com.casgem.rentAcarProject.entities.concretes.User;

@Service

public class UserManager implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateUserRequest createUserRequest) {
		User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
		this.userRepository.save(user);
		return new SuccessResult("USER.ADD");
	}

	@Override
	public Result update(UpdateUserRequest updateUserRequest) {
       User user = this.userRepository.findById(updateUserRequest.getId());
	   user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
		this.userRepository.save(user);
	   return new SuccessResult("USER.UPDATE");
	}

	@Override
	public Result delete(DeleteUserRequest deleteUserRequest) {
		this.userRepository.deleteById(deleteUserRequest.getId());

		return new SuccessResult("USER.DELETE");
	}

	@Override
	public DataResult<List<GetAllUserResponse>> getAll() {
		List<User> users= this.userRepository.findAll();
		List<GetAllUserResponse> responses =
				users.stream()
				.map(user->this.modelMapperService
						.forResponse()
						.map(user,GetAllUserResponse.class))
				.collect(Collectors.toList());
				
		return new SuccessDataResult<List<GetAllUserResponse>>(responses);
	}

	@Override
	public DataResult<GetUserResponse> getById(int id) {
		User user = this.userRepository.findById(id);
		GetUserResponse responses = this.modelMapperService.forResponse()
				.map(user, GetUserResponse.class);
		
		return new SuccessDataResult<GetUserResponse>(responses);
	}

	
}
