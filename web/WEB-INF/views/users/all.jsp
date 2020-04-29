<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<h1>All users page</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Delete</th>
    </tr>
    <jsp:useBean id="allUsers" scope="request" type="java.util.List"/>
    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td>
                <c:out value="${user.id}"/>
            </td>
            <td>
                <c:out value="${user.name}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/user/delete?id=${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <p><a href="${pageContext.request.contextPath}">Back to the main page</a></p>
</table>
</body>
</html>
