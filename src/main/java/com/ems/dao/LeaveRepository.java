package com.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ems.entities.EmployeeLeave;

@Repository
public interface LeaveRepository extends JpaRepository<EmployeeLeave, Integer>{

	@Query("select e.leaveBalance from Employee e where e.employeeId =:employeeId")
	Integer getEmployeeLeaveCountByEmployeeId(@Param("employeeId") Integer employeeId);
	
}
