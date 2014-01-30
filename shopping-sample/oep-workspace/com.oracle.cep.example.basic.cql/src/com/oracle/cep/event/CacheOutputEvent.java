package com.oracle.cep.event;

public class CacheOutputEvent {

	protected String eventID ;
	protected String eventType ;
	protected String eventKey ;
	protected Integer eventValue ;
	protected int eventIntValue ; 
	protected String state ;
	
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
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
	public Integer getEventValue() {
		return eventValue;
	}
	public void setEventValue(Integer eventValue) {
		this.eventValue = eventValue;
	}

	public int getEventIntValue() {
		return eventValue.intValue();
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}	
	
	
	public String toString(){
		return "CacheOutputEvent [eventID=" + eventID + ", eventType=" + eventType + ", eventKey=" + eventKey + ", eventValue=" + eventValue + ", state=" + state + "]";		 
	}
	
}
