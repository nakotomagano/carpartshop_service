package com.mycompany.carshop.fault;

import javax.xml.ws.WebFault;

/**
 * Cutom fault which is thrown on bad login input.
 * @author 806558
 *
 */
@WebFault(name = "AuthenticationFault", targetNamespace = "http://localhost:8080/webshop/")
public class AuthenticationFault extends Exception {

    private static final long serialVersionUID = 1L;

    public AuthenticationFault(String message, Throwable cause) {
        super(message, cause);
    }
}
