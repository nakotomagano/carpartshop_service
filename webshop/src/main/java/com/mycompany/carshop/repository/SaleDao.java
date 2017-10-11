package com.mycompany.carshop.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.carshop.model.beans.Member;
import com.mycompany.carshop.model.beans.Sale;
import com.mycompany.carshop.utils.HibernateUtil;

public class SaleDao {
    private static Logger log = LoggerFactory.getLogger(SaleDao.class);
    /**
     * Gets the sale from DB based on given parameter - ID of the sale.
     * @param saleId
     * @return
     */
    public Sale getSaleById(int saleId) {
        Sale sale = new Sale();
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Sale s WHERE saleId = :saleId";
        Query query = session.createQuery(hql);
        query.setParameter("saleId", saleId);
        sale = (Sale) query.uniqueResult();
        return sale;
    }


    /**
     * Get all sales for one specified member.
     * @param member
     * @return
     */
    public Sale[] getSalesByMember(Member member) {
        Sale sale = new Sale();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.clear();
        String hql = "select distinct s FROM Sale s join s.member m where m.memberId = :memberId";
        Query query = session.createQuery(hql);
        query.setParameter("memberId", member.getMemberId());

        List results = query.list();
        int saleNumber = results.size();
        Sale[] allSalesFromMember = new Sale[saleNumber];
        for (int i = 0; i < saleNumber; i++) {
            sale = (Sale) results.get(i);
            allSalesFromMember[i] = sale;
        }

        return allSalesFromMember;
    }

    /**
     * Stores new sale in DB.
     * @param sale
     */
    public void addNewSale(Sale sale) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.flush();
        Transaction t = session.beginTransaction();
        try {
            log.info("Step 4: saving sale");
            session.save(sale);
            log.info("Step 5: committing transaction");
            t.commit();
        } catch (HibernateException ex) {
            if (t != null) {
                t.rollback();
                log.error("Hibernate Exception while saving new Sale");
                ex.printStackTrace();
            }
        } finally {
            session.close();
        }
    }

}
