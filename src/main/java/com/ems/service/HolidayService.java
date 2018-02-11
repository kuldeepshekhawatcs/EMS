package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entities.HolidayCalendar;

@Service
public interface HolidayService {

	public List<HolidayCalendar> getHolidayList();
}
