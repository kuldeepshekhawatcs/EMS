package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entities.Customer;
import com.ems.entities.PaymentMode;

@Service
public interface CustomerService {
	public Customer insert(Customer customer) throws Exception;
	public List<Customer> findAll() throws Exception;
	public Customer update(Customer empDoc) throws Exception;
	PaymentMode getPaymentByName(String paymentModeName) throws Exception;
}
