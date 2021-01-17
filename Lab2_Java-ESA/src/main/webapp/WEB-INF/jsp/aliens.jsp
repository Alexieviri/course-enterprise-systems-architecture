<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" %>
<html>
<head>
    <title>Aliens</title>
</head>
<body>

<h3>Alien list</h3>
<c:if test="${!empty aliens}">
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Alive</th>
            <th>Race</th>
        </tr>
        <c:forEach items="${aliens}" var="alien">
            <tr>
                <td>${alien.id}</td>
                <td>${alien.fullName}</td>
                <td>${alien.alive}</td>
                <td>${alien.race.name}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>