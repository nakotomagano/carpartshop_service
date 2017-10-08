package com.mycompany.carshop.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mycompany.carshop.model.beans.Member;
import com.mycompany.carshop.utils.HibernateUtil;

/**
 * Repository class for dealing with DB informations related to members of webshop.
 * @author Veljko Matovic
 * Oct 8, 2017
 *
 */
public class MemberDao {

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

        List results = query.list();
        //TODO: Find better way to get single result!

        member = (Member) results.get(0);
        session.close();
        return member;
    }


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
}
