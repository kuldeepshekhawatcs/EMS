package com.ems.service.impl;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.LeaveRepository;
import com.ems.entities.EmployeeLeave;
import com.ems.service.LeaveService;
import com.ems.utilities.EmployeeUtility;

@Service
@Transactional
public class LeaveServiceImpl implements LeaveService{
	
	@Autowired
	private LeaveRepository leaveRepository;

	@Override
	public Integer getEmployeeLeaveCountByEmployeeId(Integer employeeId) {
		return leaveRepository.getEmployeeLeaveCountByEmployeeId(employeeId);
	}

	@Override
	public EmployeeLeave applyLeave(EmployeeLeave leave) {
		return leaveRepository.save(leave);
	}

	@Override
	public List<EmployeeLeave> findAll() {
		return leaveRepository.findAll();
	}

	@Override
	public EmployeeLeave updateLeaveStatus(EmployeeLeave leave) throws Exception {
		if(leave.getLeaveStatus().equalsIgnoreCase("APPROVED"))
		{
			int balanceLeaves = leave.getEmployee().getLeaveBalance() - leave.getTotalWorkingDaysOfLeave();
			leave.getEmployee().setLeaveBalance(balanceLeaves);
		}
		return leaveRepository.saveAndFlush(leave);
	}

	
	
}
