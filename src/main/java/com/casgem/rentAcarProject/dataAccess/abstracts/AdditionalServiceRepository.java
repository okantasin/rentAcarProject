package com.casgem.rentAcarProject.dataAccess.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.entities.concretes.AdditionalService;

public interface AdditionalServiceRepository {

	AdditionalService findById(int id);
	List<AdditionalService> getByRentalId(int id);


}
