package com.techdata.carshop.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.techdata.carshop.model.beans.CarSystem;
import com.techdata.carshop.utils.HibernateUtil;
/**
 * Repository class for dealing with DB informations related to CarSystem.
 * @author 806558
 *
 */
public class CarSystemDAO {

    /**
     * Gets the CarSystem from DB based on given parameter - ID of the system.
     * @param systemId - id of the Car System required.
     * @return CarSystem
     */
    public final CarSystem getSystem(final int systemId) {
        CarSystem sys = new CarSystem();
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("from CarSystem");
        List<Integer> list = q.list();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            sys = (CarSystem) iterator.next();
            if (systemId == sys.getSystemId()) {
                break;
            }
        }
        session.close();
        return sys;
    }
}

