package com.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ems.entities.Employee;
import com.ems.entities.Job;
import com.ems.entities.User;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>{

	@Query("select e.paymentMode from PaymentMode e")
	List<String> findPaymentModes();

	
}
