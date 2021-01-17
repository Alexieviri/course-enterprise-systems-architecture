<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" %>
<html>
<head>
    <title>Races</title>
</head>
<body>

<h3>Race list</h3>
<c:if test="${!empty races}">
    <table>
        <tr>
            <th>ID</th>
            <th>Race Name</th>
        </tr>
        <c:forEach items="${races}" var="race">
            <tr>
                <td>${race.id}</td>
                <td>${race.name}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>