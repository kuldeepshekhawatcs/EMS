package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entities.Invoice;
import com.ems.service.InvoiceService;

@RestController
public class InvoiceRestController {

	
	@Autowired
	private InvoiceService invoiceService;
	
	
	@RequestMapping(value = "/create-invoice", method = RequestMethod.POST)
	@ResponseBody
	public Invoice createInvoice(@RequestBody Invoice invoice) throws Exception{
		
		return invoiceService.insert(invoice);
	}
	
	@RequestMapping(value = "/finalise-invoice", method = RequestMethod.POST)
	@ResponseBody
	public Invoice finaliseInvoice(@RequestBody Invoice invoice) throws Exception{
		
		return invoiceService.finaliseInvoice(invoice);
	}
	
	@RequestMapping(value = "/getInvoiceByJobId", method = RequestMethod.GET)
	@ResponseBody
	public Invoice getInvoiceByJobId(@RequestParam("id") Integer jobId) throws Exception{
		Invoice invoice = invoiceService.getInvoiceByJobId(jobId);
		return invoice;
	}
}
