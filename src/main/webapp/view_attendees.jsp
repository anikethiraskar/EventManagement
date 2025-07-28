<%@ page import="java.util.*, com.anii.model.Attendee" %>
<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
  <title>Event Attendees</title>
  <link rel="stylesheet" href="css/view_attendees.css" />
</head>
<body>
  <div class="container">
    <h2>Registered Attendees</h2>
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Email</th>
          <th>Phone</th>
        </tr>
      </thead>
      <tbody>
        <%
          List<Attendee> attendees = (List<Attendee>) request.getAttribute("attendees");
          for (Attendee a : attendees) {
        %>
          <tr>
            <td><%= a.getName() %></td>
            <td><%= a.getEmail() %></td>
            <td><%= a.getPhone() %></td>
          </tr>
        <%
          }
        %>
      </tbody>
    </table>

    <%
      int eventId = Integer.parseInt(request.getParameter("eventId"));
    %>
    <br/>
    <a href="GeneratePDFServlet?eventId=<%= eventId %>" class="download-button">Download PDF Badges</a>
    <br/><br/>
    <a href="dashboard.jsp">Back to Dashboard</a>
  </div>
</body>
</html>
