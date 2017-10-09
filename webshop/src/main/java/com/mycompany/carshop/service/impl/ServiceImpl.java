package com.mycompany.carshop.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.model.beans.Deal;
import com.mycompany.carshop.model.beans.Manufacturer;
import com.mycompany.carshop.model.beans.Member;
import com.mycompany.carshop.model.beans.Part;
import com.mycompany.carshop.repository.CarSystemDAO;
import com.mycompany.carshop.repository.DealDao;
import com.mycompany.carshop.repository.MemberDao;
import com.mycompany.carshop.repository.PartDao;
import com.mycompany.carshop.service.Service;

/**
 * Implementation of service interface.
 * @author Veljko Matovic
 * Oct 7, 2017
 *
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ServiceImpl implements Service {

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
}
