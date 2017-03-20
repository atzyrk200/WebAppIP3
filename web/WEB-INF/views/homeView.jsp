<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="SCSS/stylesheet.css">
    <link rel="stylesheet" href="SCSS/partials/login.css">

</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>


<div class="login-container">
    <section class="login" id="login">

        <header>
            <h2>Ideagen</h2>
            <h4>Login to access documents</h4>
            <jsp:include page="_menu.jsp"></jsp:include>
        </header>



    </section>
</div>
<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>