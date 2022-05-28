package com.revature.mulberry.menu;

import com.revature.mulberry.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.List;

public class MenuDao {

    public List<Menu> findAll() {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            List<Menu> items = session.createQuery("FROM Menu").list();
            transaction.commit();
            return items;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
