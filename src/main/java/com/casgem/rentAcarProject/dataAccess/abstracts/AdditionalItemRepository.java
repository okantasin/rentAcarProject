package com.casgem.rentAcarProject.dataAccess.abstracts;

public interface AdditionalItemRepository {
	AdditionalItemRepository findById(int id);
	AdditionalItemRepository findByName(String name);

}
