package com.mycompany.carshop.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAnyElement;

import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.model.beans.Member;
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
     * Gets all parts from database.
     * @return
     */
    @WebMethod
    Part[] getAllParts();

    /**
     * Gets the CarSystem with given system ID.
     * @param systemId - ID of wanted system.
     * @return CarSystem
     */
    @WebMethod
    CarSystem getSystem(int systemId);
    
    
    /**
     * Gets all parts from database.
     * @return
     */
    @WebMethod
    CarSystem[] getAllSystems();
    
    /**
     * Gets member from database with given id.
     * @param id
     * @return
     */
    @WebMethod
    Member getMemberById(int id);
    
    /**
     * Gets all members from database.
     * @return
     */
    @WebMethod
    Member[] getAllMembers();
}
