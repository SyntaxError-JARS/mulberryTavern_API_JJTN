package com.revature.mulberry.customer;

import com.revature.mulberry.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.*;
import java.util.List;

public class CustomerDao {

    public Customer create(Customer newCustomer) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(newCustomer);
            transaction.commit();
            return newCustomer;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
    public Customer authenticateAdmin(String username, String password){

        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from Customer where username= :username and password= :password and is_admin= :is_admin");
            query.setParameter("username", username);
            query.setParameter("password", password);
            query.setParameter("is_admin", true);
            Customer admin = (Customer) query.uniqueResult();
            transaction.commit();
            return admin;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }
    public Customer authenticateCustomer(String username, String password){

        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from Customer where username= :username and password= :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            Customer customer = (Customer) query.uniqueResult();
            transaction.commit();
            return customer;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }

    }
}
