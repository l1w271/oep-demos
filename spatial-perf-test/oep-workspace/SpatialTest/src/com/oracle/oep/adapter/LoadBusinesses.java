package com.oracle.oep.adapter;

import java.util.Random;

import oracle.spatial.geometry.JGeometry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;

import com.bea.wlevs.ede.api.InitializingBean;
import com.oracle.cep.cartridge.spatial.Geometry;
import com.oracle.oep.event.BusinessData;

public class LoadBusinesses implements InitializingBean, RunnableBean, StreamSource {

	Log log_ = LogFactory.getLog(LoadBusinesses.class);
    private StreamSender eventSender;
    private int numberBusinesses ; 
    private int loaded = 0 ;
    
    //private Random r ;
    
	public int getNumberBusinesses() {
		return numberBusinesses;
	}

	public void setNumberBusinesses(int numberBusinesses) {
		this.numberBusinesses = numberBusinesses;
	}

	public void afterPropertiesSet() throws Exception {
		
		System.out.println("Set number of businesses to load = " + numberBusinesses);
		
	}

	public void loadAll() throws Exception {
		
		
		while(loaded < numberBusinesses) {
		
			Random la = new Random();
			int ai = la.nextInt(10);
			double lai = la.nextDouble();
			double lad = (30+ai) + lai ;	
			//System.out.println("lad: " + lad);
			
			Random lo = new Random();
			int oi = lo.nextInt(10);
			double loi = lo.nextDouble();
			double lod = (-123+oi) + loi ;	
			//System.out.println("lod: " + lod);
			
			Random indR = new Random();
			int ind = indR.nextInt(9) + 1 ;
			//System.out.println("INDUSTRY = " + ind);
			
			BusinessData data = new BusinessData();
			data.setBusinessID(loaded);
			data.setIndustryID(ind);
			data.setLatitude(lad);
			data.setLongitude(lod);
			data.setBusinessEmail("test@emailexample.com");
			data.setBusinessName("Business_" + loaded);
			
			JGeometry jgeom = Geometry.createPoint(8307, data.getLongitude(), data.getLatitude());
			data.setGeometry(Geometry.to_Geometry(jgeom));
			loaded += 1; 
			
			//System.out.println("loaded: " + loaded);
			eventSender.sendInsertEvent(data);
		}

	}

	   /* (non-Javadoc)
     * @see com.bea.wlevs.ede.api.StreamSource#setEventSender(com.bea.wlevs.ede.api.StreamSender)
     */
    public void setEventSender(StreamSender sender) {
        eventSender = sender;
    }

	@Override
	public void run() {
		
		if(log_.isInfoEnabled()) {
			log_.info("Loading businesses ...");
		}		
		System.out.println("Loading Businesses!");
		try {
			loadAll();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("Loaded " + loaded + " Businesses!");

		if(log_.isInfoEnabled()) {
			log_.info("Loading businesses complete! ");
		}
		
		
	}

	@Override
	public void suspend() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
