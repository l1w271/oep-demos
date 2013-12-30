package com.oracle.cep.event;

public class CacheStateEvent {

	protected String eventKey ;	
	protected String state ;	
	protected String check ;	
	protected String response ;

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	public String toString(){
		return "CacheStateEvent [eventKey=" + eventKey + "state=" + state + ", check" + check + "response=" + response + "]";		 
	}
	
}
