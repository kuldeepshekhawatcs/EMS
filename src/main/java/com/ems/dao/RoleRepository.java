package com.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query("select distinct(e.roleName) from Role e")
	List<String> getDistinctRole();
}
