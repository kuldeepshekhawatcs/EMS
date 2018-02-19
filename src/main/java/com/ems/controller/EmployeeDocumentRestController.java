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
import com.google.gson.JsonObject;

@RestController
public class EmployeeDocumentRestController {
	
	final static Logger logger = Logger.getLogger(EmployeeDocumentRestController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	EmployeeTypeService employeeTypeService;
	
	@Autowired
	EmployeeDocumentService employeeDocService;
	
	
	@RequestMapping(value = "/getEmployeeAttachmentByEmployeeId", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeDocuments> getEmployeeAttachmentByEmployeeId(@RequestParam Integer employeeId) throws Exception{
		return employeeDocService.getEmployeeAttachmentByEmployeeId(employeeId);		
	}
	
	@RequestMapping(value = "/deleteAttachmentById", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteAttachmentById(@RequestParam Integer documentId) throws Exception{
		 employeeDocService.deleteAttachmentById(documentId);
		 return Literals.SUCCESS_MESSAGE;
	}

}
