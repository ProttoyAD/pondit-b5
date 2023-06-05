<%--
  Created by IntelliJ IDEA.
  User: YOGA
  Date: 5/30/2023
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>${errorMessage}</div>
<form:form method="post" action="${pageContext.request.contextPath}/user/register" modelAttribute="user">
    <form:input type="text" path="username" placeholder="Username"/>
    <form:input type="text" path="email" placeholder="Email"/>
    <form:input type="password" path="password" placeholder="Password"/>
    <form:input type="password" path="rePassword" placeholder="Re enter Password"/>
    <input type="submit" value="Register">
</form:form>
</body>
</html>
