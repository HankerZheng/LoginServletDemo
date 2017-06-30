<%--
  Created by IntelliJ IDEA.
  User: hanzheng
  Date: 6/24/17
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <title>Please log in...</title>
</head>
<body>
<c:if test="${invalidUser}"><p style="color: red">Incorrect User Name or Password</p></c:if>
<form method="post">
    <h1>Username: </h1>
    <input type="text" name="username" required="required"/>
    <h1>Password: </h1>
    <input type="password" name="password" required="required"/><br>
    <input type="submit"/>
    <input type="reset" />
</form>
</body>
</html>