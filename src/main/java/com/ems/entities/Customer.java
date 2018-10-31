package com.ems.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name= "customer")
public class Customer {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	private String customerName;
	
	@ManyToOne
	@JoinColumn(name = "paymentmode_id")
	@Basic(fetch = FetchType.LAZY)
	private PaymentMode paymentModeObject;
	
	private String bankName;
	private String chequeNo;
	private String amount;
	private Date dateOfPayment;
	private String mobile;
	@Transient
	private String paymentMode;
	
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentModeObject = paymentMode;
	}
	private String address;
	public PaymentMode getPaymentModeObject() {
		return paymentModeObject;
	}
	public void setPaymentModeObject(PaymentMode paymentModeObject) {
		this.paymentModeObject = paymentModeObject;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

}
