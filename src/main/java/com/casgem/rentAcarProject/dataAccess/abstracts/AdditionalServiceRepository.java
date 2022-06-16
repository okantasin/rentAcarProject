package com.casgem.rentAcarProject.dataAccess.abstracts;

import java.util.List;

public interface AdditionalServiceRepository {

	AdditionalServiceRepository findById(int id);
	List<AdditionalServiceRepository> getByRentalId(int id);


}
