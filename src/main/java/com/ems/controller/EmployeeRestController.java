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
import com.ems.litrals.Literals;
import com.ems.service.EmployeeDocumentService;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeTypeService;
import com.ems.service.RoleService;
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

	@RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
	public String updateCandidate(MultipartHttpServletRequest request,@RequestHeader HttpHeaders requestHeader) throws Exception {
		String employeeData = request.getParameter("data");
		GsonBuilder builder = new GsonBuilder(); 
		builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
			@Override
			public Date deserialize(JsonElement json,
					java.lang.reflect.Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				return new Date(json.getAsJsonPrimitive().getAsLong()); 
			} 
		});
		Employee convertedObject = builder.create().fromJson(employeeData,Employee.class);
		Employee emp = employeeService.update(convertedObject);
		Iterator<String> itr = request.getFileNames();
		List<EmployeeDocuments> docList = employeeDocService.getEmployeeAttachmentByEmployeeId(emp.getEmployeeId());
		while (itr.hasNext()) {
			String key = itr.next();
			BeanPropertyValueEqualsPredicate predicate = new BeanPropertyValueEqualsPredicate("documentDescription", key);
			EmployeeDocuments empDoc = (EmployeeDocuments) org.apache.commons.collections.CollectionUtils.find(docList, predicate);
			if(emp == null)
			{
				empDoc = new EmployeeDocuments();
			}
			MultipartFile mpf = request.getFile(key);
			byte[] bytes = mpf.getBytes();
			Blob blob = new SerialBlob(bytes);
			empDoc.setDocumentDescription(key);
			empDoc.setDoc(blob);
			employeeDocService.update(empDoc);
		}
		return Literals.SUCCESS_MESSAGE;
	}

	
	@RequestMapping(value = "/getEmployeeProfile", method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployeeProfile(@RequestParam("employeeId") Integer employeeId) throws Exception{
		return employeeService.findEmployeeById(employeeId);
	}

	@RequestMapping(value = "/submitUserCredentials", method = RequestMethod.GET)
	@ResponseBody
	public Employee submitUserCredentials(@RequestParam("username") String username,@RequestParam("password") String password) throws Exception{
		try{
		Employee emp = employeeService.validateCredentials(username,password);
		if(null == emp) throw new Exception("Invalid Credentials");
		return emp;
		}catch (Exception e) {
			throw e;
		}
		
	}

}
