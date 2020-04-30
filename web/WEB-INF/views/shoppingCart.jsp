<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h1>Shopping Cart page</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Delete</th>
    </tr>
    <jsp:useBean id="Products" scope="request" type="java.util.List"/>
    <c:forEach var="product" items="${Products}">
        <tr>
            <td>
                <c:out value="${product.id}"/>
            </td>
            <td>
                <c:out value="${product.name}"/>
            </td>
            <td>
                <c:out value="${product.price}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/shoppingCart/delete?id=${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="${pageContext.request.contextPath}/shoppingCart/completeOrder" method="get">
    <button type="submit">Complete Order</button>
</form>
<p><a href="${pageContext.request.contextPath}">Back to the main page</a></p>
</body>
</html>
