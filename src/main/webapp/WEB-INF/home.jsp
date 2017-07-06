<%@ page import="net.antra.hanz.util.User" %><%--
  Created by IntelliJ IDEA.
  User: hanzheng
  Date: 6/24/17
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome, ${user.getUsername()}</title>
</head>
<body>
    <h1 align="center">Welcome, ${user.getUsername()}</h1>
    <h3 align="center">
        <a href="/logout">Logout</a>
    </h3>
    <h3 align="center">
        <a href="/addemp"><h3>Add Employees</h3></a>
    </h3>
    <h3 align="center">
        <a href="/adddept"><h3>Add Department</h3></a>
    </h3>
    <h2 align="center">Employee List</h2>
    <table style="width:80%" align="center">
        <tr>
            <th align="center">empId</th>
            <th align="center">firstName</th>
            <th align="center">lastName</th>
            <th align="center">age</th>
            <th align="center">deptId</th>
        </tr>
        <c:forEach var="emp" items="${applicationScope['empList']}">
            <tr>
                <td align="center"><c:out value="${emp.getEmpId()}"/></td>
                <td align="center"><c:out value="${emp.getFirstName()}"/> </td>
                <td align="center"><c:out value="${emp.getLastName()}"/> </td>
                <td align="center"><c:out value="${emp.getAge()}"/> </td>
                <td align="center"><c:out value="${emp.getDeptId()}"/> </td>
            </tr>
        </c:forEach>
    </table>

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
