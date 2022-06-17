package com.casgem.rentAcarProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casgem.rentAcarProject.entities.concretes.AdditionalFeatureItem;

public interface AdditionalFeatureItemRepository extends JpaRepository<AdditionalFeatureItem, Integer>{
	AdditionalFeatureItem findById(int id);
	

}
