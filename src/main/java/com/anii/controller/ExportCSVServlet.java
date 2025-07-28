package com.anii.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.anii.dao.AttendeeDAO;
import com.anii.model.Attendee;

@WebServlet("/ExportCSVServlet")
public class ExportCSVServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Step 1: Get eventId from request
        String eventIdParam = request.getParameter("eventId");

        if (eventIdParam == null || eventIdParam.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing event ID");
            return;
        }

        int eventId;
        try {
            eventId = Integer.parseInt(eventIdParam);
        } catch (NumberFormatException ex) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid event ID format");
            return;
        }

        // Step 2: Get attendees from DAO
        AttendeeDAO dao = new AttendeeDAO();
        List<Attendee> attendees = dao.getAttendeesByEventId(eventId);

        // Step 3: Set response headers for CSV
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"attendees_event_" + eventId + ".csv\"");

        // Step 4: Write CSV content
        PrintWriter writer = response.getWriter();
        writer.println("ID,Name,Email,Phone");

        for (Attendee a : attendees) {
            String name = a.getName() != null ? a.getName().replace(",", " ") : "";
            String email = a.getEmail() != null ? a.getEmail() : "";
            String phone = a.getPhone() != null ? a.getPhone() : "";
            writer.printf("%d,%s,%s,%s%n", a.getId(), name, email, phone);
        }

        writer.flush();
        writer.close();
    }
}
