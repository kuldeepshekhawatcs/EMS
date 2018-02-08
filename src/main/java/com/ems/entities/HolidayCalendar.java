package com.ems.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HolidayCalendar {

	@Id
	private Date holidayDate;
	
	private Calendar holidayYear;
	
	private String holidayDescription;
	
	private Calendar dayOnHoliday;

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public Calendar getHolidayYear() {
		return holidayYear;
	}

	public void setHolidayYear(Calendar holidayYear) {
		this.holidayYear = holidayYear;
	}

	public String getHolidayDescription() {
		return holidayDescription;
	}

	public void setHolidayDescription(String holidayDescription) {
		this.holidayDescription = holidayDescription;
	}

	public Calendar getDayOnHoliday() {
		return dayOnHoliday;
	}

	public void setDayOnHoliday(Calendar dayOnHoliday) {
		this.dayOnHoliday = dayOnHoliday;
	}
}
