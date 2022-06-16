package com.casgem.rentAcarProject.business.abstracts;

import java.rmi.RemoteException;

import com.casgem.rentAcarProject.business.requests.users.CreateUserRequest;

public interface PersonCheckService {

	Boolean checkPerson(CreateUserRequest createUserRequest) throws RemoteException;
}
