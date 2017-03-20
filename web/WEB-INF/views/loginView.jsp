<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="SCSS/stylesheet.css">
    <link rel="stylesheet" href="SCSS/partials/login.css">

</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<div class="login-container">
    <section class="login" id="login">
        <header>
            <h2>Ideagen</h2>
            <h4>Login</h4>
        </header>

<p style="color: red;">${errorString}</p>

<form class="login-form" method="POST" action="doLogin">
    <table border="0">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="userUsername" value= "${user.userUsername}" /> </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="userPassword" value= "${user.userPassword}" /> </td>
        </tr>
        <tr>
            <td>Remember me</td>
            <td><input type="checkbox" name="rememberMe" value= "Y" /> </td>
        </tr>
        <tr>
            <td class="submit-container">
                <input type="submit" class="btn medium primary" value= "Submit" />
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
</form>
    </section>
</div>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>