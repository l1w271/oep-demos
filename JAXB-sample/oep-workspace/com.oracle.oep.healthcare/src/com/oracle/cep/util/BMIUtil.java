package com.oracle.cep.util;

import java.math.BigDecimal;

public class BMIUtil {

	public static int UNDERWEIGHT = 0 ; 
	public static int NORMAL = 1 ;
	public static int OVERWEIGHT = 2 ;
	public static int OBSESE = 3 ;
	
	private double height ;
	private double weight ;
	
	public BMIUtil(double height, double weight){
		
		this.height = height ;
		this.weight = weight ;
	}
	
	
	public double getBMIValue() {
		
		 double b = weight/height ;
		
		 int decimalPlace = 2;
		 BigDecimal bd = new BigDecimal(b);
		 bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
		 System.out.println("BigDecimal:" + bd);
		 double bmi = bd.doubleValue();
		
		return bmi ;		
		
	}
	
	
	
	public int getBMIClass() {
				
		double bmi = weight / height ;
		
		if (bmi < 18.5 ) {
			return UNDERWEIGHT ;			
		}
		
		if (bmi >= 18.5 && bmi < 25) {
			return NORMAL ;			
		} 
		
		if (bmi >= 25 && bmi < 30) {
			return OVERWEIGHT ;			
		} 

		if (bmi >= 30) {
			return OBSESE ;			
		} 

		return -1 ;
		
	}
	
}
