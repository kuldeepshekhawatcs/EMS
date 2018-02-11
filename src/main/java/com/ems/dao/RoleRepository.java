package com.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	
}
