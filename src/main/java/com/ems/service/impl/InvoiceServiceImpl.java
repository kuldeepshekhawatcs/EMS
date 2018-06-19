package com.ems.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.InvoiceRepositoryDao;
import com.ems.entities.Invoice;
import com.ems.entities.Items;
import com.ems.entities.Job;
import com.ems.litrals.JobStatus;
import com.ems.service.InvoiceService;
import com.ems.service.JobService;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired
	InvoiceRepositoryDao invoiceRepositoryDao;
	@Autowired
	private JobService jobService;

	@Override
	public Invoice insert(Invoice invoice) throws Exception {
		if (invoice.getInvoiceId() != null) {
			update(invoice);
			calculateInvoiceAmount(invoice);
		} else {
			int ticketNo = invoice.getJob().getTicketNo();
			invoice.setJob(jobService.findJobById(ticketNo));
			invoice.setInvoiceId(invoice.getGeneratedInvoiceId());
			calculateInvoiceAmount(invoice);
		}
		 return  invoiceRepositoryDao.save(invoice);
	}

	@Override
	public List<Invoice> findAll() throws Exception {
		return invoiceRepositoryDao.findAll();
	}

	@Override
	public Invoice update(Invoice convertedObject) throws Exception {
		return invoiceRepositoryDao.save(convertedObject);
	}

	private static void calculateInvoiceAmount(Invoice invoice) throws Exception
	{
		try{
		double subTotal = 0.0;
		if(!invoice.getItems().isEmpty()) {
			
			for(Items item : invoice.getItems())
			{
				if(item.isSelected())
				{
				subTotal = subTotal + item.getTotal();
				}
			}
			invoice.setSubTotal(subTotal);
			double balance = subTotal - invoice.getAdvancePaid();
			invoice.setBalance(balance);
		}
		}
		catch (Exception e) {
			throw new Exception("Exception occur while calculateInvoiceAmount ****");
		}
		
	}

	@Override
	public Invoice findById(String invoiceId) {
		return invoiceRepositoryDao.findById(invoiceId);
	}

	@Override
	public Invoice finaliseInvoice(Invoice invoice) throws Exception {
		try{
			List<Items> itemList = invoice.getItems();
			if(!itemList.isEmpty()) {
				
				Iterator<Items> itt = itemList.iterator();
				while(itt.hasNext())
				{
					Items item = itt.next();
					if(!item.isSelected())
					{
						itt.remove();
					}
				}
			}
		}
			catch (Exception e) {
				throw new Exception("Exception occur while finaliseInvoice ****");
			}
		invoice.getJob().setStatus(JobStatus.ESTIMATED);
		return update(invoice);
	}

	@Override
	public Invoice getInvoiceByJobId(Integer jobId) {
		return invoiceRepositoryDao.getInvoiceByJobId(jobId);
	}

}
