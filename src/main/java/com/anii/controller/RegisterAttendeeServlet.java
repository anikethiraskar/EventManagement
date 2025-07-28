
package com.anii.controller;

import com.anii.dao.AttendeeDAO;
import com.anii.dao.EventDAO;
import com.anii.model.Attendee;
import com.anii.model.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterAttendeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String link = req.getParameter("link");

        Event event = new EventDAO().getEventByLink(link);
        Attendee a = new Attendee();
        a.setName(name);
        a.setEmail(email);
        a.setPhone(phone);
        a.setPassword(password);
        a.setEvent(event);

        new AttendeeDAO().saveAttendee(a);
        res.sendRedirect("attendee_login.jsp");
    }
}
