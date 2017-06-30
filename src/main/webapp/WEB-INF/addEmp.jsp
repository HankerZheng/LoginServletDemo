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
    <h1 align="center">Welcome, ${user.getUsername()}</h1>
    <h3 align="center">
        <a href="/logout">Logout</a>
    </h3>

    <c:if test="${empError}">
        <p style="color:red">Invalid Input, Please Try Again!!</p>
    </c:if>

    <form method="post">
        <h4>First Name: </h4>
        <input type="text" name="first_name" required="required"/>
        <h4>Last Name: </h4>
        <input type="text" name="last_name" required="required"/>
        <h4>Emp Age: </h4>
        <input type="number" name="age" required="required"/>
        <h4>Dept ID: </h4>
        <select name="dept_id">
            <option value="default" disabled selected>select a department</option>
            <c:forEach var="dept" items="${applicationScope['deptList']}">
                <option value="${dept.getDeptId()}">${dept.getDeptName()}</option>
            </c:forEach>
        </select> <br/>
        <input type="submit"/>
        <a href="/home">cancel</a>
    </form>

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

</body>
</html>
