package com.techdata.carshop.temp;

import javax.xml.ws.Endpoint;

import com.techdata.carshop.service.impl.ServiceImpl;


public class CarPartPublisher {
    
public static void main(String[] args) {
        Endpoint.publish(
           "http://localhost:8088/carshopservice", 
           new ServiceImpl());
    }

}
