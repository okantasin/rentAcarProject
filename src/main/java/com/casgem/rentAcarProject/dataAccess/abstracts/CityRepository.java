package com.casgem.rentAcarProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casgem.rentAcarProject.entities.concretes.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	
	City findById(int id);
	
	City findByName(String name);
}
