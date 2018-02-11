package com.ems.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_type")
public class EmployeeType {

	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_type_id")
	private Integer employeeTypeId;
	
	@Column(name="employee_type_code")
	private String employeeTypeCode;
	
	@Column(name="employee_type_description")
	private String employeeTypeDescription;
		
	@Column(name="leave_granted_per_year")
	private Integer leavesGrantedPerYear;
	

	public Integer getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(Integer employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	public String getEmployeeTypeCode() {
		return employeeTypeCode;
	}

	public void setEmployeeTypeCode(String employeeTypeCode) {
		this.employeeTypeCode = employeeTypeCode;
	}

	public String getEmployeeTypeDescription() {
		return employeeTypeDescription;
	}

	public void setEmployeeTypeDescription(String employeeTypeDescription) {
		this.employeeTypeDescription = employeeTypeDescription;
	}

	public Integer getLeavesGrantedPerYear() {
		return leavesGrantedPerYear;
	}

	public void setLeavesGrantedPerYear(Integer leavesGrantedPerYear) {
		this.leavesGrantedPerYear = leavesGrantedPerYear;
	}
	
	
}
