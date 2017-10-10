package com.mycompany.carshop.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.model.beans.Deal;
import com.mycompany.carshop.model.beans.Manufacturer;
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
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Service {
    /**
     * Gets the part with given part ID.
     * @param partId - id of wanted part.
     * @return Part
     */
    @WebMethod
    @WebResult(name = "Part")
    Part getPartById(int partId);

    /**
     * Gets all parts from database.
     * @return
     */
    @WebMethod
    @WebResult(name = "AllParts")
    Part[] getAllParts();

    /**
     * Gets all parts from given manufacturer.
     * @param manufacturer
     * @return
     */
    @WebMethod
    Part[] getAllPartsByManufacturer(Manufacturer manufacturer);

    /**
     * Gets all parts from given carSystem.
     * @param carSystem
     * @return
     */
    @WebMethod
    Part[] getAllPartsBySystem(CarSystem carSystem);

    /**
     * Gets the CarSystem with given system ID.
     * @param systemId - ID of wanted system.
     * @return CarSystem
     */
    @WebMethod
    CarSystem getSystemById(int systemId);


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

    /**
     * Gets deal with given id.
     * @param id
     * @return
     */
    @WebMethod
    Deal getDealById(int id);

    /**
     * Gets all deals for member.
     * @param member - whose deals we need to return.
     * @return
     */
    @WebMethod
    Deal[] getDealsByMember(Member member);

    /**
     * Insert new car system.
     * @param carSystem
     */
    @WebMethod
    void addNewSystem(CarSystem carSystem);

    /**
     * Insert new part in database.
     * @param part
     */
    @WebMethod
    void addNewPart(Part part);

    /**
     * Create new deal.
     * @param deal
     */
    @WebMethod
    void addNewDeal(Deal deal);

    /**
     * Returns member with given email and password.
     * If there is no user with given credentials, nullpointerexception is thrown.
     * @param email
     * @param password
     * @return
     */
    @WebMethod
    Member getMemberByIdAndPassword(String email, String password);
}
