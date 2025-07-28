<!DOCTYPE html>
<html>
<head>
  <title>Create Event</title>
  <link rel="stylesheet" href="css/createevent.css" />
</head>
<body>
  <div class="form-container">
    <h2>Create New Event</h2>
    <form action="CreateEventServlet" method="post">
      <label for="title">Title</label>
      <input type="text" name="title" id="title" required />

      <label for="type">Type</label>
      <input type="text" name="type" id="type" required />

      <label for="date">Date</label>
      <input type="date" name="date" id="date" required />

      <label for="venue">Venue</label>
      <input type="text" name="venue" id="venue" required />

      <label for="description">Description</label>
      <textarea name="description" id="description" rows="4"></textarea>

      <input type="submit" value="Create Event" />
    </form>
  </div>
</body>
</html>
