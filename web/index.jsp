<%@ page import="java.sql.*" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="WebApp.Connector" %>

<%--
Created by IntelliJ IDEA.
User: andre_000
Date: 13/03/2017
Time: 03:29
To change this template use File | Settings | File Templates.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Log In Page</title>
    <link rel="stylesheet" href="SCSS/stylesheet.css">
    <link rel="stylesheet" href="SCSS/partials/login.css">
</head>

<body>



<div class="login-container">
    <section class="login" id="login">
        <header>
            <h2>Ideagen</h2>
            <h4>Login to access documents</h4>
        </header>
        <form class="login-form" action="#.jsp">
            <input type="text" class="login-input" placeholder="Username" required autofocus/>
            <input type="password" class="login-input" placeholder="Password" required/>
            <div class="submit-container">
                <div class="sub-container">
                    <button class="btn medium secondary">Forgot Password?</button>
                </div>
                <div class="sub-container">

                    <!--                    <button type="submit" class="btn medium primary">SIGN IN</button>-->
                    <button class="btn medium primary">Log In</button>
                </div>
            </div>
        </form>
    </section>
</div>

<%

        try {
            Connector.main(null);

         }
    catch (Exception e){
       System.out.println("An exception occurred: " + e.getMessage());
    }
%>

</body>

</html>