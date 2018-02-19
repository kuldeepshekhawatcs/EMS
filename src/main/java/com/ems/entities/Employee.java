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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="employee")
public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer employeeId;
	
	private String password;
	  
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	private Date dateOfBirth;
	
	private String phoneNumber;
	
	private String email;
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	private Date dateOfJoining;
	
	private String address;
	
	private String pinCode;
	
	private String country;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "employee_type")
	private EmployeeType employeeType;
	
	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "role_id")
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public String getDrivinglicenseNumber() {
		return drivinglicenseNumber;
	}

	public void setDrivinglicenseNumber(String drivinglicenseNumber) {
		this.drivinglicenseNumber = drivinglicenseNumber;
	}

	private String bankAccountNumber;
	
	private String bankName;
	
	private String branchName;
	
	private String 	ifscCode;
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String salary;
	
	private String panNumber; 
	
	private String drivinglicenseNumber;
	
	private Boolean IsPVDocumentUpload;
	
	
	public Boolean getIsPVDocumentUpload() {
		return IsPVDocumentUpload;
	}

	public void setIsPVDocumentUpload(Boolean isPVDocumentUpload) {
		IsPVDocumentUpload = isPVDocumentUpload;
	}

	public String getDrivingLicenseNumber() {
		return drivinglicenseNumber;
	}

	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivinglicenseNumber = drivingLicenseNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	private Integer leaveBalance;
	
	public Gender gender;
	
	public enum  Gender {
		MALE,FEMALE;
	}
	
	private String adharNumber;
	
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
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

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
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
}
