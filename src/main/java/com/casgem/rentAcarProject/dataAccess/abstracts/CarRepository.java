package com.casgem.rentAcarProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casgem.rentAcarProject.entities.concretes.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	   Car findById(int id);
	   List<Car> getByBrandId(int id);
	   
	

}
