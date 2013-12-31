package com.oracle.cep.adapter;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bea.wlevs.adapters.jms.api.OutboundMessageConverter;
import com.bea.wlevs.adapters.jms.api.MessageConverterException;

//import com.oracle.cep.demo.jaxb.event.*;
import com.oracle.cep.siebel.jaxb.event.*;


public class OutboundJmsJaxbMessageConverter implements OutboundMessageConverter {

	Log log_ = LogFactory.getLog(OutboundJmsJaxbMessageConverter.class);

	private JAXBContext jaxbContext_;

	@SuppressWarnings("unchecked")
	public List<Message> convert(Session jmsSession, Object event) throws MessageConverterException, JMSException {
					
		List<Message> messages = new ArrayList<Message>();
		String xml = null ;
		
		System.out.println("OUTBOUND JMS JAXB ADAPTER: RECEIVED MESSAGE! " + event.getClass().getSimpleName());
		
		if (event instanceof ActivitiesInputType) {
			
			ActivitiesInputType alert = (ActivitiesInputType) event ;
			//alert.getAlertType();
			xml = getXML(alert);
			
			Message msg = jmsSession.createTextMessage(xml);
			messages.add(msg);
		} else {
			
			System.out.println("This isn't a recognized alert type!");

			log_.warn("onMessage():skipping unexpected message type:" + event.toString());
			messages = Collections.EMPTY_LIST;
		}
		
		/*	
		if (event instanceof BMIAlertType) {
			
			//BMIAlertType alert = (BMIAlertType) event ;
			//alert.getAlertType();
			xml = getBMIAlertTypeXML((BMIAlertType) event);
			
			Message msg = jmsSession.createTextMessage(xml);
			messages.add(msg);
		}			
		
		else if (event instanceof BPAlertType) {
				
			xml = getBPAlertTypeXML((BPAlertType) event);
				
			Message msg = jmsSession.createTextMessage(xml);
			messages.add(msg);
		}

		else if (event instanceof BGAlertType) {
				
			xml = getBGAlertTypeXML((BGAlertType) event);
				
			Message msg = jmsSession.createTextMessage(xml);
			messages.add(msg);			
		}
		
		else if (event instanceof HBA1CAlertType) {
			
			xml = getHBA1CAlertTypeXML((HBA1CAlertType) event);
				
			Message msg = jmsSession.createTextMessage(xml);
			messages.add(msg);			
							
		} else {
			
			System.out.println("This isn't a recognized alert type!");

			log_.warn("onMessage():skipping unexpected message type:" + event.toString());
			messages = Collections.EMPTY_LIST;
		}
		
		*/
		
		return messages;
	}
	
	
	private String getXML(ActivitiesInputType eventPoJo) throws MessageConverterException {
		
		//eventPoJo.setTimestamp(System.currentTimeMillis());

		ObjectFactory factory = new ObjectFactory();
		JAXBElement<ActivitiesInputType> element = factory.createActivitiesInput(eventPoJo);
		String xml = createXMLMessage(element);
		
		return xml ;
	}

	
	/*
	private String getBPAlertTypeXML(BPAlertType eventPoJo) throws MessageConverterException {
		
		//eventPoJo.setTimestamp(System.currentTimeMillis());

		ObjectFactory factory = new ObjectFactory();
		JAXBElement<BPAlertType> element = factory.createBPAlert(eventPoJo);
		String xml = createXMLMessage(element);
		
		return xml ;
	}


	private String getBMIAlertTypeXML(BMIAlertType eventPoJo) throws MessageConverterException {
		
		//eventPoJo.setTimestamp(System.currentTimeMillis());

		ObjectFactory factory = new ObjectFactory();
		JAXBElement<BMIAlertType> element = factory.createBMIAlert(eventPoJo);
		String xml = createXMLMessage(element);
		
		return xml ;
	}

	private String getBGAlertTypeXML(BGAlertType eventPoJo) throws MessageConverterException {
		
		//eventPoJo.setTimestamp(System.currentTimeMillis());

		ObjectFactory factory = new ObjectFactory();
		JAXBElement<BGAlertType> element = factory.createBGAlert(eventPoJo);
		String xml = createXMLMessage(element);
		
		return xml ;
	}

	private String getHBA1CAlertTypeXML(HBA1CAlertType eventPoJo) throws MessageConverterException {
		
		//eventPoJo.setTimestamp(System.currentTimeMillis());

		ObjectFactory factory = new ObjectFactory();
		JAXBElement<HBA1CAlertType> element = factory.createHBA1CAlert(eventPoJo);
		String xml = createXMLMessage(element);
		
		return xml ;
	}
	*/
	
	
	@SuppressWarnings("unchecked")
	private String createXMLMessage(JAXBElement element) {
		try {			
			
			Marshaller m = jaxbContext_.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			StringWriter sw = new StringWriter();
			m.marshal(element, sw);
			//TESTING: show the xml string on the console
			System.out.println(sw.toString());
			return sw.toString();		
		}
		catch (JAXBException jaxbException) {
			//throw new Exception("JAXB unmarshalling failure:", jaxbException);
			jaxbException.printStackTrace();
			return null ;
		}
	}

	
	/**
	 * Set from Spring Configuration
	 * @param packageNames
	 */
	public void setJaxbContextPackageList(String packageNames) {
		log_.info("setJaxbContextPackageList():"+packageNames);
		try {
			jaxbContext_ = JAXBContext.newInstance(packageNames);
		} catch (JAXBException e) {
			throw new IllegalArgumentException(
					"Could not construct JAXBContext using packageNames:"+packageNames+
					" message:"+e.getMessage(), e);
		}
	}	

	/**
	 * Spring callback
	 */
	public void afterPropertiesSet() throws Exception {
		if(jaxbContext_ == null) {
			throw new IllegalStateException(
					"OutboundJmsJaxbMessageConverter.afterPropertiesSet() jaxbContext is not initialized." +
					"Ensure that the jaxbContextPackageList property has been set.");
		}	
	}

}
