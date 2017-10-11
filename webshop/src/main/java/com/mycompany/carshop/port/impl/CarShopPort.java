package com.mycompany.carshop.port.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.model.beans.Deal;
import com.mycompany.carshop.model.beans.Manufacturer;
import com.mycompany.carshop.model.beans.Member;
import com.mycompany.carshop.model.beans.Part;
import com.mycompany.carshop.port.WebShopPort;
import com.mycompany.carshop.repository.CarSystemDAO;
import com.mycompany.carshop.repository.DealDao;
import com.mycompany.carshop.repository.MemberDao;
import com.mycompany.carshop.repository.PartDao;

/**
 * Implementation of service interface.
 * @author Veljko Matovic
 * Oct 7, 2017
 *
 */
@WebService(endpointInterface = "com.mycompany.carshop.port.WebShopPort")
public class CarShopPort implements WebShopPort {

    public CarShopPort() {
        super();
    }
    /**
     * Exposed method for getting part based on it's iD.
     * @param partId - ID of required part.
     * @return Part
     */
    @WebMethod
    public Part getPartById(final int partId) {

        PartDao partDao = new PartDao();
        return partDao.getPartById(partId);
    }

    /**
     * Gets all parts from database.
     */
    @WebMethod
    public Part[] getAllParts() {
        PartDao partDao = new PartDao();
        return partDao.getAllParts();
    }


    /**
     * Exposed method for getting car system based on it's ID.
     * @param systemId - ID of required system.
     * @return CarSystem
     */
    @WebMethod
    public CarSystem getSystemById(final int systemId) {
        CarSystemDAO carSysDao = new CarSystemDAO();
        return carSysDao.getSystemById(systemId);
    }



    /**
     * Gets all systems from database.
     */
    @WebMethod
    public CarSystem[] getAllSystems() {
        CarSystemDAO carSysDao = new CarSystemDAO();
        return carSysDao.getAllSystems();
    }

    /**
     * Gets member by id.
     */
    @WebMethod
    public Member getMemberById(int id) {
        MemberDao memberDao = new MemberDao();
        return memberDao.getMemberById(id);
    }

    /**
     * Gets all members from database.
     */
    @WebMethod
    public Member[] getAllMembers() {
        MemberDao memberDao = new MemberDao();
        return memberDao.getAllMembers();
    }

    /**
     * Gets deal from database with given id.
     */
    @WebMethod
    public Deal getDealById(int id) {
        DealDao dealDao = new DealDao();
        return dealDao.getDealById(id);
    }

    /**
     * Gets all parts by manufacturer.
     */
    @WebMethod
    public Part[] getAllPartsByManufacturer(Manufacturer manufacturer) {
        PartDao partDao = new PartDao();
        return partDao.getAllPartsByManufacturer(manufacturer);
    }

    @WebMethod
    public Deal[] getDealsByMember(Member member) {
        DealDao dealDao = new DealDao();
        return dealDao.getDealsByMember(member);
    }

    /**
     * Get all parts from given system.
     */
    @WebMethod
    public Part[] getAllPartsBySystem(CarSystem carSystem) {
        PartDao partDao = new PartDao();
        return partDao.getAllPartsBySystem(carSystem);
    }

    /**
     * Insert new car system.
     */
    @WebMethod
    public void addNewSystem(CarSystem carSystem) {
        CarSystemDAO carSystemDao = new CarSystemDAO();
        try {
            carSystemDao.addNewSystem(carSystem);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Order could not be placed!");
            e.printStackTrace();
        }
    }

    /**
     * Inserts new part in DB.
     */
    @WebMethod
    public void addNewPart(Part part) {
        PartDao partDao = new PartDao();
        try {
            partDao.addNewPart(part);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Part could not be inserted!");
            e.printStackTrace();
        }
    }

    /**
     * Place new order.
     */
    @WebMethod
    public void addNewDeal(Deal deal){
        DealDao dealDao = new DealDao();
        try {
            dealDao.addNewDeal(deal);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Order could not be placed!");
            e.printStackTrace();
        }
    }
    @WebMethod
    public Member getMemberByEmailAndPassword(String email, String password) {
        MemberDao memberDao = new MemberDao();
        return memberDao.getMemberByEmailAndPassword(email, password);
    }
}
