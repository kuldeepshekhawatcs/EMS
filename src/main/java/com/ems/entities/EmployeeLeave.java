package com.ems.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.ems.litrals.Country;

@Entity
public class EmployeeLeave {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int leaveId;

	@ManyToOne(cascade = CascadeType.ALL)@NotNull
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@Column(name="leave_from_date")
	private Date leaveFromDate;
	
	@Column(name="leave_to_date")
	private Date leaveToDate;
	
	@Column(name="total_working_days_of_leave")
	private Integer totalWorkingDaysOfLeave;
	
	@Column(name="leave_description")
	private String leaveDescription;
	
	@Column(name="leave_status")
	private String leaveStatus;

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getLeaveFromDate() {
		return leaveFromDate;
	}

	public void setLeaveFromDate(Date leaveFromDate) {
		this.leaveFromDate = leaveFromDate;
	}

	public Date getLeaveToDate() {
		return leaveToDate;
	}

	public void setLeaveToDate(Date leaveToDate) {
		this.leaveToDate = leaveToDate;
	}

	public Integer getTotalWorkingDaysOfLeave() {
		return totalWorkingDaysOfLeave;
	}

	public void setTotalWorkingDaysOfLeave(Integer totalWorkingDaysOfLeave) {
		this.totalWorkingDaysOfLeave = totalWorkingDaysOfLeave;
	}

	public String getLeaveDescription() {
		return leaveDescription;
	}

	public void setLeaveDescription(String leaveDescription) {
		this.leaveDescription = leaveDescription;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
}
