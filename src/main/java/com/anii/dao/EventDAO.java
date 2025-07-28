
package com.anii.dao;

import com.anii.model.Event;
import com.anii.util.HibernateUtil;
import org.hibernate.*;
import java.util.List;

public class EventDAO {
    public void saveEvent(Event e) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(e);
        tx.commit();
        s.close();
    }

    public List<Event> getAllEvents() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Event> list = s.createQuery("from Event").list();
        s.close();
        return list;
    }

    public Event getEventByLink(String link) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Event e = (Event) s.createQuery("from Event where registrationLink = :link")
                .setParameter("link", link).uniqueResult();
        s.close();
        return e;
    }

    public Event getEventById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Event e = (Event) s.get(Event.class, id);
        s.close();
        return e;
    }
}
