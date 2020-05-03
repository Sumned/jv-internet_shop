<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Hello! Please provide your user details</h1>
<h4 style="color:red">${message}</h4>
<form method="post" action="${pageContext.request.contextPath}/registration">

    <h3>Please provide your login </h3>
    <p><input type="text" name="login"></p>

    <h3>Please provide your password </h3>
    <p><input type="password" name="password"></p>

    <h3>Please repeat your password </h3>
    <p><input type="password" name="passwordRepeat"></p>

            <button type="submit">Register</button>

    <p><a href="${pageContext.request.contextPath}/login">Back to the login page</a></p>


</form>
</body>
</html>
