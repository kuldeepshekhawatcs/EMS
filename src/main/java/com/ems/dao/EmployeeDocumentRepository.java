package com.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ems.entities.Employee;
import com.ems.entities.EmployeeDocuments;

@Repository
public interface EmployeeDocumentRepository extends JpaRepository<EmployeeDocuments, Integer>{
	
	@Query("select e from EmployeeDocuments e where e.employee.employeeId = :employeeId")
	public List<EmployeeDocuments> getEmployeeAttachmentByEmployeeId(@Param("employeeId")Integer employeeId);
}
