package com.anii.dao;

import com.anii.model.ContactUs;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class ContactDAO {
    private SessionFactory factory;

    public ContactDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public boolean save(ContactUs contact) {
        Session session = null;
        Transaction tx = null;
        boolean success = false;

        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(contact);
            tx.commit();
            success = true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close(); // ✅ Close manually
        }

        return success;
    }
}
