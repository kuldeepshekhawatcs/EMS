package com.ems.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.EmployeeRepository;
import com.ems.dao.EmployeeTypeRepository;
import com.ems.entities.Employee;
import com.ems.entities.EmployeeType;
import com.ems.entities.Role;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeTypeService;

@Service
@Transactional
public class EmployeeTypeServiceImpl implements EmployeeTypeService{
	
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;

	@Override
	public EmployeeType insert(EmployeeType employeeType) throws Exception{
		return employeeTypeRepository.save(employeeType);
	}
	
	@Override
	public List<EmployeeType> findAll() throws Exception {
		return employeeTypeRepository.findAll();
	}
	
	public EmployeeType findByName(String empTypeName) throws Exception{
		if(empTypeName.equalsIgnoreCase("REGULAR") || empTypeName.equalsIgnoreCase("CONTRACT"))
			return employeeTypeRepository.findOne(1);
		else
			return employeeTypeRepository.findOne(2);
	}
		
}

