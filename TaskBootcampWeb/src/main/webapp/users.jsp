<%--
  Created by IntelliJ IDEA.
  User: mr_ra
  Date: 8/30/2023
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>List Example</title>
</head>
<body>
<h1>List Example using JSTL and Jakarta Servlet</h1>

<c:set var="items" value="${['Item 1', 'Item 2', 'Item 3', 'Item 4']}" />

<ul>
  <c:forEach items="${items}" var="item">
    <li>${item}</li>
  </c:forEach>
</ul>
</body>
</html>
