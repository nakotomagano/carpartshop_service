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

    private PartDao partDao = new PartDao();
    private MemberDao memberDao = new MemberDao();
    private CarSystemDAO carSystemDao = new CarSystemDAO();
    private DealDao dealDao = new DealDao();

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
        return partDao.getPartById(partId);
    }

    /**
     * Gets all parts from database.
     */
    @Override
    @WebMethod
    public Part[] getAllParts() {
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
        return carSystemDao.getSystemById(systemId);
    }


    /**
     * Gets all systems from database.
     */
    @Override
    @WebMethod
    public CarSystem[] getAllSystems() {
        return carSystemDao.getAllSystems();
    }

    /**
     * Gets member by id.
     */
    @Override
    @WebMethod
    public Member getMemberById(int id) {
        return memberDao.getMemberById(id);
    }

    /**
     * Gets all members from database.
     */
    @Override
    @WebMethod
    public Member[] getAllMembers() {
        return memberDao.getAllMembers();
    }

    /**
     * Gets deal from database with given id.
     */
    @Override
    @WebMethod
    public Deal getDealById(int id) {
        return dealDao.getDealById(id);
    }

    /**
     * Gets all parts by manufacturer.
     */
    @Override
    @WebMethod
    public Part[] getAllPartsByManufacturer(Manufacturer manufacturer) {
        return partDao.getAllPartsByManufacturer(manufacturer);
    }

    @Override
    @WebMethod
    public Deal[] getDealsByMember(Member member) {
        return dealDao.getDealsByMember(member);
    }

    /**
     * Get all parts from given system.
     */
    @Override
    @WebMethod
    public Part[] getAllPartsBySystem(CarSystem carSystem) {
        return partDao.getAllPartsBySystem(carSystem);
    }

    /**
     * Insert new car system.
     */
    @Override
    @WebMethod
    public void addNewSystem(CarSystem carSystem) {
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

    /**
     * Deletes given part from database.
     */
    @Override
    @WebMethod
    public boolean deletePart(Part part) {
        partDao.deletePart(part);
        return true;
    }

    /**
     * Gets all parts by given car system and manufacturer.
     */
    @Override
    @WebMethod
    public Part[] getPartsByCarSystemAndManufacturer(CarSystem carSystem, Manufacturer manufacturer) {
        return partDao.getPartsByCarSystemAndManufacturer(carSystem, manufacturer);
    }


}
