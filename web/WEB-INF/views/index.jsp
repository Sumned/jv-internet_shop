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
    <p><a href="${pageContext.request.contextPath}/inject_data">Inject test data</a></p>
    <p><a href="${pageContext.request.contextPath}/users/all">All users list</a></p>
    <p><a href="${pageContext.request.contextPath}/products/all">All products list</a></p>
    <p><a href="${pageContext.request.contextPath}/products/all_to_admin">All products list for admin only</a></p>
    <p><a href="${pageContext.request.contextPath}/products/add">Add a new products</a></p>
    <p><a href="${pageContext.request.contextPath}/shopping_cart">Shopping cart</a></p>
    <p><a href="${pageContext.request.contextPath}/orders/all">All orders for admin only</a></p>
    <p><a href="${pageContext.request.contextPath}/orders/user_all">All user orders</a></p>
    <p><a href="${pageContext.request.contextPath}/logout">Exit</a></p>
  </div>
  </body>
</html>
