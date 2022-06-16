package com.casgem.rentAcarProject.entities.concretes;

import java.time.LocalDate;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rentals")
public class Rental {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="pickup_date")
	private LocalDate pickupDate;
	
	@Column(name="return_date")
	private LocalDate returnDate;
	
	@Column(name="total_days")
	private int totalDays;
	
	@Column(name="total_price")
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="car_id")
	private Car car;
	
	//Arabayı kiraladığımız şehir
	@ManyToOne
	@JoinColumn(name="pickup_city_id")
	private City pickupCityId;
	//Arabayı teslim ettiğimiz şehir
	@ManyToOne
	@JoinColumn(name="return_city_id")
	private City returnCityId;
	
	@OneToMany(mappedBy = "rental")
	private List<AdditionalFeatureService> additionalFeatureServices;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
}
