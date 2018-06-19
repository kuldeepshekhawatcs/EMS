package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entities.Invoice;

@Service
public interface InvoiceService {

	public Invoice insert(Invoice invoice) throws Exception;
	public List<Invoice> findAll() throws Exception;
	public Invoice update(Invoice convertedObject) throws Exception;
	public Invoice findById(String invoiceId);
	public Invoice finaliseInvoice(Invoice invoice) throws Exception;
	public Invoice getInvoiceByJobId(Integer jobId);
	
}
