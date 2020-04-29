<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<h1>Hello! Please add a new product</h1>
<form method="post" action="${pageContext.request.contextPath}/addProduct">

    <h3>Please input product name </h3>
    <p><input type="text" name="name"></p>

    <h3>Please input price </h3>
    <p><input type="number" name="price"></p>

    <button type="submitu">Apply</button>

    <p><a href="${pageContext.request.contextPath}">Back to the main page</a></p>

</form>
</body>
</html>
