package com.oracle.oep.customfunction;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeSinceDate {
	
	//user-defined function supported data types
	//http://docs.oracle.com/cd/E21764_01/apirefs.1111/e12048/funcusr.htm#BABJIEHI
	
	public Long getDaysDifference(Object lastDate) {
	    
		Long result = new Long(-1L) ;
		try {
			TimeUnit tUnit = TimeUnit.DAYS ;
		    Date d1 = null ;
		    if (lastDate != null){	
		    	if (lastDate instanceof Date){
					d1 = (Date)lastDate ;
					long diffInMillies = Calendar.getInstance().getTimeInMillis() - d1.getTime();
					result = new Long(tUnit.convert(diffInMillies,TimeUnit.MILLISECONDS));
				}
		    }
		
		} catch (Exception ex) {
			ex.printStackTrace();
		
		}
	    
	    System.out.println("####### THE DAYS DIFF IS: " + result );
	    return result ; 
	}

}
