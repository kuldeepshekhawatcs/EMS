package com.ems.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.EmployeeRepository;
import com.ems.dao.JobRepository;
import com.ems.dao.UserRepository;
import com.ems.entities.Employee;
import com.ems.entities.Job;
import com.ems.entities.User;
import com.ems.litrals.JobStatus;
import com.ems.service.EmployeeService;
import com.ems.service.InvoiceService;
import com.ems.service.JobService;

@Service
@Transactional
public class JobServiceImpl implements JobService{
	
	@Autowired
	private JobRepository JobRepository;

	
	@Override
	public Job insert(Job job) throws Exception{
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


	
}
