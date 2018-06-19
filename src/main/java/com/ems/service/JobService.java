package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entities.Job;

@Service
public interface JobService {

	public Job insert(Job employee) throws Exception;
	public List<Job> findAll() throws Exception;
	public Job update(Job convertedObject) throws Exception;
	public Job findJobById(Integer jobId);
	public Job cancelJob(Integer id) throws Exception;
}
	