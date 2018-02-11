package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entities.Employee;
import com.ems.entities.Role;

@Service
public interface RoleService {

	public Role insert(Role role) throws Exception;
	public List<Role> findAll() throws Exception;
	public Role findById(int id) throws Exception;
	public Role findByName(String roleName) throws Exception;
}
