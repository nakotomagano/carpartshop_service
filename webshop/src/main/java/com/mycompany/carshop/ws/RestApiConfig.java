package com.mycompany.carshop.ws;

import org.glassfish.jersey.server.ResourceConfig;

public class RestApiConfig extends ResourceConfig {

    public RestApiConfig() {
        packages("com.mycompany.carshop.port.impl");
    }
}
