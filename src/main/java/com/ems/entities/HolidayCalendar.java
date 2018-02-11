package com.ems.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HolidayCalendar {

	@Id
	private Date holidayDate;
	
	private String holidayYear;
	
	private String holidayDescription;
	
	private String dayOnHoliday;

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getHolidayYear() {
		return holidayYear;
	}

	public void setHolidayYear(String holidayYear) {
		this.holidayYear = holidayYear;
	}

	public String getHolidayDescription() {
		return holidayDescription;
	}

	public void setHolidayDescription(String holidayDescription) {
		this.holidayDescription = holidayDescription;
	}

	public String getDayOnHoliday() {
		return dayOnHoliday;
	}

	public void setDayOnHoliday(String dayOnHoliday) {
		this.dayOnHoliday = dayOnHoliday;
	}
}
