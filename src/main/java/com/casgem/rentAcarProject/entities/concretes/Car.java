package com.casgem.rentAcarProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	@Column(name="id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "dailyPrice")
	private double dailyPrice;
	
	@Column(name = "plate")
	private String plate;
	
	@Column(name="state")
	private int state;
	
	@Column(name = "kilometer")
	private Integer kilometer;
	
	@Column(name="min_findeks_score")
	private int minFindeksScore;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;

	//Bir araç bir çok kez bakıma gidebilir
	@OneToMany(mappedBy = "car")
	private List<Maintenance> maintenances;
	//Bir araç birden çok kiralanabilir.
	@OneToMany(mappedBy = "car")
	private List<Rental> rentals;
	
	//Bir şehirde birden fazla araç olabilir
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;

	

}
