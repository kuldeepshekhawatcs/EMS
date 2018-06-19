package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entities.Job;
import com.ems.litrals.JobStatus;
import com.ems.service.JobService;
import com.ems.utilities.JobListDTO;

@RestController()
public class JobRestController {
	
	@Autowired
	JobService jobService;
	
	@RequestMapping(value = "/getAllJobs", method = RequestMethod.GET)
	@ResponseBody
	public JobListDTO getAllEmployee() throws Exception{
		JobListDTO jobListDTO = new JobListDTO();
		jobListDTO.setJobList(jobService.findAll());
		return jobListDTO;
	}
	
	@RequestMapping(value = "/load-new-job", method = RequestMethod.GET)
	@ResponseBody
	public Job loadNewJob() throws Exception{
		return new Job();
	}
	
	@RequestMapping(value = "/create-new-job", method = RequestMethod.POST)
	@ResponseBody
	public Job createNewJob(@RequestBody Job job) throws Exception{
		job.setStatus(JobStatus.ESTIMATION_PENDING);
		return jobService.insert(job);
	}
	
	@RequestMapping(value = "/getJobCartById", method = RequestMethod.GET)
	@ResponseBody
	public Job getJobCartById(@RequestParam("id") Integer id) throws Exception{
		return jobService.findJobById(id);
	}
	
	@RequestMapping(value = "/cancel-job", method = RequestMethod.PUT)
	@ResponseBody
	public Job cancelJob(@RequestParam("id") Integer id) throws Exception{
		return jobService.cancelJob(id);
	}
}
