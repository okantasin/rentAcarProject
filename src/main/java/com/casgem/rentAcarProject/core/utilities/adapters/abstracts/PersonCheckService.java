package com.casgem.rentAcarProject.core.utilities.adapters.abstracts;

import java.rmi.RemoteException;

import com.casgem.rentAcarProject.business.requests.user.CreateUserRequest;

public interface PersonCheckService {

	boolean checkPerson(CreateUserRequest createUserRequest) throws RemoteException;
}
