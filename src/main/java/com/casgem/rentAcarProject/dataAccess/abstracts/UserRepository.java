package com.casgem.rentAcarProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casgem.rentAcarProject.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
