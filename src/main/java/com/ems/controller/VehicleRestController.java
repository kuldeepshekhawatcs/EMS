package com.ems.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.service.JobService;
import com.ems.service.VehicleService;
import com.ems.utilities.DropDownList;

@RestController
public class VehicleRestController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private JobService jobService;
	
	
	@RequestMapping(value = "/getVehicles", method = RequestMethod.GET)
	@ResponseBody
	public DropDownList getLeaveCountByEmployeeId() throws Exception{
		DropDownList dropDownList = new DropDownList();
		dropDownList.setVehicleList(vehicleService.findAllVehicle());
		dropDownList.setPaymentModeList(jobService.findPaymentModes());
		return dropDownList;
		
	}
	
	

}
