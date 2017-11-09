package com.mycompany.carshop.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static Logger log = LoggerFactory.getLogger(PartDao.class);
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
        p = (Part) query.uniqueResult();
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

    /**
     * Inserts new part in database.
     * @param part
     */
    public void addNewPart(Part part) {
        //TODO: Check if all necessary fields are populated.

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.flush();
        Transaction t = session.beginTransaction();
        try {
            log.info("Step 4: saving part");
            session.save(part);
            log.info("Step 5: committing transaction");
            t.commit();
        } catch (HibernateException ex) {
            if (t != null) {
                t.rollback();
                log.error("Hibernate Exception while saving new Part");
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }
    }

    /**
     * Deletes part from database.
     * @param part
     */
    public void deletePart(Part part) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        session.delete(part);
        t.commit();
        session.close();
    }

    /**
     * Returns all parts manufactured by given manufacturer and which belong to a given car system.
     * @param carSystem
     * @param manufacturer
     * @return
     */
    public Part[] getPartsByCarSystemAndManufacturer(CarSystem carSystem, Manufacturer manufacturer) {
        Part p = new Part();
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select distinct p FROM Part p join p.system s join p.man m where s.systemId = :sysId and m.manId = :manId";
        Query query = session.createQuery(hql);
        query.setParameter("sysId", carSystem.getSystemId());
        query.setParameter("manId", manufacturer.getManId());

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
