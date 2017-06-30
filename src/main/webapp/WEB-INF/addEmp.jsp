<%--
  Created by IntelliJ IDEA.
  User: hanzheng
  Date: 6/26/17
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employees, ${user.getUsername()}</title>
</head>
<body>
<c:if test="${empError}">
    <p style="color:red">Invalid Input, Please Try Again!!</p>
</c:if>
<form method="post">
    <h1>Emp ID: </h1>
    <input type="number" name="emp_id" required="required"/>
    <h1>First Name: </h1>
    <input type="text" name="first_name" required="required"/>
    <h1>Last Name: </h1>
    <input type="text" name="last_name" required="required"/>
    <h1>Emp Age: </h1>
    <input type="number" name="age" required="required"/>
    <h1>Dept ID: </h1>
    <select name="dept_id">
        <option value="default" disabled selected>select a department</option>
        <c:forEach var="dept" items="${applicationScope['deptList']}">
            <option value="${dept.getDeptId()}">${dept.getDeptName()}</option>
        </c:forEach>
    </select>
    <input type="submit"/>
</form>
<a href="/home">cancel</a>
</body>
</html>
