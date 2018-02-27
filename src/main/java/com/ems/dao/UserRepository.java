package com.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ems.entities.Employee;
import com.ems.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select e from User e where e.userName= :username AND e.password=:password")
	User validateCredentials(@Param("username") String username, @Param("password") String password);
	
}
