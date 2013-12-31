package com.oracle.cep.adapter;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;

 /**
 * 	BAM Uses the XML XSD format for DateTime (by default): 2004-05-22T08:31:00.0000000-07:00
 *  You can configure a different format on the EMS configuration, but then
 *  you have to remember to set that format on every EMS definition.  For now
 *  we provide this utility to format all DateTime values.  
 *  
 *  Note that there doesn't seem to be an easy way to do this using the 
 *  SimpleDateFormat (TZ ends up as -0700 rather than -07:00).
 */
public class XmlDateFormatter {

	private GregorianCalendar calendar_;
	private DatatypeFactory dataTypeFactory_;
	
	public XmlDateFormatter() {
		try {
			calendar_ = (GregorianCalendar) java.util.Calendar.getInstance();
			dataTypeFactory_ = javax.xml.datatype.DatatypeFactory.newInstance();
			
		} catch(Exception e) {
			throw new RuntimeException("Failure during initialization:"+e.getMessage(),e);
		}
	}
	 
	synchronized public String format(long date) {
		return format(new Date(date));
	}

	synchronized public String format(Date date) {
		calendar_.setTime(date);
		return dataTypeFactory_.newXMLGregorianCalendar(calendar_).toXMLFormat();
	}
}
