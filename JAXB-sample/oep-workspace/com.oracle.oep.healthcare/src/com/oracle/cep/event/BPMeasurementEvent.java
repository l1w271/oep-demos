package com.oracle.cep.event;

public class BPMeasurementEvent {

	protected String patientID ;
	protected int systolic  ;
	protected int diastolic ;
	protected int bpClass ;
	protected long measureDateTime ;
	//temp
	protected Long measureDateTimeL ;
	protected Integer systolicI ;
	protected Integer diastolicI ;
	
	public BPMeasurementEvent(){
		
	}
	
	public BPMeasurementEvent(String patientID, int systolic, int diastolic, long measureDateTime){
	
		this.patientID = patientID ;
		this.systolic = systolic ;
		this.diastolic = diastolic ;
		this.measureDateTime = measureDateTime;
		
	}
	
	
	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}



	public String toString(){
		return "BPMeasurementEvent [patientID=" + patientID + ", systolic=" + systolic + ", diastolic=" + diastolic + ", bpClass=" + bpClass + ", measureDateTime=" + measureDateTime + "]";		 
	}
	
	public Long getMeasureDateTimeL() {
		return measureDateTimeL;
	}

	public void setMeasureDateTimeL(Long measureDateTimeL) {
		this.measureDateTimeL = measureDateTimeL;
		this.measureDateTime = measureDateTimeL.longValue();
	}

	public int getBpClass() {
		return bpClass;
	}

	public void setBpClass(int bpClass) {
		this.bpClass = bpClass;
	}

	public long getMeasureDateTime() {
		return measureDateTime;
	}

	public void setMeasureDateTime(long measureDateTime) {
		this.measureDateTime = measureDateTime;
	}

	public int getSystolic() {
		return systolic;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public Integer getSystolicI() {
		return systolicI;
	}

	public void setSystolicI(Integer systolicI) {
		this.systolic = systolicI.intValue();
		this.systolicI = systolicI;
	}

	public Integer getDiastolicI() {
		return diastolicI;
	}

	public void setDiastolicI(Integer diastolicI) {
		this.diastolic = diastolicI.intValue() ;
		this.diastolicI = diastolicI;
	}

	

	
}
