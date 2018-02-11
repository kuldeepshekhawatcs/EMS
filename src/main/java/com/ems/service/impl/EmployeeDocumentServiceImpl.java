package com.ems.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.EmployeeDocumentRepository;
import com.ems.dao.EmployeeRepository;
import com.ems.entities.Employee;
import com.ems.entities.EmployeeDocuments;
import com.ems.service.EmployeeDocumentService;
import com.ems.service.EmployeeService;

@Service
@Transactional
public class EmployeeDocumentServiceImpl implements EmployeeDocumentService{
	
	@Autowired
	private EmployeeDocumentRepository employeeDocRepository;

	@Override
	public EmployeeDocuments insert(EmployeeDocuments employeeDoc) throws Exception{
		return employeeDocRepository.save(employeeDoc);
	}
	
	@Override
	public List<EmployeeDocuments> findAll() throws Exception {
		return employeeDocRepository.findAll();
	}
}
