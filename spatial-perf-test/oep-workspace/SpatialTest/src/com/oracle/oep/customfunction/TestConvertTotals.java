package com.oracle.oep.customfunction;

public class TestConvertTotals {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConvertTotals c = new ConvertTotals();
		
		Double d = new Double(6000.19723);
		String x = c.convertTotal(d);
		System.out.println("RETURNED: " + x);
		
		
		double d1 = 1.254785 ;
		String x1 = c.convertPercent(d1);
		System.out.println("RETURNED: " + x1);
		
	}

}
