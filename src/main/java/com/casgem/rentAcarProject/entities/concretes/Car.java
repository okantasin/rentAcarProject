package com.casgem.rentAcarProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cars")
public class Car {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="description")
	private String description;
	
	
	@Column(name="dailyPrice")
	private double dailyPrice;
	
	@Column(name="plate")
	private String plate;
	
	
	@Column(name="kilometer")
	private String kilometer;
	
	@Column(name="state")
	private int id;

}
