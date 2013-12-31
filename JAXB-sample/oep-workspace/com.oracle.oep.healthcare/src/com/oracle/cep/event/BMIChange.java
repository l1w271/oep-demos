package com.oracle.cep.event;

import com.oracle.coherence.data.PatientBMI;
import java.math.BigDecimal ;

public class BMIChange {

	protected String patientID ;
	protected double oldBMIValue ;
	protected int oldBMIClass ;
	protected long oldMeasureDateTime ;

	protected double newBMIValue ;
	protected int newBMIClass ;
	protected long newMeasureDateTime ;
	
	protected int bmiClassDiff ;
	protected double bmiValueDiff ;
	
	protected String alertType = "";
	
	private int decimalplaces = 2 ;
	
	public BMIChange(){
		
	}
	
	public String toString(){
		return "BMIChange" + "\n" +
		"[patientID=" + patientID + ", alertType=" + alertType + "\n" + 
		", newBMIClass=" + newBMIClass + ", newBMIValue=" + newBMIValue + "\n" +
		", oldBMIClass=" + oldBMIClass + ", oldBMIValue=" + oldBMIValue + "\n" + 
		", newMeasureDateTime=" + newMeasureDateTime + ", oldMeasureDateTime=" + oldMeasureDateTime + "\n" + 
		", bmiClassDiff=" + bmiClassDiff + ", bmiValueDiff=" + bmiValueDiff + "\n" +
		"]";		 
	}

	
	public BMIChange(PatientBMI newBMI, PatientBMI oldBMI){
		
		this.patientID = newBMI.getPatientID();
		this.newBMIClass = newBMI.getBmiClass() ;
		this.newBMIValue = newBMI.getBmiValue().doubleValue();
		this.newMeasureDateTime = newBMI.getMeasureDateTime();
		
		this.oldBMIClass = oldBMI.getBmiClass();
		this.oldBMIValue = oldBMI.getBmiValue().doubleValue();
		this.oldMeasureDateTime = oldBMI.getMeasureDateTime();
		
		calcBMIClassDiff();
		calcBMIValueDiff();
	}
		
	private void calcBMIClassDiff() {
		this.bmiClassDiff = newBMIClass - oldBMIClass;
	}

	private void calcBMIValueDiff() {
		
		BigDecimal n = new BigDecimal(newBMIValue);
		n.setScale(decimalplaces, BigDecimal.ROUND_UP);
		BigDecimal o = new BigDecimal(oldBMIValue);
		o.setScale(decimalplaces, BigDecimal.ROUND_UP);
		
		double diff = n.subtract(o).doubleValue() ;
		
		this.bmiValueDiff = diff;
	}
	
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public double getOldBMIValue() {
		return oldBMIValue;
	}
	public void setOldBMIValue(double oldBMIValue) {
		this.oldBMIValue = oldBMIValue;
	}
	public int getOldBMIClass() {
		return oldBMIClass;
	}
	public void setOldBMIClass(int oldBMIClass) {
		this.oldBMIClass = oldBMIClass;
	}
	public long getOldMeasureDateTime() {
		return oldMeasureDateTime;
	}
	public void setOldMeasureDateTime(long oldMeasureDateTime) {
		this.oldMeasureDateTime = oldMeasureDateTime;
	}
	public double getNewBMIValue() {
		return newBMIValue;
	}
	public void setNewBMIValue(double newBMIValue) {
		this.newBMIValue = newBMIValue;
	}
	public int getNewBMIClass() {
		return newBMIClass;
	}
	public void setNewBMIClass(int newBMIClass) {
		this.newBMIClass = newBMIClass;
	}
	public long getNewMeasureDateTime() {
		return newMeasureDateTime;
	}
	public void setNewMeasureDateTime(long newMeasureDateTime) {
		this.newMeasureDateTime = newMeasureDateTime;
	}

	public int getBmiClassDiff() {
		return bmiClassDiff;
	}

	public void setBmiClassDiff(int bmiClassDiff) {
		this.bmiClassDiff = bmiClassDiff;
	}

	public double getBmiValueDiff() {
		return bmiValueDiff;
	}

	public void setBmiValueDiff(double bmiValueDiff) {
		this.bmiValueDiff = bmiValueDiff;
	}

	public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}
	

	
	
	
}
