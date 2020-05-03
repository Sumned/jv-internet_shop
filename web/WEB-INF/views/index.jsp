<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcome</title>
  </head>
  <body>
  <h1>Welcome to the shop</h1>
  <p><a href="${pageContext.request.contextPath}/injectData">Inject test data</a></p>
  <p><a href="${pageContext.request.contextPath}/users/all">All users list</a></p>
  <p><a href="${pageContext.request.contextPath}/products/all">All products list</a></p>
  <p><a href="${pageContext.request.contextPath}/addProduct">Add a new products</a></p>
  <p><a href="${pageContext.request.contextPath}/shoppingCart">Shopping cart</a></p>
  <p><a href="${pageContext.request.contextPath}/orders/all">All orders</a></p>
  </body>
</html>
