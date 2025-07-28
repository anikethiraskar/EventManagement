
package com.anii.controller;

import com.anii.dao.AttendeeDAO;
import com.anii.model.Attendee;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AttendeeLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Attendee a = new AttendeeDAO().login(email, password);
        if (a != null) {
            req.getSession().setAttribute("attendee", a);
            res.sendRedirect("attendee_dashboard.jsp");
        } else {
            res.sendRedirect("attendee_login.jsp?error=1");
        }
    }
}
