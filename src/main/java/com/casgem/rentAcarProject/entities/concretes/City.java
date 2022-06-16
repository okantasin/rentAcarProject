package com.casgem.rentAcarProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cities")
public class City {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	
	@OneToMany(mappedBy = "city")
	private List<Car> cars;
	
	@OneToMany(mappedBy = "pickupCityId")
	private List<Rental> pickupCityRentals;
	
	@OneToMany(mappedBy =  "returnCityId")
	private List<Rental> returnCityRentals;
	

	
	

}
