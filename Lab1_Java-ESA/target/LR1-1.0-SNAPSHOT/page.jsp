<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 25.11.2020
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SCII-Aliens</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Is alive</td>
        <td>Race</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${aliensList}" var="alien">
        <tr>
            <td>${alien.id}</td>
            <td>${alien.fullName}</td>
            <td>${alien.alive}</td>
            <td>${alien.race.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
