package com.ems.service.impl;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ems.dao.VehicleRepository;
import com.ems.entities.Vehicle;
import com.ems.service.VehicleService;
import com.ems.utilities.DropDownList;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public Vehicle insert(Vehicle invoice) throws Exception {
		return vehicleRepository.save(invoice);
	}

	@Override
	public List<Vehicle> findAll() throws Exception {
	return vehicleRepository.findAll();
	}

	@Override
	public Vehicle update(Vehicle convertedObject) throws Exception {
		return vehicleRepository.save(convertedObject);
	}

	@Cacheable("vehicles")
	@Override
	public List<Vehicle> findAllVehicle() {
		List<Vehicle> list = vehicleRepository.findDistinctVehicle();
		return list;
	}
	
}
