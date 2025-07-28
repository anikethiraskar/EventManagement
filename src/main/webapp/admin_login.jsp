<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Login</title>
  <link rel="stylesheet" href="css/index.css" />
  <link rel="stylesheet" href="css/adminlogin.css" />
</head>
<body>
  <%-- <%@ include file="Component/navbar.jsp" %> --%> 

  <div class="main-content">
    <div class="login-container">
      <h2>Admin Login</h2>
      <form name="loginForm" action="./AdminLoginServlet" method="post" onsubmit="return validateForm();">
        <input type="text" name="email" placeholder="Email" required />
        <input type="password" name="password" placeholder="Password" required />
        <input type="submit" value="Login" />
        <div style="display: flex; justify-content: center;">
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
      </form>
      <div class="error-message">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
      </div>
    </div>
  </div>

  <%-- <%@ include file="Component/footer.jsp" %> --%>
</body>
</html>
