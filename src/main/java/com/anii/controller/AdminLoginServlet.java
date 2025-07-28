
package com.anii.controller;

import com.anii.dao.UserDAO;
import com.anii.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserDAO dao = new UserDAO();
        User user = dao.login(email, password);

        if (user != null) {
            req.getSession().setAttribute("admin", user);
            res.sendRedirect("dashboard.jsp");
        } else {
            req.setAttribute("error", "Invalid Credentials");
            req.getRequestDispatcher("admin_login.jsp").forward(req, res);
        }
    }
}
