<%--
  Created by IntelliJ IDEA.
  User: mr_ra
  Date: 8/30/2023
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>
<h1>Welcome to our website!</h1>

<c:choose>
    <c:when test="${not empty name}">
        <p>Hello, ${name}! Welcome back.</p>
    </c:when>
    <c:otherwise>
        <p>Please enter your name:</p>
        <form action="welcome.jsp" method="post">
            <input type="text" name="name">
            <input type="submit" value="Submit">
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>

