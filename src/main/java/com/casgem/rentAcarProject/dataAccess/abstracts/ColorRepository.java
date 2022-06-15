package com.casgem.rentAcarProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casgem.rentAcarProject.entities.concretes.Color;

public interface ColorRepository extends JpaRepository<Color, Integer>{
	Color getById(int id);
	Color findByName(String name);

}
