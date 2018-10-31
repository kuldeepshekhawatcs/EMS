package com.ems.utilities;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDropDownlist {

	List<String> countryList = new ArrayList<>();
	List<String> rolesList = new ArrayList<>();
	List<String> empTypeList = new ArrayList<>();
	
	
	public List<String> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<String> countryList) {
		this.countryList = countryList;
	}
	public List<String> getRolesList() {
		return rolesList;
	}
	public void setRolesList(List<String> rolesList) {
		this.rolesList = rolesList;
	}
	public List<String> getEmpTypeList() {
		return empTypeList;
	}
	public void setEmpTypeList(List<String> empTypeList) {
		this.empTypeList = empTypeList;
	}
	
}
