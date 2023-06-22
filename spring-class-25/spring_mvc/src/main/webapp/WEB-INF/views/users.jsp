<%--
  Created by IntelliJ IDEA.
  User: rakib
  Date: 5/28/2023
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Show All Users</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
        <c:forEach var="user" items="${users}" >
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
    </tr>
        </c:forEach>
</table>
</body>
</html>
