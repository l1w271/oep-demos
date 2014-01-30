package com.oracle.oep.customfunction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimeSinceDate {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    TimeSinceDate t = new TimeSinceDate();
		
	    Date d = null ;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			d = sdf.parse("2013/01/30");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	    
	    
	    long ldiff = t.getDaysDifference(d);
	    
		
		System.out.println("RETURNED: " + ldiff);
		
	}

}
