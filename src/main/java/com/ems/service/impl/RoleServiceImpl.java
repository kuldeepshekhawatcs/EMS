package com.ems.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.EmployeeRepository;
import com.ems.dao.RoleRepository;
import com.ems.entities.Employee;
import com.ems.entities.Role;
import com.ems.service.EmployeeService;
import com.ems.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role insert(Role role) throws Exception {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() throws Exception {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(int id) throws Exception {
		return roleRepository.findOne(id);
	}
	
	@Override
	public Role findByName(String roleName) throws Exception {
		if(roleName.equalsIgnoreCase("MANAGER") || roleName.equalsIgnoreCase("ADMIN"))
			return roleRepository.findOne(1);
		else
			return roleRepository.findOne(2);
	}

	@Override
	public List<String> getDistinctRole() {
		return roleRepository.getDistinctRole();
	}
}
