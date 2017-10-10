package com.mycompany.carshop.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.carshop.model.beans.Deal;
import com.mycompany.carshop.model.beans.Member;
import com.mycompany.carshop.model.beans.Part;
import com.mycompany.carshop.utils.HibernateUtil;
/**
 * Repository class for dealing with DB informations related to concluded deals/purchases.
 * @author Veljko Matovic
 * Oct 9, 2017
 *
 */
public class DealDao {
    private static Logger log = LoggerFactory.getLogger(DealDao.class);

    /**
     * Gets the Deal from DB based on given parameter - ID of the deal.
     * @param dealId - id of wanted deal.
     * @return
     */
    public Deal getDealById(int dealId) {
        Deal deal = new Deal();

        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Deal d WHERE dealId = :dealId";
        Query query = session.createQuery(hql);
        query.setParameter("dealId", dealId);
        deal = (Deal) query.uniqueResult();
        session.close();
        return deal;
    }

    /**
     * Get all deals for one specified member.
     * @param member - member whose deals we need.
     * @return
     */
    public Deal[] getDealsByMember(Member member) {
        Deal deal = new Deal();
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "select distinct d FROM Deal d join d.member m where m.memberId = :memberId";
        Query query = session.createQuery(hql);
        query.setParameter("memberId", member.getMemberId());

        List results = query.list();
        int dealNumber = results.size();
        Deal[] allDealsFromMember = new Deal[dealNumber];
        for (int i = 0; i < dealNumber; i++) {
            deal = (Deal) results.get(i);
            allDealsFromMember[i] = deal;
        }

        return allDealsFromMember;
    }

    public void addNewDeal (Deal deal) {
      //TODO: Check if all necessary fields are populated.

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.flush();
        Transaction t = session.beginTransaction();
        try {
            log.info("Step 4: saving deal");
            session.save(deal);
            log.info("Step 5: committing transaction");
            t.commit();
        } catch (HibernateException ex) {
            if (t != null) {
                t.rollback();
                log.error("Hibernate Exception while saving new Deal");
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }
    }
}
