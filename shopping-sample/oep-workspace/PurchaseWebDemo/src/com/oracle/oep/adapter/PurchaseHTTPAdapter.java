package com.oracle.oep.adapter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import com.bea.wlevs.ede.api.Adapter;
import com.bea.wlevs.ede.api.RunnableBean;
import com.bea.wlevs.ede.api.InitializingBean;
import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;
import com.bea.wlevs.ede.api.SuspendableBean;
import com.bea.wlevs.ede.api.ResumableBean;
import com.bea.wlevs.util.Service;
import com.oracle.oep.event.PurchaseEvent;

import java.util.UUID;

public class PurchaseHTTPAdapter extends HttpServlet implements Adapter, InitializingBean, StreamSource, RunnableBean, ResumableBean, SuspendableBean {

	private static final long serialVersionUID = -2319331919163970964L;
	private boolean suspended = true ;
	
	private StreamSender eventSender;
	
	public void setEventSender(StreamSender sender) {
	        eventSender = sender;
	}
	
	private String contextString;

	public void setContextString(String contextString) {
		this.contextString = contextString;
	}
    
    
    public PurchaseHTTPAdapter() {
        super();
    }

    public void run() {
    	
        while (!isSuspended()) { 
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				//e.printStackTrace();
			}

        }
        
    }
 
    public synchronized void suspend() {
        suspended = true;
    }
    
    private synchronized boolean isSuspended() {
        return suspended;
    }


	@Override
	public void beforeResume() throws Exception {
		
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	
	@Service(serviceType = HttpService.class)
	public void setHttpService(HttpService httpService) {
		try {
			httpService.registerServlet(contextString, this, null, null);
			System.out.println("Servlet Registered with Context:" + contextString );
		} catch (ServletException e) {
			System.out.println("ERROR: Could not register servlet: "
					+ e.getMessage());
			e.printStackTrace();
		} catch (NamespaceException e) {
			System.out.println("ERROR: Could not register servlet: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		doAny(request, response);
		//System.out.println("**** END GET  *****");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		doAny(request, response);
		//System.out.println("**** END POST  *****");
		
	}
	
	public void doAny(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String responseString = ""; 
		PurchaseEvent event = new PurchaseEvent();
		
		//String submitType = request.getParameter("FormName");
		/*
		if (submitType != null){
			System.out.println("Received a request.");
			
		*/	
		UUID purchaseID = UUID.randomUUID();
		event.setPurchaseID(purchaseID.toString());
		
			boolean isOK = true ; 
			
			try {
				event.setCustomerID(request.getParameter("customerID"));
				event.setCardNo(request.getParameter("cardNo"));		
				double price = 0.00d ;
				try {
					price = Double.valueOf(request.getParameter("price")).doubleValue();
					isOK = true ;
					event.setPrice(price);
					System.out.println("Price is OK");
				} catch (NumberFormatException nfex) {
					isOK = false ;
					responseString += "<b> Price is : '" + request.getParameter("price") + "' is not valid! </b>";
					System.out.println("Number Format Exception");
				}
				
				int rtoMerchantID = 0;
				try {
					rtoMerchantID = Integer.valueOf(request.getParameter("rtoMerchantID")).intValue();
					event.setRtoMerchantID(rtoMerchantID);
					System.out.println("rtoMerchantID is OK");					
					
				} catch (NumberFormatException nfex) {
					isOK = false ;
					responseString += "<b> rtoMerchantID is : '" + request.getParameter("rtoMerchantID") + "' is not valid! </b>";
					System.out.println("Number Format Exception");
				}
				
				if (isOK){ 
					eventSender.sendInsertEvent(event);
				}
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Error accepting a request!");
				
			}


		//}
		//response.flushBuffer();	
		PrintWriter out = response.getWriter();
		responseString += "<br><a href=\"/purchaseEntry/purchase.html\">Return To Purchase Entry</a>" ;
		out.write(responseString);
		out.close();
		
		
		
	}
	
	public boolean testStartsNumber(String text) {
	//Test to see if the input starts with a number 
   //return false = invalid input if it does
	   
	   if (text.matches("[0-9]+")) {
		return false ;
	   }
		else {
			
			if (text.length() > 0){
				return true ;
			}
			return false ;
		}
		
	
	}

	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		
	}




	
    
}
