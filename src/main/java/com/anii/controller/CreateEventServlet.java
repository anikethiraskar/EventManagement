
package com.anii.controller;

import com.anii.dao.EventDAO;
import com.anii.model.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

public class CreateEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Event e = new Event();
        e.setTitle(req.getParameter("title"));
        e.setType(req.getParameter("type"));
        e.setDate(req.getParameter("date"));
        e.setVenue(req.getParameter("venue"));
        e.setDescription(req.getParameter("description"));
        e.setRegistrationLink(UUID.randomUUID().toString());

        new EventDAO().saveEvent(e);

        req.setAttribute("link", e.getRegistrationLink());
        req.getRequestDispatcher("event_created.jsp").forward(req, res);
    }
}
