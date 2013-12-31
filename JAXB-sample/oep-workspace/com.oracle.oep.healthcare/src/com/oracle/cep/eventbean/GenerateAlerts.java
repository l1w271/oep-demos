package com.oracle.cep.eventbean;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSender;

import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.StreamSource;

import com.oracle.cep.event.BMIChange;
import com.oracle.cep.event.BPChange;
import com.oracle.cep.demo.jaxb.event.HBA1CAlertType;
import com.oracle.cep.demo.jaxb.event.BGAlertType;
import com.oracle.cep.siebel.jaxb.event.*;

public class GenerateAlerts implements StreamSource, StreamSink {

	private String INPUT_TYPE = "Meter Read";
	
	
	private StreamSender streamSender_;
		
	public void setEventSender(StreamSender sender) {
		streamSender_ = sender;
	}
	
	
	public void onInsertEvent(Object event) throws EventRejectedException {
						
		if (event != null){
			
			if (event instanceof BMIChange){
				
				BMIChange e = (BMIChange)event ;
				
				String InpDescription = "BMI Alert!" + e.getNewBMIValue() ;
							
				streamSender_.sendInsertEvent(getActivitiesInputType(e.getPatientID(),InpDescription));								
			
			} else if (event instanceof BPChange){
				
				BPChange e = (BPChange)event ;
				String InpDescription = "BP Alert! " + e.getNewSystolic() + "/" + e.getNewDiastolic() + " mm Hg" ;
				
				streamSender_.sendInsertEvent(getActivitiesInputType(e.getPatientID(),InpDescription));
				
					
			} else if (event instanceof HBA1CAlertType){
				
				HBA1CAlertType e = (HBA1CAlertType)event ;
				String InpDescription = "HBA1C Alert! " + e.getHBA1CMeasurement() + "" ;
				
				streamSender_.sendInsertEvent(getActivitiesInputType(e.getPatientID(),InpDescription));
			
			} else if (event instanceof BGAlertType){
			
				BGAlertType e = (BGAlertType)event ;
				String InpDescription = "BG Alert! " + e.getGlucose() + " " + e.getMeasureType() + "" ;
			
			streamSender_.sendInsertEvent(getActivitiesInputType(e.getPatientID(),InpDescription));
			
			}
			
		}
		
	}
	
	
	private ActivitiesInputType getActivitiesInputType(String caseID, String InpDescription){
		
		//ActivitiesInputType input = new  ActivitiesInputType();
		ObjectFactory factory = new ObjectFactory();
		ActivitiesInputType input = factory.createActivitiesInputType();
		//input.setErrorSpcCode(value);
		//input.setErrorSpcMessage(value);
		input.setInpDescription(InpDescription);
		input.setInpType(INPUT_TYPE);
		input.setCaseNum(caseID);
		//input.setObjectSpcId(caseID);
		//input.setProcessSpcInstanceSpcId(value);
		//input.setSiebelSpcOperationSpcObjectSpcId(value);
		
		return input ;
	}


}




/*
BPChange e = (BPChange)event ;
BPAlertType alert = new BPAlertType();
alert.setAlertType(e.getAlertType());
alert.setBpClassDiff(e.getBpClassDiff());
alert.setDiastolicDiff(e.getDiastolicDiff());
alert.setNewBPClass(e.getNewBPClass());
alert.setNewDiastolic(e.getNewDiastolic());				
alert.setNewSystolic(e.getNewSystolic());
alert.setOldBPClass(e.getOldBPClass());
alert.setOldDiastolic(e.getOldDiastolic());
alert.setOldMeasureDateTime(e.getOldMeasureDateTime());
alert.setPatientID(e.getPatientID());

streamSender_.sendInsertEvent(alert);
*/							


/*
BMIAlertType alert = new BMIAlertType();
alert.setAlertType(e.getAlertType());
alert.setBmiClassDiff(e.getBmiClassDiff());
alert.setBmiValueDiff(e.getBmiValueDiff());				
alert.setNewBMIClass(e.getNewBMIClass());
alert.setNewBMIValue(e.getNewBMIValue());
alert.setNewMeasureDateTime(e.getNewMeasureDateTime());
alert.setOldBMIClass(e.getOldBMIClass());
alert.setOldBMIValue(e.getOldBMIValue());
alert.setOldMeasureDateTime(e.getOldMeasureDateTime());				
alert.setPatientID(e.getPatientID());
*/

