<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Event Created</title>
  <link rel="stylesheet" href="css/eventcreated.css" />
</head>
<body>
  <div class="container">
    <h2>✅ Event Created Successfully!</h2>
    <p>Your event registration link:</p>
    <a class="link" href="attendee_register.jsp?link=<%= request.getAttribute("link") %>">
      <%= request.getAttribute("link") %>
    </a>
    <br />
    <a class="btn" href="dashboard.jsp">Back to Dashboard</a>
  </div>
</body>
</html>
