package org.anupam.camel.camelExample;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CamelContext camelContext = new DefaultCamelContext();
    	try{
	        camelContext.addRoutes(new FileProcessorRoute());
	        camelContext.start();
	        Thread.sleep(4000);	        
    		camelContext.stop();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
