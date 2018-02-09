package com.ems.controller;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.log4j.Logger;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ems.entities.Employee;
import com.ems.entities.EmployeeDocuments;
import com.ems.litrals.Literals;
import com.ems.service.EmployeeService;
import com.ems.utilities.EmployeeUtility;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
public class EmployeeRestController {
	
	final static Logger logger = Logger.getLogger(EmployeeRestController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/getallemployee", method = RequestMethod.GET)
	public List<Employee> getAllEmployee() throws Exception{
		return employeeService.findAll();
	}
	
	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public String addCandidate(MultipartHttpServletRequest request,
			@RequestHeader HttpHeaders requestHeader) throws Exception {

		String employeeData = request.getParameter("data");
		JsonObject convertedObject = new Gson().fromJson(employeeData,
				JsonObject.class);
		Employee employee = EmployeeUtility.convertToEmployee(convertedObject);
		Iterator<String> itr = request.getFileNames();
		List<EmployeeDocuments> docList = null;
		while (itr.hasNext()) {
			docList = new ArrayList<>();
			EmployeeDocuments empDoc = new EmployeeDocuments();
			String key = itr.next();
			MultipartFile mpf = request.getFile(key);
			byte[] bytes = mpf.getBytes();
			Blob blob = new SerialBlob(bytes);
			empDoc.setDocumentDescription(key);
			//empDoc.setDocumentFile(bytes);
			empDoc.setDoc(blob);
			docList.add(empDoc);
			empDoc.setEmployee(employee);
		}
		
		employee.setEmployeeDoc(docList);
		employeeService.insert(employee);
		return Literals.SUCCESS_MESSAGE;
	}
}
