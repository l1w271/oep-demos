/* (c) 2006-2009 Oracle.  All rights reserved. */
package com.oracle.oep.adapter;

import com.bea.wlevs.ede.api.RelationSink;
import com.bea.wlevs.ede.api.StreamSink;

public class OutputBean implements StreamSink, RelationSink {

	public void onInsertEvent(Object event) {
        System.out.println("OutputBean:onEvent() + " + event.toString());	
	}

	public void onDeleteEvent(Object event) {
        System.out.println("OutputBean:onEvent() - " + event.toString());	
	}

	public void onUpdateEvent(Object event) {
        System.out.println("OutputBean:onEvent() U " + event.toString());	
	}
}
