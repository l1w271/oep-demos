package com.oracle.coherence.entry;

import java.io.IOException;

import com.tangosol.io.pof.PortableObject;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.processor.AbstractProcessor;

import com.oracle.coherence.data.PatientBP ;


public class BPUpdater extends AbstractProcessor implements PortableObject {

    // ----- data members -------------------------------------------
	private static final long serialVersionUID = 1L;
	private PatientBP bp ;
	
	// ----- constructors -------------------------------------------

    public BPUpdater(){
    }

    public BPUpdater(PatientBP bp){
    	
    	this.bp = bp ; 
    	//System.out.println("Incoming bp" + bp.toString());
    }

    // ----- InvocableMap.EntryProcessor interface ------------------
    
    public Object process(InvocableMap.Entry entry) {
    	   	
    	if (entry.isPresent())
    	  {
    	   
    		//System.out.println("Entry is Present! " + sms.toString());
    		// do update
    		PatientBP prev = (PatientBP) entry.getValue();    		
    		
    		//replace the old entry with the new entry in the cache
    		entry.setValue(bp);    		
    		
    		//pass back the old entry
    		return prev ;
    	        	    
    	  }
    	  else
    	  {    	    
    		
    		System.out.println("No Entry Yet. Add it: " + bp.toString());       			
    		entry.setValue(bp);    			
    		return null ;
    	    
    	  }
    	
    }    	
    
	public void readExternal(PofReader in) throws IOException {
		this.bp = (PatientBP) in.readObject(0);
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeObject(0, this.bp);
	}

}
