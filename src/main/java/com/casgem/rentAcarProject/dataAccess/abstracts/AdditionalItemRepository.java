package com.casgem.rentAcarProject.dataAccess.abstracts;

import com.casgem.rentAcarProject.entities.concretes.AdditionalItem;

public interface AdditionalItemRepository {
	AdditionalItem findById(int id);
	AdditionalItem findByName(String name);

}
