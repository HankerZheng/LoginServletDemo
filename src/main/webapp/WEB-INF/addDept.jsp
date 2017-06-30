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
    <h1 align="center">Welcome, ${user.getUsername()}</h1>
    <h3 align="center">
        <a href="/logout">Logout</a>
    </h3>

    <c:if test="${deptError}">
        <p style="color:red">Invalid Input, Please Try Again!!</p>
    </c:if>

    <form method="post">
        <h4>Dept Name: </h4>
        <input type="text" name="dept_name" required="required"/>
        <h4>Dept Email: </h4>
        <input type="email" name="dept_email" required="required"/><br>
        <input type="submit"/>
        <a href="/home">cancel</a>
    </form>

    <h2 align="center">Department List</h2>
    <table style="width: 80%" align="center">
        <tr>
            <th align="center">deptId</th>
            <th align="center">deptName</th>
            <th align="center">deptEmail</th>
        </tr>
        <c:forEach var="dept" items="${applicationScope['deptList']}">
            <tr>
                <td align="center"><c:out value="${dept.getDeptId()}"/></td>
                <td align="center"><c:out value="${dept.getDeptName()}"/> </td>
                <td align="center"><c:out value="${dept.getDeptEmail()}"/> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
