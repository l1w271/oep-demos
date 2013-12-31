package com.oracle.cep.cache;

import java.util.Map;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSender;

import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.StreamSource;

import com.oracle.cep.event.BPChange;
import com.oracle.cep.event.BPMeasurementEvent;
import com.oracle.cep.util.BPUtil;

import com.oracle.coherence.data.PatientBP ;
import com.oracle.coherence.entry.BPUpdater ;

import com.tangosol.net.NamedCache;

public class BPCacheInvoke implements StreamSource, StreamSink {

	private StreamSender streamSender_;
	
	@SuppressWarnings("unchecked")
	private Map bpCache;	
		
	@SuppressWarnings("unchecked")
	public void setBpCache(Map bpCache) {
		this.bpCache = bpCache;
	}
	
	public void setEventSender(StreamSender sender) {
		streamSender_ = sender;
	}
	
	
	public void onInsertEvent(Object event) throws EventRejectedException {
						
		if (event != null){
			
			if (event instanceof BPMeasurementEvent){
				BPMeasurementEvent e = (BPMeasurementEvent)event ;
				
				BPUtil util = new BPUtil(e.getSystolic(), e.getDiastolic());				
				e.setBpClass(util.getBpClass());
				
				PatientBP bp = new PatientBP(e.getPatientID(), e.getSystolic(), e.getDiastolic(), e.getBpClass(), e.getMeasureDateTime());				
				
				String key = e.getPatientID();				
				BPChange change = addToCache(key, bp); 								
				
				if (change != null){
					//send downstream to be processed
					//System.out.println("Sending Event to be processed after cache invoke:" + amt.toString());
					streamSender_.sendInsertEvent(change);				
				} 
				
			}
					
		}
		
	}

	public BPChange addToCache(String key, PatientBP event) throws EventRejectedException {
				
 		
		NamedCache cache = (NamedCache)bpCache ;    	
	
		BPUpdater updater = new BPUpdater(event);		
		Object old = cache.invoke(key, updater); 
		
		if (old != null){
			
			//get an event with new and previous in it 
			if (old instanceof PatientBP){
				
				PatientBP oldBP = (PatientBP)old ;
				BPChange change = new BPChange(event, oldBP);
								
				return change ;		
			}
			
		}
				
		return null ;
		
	}



	
}
