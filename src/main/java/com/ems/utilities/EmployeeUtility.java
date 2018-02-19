package com.ems.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.assertj.core.util.DateUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.ems.entities.Employee;
import com.ems.entities.Employee.Gender;
import com.ems.entities.EmployeeType;
import com.ems.entities.Role;
import com.google.gson.JsonObject;


public class EmployeeUtility {
	
	public static SimpleDateFormat formattor = new SimpleDateFormat("yyyy-MM-dd");

	public static Employee convertToEmployee(JsonObject json) throws ParseException, JSONException
	{
		Employee employee = new Employee();
		employee.setAddress(json.get("address") == null ? null : json.get("address").getAsString());
		employee.setAdharNumber(json.get("adharNumber") == null ? null :  json.get("adharNumber").getAsString());
		employee.setBankAccountNumber(json.get("bankAccountNumber") == null ? null : json.get("bankAccountNumber").getAsString());
		employee.setBankName(json.get("bankName").getAsString() == null ? null : json.get("bankName").getAsString());
		employee.setBranchName(json.get("branchName").getAsString() == null ? null : json.get("branchName").getAsString());
		employee.setCountry(json.get("country").getAsString() == null ? null : json.get("country").getAsString());
		Date doB = null ;
		Date doJ = null; 
		try{
		doB = formattor.parse(json.get("dateOfBirth").getAsString() == null ? null : json.get("dateOfBirth").getAsString());
		doJ = formattor.parse(json.get("dateOfJoining").getAsString() == null ? null : json.get("dateOfJoining").getAsString()); 
		}catch(Exception e)
		{
			doB =new Date(Long.valueOf(json.get("dateOfBirth").getAsString()));
			doJ = new Date(Long.valueOf(json.get("dateOfJoining").getAsString()));
		}
		employee.setDateOfBirth(doB);
		employee.setDateOfJoining(doJ);
		employee.setDrivingLicenseNumber(json.get("drivinglicenseNumber").getAsString() == null ? null : json.get("drivinglicenseNumber").getAsString());
		employee.setEmail(json.get("email").getAsString() == null ? null : json.get("email").getAsString());
		employee.setFirstName(json.get("firstName").getAsString() == null ? null : json.get("firstName").getAsString());
		employee.setIfscCode(json.get("ifscCode").getAsString() == null ? null : json.get("ifscCode").getAsString());
		employee.setIsPVDocumentUpload(false);
		employee.setLastName(json.get("lastName").getAsString() == null ? null : json.get("lastName").getAsString());
		employee.setLeaveBalance(null);
		employee.setMiddleName(json.get("middleName").getAsString() == null ? null : json.get("middleName").getAsString());
		employee.setPanNumber(json.get("panNumber").getAsString() == null ? null : json.get("panNumber").getAsString());
		employee.setPhoneNumber(json.get("phoneNumber").getAsString() == null ? null : json.get("phoneNumber").getAsString());
		employee.setPinCode(json.get("pinCode").getAsString() == null ? null : json.get("pinCode").getAsString());
		if(json.get("gender").getAsString().equalsIgnoreCase("MALE"))	employee.setGender(Gender.MALE);
		else  employee.setGender(Gender.FEMALE);
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
