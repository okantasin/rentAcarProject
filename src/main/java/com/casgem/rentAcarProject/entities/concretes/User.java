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
@Table(name="users")
public class User {
          @Id()
          @GeneratedValue(strategy = GenerationType.SEQUENCE)
          @Column(name="id")
          private int id;
          
          @Column(name="nationality_number")
          private String nationalityNumber;
          
          @Column(name="first_name")
          private String firstName;
          
          @Column(name="last_name")
          private String lastName;
          
          @Column(name="birth_day")
          private int birthDay;
          
          @Column(name="email")
          private String email;
          
          @Column(name="password")
          private int password;
          
          @OneToMany(mappedBy = "user")
          List<Rental> rentals;
       

}
