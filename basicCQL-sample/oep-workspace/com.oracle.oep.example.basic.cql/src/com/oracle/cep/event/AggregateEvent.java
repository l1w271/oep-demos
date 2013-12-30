package com.oracle.cep.event;

public class AggregateEvent {

	private String eventKey ;	
	
	private int eventTotal ;
	
	public String getEventKey() {
		return eventKey;
	}


	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}


	public int getEventTotal() {
		return eventTotal;
	}


	public void setEventTotal(int eventTotal) {
		this.eventTotal = eventTotal;
	}

	public String toString(){
		return "AggregateEvent [eventKey= " + eventKey + " eventTotal=" + eventTotal + "]";		 
	}
	
	
}
