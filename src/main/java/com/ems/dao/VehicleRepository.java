package com.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.entities.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

	@Query("select e from Vehicle e where e.id IN (select e.id from Vehicle e group by e.model)")
	List<Vehicle> findDistinctVehicle();

	
}
