/* (c) 2006-2009 Oracle.  All rights reserved. */
package com.bea.wlevs.event.example.helloworld;

public class HelloWorldEvent {
	
	private String message;
	private String id ;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage (String message) {
		this.message = message;
	}
}
