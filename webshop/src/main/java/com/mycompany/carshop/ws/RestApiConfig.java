package com.mycompany.carshop.ws;

import org.glassfish.jersey.server.ResourceConfig;

import com.mycompany.carshop.port.impl.CORSResponseFilter;

public class RestApiConfig extends ResourceConfig {

    public RestApiConfig() {
        packages("com.mycompany.carshop.port.impl");
        register(CORSResponseFilter.class);
    }
}
