<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    <body>
        <h1>Login</h1>
         <form method="POST" action="home">
            <label>Username:</label>
            <input type="text" name="username" value="${user.username}">
            <br>
            <label>Password:</label>
            <input type="text" name="password" value="${user.password}">
            <br>
            <input type="submit" value="Log in">
        </form>
    </body>
</html>
