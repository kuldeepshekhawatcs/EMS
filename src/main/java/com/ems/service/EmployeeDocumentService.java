package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entities.Employee;
import com.ems.entities.EmployeeDocuments;

@Service
public interface EmployeeDocumentService {
	public EmployeeDocuments insert(EmployeeDocuments employeeDocument) throws Exception;
	public List<EmployeeDocuments> findAll() throws Exception;
	public List<EmployeeDocuments> getEmployeeAttachmentByEmployeeId(Integer employeeId);
	public void deleteAttachmentById(Integer employeeId);
	public EmployeeDocuments update(EmployeeDocuments empDoc);
}
