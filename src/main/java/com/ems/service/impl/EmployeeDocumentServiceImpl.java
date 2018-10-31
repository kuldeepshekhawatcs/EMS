package com.ems.service.impl;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.EmployeeDocumentRepository;
import com.ems.entities.EmployeeDocuments;
import com.ems.service.EmployeeDocumentService;

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

	@Override
	public List<EmployeeDocuments> getEmployeeAttachmentByEmployeeId(Integer employeeId) {
		return employeeDocRepository.getEmployeeAttachmentByEmployeeId(employeeId);
	}

	@Override
	public void deleteAttachmentById(Integer documentId) {
		 employeeDocRepository.delete(documentId);
	}

	@Override
	public EmployeeDocuments update(EmployeeDocuments empDoc) {
		return employeeDocRepository.save(empDoc);
	}

	@Override
	public EmployeeDocuments findById(Integer docId) {
		return employeeDocRepository.findOne(docId);
	}
}
