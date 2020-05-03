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
<h1>Hello! Please add a new product</h1>
<form method="post" action="${pageContext.request.contextPath}/addProduct">

    <h3>Please input product name </h3>
    <p><input type="text" name="name"></p>

    <h3>Please input price </h3>
    <p><input type="number" name="price"></p>

    <button type="submitu">Apply</button>

    <p><a href="${pageContext.request.contextPath}/">Back to the main page</a></p>

</form>
</body>
</html>
