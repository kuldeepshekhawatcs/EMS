package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entities.EmployeeType;

@Service
public interface EmployeeTypeService {

	public EmployeeType insert(EmployeeType employee) throws Exception;
	public List<EmployeeType> findAll() throws Exception;
	public EmployeeType findByName(String empTypeName) throws Exception;
	public List<String> getDistinctEmployeeType() throws Exception;
	
}
