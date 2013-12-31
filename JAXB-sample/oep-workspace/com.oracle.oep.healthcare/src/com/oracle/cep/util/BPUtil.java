package com.oracle.cep.util;

public class BPUtil {

	public static int LOW = 0 ; 
	public static int NORMAL = 1 ;
	public static int HIGH = 2 ;

	protected int systolic  ;
	protected int diastolic ;
	
	private static int TARGET_SYSTOLIC = 130 ;
	private static int TARGET_DIASTOLIC = 80 ;
	
	private static int RANGE = 10 ;

	protected int systolicClass  ;
	protected int diastolicClass ;
	
	protected int bpClass ;
	
	public BPUtil(int systolic, int diastolic){
		
		this.systolic = systolic ;
		this.diastolic = diastolic ;
		
		systolicClass = getSystolicClass();
		diastolicClass = getDiastolicClass();
		
	}
		
	public int getSystolicClass() {
		
		int HIGH_SYSTOLIC = TARGET_SYSTOLIC + RANGE ;
		int LOW_SYSTOLIC = TARGET_SYSTOLIC - RANGE ;
			
		
		if (systolic < LOW_SYSTOLIC ) {
			return LOW ;			
		} else if (systolic >= LOW_SYSTOLIC && systolic <= HIGH_SYSTOLIC) {
			return NORMAL ;			
		} else {
			return HIGH ;
		}

	}

	public int getDiastolicClass() {

		int HIGH_DIASTOLIC = TARGET_DIASTOLIC + RANGE ;
		int LOW_DIASTOLIC = TARGET_DIASTOLIC - RANGE ;

		if (diastolic < LOW_DIASTOLIC ) {
			return LOW ;			
		} else if (diastolic >= LOW_DIASTOLIC && diastolic <= HIGH_DIASTOLIC) {
			return NORMAL ;			
		} else {
			return HIGH ;
		}						
	}

	public int getBpClass() {
	
		if ( systolicClass > NORMAL || diastolicClass > NORMAL ){
			return HIGH ;
		} else if ( systolicClass < NORMAL || diastolicClass < NORMAL ){
			return LOW ;
		}
		else {
			return NORMAL ;
		}
		
	}
		
}
