
package com.anii.dao;

import com.anii.model.Attendee;
import com.anii.model.Event;
import com.anii.util.HibernateUtil;
import org.hibernate.*;

import java.util.List;

public class AttendeeDAO {
    public void saveAttendee(Attendee a) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(a);
        tx.commit();
        s.close();
    }

    public Attendee login(String email, String password) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Attendee a = (Attendee) s.createQuery("from Attendee where email = :email and password = :password")
                .setParameter("email", email).setParameter("password", password).uniqueResult();
        s.close();
        return a;
    }

    public List<Attendee> getAttendeesByEvent(Event event) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Attendee> list = s.createQuery("from Attendee where event = :e")
                .setParameter("e", event).list();
        s.close();
        return list;
    }
    public List<Attendee> getAttendeesByEventId(int eventId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Attendee> list = session.createQuery("FROM Attendee WHERE event.id = :eventId")
                                     .setParameter("eventId", eventId)
                                     .list();
        session.close();
        return list;
    }

}
