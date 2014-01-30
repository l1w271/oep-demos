package com.oracle.oep.customfunction;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Locale;

public class ConvertTotals {

	public String convertTotal(double amount) {
		
		BigDecimal payment = new BigDecimal(amount);
	    NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US); 
	    double doublePayment = payment.doubleValue();
	    String s = n.format(doublePayment);
	    //System.out.println(s);
	      
	    return s ;
		
    }
	
	public String convertPercent(double amount) {
		
		
		NumberFormat formatter = new DecimalFormat("##0.00");
		String s = formatter.format(amount);  
		
	    return s ;
		
    }
	
	
}
