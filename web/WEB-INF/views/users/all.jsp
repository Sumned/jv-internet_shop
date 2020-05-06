<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <h1>All users page</h1>
    <table class="table table-sm" border="1">
        <tr class="table-active">
            <th>ID</th>
            <th>Name</th>
            <th>Role</th>
            <th>Delete</th>
        </tr>
        <jsp:useBean id="allUsers" scope="request" type="java.util.List"/>
        <c:forEach var="user" items="${allUsers}">
            <tr>
                <td>
                    <c:out value="${user.id}"/>
                </td>
                <td>
                    <c:out value="${user.login}"/>
                </td>
                <td>
                    <table border="1">
                        <tr>
                            <c:forEach var="role" items="${user.roles}">
                        <tr>
                            <td>
                                <c:out value="${role.roleName}"/>
                            </td>
                        </tr>
                        </c:forEach>
                        </tr>
                    </table>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/delete?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="${pageContext.request.contextPath}/">Back to the main page</a></p>
</div>
</body>
</html>
