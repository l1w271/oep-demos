/* (c) 2006-2009 Oracle.  All rights reserved. */
package com.bea.wlevs.example.helloworld;

import com.bea.wlevs.ede.api.StreamSink;

import com.oracle.helloworld.event.HelloWorldEvent;

public class HelloWorldBean implements StreamSink {

    /* (non-Javadoc)
     * @see com.bea.wlevs.ede.api.StreamSink#onInsertEvent(java.lang.Object)
     */
    public void onInsertEvent(Object event) {
    	
    	if (event instanceof HelloWorldEvent) {
            HelloWorldEvent helloWorldEvent = (HelloWorldEvent) event;
            System.out.println("*** Message: " + helloWorldEvent.getMessage());
        }
        
    }
}
