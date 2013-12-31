package com.oracle.cep.cache;

import java.util.Map;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSender;

import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.StreamSource;

import com.oracle.cep.event.BMIEvent;
import com.oracle.cep.event.BMIChange;
import com.oracle.cep.util.BMIUtil;

import com.oracle.coherence.data.PatientBMI ;
import com.oracle.coherence.entry.BMIUpdater ;

import com.tangosol.net.NamedCache;

public class BMICacheInvoke implements StreamSource, StreamSink {

	private StreamSender streamSender_;
	
	@SuppressWarnings("unchecked")
	private Map bmiCache;	
		
	@SuppressWarnings("unchecked")
	public void setBmiCache(Map bmiCache) {
		this.bmiCache = bmiCache;
	}
	
	public void setEventSender(StreamSender sender) {
		streamSender_ = sender;
	}
	
	
	public void onInsertEvent(Object event) throws EventRejectedException {
						
		if (event != null){
			
			if (event instanceof BMIEvent){
				BMIEvent e = (BMIEvent)event ;
				BMIUtil util = new BMIUtil(e.getHeight(), e.getWeight());				
				e.setBmiValue(util.getBMIValue());
				e.setBmiClass(util.getBMIClass());
				
				PatientBMI bmi = new PatientBMI(e.getPatientID(), e.getBmiValue(), e.getBmiClass(), e.getMeasureDateTime());				
				
				String key = e.getPatientID();				
				BMIChange change = addToCache(key, bmi); 								
				
				if (change != null){
					//send downstream to be processed
					//System.out.println("Sending Event to be processed after cache invoke:" + amt.toString());
					streamSender_.sendInsertEvent(change);				
				} 
				
			}
					
		}
		
	}

	public BMIChange addToCache(String key, PatientBMI event) throws EventRejectedException {
				
 		
		NamedCache cache = (NamedCache)bmiCache ;    	
	
		BMIUpdater updater = new BMIUpdater(event);		
		Object old = cache.invoke(key, updater); 
		
		if (old != null){
			
			//get an event with new and previous in it 
			if (old instanceof PatientBMI){
				
				PatientBMI oldBMI = (PatientBMI)old ;
				BMIChange change = new BMIChange(event, oldBMI);
								
				return change ;		
			}
			
		}
				
		return null ;
		
	}
	
}
