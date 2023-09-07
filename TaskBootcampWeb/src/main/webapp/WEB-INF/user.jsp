<%--
  Created by IntelliJ IDEA.
  User: mr_ra
  Date: 9/5/2023
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
<h1>User Form</h1>
<form method="post" action="user">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required><br><br>

  <label for="surname">Surname:</label>
  <input type="text" id="surname" name="surname" required><br><br>

  <input type="submit" value="Submit">
</form>

<%
  if (request.getMethod().equalsIgnoreCase("POST")) {
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");

    // Alınan verileri işleyin veya veritabanına kaydedin
%>
<h2>Post Data:</h2>
<p>Name: <%= name %></p>
<p>Surname: <%= surname %></p>
<%
  }
%>
</body>
</html>
