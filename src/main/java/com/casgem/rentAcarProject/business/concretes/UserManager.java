package com.casgem.rentAcarProject.business.concretes;

import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.UserService;
import com.casgem.rentAcarProject.business.requests.user.CreateUserRequest;
import com.casgem.rentAcarProject.business.requests.user.DeleteUserRequest;
import com.casgem.rentAcarProject.business.requests.user.UpdateUserRequest;
import com.casgem.rentAcarProject.business.responses.users.GetAllUserResponse;
import com.casgem.rentAcarProject.business.responses.users.GetUserResponse;
import com.casgem.rentAcarProject.core.utilities.adapters.abstracts.PersonCheckService;
import com.casgem.rentAcarProject.core.utilities.exceptions.BusinessException;
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

	@Autowired
	private PersonCheckService personCheckService;

	@Override
	public Result add(CreateUserRequest createUserRequest) throws NumberFormatException, RemoteException {
		checkIfRealPerson(createUserRequest);
		checkIfIdentityIsSame(createUserRequest.getNationalityNumber());
		checkIfEmailIsSame(createUserRequest.getEmail());
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

		List<User> users = this.userRepository.findAll();
		List<GetAllUserResponse> responses = users.stream()
				.map(user -> this.modelMapperService.forResponse().map(user, GetAllUserResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllUserResponse>>(responses, "ALL USERS LİSTED");
	}

	@Override
	public DataResult<List<GetAllUserResponse>> getAll(Integer pageNo, Integer pageSize) {

	     PageRequest pageable = PageRequest.of(pageNo, pageSize);
	     
		List<User> users = this.userRepository.findAll(pageable).getContent();
		List<GetAllUserResponse> response = users.stream()
				.map(user->this.modelMapperService.forResponse().map(user, GetAllUserResponse.class))
				.collect(Collectors.toList());
		return new  SuccessDataResult<List<GetAllUserResponse>>(response);
	}

	@Override
	public DataResult<GetUserResponse> getById(int id) {
		User user = this.userRepository.findById(id);
		GetUserResponse responses = this.modelMapperService.forResponse().map(user, GetUserResponse.class);

		return new SuccessDataResult<GetUserResponse>(responses, "USES LİSTED");
	}

	private void checkIfIdentityIsSame(String name) {
		User user = this.userRepository.findByNationalityNumber(name);
		if (user != null) {
			throw new BusinessException("USER.EXIST");
		}
	}

	private void checkIfRealPerson(CreateUserRequest user) throws NumberFormatException, RemoteException {
		if (!personCheckService.checkPerson(user)) {
			throw new BusinessException("USER.VALIDATION.ERROR");
		}
	}

	private void checkIfEmailIsSame(String email) {
		User user = this.userRepository.findByEmail(email);
		if (user != null) {
			throw new BusinessException("EMAIL.EXIST");
		}
	}

}
