package com.casgem.rentAcarProject.core.utilities.adapters.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.requests.user.CreateUserRequest;
import com.casgem.rentAcarProject.core.utilities.adapters.abstracts.PersonCheckService;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class MernisKpsAdapter implements PersonCheckService{

	
	
	@Override
	public boolean checkPerson(CreateUserRequest user) throws RemoteException {
		
		KPSPublicSoapProxy kpsPublicSoapProxy= new KPSPublicSoapProxy();
		
		 boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(user.getNationalityNumber()), user.getFirstName().toUpperCase(),
				 
				 user.getLastName().toUpperCase(),
				
				 user.getBirthDay());
		 
		 return result;
		 
	
	}

}
