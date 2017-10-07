package com.mycompany.carshop.temp;

import javax.xml.ws.Endpoint;

import com.mycompany.carshop.service.impl.ServiceImpl;


public class CarPartPublisher {
    
public static void main(String[] args) {
        Endpoint.publish(
           "http://localhost:8089/carshopservice", 
           new ServiceImpl());
    }

}
