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
    <table class="table table-sm" border="1">
        <caption>All products list</caption>
        <tr class="table-active">
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <jsp:useBean id="allProducts" scope="request" type="java.util.List"/>
        <c:forEach var="product" items="${allProducts}">
            <tr>
                <td align="center" width="20">
                    <c:out value="${product.id}"/>
                </td>
                <td align="center" width="250">
                    <c:out value="${product.name}"/>
                </td>
                <td align="center" width="250">
                    <c:out value="${product.price}"/>
                </td>
                <td align="center" width="50">
                    <button class="btn btn-success btn-sm" onclick="window.location.href = '${pageContext.request.contextPath}/shopping_cart/add?id=${product.getId()}';">Add to shopping cart</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="${pageContext.request.contextPath}"></a></p>
    <p><a href="${pageContext.request.contextPath}/">Back to the main page</a></p>
    </div>
</body>
</html>
