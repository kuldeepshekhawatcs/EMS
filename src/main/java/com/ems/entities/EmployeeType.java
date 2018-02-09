package com.ems.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_type")
public class EmployeeType {

	@Id
	@Column(name="employee_type_id")
	private Integer employeeTypeId;
	
	@Column(name="employee_type_code")
	private String employeeTypeCode;
	
	@Column(name="employee_type_description")
	private String employeeTypeDescription;
		
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "role_id")
	private Role role;
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

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
