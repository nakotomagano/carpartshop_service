package com.mycompany.carshop.temp;

import javax.xml.ws.Endpoint;

import com.mycompany.carshop.port.impl.CarShopPort;

/**
 * Starts the app as standalone. Run as --> Java Application.
 * @author Veljko Matovic
 * Oct 15, 2017
 */
public class CarPartPublisher {

    /**
     * Temporary publisher for testing other parts of application.
     * @param args
     */
    public static void main(String[] args) {
        Endpoint.publish(
                "http://localhost:8088/carshopservice", new CarShopPort());
    }

}
