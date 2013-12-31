package com.oracle.cep.event;

public class BMIEvent {

	protected String patientID ;
	protected double height ;
	protected double weight ;
	protected double bmiValue ;
	protected int bmiClass ;
	protected long measureDateTime ;
	
	//temp
	protected Double heightD ;
	protected Double weightD ;
	protected Long measureDateTimeL ;
	
	public BMIEvent(){
		
	}
	
	public BMIEvent(String patientID, double height, double weight, long measureDateTime){
	
		this.patientID = patientID ;
		this.height = height ;
		this.weight = weight ;
		this.measureDateTime = measureDateTime;
		
	}
	
	
	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public long getMeasureDateTime() {
		return measureDateTime;
	}

	public void setMeasureDateTime(long measureDateTime) {
		this.measureDateTime = measureDateTime;
	}

	public double getBmiValue() {
		return bmiValue;
	}

	public void setBmiValue(double bmiValue) {
		this.bmiValue = bmiValue;
		//System.out.println("BMIEVENT: The BMI VALUE IS:" + bmiValue);
	}

	public int getBmiClass() {
		return bmiClass;
	}

	public void setBmiClass(int bmiClass) {
		this.bmiClass = bmiClass;
	}

	public String toString(){
		return "BMIEvent [patientID=" + patientID + ", height=" + height + ", weight=" + weight + ", bmiValue=" + bmiValue + ", bmiClass=" + bmiClass + ", measureDateTime=" + measureDateTime + "]";		 
	}

	
	
	//TEMP
	
	public Double getHeightD() {
		return heightD;
	}

	public void setHeightD(Double heightD) {
		this.heightD = heightD;
		this.height = heightD.doubleValue();
	}

	public Double getWeightD() {
		return weightD;
	}

	public void setWeightD(Double weightD) {
		this.weightD = weightD;
		this.weight = weightD.doubleValue();
	}

	public Long getMeasureDateTimeL() {
		return measureDateTimeL;
	}

	public void setMeasureDateTimeL(Long measureDateTimeL) {
		this.measureDateTimeL = measureDateTimeL;
		this.measureDateTime = measureDateTimeL.longValue();
	}
	
}
