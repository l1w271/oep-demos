package com.oracle.cep.event;

public class CacheCheckEvent {

	protected String eventKey ;
	protected String check ;
	
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	
	public String toString(){
		return "CacheCheckEvent [eventKey=" + eventKey + ", check=" + check + "]";		 
	}
	
}
