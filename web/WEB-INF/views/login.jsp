<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login page</h1>
<h4 style="color:red">${errorMsg}</h4>
<form action="${pageContext.request.contextPath}/login" method="post">
    <h3>Please provide your login </h3>
    <p><label>
        <input type="text" name="login">
    </label></p>
    <h3>Please provide your password </h3>
    <p><label>
        <input type="password" name="password">
    </label></p>
    <button type="submit">Login</button>
</form>
<h2> Haven't account yet?</h2>
<p><a href="${pageContext.request.contextPath}/registration">Registration page</a></p>
</body>
</html>
