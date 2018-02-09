package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entities.Employee;

@Service
public interface EmployeeService {

	public Employee insert(Employee employee) throws Exception;
	public List<Employee> findAll() throws Exception;
}
