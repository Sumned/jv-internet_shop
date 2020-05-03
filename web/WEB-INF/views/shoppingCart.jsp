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
                <button class="btn btn-danger btn-sm" onclick="window.location.href = '${pageContext.request.contextPath}/shoppingCart/delete?id=${product.id}';">Delete</button>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="${pageContext.request.contextPath}/shoppingCart/completeOrder" method="get">
    <button type="submit" class="btn btn-success">Complete Order</button>
</form>
<p><a href="${pageContext.request.contextPath}/">Back to the main page</a></p>
</div>
</body>
</html>
