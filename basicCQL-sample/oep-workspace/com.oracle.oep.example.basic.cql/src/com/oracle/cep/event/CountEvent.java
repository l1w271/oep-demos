package com.oracle.cep.event;

public class CountEvent {

	private int eventCount ;

	public int getEventCount() {
		return eventCount;
	}

	public void setEventCount(int eventCount) {
		this.eventCount = eventCount;
	}
		
	public String toString(){
		return "CountEvent [eventCount=" + eventCount + "]";		 
	}
	
	
	
	
}
