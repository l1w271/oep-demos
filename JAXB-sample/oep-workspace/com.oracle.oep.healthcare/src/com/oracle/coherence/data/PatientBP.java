package com.oracle.coherence.data;

import java.io.IOException;
import java.io.Serializable;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class PatientBP implements Serializable, PortableObject {

	private static final long serialVersionUID = 1L;
	protected String patientID ;
	protected int systolic ;
	protected int diastolic ;		
	protected int bpClass ;
	protected long measureDateTime ;
		
	public PatientBP(){
		
	}
	
	public PatientBP(String patientID, int systolic, int diastolic, int bpClass, long measureDateTime){

		this.patientID = patientID ;
		this.systolic = systolic ;
		this.diastolic = diastolic ;
		this.bpClass = bpClass ;
		this.measureDateTime = measureDateTime ; 
					
		//System.out.println("PatientBMI: The BMI VALUE IS:" + bmiValue);
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
		return "PatientBP [patientID=" + patientID + ", systolic=" + systolic + ", diastolic=" + diastolic + ", bpClass=" + bpClass + ", measureDateTime=" + measureDateTime + "]";		 
	}

	public void readExternal(PofReader in) throws IOException {
		patientID = in.readString(0);
		systolic = in.readInt(1);
		diastolic = in.readInt(2);
		bpClass = in.readInt(3);			
		measureDateTime = in.readLong(4);
		
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeString(0, patientID);
		out.writeInt(1, systolic);
		out.writeInt(2, diastolic);
		out.writeInt(3, bpClass);
		out.writeLong(4, measureDateTime);

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

	public int getBpClass() {
		return bpClass;
	}

	public void setBpClass(int bpClass) {
		this.bpClass = bpClass;
	}

	
	
	
}
