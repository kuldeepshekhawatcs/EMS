package com.ems.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.ems.litrals.Literals;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable{

	@Id
	private String invoiceId;
	private double shipping;
	private double miscellanous;
	private double other;
	private double subTotal;
	private double balance;
	private double advancePaid;
	
	public double getAdvancePaid() {
		return advancePaid;
	}

	public void setAdvancePaid(double advancePaid) {
		this.advancePaid = advancePaid;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@OneToMany(cascade = CascadeType.ALL)
	private List<Items> items = new ArrayList<>();
	
	@OneToOne(cascade = {CascadeType.ALL})
	@NotNull
    @JoinColumn(name = "job_id")
	private Job job;

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getGeneratedInvoiceId()
	{
		String value = "INV-" + generateInvoiceId().toString();
		return value;
	}
	
	private static Integer generateInvoiceId() {
		Random random = new Random();
		Integer value =  random.nextInt((Literals.MAX - Literals.MIN) + 1) + Literals.MIN;
		return value;
	}


	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}

	public double getMiscellanous() {
		return miscellanous;
	}

	public void setMiscellanous(double miscellanous) {
		this.miscellanous = miscellanous;
	}

	public double getOther() {
		return other;
	}

	public void setOther(double other) {
		this.other = other;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public void addItem(Items item)
	{
		try {
			this.items.add(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
