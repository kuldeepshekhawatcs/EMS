package com.ems.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ems.litrals.Country;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer employeeId;
	
	private String password;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Date dateOfBirth;
	
	private Integer phoneNumber;
	
	private String email;
	
	private Date dateOfJoining;
	
	private String address;
	
	private Integer pinCode;
	
	private String country;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "employee_type")
	private EmployeeType employeeType;
	
	private Integer bankAccountNumber;
	
	private String bankName;
	
	private String branchName;
	
	private String 	ifscCode;
	
	private Integer salary;
	
	private Integer leaveBalance;
	
		
	public Integer getEmployeeId() {
		return employeeId;
	}

	/*public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}*/

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		/*this.country = new Country();
		switch(countryName){
			case "AFGHANISTAN":
				this.country.setCountries(Countries.AFGHANISTAN);
				break;
			case "BAHAMAS":
				this.country.setCountries(Countries.BAHAMAS);
				break;
			case "CAMBODIA":
				
				break;
			case "DENMARK":
				break;
			case "ECUADOR":
				break;
			case "FIJI":
				break;
			case "GABON":
				break;
			case "HAITI":
				break;
			case "INDIA":
				break;
			case "JAPAN":
				break;
			case "KUWAIT":
				break;
			case "LUXEMBOURG":
				break;
			case "MYANMAR":
				break;
			case "NEPAL":
				break;
			case "PANAMA":
				break;
			case "QATAR":
				break;
			case "RUSSIA":
				break;
			case "SLOVAKIA":
				break;
			case "TURKEY":
				break;
			case "UNITEDKINGDOM":
				break;
			case "UNITEDSTATES":
				break;
			case "VIETNAM":
				break;
			case "YEMEN":
				break;
			case "ZIMBABWE":
				break;
		}*/
		this.country = country;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public Integer getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(Integer bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(Integer leaveBalance) {
		this.leaveBalance = leaveBalance;
	}
}
