package com.ems.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.ems.entities.Employee;
import com.ems.entities.EmployeeType;
import com.ems.entities.Role;
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
		//employee.setEmail(json.get("email").getAsString());
		employee.setFirstName(json.get("firstName").getAsString());
		
		//employee.setGender();
		
		employee.setIfscCode(json.get("ifscCode").getAsString());
		employee.setIsPVDocumentUpload(false);
		employee.setLastName(json.get("lastName").getAsString());
		employee.setLeaveBalance(0);
		employee.setMiddleName(json.get("middleName").getAsString());
		employee.setPanNumber(json.get("panNumber").getAsString());
		employee.setPhoneNumber(json.get("phoneNumber").getAsString());
		employee.setPinCode(json.get("pinCode").getAsString());
		EmployeeType employeeType = new EmployeeType();
		employeeType.setEmployeeTypeDescription("PERMANENT");
		employeeType.setLeavesGrantedPerYear(50);
		employee.setPinCode(json.get("pinCode").getAsString());
		return employee;
	}
	
	public static String writeAttachDocument(MultipartFile multiFile) throws Exception
	{
		String folderName = "F:\\New folder\\"; 
		String fileName  = multiFile.getName();
		File f = new File(folderName + fileName);
		 byte[] fileContent = multiFile.getBytes();
		Path path = Paths.get(f.getAbsolutePath());
		try {
			Files.write(path, fileContent);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	return f.getPath();
	}
	
}
