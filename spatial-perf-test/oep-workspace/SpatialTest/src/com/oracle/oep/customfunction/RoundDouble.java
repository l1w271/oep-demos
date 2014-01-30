package com.oracle.oep.customfunction;

import java.math.*;
import java.text.DecimalFormat;

public class RoundDouble {
	
	public Object executeDouble(double arg0, int scale) {
        
		double d = 0.00 ;
		
		try{
			
			BigDecimal bd = new BigDecimal(arg0);
			bd = bd.setScale(scale,BigDecimal.ROUND_HALF_UP);
			d = bd.doubleValue() ;
		
			//System.out.println("This amount: " + arg0 + " was rounded to: " + d );


		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return new Double(d);
    }
	
	public String executeString(double arg0, int scale) {
        
		String result = "" ;
		
		try{
			
			BigDecimal bd = new BigDecimal(arg0);
			bd = bd.setScale(scale,BigDecimal.ROUND_HALF_UP);
			double d = bd.doubleValue() ;
			
		    DecimalFormat df = new DecimalFormat("#.00");
		    result = df.format(d);
			
			//System.out.println("This amount: " + arg0 + " was rounded to: " + result);


		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return result ;
    }

	


}
