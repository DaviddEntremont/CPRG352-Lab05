<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    <body>
        <h1>Login</h1>
        
         <c:if test="${loggedout}">
        <p>You have successfully logged out.</p>
        </c:if>
        
         <form method="POST" action="login">
            <label>Username:</label>
            <input type="text" name="username" value="${username}">
            <br>
            <label>Password:</label>
            <input type="text" name="password" value="${password}">
            <br>
            <input type="submit" value="Log in">
        </form>
            
        <c:if test="${nullBoth}">
        <p>Please enter both a username and password.</p>
        </c:if>
                
        <c:if test="${nullUsername}">
        <p>Please enter a username.</p>
        </c:if>
        
        <c:if test="${nullPassword}">
        <p>Please enter a password.</p>
        </c:if>
        
        <c:if test="${invalid}">
        <p>Failed authentication.</p>
        </c:if>
     
    </body>
</html>
