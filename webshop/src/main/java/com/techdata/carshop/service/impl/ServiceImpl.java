package com.techdata.carshop.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.techdata.carshop.model.beans.CarSystem;
import com.techdata.carshop.model.beans.Part;
import com.techdata.carshop.repository.CarSystemDAO;
import com.techdata.carshop.repository.PartDao;
import com.techdata.carshop.service.Service;

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
    public Part getPart(final int partId) {
        PartDao partDao = new PartDao();
        return partDao.getPart(partId);
    }

    /**
     * Exposed method for getting car system based on it's ID.
     * @param systemId - ID of required system.
     * @return CarSystem
     */
    @WebMethod
    public CarSystem getSystem(final int systemId) {
        CarSystemDAO carSysDao = new CarSystemDAO();
        return carSysDao.getSystem(systemId);
    }


}
