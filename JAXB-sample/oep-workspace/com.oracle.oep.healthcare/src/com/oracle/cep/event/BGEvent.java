package com.oracle.cep.event;

public class BGEvent {

	protected String patientID ;
	protected double glucose ;
	protected int measureType ;
	protected long measureDateTime ;
	
	//temp
	protected Double glucoseD ;
	protected Integer measureTypeI ;
	protected Long measureDateTimeL ;
	
	public static int MORNING = 0 ; 
	public static int AFTER_MEAL = 1 ;
	public static int BEFORE_BED = 2 ;
	
	public BGEvent(){
		
	}
	
	public BGEvent(String patientID, double glucose, int measureType, long measureDateTime){
	
		this.patientID = patientID ;
		this.glucose = glucose ;
		this.measureType = measureType ;
		this.measureDateTime = measureDateTime;
		
	}
	
	
	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public long getMeasureDateTime() {
		return measureDateTime;
	}

	public void setMeasureDateTime(long measureDateTime) {
		this.measureDateTime = measureDateTime;
	}


	public String toString(){
		return "BGEvent [patientID=" + patientID + ", glucose=" + glucose + ", measureType=" + measureType + ", measureDateTime=" + measureDateTime + "]";		 
	}

	
	
	//TEMP	
	public Long getMeasureDateTimeL() {
		return measureDateTimeL;
	}

	public void setMeasureDateTimeL(Long measureDateTimeL) {
		this.measureDateTimeL = measureDateTimeL;
		this.measureDateTime = measureDateTimeL.longValue();
	}

	public double getGlucose() {
		return glucose;
	}

	public void setGlucose(double glucose) {
		this.glucose = glucose;
	}

	public int getMeasureType() {
		return measureType;
	}

	public void setMeasureType(int measureType) {
		this.measureType = measureType;
	}

	public Double getGlucoseD() {
		return glucoseD;
	}

	public void setGlucoseD(Double glucoseD) {
		this.glucose = glucoseD.doubleValue();
		this.glucoseD = glucoseD;
	}

	public Integer getMeasureTypeI() {
		return measureTypeI;
	}

	public void setMeasureTypeI(Integer measureTypeI) {
		this.measureType = measureTypeI.intValue();
		this.measureTypeI = measureTypeI;
	}
	
	
	
	
}
