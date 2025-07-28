<%@ page import="com.anii.dao.EventDAO, com.anii.model.Event" %>
<%
    String link = request.getParameter("link");
    EventDAO dao = new EventDAO();
    Event e = dao.getEventByLink(link);
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Register for Event</title>
  <link rel="stylesheet" href="css/attendee_register.css" />
</head>
<body>
  <div class="register-container">
    <h2>Register for: <%= e.getTitle() %></h2>
    <form action="RegisterAttendeeServlet" method="post">
      <input type="text" name="name" placeholder="Full Name" required />
      <input type="email" name="email" placeholder="Email" required />
      <input type="text" name="phone" placeholder="Phone" required />
      <input type="password" name="password" placeholder="Password" required />
      <input type="hidden" name="link" value="<%= link %>" />
      <input type="submit" value="Register" />
    </form>
  </div>
</body>
</html>
