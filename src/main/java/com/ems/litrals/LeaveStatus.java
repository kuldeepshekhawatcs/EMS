package com.ems.litrals;


enum Status{
	APPROVED, PENDING, REJECTED;
}

public class LeaveStatus{
	public static Status[] getStatus(){
		return Status.values();
	}
}