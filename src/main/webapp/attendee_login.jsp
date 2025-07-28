<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Attendee Login</title>
  <link rel="stylesheet" href="css/attendee_login.css" />
</head>
<body>
  <div class="login-container">
    <h2>Attendee Login</h2>
    <form action="AttendeeLoginServlet" method="post">
      <input type="email" name="email" placeholder="Email" required />
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
  </div>
</body>
</html>
