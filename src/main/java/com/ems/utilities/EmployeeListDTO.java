package com.ems.utilities;

import java.util.ArrayList;
import java.util.List;

import com.ems.entities.Employee;

public class EmployeeListDTO {

	private List<Employee> employeeList = new ArrayList<>();

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
