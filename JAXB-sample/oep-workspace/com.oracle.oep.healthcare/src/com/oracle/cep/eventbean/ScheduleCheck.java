package com.oracle.cep.eventbean;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSender;

import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.StreamSource;

import com.oracle.cep.event.BMIChange;
import com.oracle.cep.event.BPChange;
import com.oracle.cep.demo.jaxb.event.*;
//import com.oracle.cep.siebel.jaxb.event.ADSSpcUpdateSpcCaseSpcActivitiesInput;

import commonj.timers.*;

public class ScheduleCheck implements StreamSource, StreamSink {

	private StreamSender streamSender_;
		
	public void setEventSender(StreamSender sender) {
		streamSender_ = sender;
	}
	
	
	private static class MyTimerListener implements TimerListener {
		    
		  public void timerExpired(Timer timer) {
		      System.out.println("timer expired called on " + timer);
		      // some useful work here ...
		      // let's just cancel the timer
		      System.out.println("cancelling timer ...");
		      timer.cancel();
		  }
	  }

	
	public void onInsertEvent(Object event) throws EventRejectedException {
						
		if (event != null){
			
			
			try {
			      InitialContext ic = new InitialContext();
			      TimerManager tm = (TimerManager)ic.lookup("java:comp/env/tm/default");
			      // Execute timer every 10 seconds starting immediately
			      tm.schedule (new MyTimerListener(), 0, 10*1000);
			      System.out.println("<h4>Timer scheduled!</h4>");
			    } catch (NamingException ne) {
			      ne.printStackTrace();
			      System.out.println("<h4>Timer schedule failed!</h4>");
			    }
			
			
			
			
			if (event instanceof BMIChange){
				
				BMIChange e = (BMIChange)event ;
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
				
				
				
				/*
				ADSSpcUpdateSpcCaseSpcActivitiesInput input = new  ADSSpcUpdateSpcCaseSpcActivitiesInput();
				input.setErrorSpcCode(value);
				input.setErrorSpcMessage(value);
				input.setInpDescription(value);
				input.setInpType(value);
				input.setObjectSpcId(value);
				input.setProcessSpcInstanceSpcId(value);
				input.setSiebelSpcOperationSpcObjectSpcId(value);
				*/
				
				streamSender_.sendInsertEvent(alert);								
			}
			
			if (event instanceof BPChange){
				
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
			}
					
		}
	
	}


}
