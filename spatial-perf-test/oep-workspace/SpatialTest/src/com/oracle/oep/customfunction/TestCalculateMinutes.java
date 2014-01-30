package com.oracle.oep.customfunction;

import java.util.Calendar;
import java.util.Date;

public class TestCalculateMinutes {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CalculateMinutes c = new CalculateMinutes();
		
		Date d1 = Calendar.getInstance().getTime();
		try {
			Thread.sleep(1256 * 127);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date d2 = Calendar.getInstance().getTime();
		
		double inArea = c.minutesinArea(d1, d2);

		System.out.println("RETURNED: " + inArea);
		
	}

}
