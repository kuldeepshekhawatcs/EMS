package com.ems.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.util.IgnoreJava6Requirement;
import org.springframework.web.bind.annotation.Mapping;

import com.ems.litrals.Country;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="employee")
public class Employee implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer employeeId;
	
	private Date dateOfJoining;
		
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "employee_type")
	private EmployeeType employeeType;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "role_id")
	private Role role;

	@JsonIgnoreProperties(ignoreUnknown = true)
	private String salary;
	
	private Integer leaveBalance;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Integer getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(Integer leaveBalance) {
		this.leaveBalance = leaveBalance;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

}
