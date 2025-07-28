package com.anii.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

import com.anii.dao.AttendeeDAO;
import com.anii.model.Attendee;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class GeneratePDFServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int eventId = Integer.parseInt(request.getParameter("eventId"));
        AttendeeDAO dao = new AttendeeDAO();
        List<Attendee> attendees = dao.getAttendeesByEventId(eventId);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"badges.pdf\"");

        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
            Font labelFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.DARK_GRAY);
            Font valueFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
            Font indexFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLUE);

            int index = 1;
            for (Attendee attendee : attendees) {
                // Create a table with 2 columns: Index | Badge Info
                PdfPTable badgeTable = new PdfPTable(2);
                badgeTable.setWidthPercentage(80);
                badgeTable.setWidths(new float[]{1, 5}); // Column ratios
                badgeTable.setSpacingBefore(20f);
                badgeTable.setSpacingAfter(20f);
                badgeTable.setHorizontalAlignment(Element.ALIGN_CENTER);

                // Index cell
                PdfPCell indexCell = new PdfPCell(new Phrase(String.valueOf(index), indexFont));
                indexCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                indexCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                indexCell.setPadding(10f);
                indexCell.setBackgroundColor(new BaseColor(200, 230, 255)); // Light blue
                indexCell.setBorderWidth(1.5f);
                badgeTable.addCell(indexCell);

                // Info cell
                PdfPCell infoCell = new PdfPCell();
                infoCell.setBorderColor(BaseColor.GRAY);
                infoCell.setPadding(15);
                infoCell.setBackgroundColor(new BaseColor(240, 240, 255)); // Light lavender
                infoCell.setBorderWidth(1.5f);

                Paragraph p = new Paragraph("EVENT BADGE", titleFont);
                p.setAlignment(Element.ALIGN_CENTER);
                p.setSpacingAfter(10f);
                infoCell.addElement(p);

                infoCell.addElement(new Paragraph("Name: " + attendee.getName(), valueFont));
                infoCell.addElement(new Paragraph("Email: " + attendee.getEmail(), labelFont));
                infoCell.addElement(new Paragraph("Phone: " + attendee.getPhone(), labelFont));
                infoCell.addElement(new Paragraph("Event: " + attendee.getEvent().getTitle(), labelFont));

                badgeTable.addCell(infoCell);
                document.add(badgeTable);

                index++; // Increment serial number
            }

            document.close();
            writer.close();

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
