package com.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ems.entities.Invoice;

public interface InvoiceRepositoryDao extends JpaRepository<Invoice, Integer>{

	@Query("select e from Invoice e where e.invoiceId = :invoiceId")
	Invoice findById(String invoiceId);
	
	@Query("select e from Invoice e where e.job.ticketNo = :jobId")
	Invoice getInvoiceByJobId(@Param("jobId") Integer jobId);
	

}
