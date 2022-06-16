package com.casgem.rentAcarProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casgem.rentAcarProject.entities.concretes.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer>{
	
	      Maintenance findById(int id); 
	
}
