<%@ page import="com.anii.model.Attendee" %>
<%@ page session="true" %>
<%
    Attendee att = (Attendee) session.getAttribute("attendee");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Attendee Dashboard</title>
  <link rel="stylesheet" href="css/attendee_dashboard.css" />
</head>
<body>
  <div class="dashboard-container">
    <h2>Welcome, <%= att.getName() %> </h2>
    <div class="event-details">
      <h3>You are registered for: <span><%= att.getEvent().getTitle() %></span></h3>
      <p><strong>Venue:</strong> <%= att.getEvent().getVenue() %></p>
      <p><strong>Date:</strong> <%= att.getEvent().getDate() %></p>
      <a href="index.html" class="btn-filled">Start Planning</a>
    </div>
  </div>
</body>
</html>
