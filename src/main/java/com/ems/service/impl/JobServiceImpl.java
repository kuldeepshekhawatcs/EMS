package com.ems.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.JobRepository;
import com.ems.entities.Customer;
import com.ems.entities.Job;
import com.ems.litrals.JobStatus;
import com.ems.service.CustomerService;
import com.ems.service.JobService;

@Service
@Transactional
public class JobServiceImpl implements JobService{
	
	@Autowired
	private JobRepository JobRepository;

	@Autowired
	private CustomerService customerService;
	
	@Override
	public Job insert(Job job) throws Exception{
		Customer customer = null;
		if(job.getCustomer() != null)
		{
			customer = job.getCustomer();
			customer.setPaymentMode(customerService.getPaymentByName(customer.getPaymentMode()));
			customer = customerService.insert(customer);
		}
		job.setCustomer(customer);
		return JobRepository.save(job);
	}
	
	@Override
	public List<Job> findAll() throws Exception {
		return JobRepository.findAll();
	}

	@Override
	public Job update(Job convertedObject) throws Exception {
		return JobRepository.save(convertedObject);
	}

	@Override
	public Job findJobById(Integer jobId) {
		return JobRepository.findOne(jobId);
	}

	@Override
	public Job cancelJob(Integer id) throws Exception {
		Job job = findJobById(id);
		job.setStatus(JobStatus.CANCEL_JOBCARD);
		return update(job);
	}

	@Override
	public List<String> findPaymentModes() {
		return JobRepository.findPaymentModes();
		
	}


	
}
