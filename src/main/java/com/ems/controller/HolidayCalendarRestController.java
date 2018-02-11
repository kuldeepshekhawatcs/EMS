package com.ems.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.service.HolidayService;
import com.ems.utilities.HolidayListDTO;

@RestController
public class HolidayCalendarRestController {
	
	final static Logger logger = Logger.getLogger(HolidayCalendarRestController.class);
	
	@Autowired
	private HolidayService holidayService;
	
	@RequestMapping("/getHolidayList")
	public HolidayListDTO getAllHolidays(){
		HolidayListDTO holidayListDTO = new HolidayListDTO();
		holidayListDTO.setCalendars(holidayService.getHolidayList());
		return holidayListDTO;
	}
	
}
