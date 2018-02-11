package com.ems.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.HolidayRepository;
import com.ems.entities.HolidayCalendar;
import com.ems.service.HolidayService;

@Service
@Transactional
public class HolidayServiceImpl implements HolidayService{

	@Autowired
	private HolidayRepository holidayRepository;
	
	@Override
	public List<HolidayCalendar> getHolidayList(){
		return holidayRepository.findAll();
	}
}
