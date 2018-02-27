package com.ems.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;

import com.ems.entities.Employee;
import com.ems.entities.User;
import com.ems.entities.User.Gender;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class EmployeeUtility {
	
	public static SimpleDateFormat formattor = new SimpleDateFormat("yyyy-MM-dd");

	public static Employee convertToEmployee(EmployeeDTO json) throws ParseException, JSONException
	{
		Employee emp = new Employee();
		User employee = new User();
		
		employee.setAddress(json.getAddress());
		employee.setAdharNumber(json.getAdharNumber());
		employee.setBankAccountNumber(json.getBankAccountNumber());
		employee.setBankName(json.getBankName());
		employee.setBranchName(json.getBranchName());
		employee.setCountry(json.getCountry());
		employee.setDateOfBirth(json.getDateOfBirth());
		emp.setDateOfJoining(json.getDateOfJoining());
		employee.setDrivinglicenseNumber(json.getDrivinglicenseNumber());
		employee.setEmail(json.getEmail());
		employee.setFirstName(json.getFirstName());
		employee.setIfscCode(json.getIfscCode());
		employee.setLastName(json.getLastName());
		employee.setMiddleName(json.getMiddleName());
		employee.setPanNumber(json.getPanNumber());
		employee.setPhoneNumber(json.getPhoneNumber());
		employee.setPinCode(json.getPinCode());
		/*if(json.getGender().equalsIgnoreCase("MALE"))	employee.setGender(Gender.MALE);
		else  employee.setGender(Gender.FEMALE);*/
		employee.setGender(json.getGender());
		emp.setUser(employee);
		return emp;
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
	
	public static int findWorkingDay(Date fromDate, Date toDate) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(fromDate);
		cal2.setTime(toDate);
		int numberOfDays = 0;
		while (cal1.before(cal2)) {
			if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))
					&& (Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
				numberOfDays++;
			}
			cal1.add(Calendar.DATE, 1);
		}
		return numberOfDays;
	}
	
}
