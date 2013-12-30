package com.oracle.cep.event;

public class PatternEvent {

	private String eventType ;
	private String eventKey ;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	
	public String toString(){
		return "PatternEvent [eventKey=" + eventKey + ", eventType=" + eventType + "]";		 
	}
	
}
