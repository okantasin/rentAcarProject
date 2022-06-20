package com.casgem.rentAcarProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casgem.rentAcarProject.entities.concretes.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
