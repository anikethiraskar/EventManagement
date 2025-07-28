package com.anii.controller;

import com.anii.dao.ContactDAO;
import com.anii.model.ContactUs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String service = req.getParameter("service");
        String message = req.getParameter("message");

        ContactUs contact = new ContactUs(name, email, phone, service, message);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(contact);
            tx.commit();
            session.close();
            res.sendRedirect("index.html?status=success");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            session.close();
            res.sendRedirect("index.html?status=error");
        }
    }
}
