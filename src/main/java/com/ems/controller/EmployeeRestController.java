package com.ems.controller;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ems.entities.Employee;
import com.ems.entities.EmployeeDocuments;
import com.ems.entities.EmployeeType;
import com.ems.entities.Role;
import com.ems.litrals.Literals;
import com.ems.service.EmployeeDocumentService;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeTypeService;
import com.ems.service.RoleService;
import com.ems.utilities.EmployeeListDTO;
import com.ems.utilities.EmployeeUtility;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
public class EmployeeRestController {
	
	final static Logger logger = Logger.getLogger(EmployeeRestController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	EmployeeTypeService employeeTypeService;
	
	@Autowired
	EmployeeDocumentService employeeDocService;
	
	
	@RequestMapping(value = "/getallemployee", method = RequestMethod.GET)
	@ResponseBody
	public EmployeeListDTO getAllEmployee() throws Exception{
		EmployeeListDTO employeeListDTO = new EmployeeListDTO();
		employeeListDTO.setEmployeeList(employeeService.findAll());
		return employeeListDTO;
	}
	
	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public String addCandidate(MultipartHttpServletRequest request,
			@RequestHeader HttpHeaders requestHeader) throws Exception {

		String employeeData = request.getParameter("data");
		JsonObject convertedObject = new Gson().fromJson(employeeData,
				JsonObject.class);
		Employee employee = EmployeeUtility.convertToEmployee(convertedObject);
		String roleName = convertedObject.get("role").getAsString();
		String employeeTypeName = convertedObject.get("employeeType").getAsString();
		Role role = roleService.findByName(roleName);
		EmployeeType empType = employeeTypeService.findByName(employeeTypeName);
		employee.setRole(role);
		employee.setEmployeeType(empType);
		Employee emp = employeeService.insert(employee);
		Iterator<String> itr = request.getFileNames();
		while (itr.hasNext()) {
			EmployeeDocuments empDoc = new EmployeeDocuments();
			String key = itr.next();
			MultipartFile mpf = request.getFile(key);
			byte[] bytes = mpf.getBytes();
			Blob blob = new SerialBlob(bytes);
			empDoc.setDocumentDescription(key);
			empDoc.setEmployee(emp);
			empDoc.setDoc(blob);
			employeeDocService.insert(empDoc);
		}
		return Literals.SUCCESS_MESSAGE;
	}
}
