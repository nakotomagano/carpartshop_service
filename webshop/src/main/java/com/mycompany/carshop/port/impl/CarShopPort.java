package com.mycompany.carshop.port.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.model.beans.Deal;
import com.mycompany.carshop.model.beans.Manufacturer;
import com.mycompany.carshop.model.beans.Member;
import com.mycompany.carshop.model.beans.Part;
import com.mycompany.carshop.model.beans.PartList;
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
// commented out handler, because basic http authorisation is added. Check Docs folder for more information on both.
// @HandlerChain(file = "com/mycompany/carshop/handler/handler-chain.xml")
public class CarShopPort implements WebShopPort {

    public CarShopPort() {
        super();
    }
    /**
     * Exposed method for getting part based on it's iD.
     * @param partId - ID of required part.
     * @return Part
     */
    @Override
    @WebMethod
    public Part getPartById(final int partId) {
        PartDao partDao = new PartDao();
        return partDao.getPartById(partId);
    }

    /**
     * Gets all parts from database.
     */
    @Override
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
    @Override
    @WebMethod
    public CarSystem getSystemById(final int systemId) {
        CarSystemDAO carSysDao = new CarSystemDAO();
        return carSysDao.getSystemById(systemId);
    }


    /**
     * Gets all systems from database.
     */
    @Override
    @WebMethod
    public CarSystem[] getAllSystems() {
        CarSystemDAO carSysDao = new CarSystemDAO();
        return carSysDao.getAllSystems();
    }

    /**
     * Gets member by id.
     */
    @Override
    @WebMethod
    public Member getMemberById(int id) {
        MemberDao memberDao = new MemberDao();
        return memberDao.getMemberById(id);
    }

    /**
     * Gets all members from database.
     */
    @Override
    @WebMethod
    public Member[] getAllMembers() {
        MemberDao memberDao = new MemberDao();
        return memberDao.getAllMembers();
    }

    /**
     * Gets deal from database with given id.
     */
    @Override
    @WebMethod
    public Deal getDealById(int id) {
        DealDao dealDao = new DealDao();
        return dealDao.getDealById(id);
    }

    /**
     * Gets all parts by manufacturer.
     */
    @Override
    @WebMethod
    public Part[] getAllPartsByManufacturer(Manufacturer manufacturer) {
        PartDao partDao = new PartDao();
        return partDao.getAllPartsByManufacturer(manufacturer);
    }

    @Override
    @WebMethod
    public Deal[] getDealsByMember(Member member) {
        DealDao dealDao = new DealDao();
        return dealDao.getDealsByMember(member);
    }

    /**
     * Get all parts from given system.
     */
    @Override
    @WebMethod
    public Part[] getAllPartsBySystem(CarSystem carSystem) {
        PartDao partDao = new PartDao();
        return partDao.getAllPartsBySystem(carSystem);
    }

    /**
     * Insert new car system.
     */
    @Override
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
    @Override
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
    @Override
    @WebMethod
    public void addNewDeal(Deal deal) {
        DealDao dealDao = new DealDao();
        try {
            dealDao.addNewDeal(deal);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Order could not be placed!");
            e.printStackTrace();
        }
    }
    /**
     * Returns member's details if username/password combination is correct.
     */
    @Override
    @WebMethod
    public Member getMemberByEmailAndPassword(String email, String password) { //throws NullPointerException
        MemberDao memberDao = new MemberDao();
        Member member = new Member();
        member = memberDao.getMemberByEmailAndPassword(email, password);
        return member;
    }

    /**
     * Inserts list of parts in DB.
     */
    @Override
    @WebMethod
    public boolean insertParts(PartList partList) {
        for (Part part : partList.getParts()) {
            addNewPart(part);
        }
        return true;
    }
}
