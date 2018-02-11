package com.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entities.Employee;
import com.ems.entities.EmployeeDocuments;

@Repository
public interface EmployeeDocumentRepository extends JpaRepository<EmployeeDocuments, Integer>{
	
}
