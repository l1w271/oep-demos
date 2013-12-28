/* (c) 2006-2009 Oracle.  All rights reserved. */
package com.bea.wlevs.example.helloworld;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.RelationSender;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSink;
import com.bea.wlevs.ede.api.RelationSink;
//import com.bea.wlevs.ede.api.StreamSource;
import com.bea.wlevs.ede.api.RelationSource;
import com.bea.wlevs.event.example.helloworld.HelloWorldEvent;

public class HelloWorldBean implements StreamSink, RelationSink, RelationSource {

	RelationSender sender_ ;

	@Override
	public void setEventSender(StreamSender sender) {
		
		
		sender_ = (RelationSender) sender ;
		
	}

    public void onInsertEvent(Object event) {
        if (event instanceof HelloWorldEvent) {
            HelloWorldEvent helloWorldEvent = (HelloWorldEvent) event;
            System.out.println("Message: " + helloWorldEvent.getMessage());
        }
        
      //sender_.sendDeleteEvent(event);       
        
    }

	@Override
	public void onDeleteEvent(Object event) throws EventRejectedException {
		
		 if (event instanceof HelloWorldEvent) {
	            HelloWorldEvent helloWorldEvent = (HelloWorldEvent) event;
	            System.out.println("Deleted: " + helloWorldEvent.getMessage());
		 }	            
	}

	@Override
	public void onUpdateEvent(Object event) throws EventRejectedException {
		
		
	}

}
