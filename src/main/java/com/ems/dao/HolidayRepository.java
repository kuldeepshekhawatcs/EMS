package com.ems.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.entities.HolidayCalendar;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayCalendar, Date>{

}
