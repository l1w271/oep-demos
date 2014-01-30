package com.oracle.cep.event;

public class PartitionEvent {

	private String eventKey ;	
	
	private double eventAvg ;
	
	private int eventSum ;
	private int numEvents ;
	
	public double getEventAvg() {
		return eventAvg;
	}

	public void setEventAvg(double eventAvg) {
		this.eventAvg = eventAvg;
	}

	public String getEventKey() {
		return eventKey;
	}
	
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}


	public int getEventSum() {
		return eventSum;
	}

	public void setEventSum(int eventSum) {
		this.eventSum = eventSum;
	}

	public int getNumEvents() {
		return numEvents;
	}

	public void setNumEvents(int numEvents) {
		this.numEvents = numEvents;
	}
	
	
	public String toString(){
		return "PartitionEvent [eventKey= " + eventKey + " eventAvg=" + eventAvg + " eventSum=" + eventSum + " numEvents=" + numEvents + "]";		 
	}
	
}
