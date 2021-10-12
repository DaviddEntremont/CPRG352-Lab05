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
            <input type="text" name="username" value="${note.title}">
            <br>
            <label>Contents:</label>
            <input type="text" name="password">${note.contents}
            <br><br>
            <input type="submit" value="Log in">
        </form>
    </body>
</html>
