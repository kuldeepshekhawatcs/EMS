package com.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.entities.EmployeeType;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer>{

	@Query("select distinct(e.employeeTypeDescription) from EmployeeType e")
	List<String> getDistinctEmployeeType();
	
}
