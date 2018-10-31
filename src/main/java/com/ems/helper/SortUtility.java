package com.ems.helper;

import java.util.Comparator;

import com.ems.entities.Job;

public class SortUtility {

	  public static Comparator<Job> DateComparator = new Comparator<Job>() {

	        @Override
	        public int compare(Job e1, Job e2) {
	            return (int) e2.getCreatedTime().compareTo(e1.getCreatedTime());
	        }
	    };

}
