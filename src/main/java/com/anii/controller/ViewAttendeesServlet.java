package com.anii.controller;

import com.anii.dao.AttendeeDAO;
import com.anii.model.Attendee;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class ViewAttendeesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        AttendeeDAO dao = new AttendeeDAO();
        List<Attendee> attendees = dao.getAttendeesByEventId(eventId);

        request.setAttribute("attendees", attendees);
        request.getRequestDispatcher("view_attendees.jsp").forward(request, response);
    }
}
