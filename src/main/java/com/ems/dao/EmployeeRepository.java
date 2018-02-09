package com.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	/*public Employee insert(Employee employee);
	public Employee findAll(Employee employee);
	public Employee update(Employee employee);
	public Employee remove(Employee employee);
	public Employee save(Employee employee);
	*/
}
