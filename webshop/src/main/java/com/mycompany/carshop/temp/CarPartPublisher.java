package com.mycompany.carshop.temp;

import javax.xml.ws.Endpoint;

import com.mycompany.carshop.service.impl.ServiceImpl;


public class CarPartPublisher {

    /**
     * Temporary publisher for testing other parts of application.
     * @param args
     */
    public static void main(String[] args) {
        Endpoint.publish(
                "http://localhost:8090/carshopservice", new ServiceImpl());
    }

}
