package com.ems.controller;

import java.sql.Blob;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.websocket.Session;

import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ems.entities.Employee;
import com.ems.entities.EmployeeDocuments;
import com.ems.entities.EmployeeType;
import com.ems.entities.Role;
import com.ems.entities.User;
import com.ems.litrals.Literals;
import com.ems.service.EmployeeDocumentService;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeTypeService;
import com.ems.service.RoleService;
import com.ems.utilities.EmployeeDTO;
import com.ems.utilities.EmployeeDropDownlist;
import com.ems.utilities.EmployeeListDTO;
import com.ems.utilities.EmployeeUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

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
		EmployeeDTO convertedObject = new Gson().fromJson(employeeData,
				EmployeeDTO.class);
		Employee employee = EmployeeUtility.convertToEmployee(convertedObject);
		String roleName = convertedObject.getRole();
		String employeeTypeName = convertedObject.getEmployeeType();
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
			empDoc.setUser(emp.getUser());
			empDoc.setDoc(blob);
			employeeDocService.insert(empDoc);
		}
		return Literals.SUCCESS_MESSAGE;
	}

	@RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
	public String updateCandidate(MultipartHttpServletRequest request,@RequestHeader HttpHeaders requestHeader) throws Exception {
		String employeeData = request.getParameter("data");
		Gson builder = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Employee employee = builder.fromJson(employeeData,Employee.class);
		//Employee employee = EmployeeUtility.convertToEmployee(convertedObject);
		Employee emp = employeeService.update(employee);
		Iterator<String> itr = request.getFileNames();
		List<EmployeeDocuments> docList = employeeDocService.getEmployeeAttachmentByEmployeeId(emp.getUser().getId());
		while (itr.hasNext()) {
			String key = itr.next();
			BeanPropertyValueEqualsPredicate predicate = new BeanPropertyValueEqualsPredicate("documentDescription", key);
			EmployeeDocuments empDoc = (EmployeeDocuments) org.apache.commons.collections.CollectionUtils.find(docList, predicate);
			if(empDoc == null)
			{
				empDoc = new EmployeeDocuments();
			}
			MultipartFile mpf = request.getFile(key);
			byte[] bytes = mpf.getBytes();
			Blob blob = new SerialBlob(bytes);
			empDoc.setDocumentDescription(key);
			empDoc.setDoc(blob);
			empDoc.setUser(emp.getUser());
			employeeDocService.update(empDoc);
		}
		return Literals.SUCCESS_MESSAGE;
	}

	
	@RequestMapping(value = "/getEmployeeProfile", method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployeeProfile(@RequestParam("employeeId") Integer employeeId) throws Exception{
		return employeeService.findEmployeeById(employeeId);
	}

	@RequestMapping(value = "/submitUserCredentials", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User submitUserCredentials(@RequestBody User user) throws Exception{
		try{
		user = employeeService.validateCredentials(user.getUserName(),user.getPassword());
		if(null == user) throw new Exception("Invalid Credentials");
		return user;
		}catch (Exception e) {
			throw e;
		}
		
	}
	
	@RequestMapping(value = "/findEmployeeByUserId", method = RequestMethod.GET)
	@ResponseBody
	public Employee findEmployeeByUserId(@RequestParam("userId") Integer userId) throws Exception{
		return employeeService.findEmployeeByUserId(userId);
	}
	
	@RequestMapping(value = "/dropdownlists", method = RequestMethod.GET)
	@ResponseBody
	public EmployeeDropDownlist getDropDownlistsForEmployeeAddition() throws Exception{
		EmployeeDropDownlist employeeDropDownlist = new EmployeeDropDownlist();
		employeeDropDownlist.setEmpTypeList(employeeTypeService.getDistinctEmployeeType());
		employeeDropDownlist.setRolesList(roleService.getDistinctRole());
		return employeeDropDownlist;
		 
	}
}
