package com.mycompany.carshop.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.carshop.model.beans.Member;
import com.mycompany.carshop.utils.HibernateUtil;

/**
 * Repository class for dealing with DB informations related to members of webshop.
 * @author Veljko Matovic
 * Oct 8, 2017
 *
 */
public class MemberDao {
    private static Logger log = LoggerFactory.getLogger(MemberDao.class);

    /**
     * Gets the Member from DB based on given parameter - ID of the member.
     * @param id
     * @return
     */
    public Member getMemberById(int id) {
        Member member = new Member();
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Member m WHERE memberId = :memberId";
        Query query = session.createQuery(hql);
        query.setParameter("memberId", id);
        member = (Member) query.uniqueResult();
        session.close();
        return member;
    }


    /**
     * Returns array of all members form database.
     * @return
     */
    public Member[] getAllMembers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Member");
        List memberList = q.list();
        int numberOfMembers = memberList.size();
        Member[] allMembers = new Member[numberOfMembers];
        for (int i = 0; i < numberOfMembers; i++) {
            allMembers[i] = (Member) memberList.get(i);
        }
        session.close();
        return allMembers;
    }

    /**
     * Returns member object with all information about member with given proper email and address.
     * Used for login.
     * @param email
     * @param password
     * @return
     */
    public Member getMemberByEmailAndPassword(String email, String password) {
        Member member = new Member();
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Member m WHERE email = :email and password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        query.setMaxResults(1);
        List result = query.list();
        if (result.size() > 0) {
            member = (Member) query.uniqueResult();
            session.close();
            return member;
        } else {
            session.close();
            log.error("Wrong credentials");
            throw new NullPointerException("Member does not exist");
        }
    }

}
