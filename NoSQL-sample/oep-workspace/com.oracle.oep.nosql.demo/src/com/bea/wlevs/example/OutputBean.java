package com.bea.wlevs.example;

//import oracle.kv.KVStore;
//import oracle.kv.KVStoreConfig;
//import oracle.kv.KVStoreFactory;
//import oracle.kv.Key;
//import oracle.kv.Value;
//import oracle.kv.Version;

import com.bea.wlevs.ede.api.DisposableBean;
import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.InitializingBean;
import com.bea.wlevs.ede.api.StreamSink;
//import com.bea.wlevs.util.Service;

public class OutputBean implements StreamSink, InitializingBean, DisposableBean {
    
    //private KvLiteService kvLiteService;

    public void onInsertEvent(Object event) throws EventRejectedException 
    {
      System.out.println(event);
    }
    
    /*
    @Service
    public void setKvLiteService(KvLiteService service)
    {
      this.kvLiteService = service; 
    }
*/
    @Override
    public void afterPropertiesSet() throws Exception
    {
    	
    /*	
      kvLiteService.start();
      
      // Wait 3 seconds for Store to come up.
      Thread.sleep(3000);

      KVStore store = KVStoreFactory.getStore
        (new KVStoreConfig("kvstore", "localhost:5000"));
      
      CustomerDescription description = new CustomerDescription();
      description.setUserId("ronaldo");
      description.setCreditScore(5);
      description.setAddress("Rio de Janeiro");
      description.setCustomerName("Ronaldo Nascimento");
      
      putIntoStore(store, description);
      
      description = new CustomerDescription();
      description.setUserId("jordan");
      description.setCreditScore(10);
      description.setAddress("Chicago");
      description.setCustomerName("Michael Jordan");
      
      putIntoStore(store, description);
      
      description = new CustomerDescription();
      description.setUserId("senna");
      description.setCreditScore(7);
      description.setAddress("Sao Paulo");
      description.setCustomerName("Ayrton Senna");
      
      putIntoStore(store, description);
      
     */ 
    }
    /*
    private void putIntoStore(KVStore store, CustomerDescription description) throws Exception
    {
      Version version =
        store.put(
            Key.createKey(description.getUserId()),
            Value.createValue(description.serialize()));
      
      System.out.println("Added version = " + version.getVersion());
    }
  */
    @Override
    public void destroy() throws Exception
    {
      //kvLiteService.stop();
    }
    
  
}
