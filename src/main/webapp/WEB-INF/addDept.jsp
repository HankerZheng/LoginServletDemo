<%--
  Created by IntelliJ IDEA.
  User: hanzheng
  Date: 6/26/17
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Departments, ${user.getUsername()}</title>
</head>
<body>
<c:if test="${deptError}">
    <p style="color:red">Invalid Input, Please Try Again!!</p>
</c:if>
<form method="post">
    <h1>Dept ID: </h1>
    <input type="text" name="dept_id" required="required"/>
    <h1>Dept Name: </h1>
    <input type="text" name="dept_name" required="required"/>
    <h1>Dept Email: </h1>
    <input type="email" name="dept_email" required="required"/><br>
    <input type="submit"/>
</form>
<a href="/home">cancel</a>
</body>
</html>
