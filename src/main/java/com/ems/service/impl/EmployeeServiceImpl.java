package com.ems.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.EmployeeRepository;
import com.ems.dao.UserRepository;
import com.ems.entities.Employee;
import com.ems.entities.User;
import com.ems.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public Employee insert(Employee employee) throws Exception{
		//employee.setUserName(employee.getPhoneNumber());
		//employee.setPassword("admin");
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> findAll() throws Exception {
		return employeeRepository.findAll();
	}

	@Override
	public Employee update(Employee convertedObject) throws Exception {
		return employeeRepository.save(convertedObject);
	}

	@Override
	public Employee findEmployeeById(Integer employeeId) {
		return employeeRepository.findOne(employeeId);
	}

	@Override
	public User validateCredentials(String username, String password) {
			return userRepository.validateCredentials(username, password);
	}

	@Override
	public Employee findEmployeeByUserId(Integer userId) {
		return employeeRepository.findEmployeeByUserId(userId);
	}
}
