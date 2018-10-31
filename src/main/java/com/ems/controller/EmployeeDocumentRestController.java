package com.ems.controller;

import java.sql.Blob;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entities.EmployeeDocuments;
import com.ems.litrals.Literals;
import com.ems.service.EmployeeDocumentService;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeTypeService;
import com.ems.service.RoleService;

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
	
	@RequestMapping(value = "/downloadAttachmentById/{docId}", method = RequestMethod.GET)
	public ResponseEntity downloadAttachmentById(@PathVariable("docId") Integer id) throws Exception{
			EmployeeDocuments document = employeeDocService.findById(id);
			Blob blob = document.getDoc();
			byte[] output = document.getDoc().getBytes(1L, (int)blob.length()); 
		    HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		    responseHeaders.setContentLength(output.length);
		    responseHeaders.set("Content-disposition", "attachment; filename=" + document.getDocumentDescription());
		    return new ResponseEntity(output, responseHeaders, HttpStatus.OK);		
	}
	
	
	

}
