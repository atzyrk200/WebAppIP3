<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Document</title>
</head>

<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Delete Product</h3>

<p style="color: red;">${errorString}</p>
<a href="documentList">Document List</a>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>