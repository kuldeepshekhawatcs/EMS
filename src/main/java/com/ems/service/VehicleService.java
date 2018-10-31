package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entities.Vehicle;
import com.ems.utilities.DropDownList;

@Service
public interface VehicleService {
	
	public Vehicle insert(Vehicle vehicle) throws Exception;
	public List<Vehicle> findAll() throws Exception;
	public Vehicle update(Vehicle vehicle) throws Exception;
	public List<Vehicle> findAllVehicle();
	
}
