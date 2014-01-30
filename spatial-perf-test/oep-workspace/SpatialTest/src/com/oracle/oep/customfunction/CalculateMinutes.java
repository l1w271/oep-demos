package com.oracle.oep.customfunction;

import java.math.BigDecimal;
import java.util.Date;

public class CalculateMinutes {
	
	public double minutesinArea(Object enteredAreaTime, Object lastSeenTime){
		
		double minutesInArea = 0.00 ;
		
		if (enteredAreaTime != null || lastSeenTime !=null) {
			Date d1 = null ;
			Date d2 = null ;
			if (enteredAreaTime instanceof Date){
				d1 = (Date)enteredAreaTime ;		
			}
			if (enteredAreaTime instanceof Date){
				d2 = (Date)lastSeenTime ;		
			}
			if (d1 != null || d2 != null){
				minutesInArea = (d2.getTime() - d1.getTime()) / 60000.0;
			}
			
		}
		
		minutesInArea = formatDouble(minutesInArea,3) ;

		//TODO: remove when done testing
		//minutesInArea = 17.899 ;
		System.out.println("####### THE MINUTES IN AREA IS: " + minutesInArea );
		
		return minutesInArea  ;
	
	}
	
	private double formatDouble(double d, int scale){
		
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(scale,BigDecimal.ROUND_HALF_UP);				
			
		return bd.doubleValue();
	}
	
}
