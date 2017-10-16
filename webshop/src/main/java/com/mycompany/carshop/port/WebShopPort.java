package com.mycompany.carshop.port;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.mycompany.carshop.fault.AuthenticationFault;
import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.model.beans.Deal;
import com.mycompany.carshop.model.beans.Manufacturer;
import com.mycompany.carshop.model.beans.Member;
import com.mycompany.carshop.model.beans.Part;
import com.mycompany.carshop.model.beans.PartList;

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
@SOAPBinding(style = SOAPBinding.Style.RPC) // ;style = SOAPBinding.Style.DOCUMENT, use=Use.LITERAL
public interface WebShopPort {
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
     * @throws AuthenticationFault
     */
    @WebMethod
    Member getMemberByEmailAndPassword(String email, String password); // throws NullPointerException throws AuthenticationFault

    /**
     * Inserts list of parts in DB.
     * @param partList - list of parts to be inserted.
     * @return TRUE if insert finishes successfully.
     */
    @WebMethod
    boolean insertParts(PartList partList);

    /**
     * Deletes part from database.
     * @param part - part to be deleted.
     * @return TRUE if deleted successfully.
     */
    @WebMethod
    boolean deletePart(Part part);

    /**
     * Gets all partsby given car system and manufacturer.
     * @param carSystem
     * @param manufacturer
     * @return all parts for given criteria in a list.
     */
    @WebMethod
    Part[] getPartsByCarSystemAndManufacturer(CarSystem carSystem, Manufacturer manufacturer);
}
