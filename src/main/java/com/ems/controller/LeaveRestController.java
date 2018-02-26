package com.ems.controller;


import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entities.Employee;
import com.ems.entities.EmployeeLeave;
import com.ems.service.EmployeeService;
import com.ems.service.LeaveService;
import com.ems.utilities.EmployeeListDTO;
import com.ems.utilities.WrapperDTO;

@RestController
public class LeaveRestController {
	
	@Autowired
	LeaveService leaveService;
	
	@Autowired
	EmployeeService employeeService; 
	
	
	@RequestMapping(value = "/getLeaveCountByEmployeeId", method = RequestMethod.GET)
	@ResponseBody
	public WrapperDTO getLeaveCountByEmployeeId(@RequestParam Integer employeeId) throws Exception{
		WrapperDTO obj = new WrapperDTO();
		obj.setValue(leaveService.getEmployeeLeaveCountByEmployeeId(employeeId));
		return obj;
	}
	
	@RequestMapping(value = "/applyLeave", method = RequestMethod.POST, headers = "Accept=application/json",
	consumes = "application/json", produces = "application/json")
	@ResponseBody
	public EmployeeLeave applyLeave(@RequestBody EmployeeLeave leave) throws Exception{
		leave.setLeaveStatus("PENDING");
		leave.setTotalWorkingDaysOfLeave(5);
		Employee emp = employeeService.findEmployeeById(leave.getEmployee().getEmployeeId());
		leave.setEmployee(emp);
		return leaveService.applyLeave(leave);		
	}
	
	@RequestMapping(value = "/getallLeaveRequested", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<EmployeeLeave> getallLeaveRequested() throws Exception{
		return leaveService.findAll();
	}
	
	@RequestMapping(value = "/updateLeaveStatus", method = RequestMethod.PUT)
	@ResponseBody
	public EmployeeLeave updateLeaveStatus(@RequestBody EmployeeLeave leave) throws Exception{
		return leaveService.updateLeaveStatus(leave);
	}


}
