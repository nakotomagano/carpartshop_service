package com.mycompany.carshop.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.model.beans.Manufacturer;
import com.mycompany.carshop.model.beans.Part;
import com.mycompany.carshop.utils.HibernateUtil;
/**
 * Repository class for dealing with DB informations related to Part.
 * @author Veljko Matovic
 * Oct 7, 2017
 *
 */
public class PartDao {
    /**
     * Gets the Part from DB based on given parameter - ID of the part.
     * @param partId - id of the wanted part.
     * @return Part
     */
    public Part getPartById(int partId) {
        Part p = new Part();
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Part p WHERE partId = :partId";
        Query query = session.createQuery(hql);
        query.setParameter("partId", partId);

        List results = query.list();
        //TODO: Find better way to get single result!
        p = (Part) results.get(0);
        session.close();
        return p;
    }


    /**
     * Gets all parts from database.
     * @return
     */
    public Part[] getAllParts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Part");
        List partList = q.list();
        int partNumber = partList.size();
        Part[] allParts = new Part[partNumber];
        for (int i = 0; i < partNumber; i++) {
            allParts[i] = (Part) partList.get(i);
        }
        session.close();
        return allParts;
    }


    /**
     * Gets all parts from database based on given parameter - manufacturer.
     * @return
     */
    public Part[] getAllPartsByManufacturer(Manufacturer manufacturer) {
        Part p = new Part();
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select distinct p FROM Part p join p.man m where m.manId = :manId";
        Query query = session.createQuery(hql);
        query.setParameter("manId", manufacturer.getManId());

        List results = query.list();
        int partNumber = results.size();
        Part[] allPartsFromManufacturer = new Part[partNumber];
        for (int i = 0; i < partNumber; i++) {
            p = (Part) results.get(i);
            allPartsFromManufacturer[i] = p;
        }
        session.close();
        return allPartsFromManufacturer;
    }


    /**
     * Gets all parts from database based on given parameter - part system.
     * @return
     */
    public Part[] getAllPartsBySystem(CarSystem carSystem) {
        Part p = new Part();
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select distinct p FROM Part p join p.system s where s.systemId = :sysId";
        Query query = session.createQuery(hql);
        query.setParameter("sysId", carSystem.getSystemId());

        List results = query.list();
        int partNumber = results.size();
        Part[] allPartsFromSystem = new Part[partNumber];
        for (int i = 0; i < partNumber; i++) {
            p = (Part) results.get(i);
            allPartsFromSystem[i] = p;
        }
        session.close();
        return allPartsFromSystem;
    }
}
