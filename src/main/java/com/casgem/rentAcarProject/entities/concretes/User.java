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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
          @Id()
          @GeneratedValue(strategy = GenerationType.SEQUENCE)
          @Column(name="id")
          private int id;
          
          @Column(name="nationalityNumber")
          private String nationalityNumber;
          
          @Column(name="firstName")
          private String firstName;
          
          @Column(name="lastName")
          private String lastName;
          
          @Column(name="birthDay")
          private int birthDay;
          
          @Column(name="email")
          private String email;
          
          @Column(name="password")
          private int password;
       

}
