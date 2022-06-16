package com.casgem.rentAcarProject.core.utilities.adapters.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.requests.users.CreateUserRequest;
import com.casgem.rentAcarProject.core.utilities.adapters.abstracts.PersonCheckService;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class MernisKpsAdapter implements PersonCheckService{

	
	
	@Override
	public boolean checkPerson(CreateUserRequest createUserRequest) throws RemoteException {
		KPSPublicSoapProxy kpsPublicSoapProxy= new KPSPublicSoapProxy();
		
		
		return kpsPublicSoapProxy.TCKimlikNoDogrula(createUserRequest.getNationalityId(), createUserRequest.getFirstName().toUpperCase(),
				createUserRequest.getLastName().toUpperCase(),
				createUserRequest.getBirthDay());
	}

}
