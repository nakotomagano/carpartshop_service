package com.mycompany.carshop.repository;

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
    public Part getPart(int partId) {
        Part p = new Part(1, "Part Name in db");

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("from Part");
        List<Integer> list = q.list();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            p = (Part) iterator.next();
            if (partId == p.getPartId()) {
                break;
            }
        }
        session.close();
        return p;
    }

}
