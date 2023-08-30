<%--
  Created by IntelliJ IDEA.
  User: mr_ra
  Date: 8/30/2023
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sum Calculator</title>
</head>
<body>
<form action="SumServlet" method="post">
    Number 1: <input type="text" name="num1"><br>
    Number 2: <input type="text" name="num2"><br>
    <input type="submit" value="Calculate Sum">
</form>

<c:if test="${not empty result}">
    <h2>Sum of ${num1} and ${num2} is: ${result}</h2>
</c:if>
</body>
</html>