package com.ems.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.ems.entities.Employee;
import com.google.gson.JsonObject;


public class EmployeeUtility {
	
	public static SimpleDateFormat formattor = new SimpleDateFormat("yyyy-MM-dd");

	public static Employee convertToEmployee(JsonObject json) throws ParseException, JSONException
	{
		Employee employee = new Employee();
		employee.setAddress(json.get("address").getAsString());
		employee.setAdharNumber(json.get("adharNumber").getAsString());
		employee.setBankAccountNumber(json.get("bankAccountNumber").getAsString());
		employee.setBankName(json.get("bankName").getAsString());
		employee.setBranchName(json.get("branchName").getAsString());
		employee.setCountry(json.get("country").getAsString());
		Date doB = formattor.parse(json.get("dateOfBirth").getAsString());
		employee.setDateOfBirth(doB);
		Date doJ = formattor.parse(json.get("dateOfJoining").getAsString());
		employee.setDateOfJoining(doJ);
		employee.setDrivingLicenseNumber(json.get("drivinglicenseNumber").getAsString());
		employee.setEmail(json.get("email").getAsString());
		employee.setFirstName(json.get("firstName").getAsString());
		
		//employee.setGender();
		
		employee.setIfscCode(json.get("ifscCode").getAsString());
		employee.setIsPVDocumentUpload(false);
		employee.setLastName(json.get("lastName").getAsString());
		employee.setLeaveBalance(0);
		employee.setMiddleName(json.get("middleName").getAsString());
		employee.setPanNumber(json.get("panNumber").getAsString());
		employee.setPhoneNumber(json.get("phoneNumber").getAsString());
		//employee.setPinCode(json.get("pinCode").getAsString());
		employee.setSalary("0");
		return employee;
	}
	
}
