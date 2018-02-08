package com.ems.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestController {
	
	final static Logger logger = Logger.getLogger(EmployeeRestController.class);
	
	@RequestMapping(value="/getEmployee")
	public void getEmployee(){
		System.out.println("This is Get Employee");
		logger.info("START Get Employee");
	}
	
}
