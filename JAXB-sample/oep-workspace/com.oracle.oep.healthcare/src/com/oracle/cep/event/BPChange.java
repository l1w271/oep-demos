package com.oracle.cep.event;

import com.oracle.coherence.data.PatientBP;

public class BPChange {

	protected String patientID ;
	protected int oldSystolic ;
	protected int oldDiastolic ;	
	protected int oldBPClass ;
	protected long oldMeasureDateTime ;

	protected int newSystolic ;
	protected int newDiastolic ;	
	protected int newBPClass ;
	protected long newMeasureDateTime ;
	
	protected int bpClassDiff ;
	protected int systolicDiff ;
	protected int diastolicDiff ;
	
	protected String alertType = "";
	
	
	public BPChange(){
		
	}
	
	public String toString(){
		return "BPChange" + "\n" +
		"[patientID=" + patientID + ", alertType=" + alertType + "\n" + 
		", oldSystolic=" + oldSystolic + ", newSystolic=" + newSystolic + "\n" +
		", oldDiastolic=" + oldDiastolic + ", newDiastolic=" + newDiastolic + "\n" +
		", oldBPClass=" + oldBPClass + ", newBPClass=" + newBPClass + "\n" + 
		", systolicDiff=" + systolicDiff + ", diastolicDiff=" + diastolicDiff + "\n" + 
		", oldMeasureDateTime=" + oldMeasureDateTime + ", newMeasureDateTime=" + newMeasureDateTime + "\n" +
		", bpClassDiff=" + bpClassDiff + "\n" +
		"]";		 
	}

	
	public BPChange(PatientBP newBP, PatientBP oldBP){
		
		this.patientID = newBP.getPatientID();
		
		this.newSystolic = newBP.getSystolic() ;
		this.newDiastolic = newBP.getDiastolic() ;
		this.newBPClass = newBP.getBpClass();		
		this.newMeasureDateTime = newBP.getMeasureDateTime();
		
		this.oldSystolic = oldBP.getSystolic() ;
		this.oldDiastolic = oldBP.getDiastolic() ;
		this.oldBPClass = oldBP.getBpClass();
		this.oldMeasureDateTime = oldBP.getMeasureDateTime();
		
		calcBPValueDiffs();
	}
		

	private void calcBPValueDiffs() {
		
		this.systolicDiff = newSystolic - oldSystolic ;
		this.diastolicDiff = newDiastolic - oldDiastolic ;
		this.bpClassDiff = newBPClass - oldBPClass ; 
			
	}
	
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public long getOldMeasureDateTime() {
		return oldMeasureDateTime;
	}
	public void setOldMeasureDateTime(long oldMeasureDateTime) {
		this.oldMeasureDateTime = oldMeasureDateTime;
	}
	public long getNewMeasureDateTime() {
		return newMeasureDateTime;
	}
	public void setNewMeasureDateTime(long newMeasureDateTime) {
		this.newMeasureDateTime = newMeasureDateTime;
	}

	public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public int getOldSystolic() {
		return oldSystolic;
	}

	public void setOldSystolic(int oldSystolic) {
		this.oldSystolic = oldSystolic;
	}

	public int getOldDiastolic() {
		return oldDiastolic;
	}

	public void setOldDiastolic(int oldDiastolic) {
		this.oldDiastolic = oldDiastolic;
	}

	public int getOldBPClass() {
		return oldBPClass;
	}

	public void setOldBPClass(int oldBPClass) {
		this.oldBPClass = oldBPClass;
	}

	public int getNewSystolic() {
		return newSystolic;
	}

	public void setNewSystolic(int newSystolic) {
		this.newSystolic = newSystolic;
	}

	public int getNewDiastolic() {
		return newDiastolic;
	}

	public void setNewDiastolic(int newDiastolic) {
		this.newDiastolic = newDiastolic;
	}

	public int getNewBPClass() {
		return newBPClass;
	}

	public void setNewBPClass(int newBPClass) {
		this.newBPClass = newBPClass;
	}

	public int getBpClassDiff() {
		return bpClassDiff;
	}

	public void setBpClassDiff(int bpClassDiff) {
		this.bpClassDiff = bpClassDiff;
	}

	public int getSystolicDiff() {
		return systolicDiff;
	}

	public void setSystolicDiff(int systolicDiff) {
		this.systolicDiff = systolicDiff;
	}

	public int getDiastolicDiff() {
		return diastolicDiff;
	}

	public void setDiastolicDiff(int diastolicDiff) {
		this.diastolicDiff = diastolicDiff;
	}
	

	
	
	
	
	
}
