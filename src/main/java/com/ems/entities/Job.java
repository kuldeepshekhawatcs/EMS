package com.ems.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="job")
public class Job {

	@Id @NotNull
	private String ticketNo;
	@NotNull
	private String registrationNo;
	private String status;
	private String advisor;
	private String vehicleName;
	private java.util.Date arrivalDate;
	private java.util.Date delieveryDate;
	private String mobileNumber;
	private String partStatus;
	private String customerName;
	private String insuranceName;
	private String odoMeter;
	private String avgKmPerDay;
	private String vinNo;
	private String engineNo;
	private String modelName;
	private String make;
	private String modelYear;
	private String variant;
	private String vehicleColor;
	private String fuelType;
	private String serviceType;
	private String complaint;
	
	public String getOdoMeter() {
		return odoMeter;
	}
	public void setOdoMeter(String odoMeter) {
		this.odoMeter = odoMeter;
	}
	public String getAvgKmPerDay() {
		return avgKmPerDay;
	}
	public void setAvgKmPerDay(String avgKmPerDay) {
		this.avgKmPerDay = avgKmPerDay;
	}
	public String getVinNo() {
		return vinNo;
	}
	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public String getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getRegNo() {
		return registrationNo;
	}
	public void setRegNo(String regNo) {
		registrationNo = regNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdvisor() {
		return advisor;
	}
	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public java.util.Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(java.util.Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public java.util.Date getDelieveryDate() {
		return delieveryDate;
	}
	public void setDelieveryDate(java.util.Date delieveryDate) {
		this.delieveryDate = delieveryDate;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPartStatus() {
		return partStatus;
	}
	public void setPartStatus(String partStatus) {
		this.partStatus = partStatus;
	}
	
}
