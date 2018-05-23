package com.ems.utilities;

import java.util.ArrayList;
import java.util.List;

import com.ems.entities.Job;

public class JobListDTO {

	private List<Job> jobList = new ArrayList<>();

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}
}
