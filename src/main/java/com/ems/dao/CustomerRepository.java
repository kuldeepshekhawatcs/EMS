package com.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ems.entities.Customer;
import com.ems.entities.PaymentMode;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select e from PaymentMode e where e.paymentMode =:name")
	PaymentMode getPaymentModeByName(@Param("name") String name);
}
