<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
</head>
<body>
<h1>All products page</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <jsp:useBean id="allProducts" scope="request" type="java.util.List"/>
    <c:forEach var="product" items="${allProducts}">
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
                <a href="${pageContext.request.contextPath}/product/add?id=${product.getId()}">Add to shopping cart</a>
            </td>
        </tr>
    </c:forEach>
    <p><a href="${pageContext.request.contextPath}">Back to the main page</a></p>
</table>
</body>
</html>
