package com.mycompany.carshop.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.utils.HibernateUtil;
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
    public final CarSystem getSystemById(final int systemId) {
        //TODO: do not iterate all results to get one item. Look at PartDao.
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

    public CarSystem[] getAllSystems() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from CarSystem");
        List carSystemList = q.list();
        int carSystemNumber = carSystemList.size();
        CarSystem[] allCarSystems = new CarSystem[carSystemNumber];
        for (int i = 0; i < carSystemNumber; i++) {
            allCarSystems[i] = (CarSystem) carSystemList.get(i);
        }
        session.close();
        return allCarSystems;
    }
}

