<%--
  Created by IntelliJ IDEA.
  User: YOGA
  Date: 4/6/2023
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello from the other side</h1>

<c:if test="${user != null}">
    <p>Name: ${user.name}</p>
    <p>Email: ${user.email}</p>
</c:if>
</body>
</html>
