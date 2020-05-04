<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h3>Hello! Please provide your user details</h3>
    <h4 style="color:red">${message}</h4>
    <form role="form" action="${pageContext.request.contextPath}/registration" method="post">
        <div class="form-group">
            <label for="login">Login</label>
            <input type="text"  name="login" class="form-control" id="login" placeholder="Please provide your login">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Please provide your password">
        </div>
        <div class="form-group">
            <label for="passwordRepeat">Password</label>
            <input type="password" name="passwordRepeat" class="form-control" id="passwordRepeat" placeholder="Please repeat your password">
        </div>
        <button type="submit" class="btn btn-success">Registration</button>
    </form>
    <p><a href="${pageContext.request.contextPath}/login">Back to the login page</a></p>
</div>
</body>
</html>
