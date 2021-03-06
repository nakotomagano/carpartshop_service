package com.mycompany.carshop.repository;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.carshop.model.beans.CarSystem;
import com.mycompany.carshop.model.beans.Part;
import com.mycompany.carshop.utils.HibernateUtil;

/**
 * Repository class for dealing with DB informations related to CarSystem.
 * 
 * @author 806558
 *
 */
public class CarSystemDAO {
	private static Logger log = LoggerFactory.getLogger(CarSystemDAO.class);

	/**
	 * Gets the CarSystem from DB based on given parameter - ID of the system.
	 * 
	 * @param systemId
	 *            - id of the Car System required.
	 * @return CarSystem
	 */
	public final CarSystem getSystemById(final int systemId) {
		// TODO: do not iterate all results to get one item. Look at PartDao.
		CarSystem sys = new CarSystem();
		Session session = HibernateUtil.getSessionFactory().openSession();

		// TODO: replace query to return single result
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

	/**
	 * Return array of all car systems from database.
	 * 
	 * @return
	 */
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

	/**
	 * Inserts new car system into db.
	 * 
	 * @param carSystem
	 * @throws Exception
	 */
	public void addNewSystem(CarSystem carSystem) throws Exception {
		// TODO :check if all conditions are met before placing new system, eg. check if
		// user has admin rights?

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.flush();
		Transaction t = session.beginTransaction();

		try {
			log.info("Saving carsystem to db");
			session.save(carSystem);
			log.info("Committing transaction");
			t.commit();
		} catch (HibernateException ex) {
			if (t != null) {
				t.rollback();
				log.error("Hibernate Exception while saving new transaction");
				ex.printStackTrace();
			}
		} finally {
			log.info("Closing session");
			session.close();
		}
	}

	/**
	 * Deleting carsystem from database.
	 * 
	 * @param carsystem
	 */
	public void deleteSystem(Integer id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		try {
			log.info("Deleting carsystem from db");

			Object persistentInstance = session.get(CarSystem.class, id);

			if (persistentInstance != null) {
				session.delete(persistentInstance);
				System.out.println("CarSystem was removed, id=" + id);
			}
			/*
			 * Query q =
			 * session.createQuery("delete CarSystem where systemId = :idCarSystem ");
			 * q.setParameter("idCarSystem", id); int result= q.executeUpdate();
			 * 
			 * if (result > 0) { System.out.println("CarSystem was removed, id=" +id); }
			 */
			log.info("Committing transaction");
		} catch (HibernateException ex) {
			if (t != null) {
				t.commit();
				log.error("Hibernate Exception while deleting transaction");
				ex.printStackTrace();
			}
		} finally {
			log.info("Closing session");
			session.close();
		}
	}
}
