package com.techdata.carshop.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.techdata.carshop.clientWs.CarSystem;
import com.techdata.carshop.clientWs.CarSystemArray;
import com.techdata.carshop.clientWs.ServiceImpl;
import com.techdata.carshop.clientWs.ServiceImplService;

/**
 * Client class used for calling CarShop web service 
 * Communicating with web service through send and receive 
 * Request/Response
 * @author 806560 Stefan Jovanic
 * 
 * */

public class CarShopWSclient {
	 
	URL url; 
	ServiceImplService carshopService;
	ServiceImpl port;
	
	/**
	 * Define URL and initialize Service and port. 
	 * A WSDL document defines services as collections of network endpoints, or ports. 
	 * In WSDL, the abstract definition of endpoints and messages is separated from their 
	 * concrete network deployment or data format bindings. This allows the reuse of abstract 
	 * definitions: messages, which are abstract descriptions of the data being exchanged, and
	 * port types which are abstract collections of operations.
	 * */
	public CarShopWSclient() throws MalformedURLException {
        try {
        	
        	url = new URL("http://localhost:8088/carshopservice?wsdl");
    		carshopService = new ServiceImplService(url);
    		port = carshopService.getServiceImplPort();
    		
		} catch (Exception e) {
			// TODO: handle exception
		 e.printStackTrace();
		}
	}

	/**
	 * This is initial createRequest method for purpose of testing web service 
	 * sending request port.getAllSystems(); and receiving response as CarSystemArray.
	 * Return type of method is defined as Array but WSIMPORT generated CarSystemArray object
	 * as separate type with List<CarSystem> getItem(). Using od CarSytem[] won't work.  
	 * */
	public void createRequest(){
		try {
          CarSystemArray cs = port.getAllSystems();
            // Getting methog getItem as return type is list and then getting its size.
            for (int i = 0; i < cs.getItem().size(); i++) {
				System.out.println(cs.getItem().get(i).getSystemName());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws MalformedURLException {
		// Instantiation of Class CarShopWSclient object 
		CarShopWSclient car = new CarShopWSclient();
		// Call to method createRequest. Output should be printed out all systems in DB. 
		car.createRequest();
	}

}