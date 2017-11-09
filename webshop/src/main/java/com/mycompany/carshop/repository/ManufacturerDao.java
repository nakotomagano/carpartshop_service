package com.mycompany.carshop.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.carshop.model.beans.Manufacturer;
import com.mycompany.carshop.utils.HibernateUtil;

public class ManufacturerDao {
    private static Logger log = LoggerFactory.getLogger(ManufacturerDao.class);


    public Manufacturer[] getAllManufacturers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Manufacturer");
        List manufacturerList = q.list();
        int manufacturerNumber = manufacturerList.size();
        Manufacturer[] allManufacturers = new Manufacturer[manufacturerNumber];
        for (int i = 0; i < manufacturerNumber; i++) {
            allManufacturers[i] = (Manufacturer) manufacturerList.get(i);
        }
        session.close();
        return allManufacturers;
    }
}