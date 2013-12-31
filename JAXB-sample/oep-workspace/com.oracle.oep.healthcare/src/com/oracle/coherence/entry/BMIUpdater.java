package com.oracle.coherence.entry;

import java.io.IOException;

import com.tangosol.io.pof.PortableObject;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.processor.AbstractProcessor;

import com.oracle.coherence.data.PatientBMI ;


public class BMIUpdater extends AbstractProcessor implements PortableObject {

    // ----- data members -------------------------------------------
	private static final long serialVersionUID = 1L;
	private PatientBMI bmi ;
	
	// ----- constructors -------------------------------------------

    public BMIUpdater(){
    }

    public BMIUpdater(PatientBMI bmi){
    	
    	this.bmi = bmi ; 
    	//System.out.println("Incoming bmi" + bmi.toString());
    }

    // ----- InvocableMap.EntryProcessor interface ------------------
    
    public Object process(InvocableMap.Entry entry) {
    	   	
    	if (entry.isPresent())
    	  {
    	   
    		//System.out.println("Entry is Present! " + sms.toString());
    		// do update
    		PatientBMI prev = (PatientBMI) entry.getValue();    		
    		
    		//replace the old entry with the new entry in the cache
    		entry.setValue(bmi);    		
    		
    		//pass back the old entry
    		return prev ;
    	        	    
    	  }
    	  else
    	  {    	    
    		
    		System.out.println("No Entry Yet. Add it: " + bmi.toString());       			
    		entry.setValue(bmi);    			
    		return null ;
    	    
    	  }
    	
    }    	
    
	public void readExternal(PofReader in) throws IOException {
		this.bmi = (PatientBMI) in.readObject(0);
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeObject(0, this.bmi);
	}

}
