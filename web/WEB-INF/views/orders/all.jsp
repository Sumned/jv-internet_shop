<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All orders</title>
</head>
<body>
<h1>All orders page</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>User</th>
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
                <c:out value="${orders.user.name}"/>
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
                <a href="${pageContext.request.contextPath}/orders/all/delete?id=${orders.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p><a href="${pageContext.request.contextPath}">Back to the main page</a></p>
</body>
</html>