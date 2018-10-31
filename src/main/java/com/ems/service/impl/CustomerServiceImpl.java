package com.ems.service.impl;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.CustomerRepository;
import com.ems.dao.EmployeeDocumentRepository;
import com.ems.entities.Customer;
import com.ems.entities.EmployeeDocuments;
import com.ems.entities.PaymentMode;
import com.ems.service.CustomerService;
import com.ems.service.EmployeeDocumentService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public Customer insert(Customer customer) throws Exception {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAll() throws Exception {
		return customerRepository.findAll();
	}

	@Override
	public Customer update(Customer empDoc) throws Exception {
		return insert(empDoc);
	}

	@Override
	public PaymentMode getPaymentByName(String paymentModeName) throws Exception {
		return customerRepository.getPaymentModeByName(paymentModeName);
	}
	
	
}
