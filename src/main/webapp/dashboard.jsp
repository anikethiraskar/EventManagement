<%@ page import="java.util.*, com.anii.model.Event" %>
<%@ page session="true" %>
<%@ page contentType="text/html" %>
<jsp:useBean id="dao" class="com.anii.dao.EventDAO" />
<!DOCTYPE html>
<html>
<head>
  <title>Admin Dashboard</title>
  <link rel="stylesheet" href="css/dashboard.css" />
</head>
<body>
  <div class="dashboard-container">
    <h1>Welcome, Admin!</h1>
    <div class="top-actions">
      <a href="create_event.jsp" class="create-button">+ Create New Event</a>
    </div>
    <div style="display: flex; justify-content: right;">
        <button type="button" style="
          background: linear-gradient(to right, #6366f1, #10b981);
          color: white;
          font-weight: bold;
          border: none;
          padding: 12px;
          width: 10rem;
          border-radius: 8px;
          cursor: pointer;
          font-size: 1rem;
          transition: background 0.3s ease;"
          onclick="window.location.href='index.html'">
          Back to Home
        </button>
      </div>

    <h2>All Events</h2>
    <table class="event-table">
      <thead>
        <tr>
          <th>Title</th>
          <th>Type</th>
          <th>Date</th>
          <th>Venue</th>
          <th>Registration Link</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <%
          List<Event> list = dao.getAllEvents();
          for(Event e : list) {
        %>
          <tr>
            <td><%= e.getTitle() %></td>
            <td><%= e.getType() %></td>
            <td><%= e.getDate() %></td>
            <td><%= e.getVenue() %></td>
            <td>
              <a href="attendee_register.jsp?link=<%= e.getRegistrationLink() %>" target="_blank">
                Open Link
              </a>
            </td>
            <td>
              <a href="ViewAttendeesServlet?eventId=<%= e.getId() %>">View Attendees</a> |
              <a href="ExportCSVServlet?eventId=<%= e.getId() %>">Export CSV</a> |
              <a href="GeneratePDFServlet?eventId=<%= e.getId() %>">PDF Badges</a>
            </td>
          </tr>
        <%
          }
        %>
      </tbody>
    </table>
  </div>
</body>
</html>
