package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entities.EmployeeLeave;

@Service
public interface LeaveService {
	public Integer getEmployeeLeaveCountByEmployeeId(Integer employeeId);

	public EmployeeLeave applyLeave(EmployeeLeave leave);

	public List<EmployeeLeave> findAll();

	public EmployeeLeave updateLeaveStatus(EmployeeLeave leave) throws Exception;
}
