package com.ems.litrals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

enum Status{
	APPROVED, PENDING, REJECTED;
}

public class LeaveStatus{
	public static Status[] getStatus(){
		return Status.values();
	}
}