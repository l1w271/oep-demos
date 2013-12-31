package com.oracle.coherence.data;

import java.math.BigDecimal ;

import java.io.IOException;
import java.io.Serializable;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class PatientBMI implements Serializable, PortableObject {

	private static final long serialVersionUID = 1L;
	protected String patientID ;
	protected BigDecimal bmiValue ;
	protected int bmiClass ;
	protected long measureDateTime ;
	
	private int numDecimalPlaces = 2 ;	
	
	public PatientBMI(){
		
	}
	
	public PatientBMI(String patientID, double bmiValue, int bmiClass, long measureDateTime){

		this.patientID = patientID ;
		this.bmiValue = new BigDecimal(bmiValue) ;
		this.bmiValue.setScale(numDecimalPlaces,BigDecimal.ROUND_UP);
		this.bmiClass = bmiClass ;
		this.measureDateTime = measureDateTime ; 
					
		//System.out.println("PatientBMI: The BMI VALUE IS:" + bmiValue);
	}
	
	
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public BigDecimal getBmiValue() {
		return bmiValue;
	}
	public void setBmiValue(BigDecimal bmiValue) {
		this.bmiValue = bmiValue;
	}
	public int getBmiClass() {
		return bmiClass;
	}
	public void setBmiClass(int bmiClass) {
		this.bmiClass = bmiClass;
	}
	public long getMeasureDateTime() {
		return measureDateTime;
	}
	public void setMeasureDateTime(long measureDateTime) {
		this.measureDateTime = measureDateTime;
	}

	
	public String toString(){
		return "PatientBMI [patientID=" + patientID + ", bmiValue=" + bmiValue + ", bmiClass=" + bmiClass + ", measureDateTime=" + measureDateTime + "]";		 
	}

	public void readExternal(PofReader in) throws IOException {
		patientID = in.readString(0);
		bmiValue = in.readBigDecimal(1);
		bmiValue.setScale(numDecimalPlaces,BigDecimal.ROUND_UP);
		bmiClass = in.readInt(2);			
		measureDateTime = in.readLong(3);
		
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeString(0, patientID);
		out.writeBigDecimal(1, bmiValue);
		out.writeInt(2, bmiClass);
		out.writeLong(3, measureDateTime);

	}
	
	
	
}
