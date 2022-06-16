package com.casgem.rentAcarProject.dataAccess.abstracts;

import java.util.List;

public interface AdditionalFeatureServiceRepository {

	AdditionalFeatureServiceRepository findById(int id);
	List<AdditionalFeatureServiceRepository> getByRentalId(int id);


}
