package com.ems.utilities;

import java.util.ArrayList;
import java.util.List;

import com.ems.entities.HolidayCalendar;

public class HolidayListDTO {

	private List<HolidayCalendar> calendars = new ArrayList<HolidayCalendar>();

	public List<HolidayCalendar> getCalendars() {
		return calendars;
	}

	public void setCalendars(List<HolidayCalendar> calendars) {
		this.calendars = calendars;
	}
	
}
