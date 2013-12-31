package com.oracle.cep.listener;

import com.tangosol.util.MapEvent;
import com.tangosol.util.MapListener;

/**
 * This class implements the cache listener 
 * 
 */
public class CacheListener implements MapListener {
	
	/**
	 * Spring uses this constructor to create the bean.
	 */
	public CacheListener() {
	}

	public void entryDeleted(MapEvent event) {		
		System.out.println("entryDeleted: " + event.getOldValue());		
	}

	public void entryInserted(MapEvent event) {
		System.out.println("entryInserted: " + event.getNewValue());	
			
	}

	public void entryUpdated(MapEvent event) {
		//System.out.println("CurrentTime: " + System.currentTimeMillis());
		System.out.println("entryUpdated: OLD: " + event.getOldValue() + " NEW: " + event.getNewValue());
	}
	
}
