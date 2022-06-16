package com.casgem.rentAcarProject.dataAccess.abstracts;

public interface AdditionalFeatureItemRepository {
	AdditionalFeatureItemRepository findById(int id);
	AdditionalFeatureItemRepository findByName(String name);

}
