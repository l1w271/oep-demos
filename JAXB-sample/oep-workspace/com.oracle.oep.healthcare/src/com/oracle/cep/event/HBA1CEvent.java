package com.oracle.cep.event;

public class HBA1CEvent {

	protected String patientID ;
	protected double HBA1CMeasurement ;
	protected long measureDateTime ;
	
	//temp
	protected Double HBA1CMeasurementD ;
	protected Long measureDateTimeL ;

	
	public HBA1CEvent(){
		
	}
	
	public HBA1CEvent(String patientID, double HBA1CMeasurement, long measureDateTime){
	
		this.patientID = patientID ;
		this.HBA1CMeasurement = HBA1CMeasurement ;
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
		return "BGEvent [patientID=" + patientID + ", HBA1CMeasurement=" + HBA1CMeasurement + ", measureDateTime=" + measureDateTime + "]";		 
	}

	
	
	//TEMP	
	public Long getMeasureDateTimeL() {
		return measureDateTimeL;
	}

	public void setMeasureDateTimeL(Long measureDateTimeL) {
		this.measureDateTimeL = measureDateTimeL;
		this.measureDateTime = measureDateTimeL.longValue();
	}

	public double getHBA1CMeasurement() {
		return HBA1CMeasurement;
	}

	public void setHBA1CMeasurement(double hBA1CMeasurement) {
		HBA1CMeasurement = hBA1CMeasurement;
	}

	public Double getHBA1CMeasurementD() {
		return HBA1CMeasurementD;
	}

	public void setHBA1CMeasurementD(Double hBA1CMeasurementD) {
		this.HBA1CMeasurement = hBA1CMeasurementD.doubleValue();
		HBA1CMeasurementD = hBA1CMeasurementD;
	}



	
	
	
	
}
