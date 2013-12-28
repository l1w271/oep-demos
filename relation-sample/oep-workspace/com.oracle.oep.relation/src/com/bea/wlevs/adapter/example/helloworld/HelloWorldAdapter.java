/* (c) 2006-2009 Oracle.  All rights reserved. */
package com.bea.wlevs.adapter.example.helloworld;

import java.text.DateFormat;
import java.util.Date;

import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;
import com.bea.wlevs.event.example.helloworld.HelloWorldEvent;
//import java.util.UUID;

public class HelloWorldAdapter implements RunnableBean, StreamSource {

    private static final int SLEEP_MILLIS = 1000;

    private DateFormat dateFormat;
    private String message;
    private boolean suspended;

    private StreamSender eventSender;

    public HelloWorldAdapter() {
        super();
        dateFormat = DateFormat.getTimeInstance();
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        suspended = false;
        while (!isSuspended()) { // Generate messages forever...

            generateHelloMessage();

            try {
                synchronized (this) {
                    wait(SLEEP_MILLIS);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void generateHelloMessage() {
        //String id = UUID.randomUUID().toString();
    	//String message = this.message + dateFormat.format(new Date()) + " - " + id;
    	String message = this.message + dateFormat.format(new Date());
        HelloWorldEvent event = new HelloWorldEvent();
        event.setId("5");
        event.setMessage(message);
        eventSender.sendInsertEvent(event);
    }

    /* (non-Javadoc)
     * @see com.bea.wlevs.ede.api.StreamSource#setEventSender(com.bea.wlevs.ede.api.StreamSender)
     */
    public void setEventSender(StreamSender sender) {
        eventSender = sender;
    }

    /* (non-Javadoc)
     * @see com.bea.wlevs.ede.api.SuspendableBean#suspend()
     */
    public synchronized void suspend() {
        suspended = true;
    }

    private synchronized boolean isSuspended() {
        return suspended;
    }
}