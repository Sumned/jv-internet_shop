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
<h1>All orders page</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>User_id</th>
        <th>Product list</th>
        <th>Delete</th>
    </tr>
    <jsp:useBean id="allOrders" scope="request" type="java.util.List"/>
    <c:forEach var="orders" items="${allOrders}">
        <tr>
            <td>
                <c:out value="${orders.id}"/>
            </td>
            <td>
                <c:out value="${orders.getUserId()}"/>
            </td>
                <td>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                <tr>
                <c:forEach var="product" items="${orders.products}">
                    <tr>
                        <td>
                            <c:out value="${product.name}"/>
                        </td>
                        <td>
                            <c:out value="${product.price}"/>
                        </td>
                    </tr>
                </c:forEach>
                </tr>
                </table>
                </td>
            <td>
                <button class="btn btn-danger btn-sm" onclick="window.location.href = '${pageContext.request.contextPath}/orders/all/delete?id=${orders.getId()}';">Delete</button>
            </td>
        </tr>
    </c:forEach>
</table>
<p><a href="${pageContext.request.contextPath}/">Back to the main page</a></p>
</body>
</html>