package com.mycompany.carshop.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.model.beans.Part;

/**
 * Service interface which exposes web methods.
 * Some of methods that must be available are:
 * - get information about parts/manufacturers/systems based on some criteria
 * - register new user
 * - check credentials for existing users
 * - purchase order
 * @author Veljko Matovic
 * Oct 7, 2017
 *
 */
@WebService
public interface Service {
    /**
     * Gets the part with given part ID.
     * @param partId - id of wanted part.
     * @return Part
     */
    @WebMethod
    Part getPart(int partId);

    /**
     * Gets the CarSystem with given system ID.
     * @param systemId - ID of wanted system.
     * @return CarSystem
     */
    @WebMethod
    CarSystem getSystem(int systemId);
}
