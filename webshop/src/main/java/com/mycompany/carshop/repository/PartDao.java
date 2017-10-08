package com.mycompany.carshop.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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
}
