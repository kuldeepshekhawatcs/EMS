package com.ems.utilities;

import java.util.ArrayList;
import java.util.List;

import com.ems.entities.Vehicle;


public class DropDownList {

	private List<String> paymentModeList = new ArrayList<>();
	private List<Vehicle> vehicleList = new ArrayList<>();
	
	
	public List<String> getPaymentModeList() {
		return paymentModeList;
	}
	public void setPaymentModeList(List<String> paymentModeList) {
		this.paymentModeList = paymentModeList;
	}
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
}
