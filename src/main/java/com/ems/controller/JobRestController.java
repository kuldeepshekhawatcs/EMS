package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entities.Job;
import com.ems.service.JobService;
import com.ems.utilities.JobListDTO;

@RestController()
public class JobRestController {
	
	@Autowired
	JobService jobService;
	
	@RequestMapping(value = "/job/addjob", method = RequestMethod.POST)
	public String addCandidate(@RequestBody Job job) throws Exception {
		System.out.println(job);
		return null;
	}
	
	@RequestMapping(value = "/getAllJobs", method = RequestMethod.GET)
	@ResponseBody
	public JobListDTO getAllEmployee() throws Exception{
		JobListDTO jobListDTO = new JobListDTO();
		jobListDTO.setJobList(jobService.findAll());
		return jobListDTO;
	}
	
}
