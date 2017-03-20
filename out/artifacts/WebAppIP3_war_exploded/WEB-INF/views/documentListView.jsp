<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document List</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Document List</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>RevisionNumber</th>
        <th>Title</th>
        <th>Author</th>
        <th>CreationDate</th>
        <th>Path</th>
        <th>DocumentStatus</th>
    </tr>
    <c:forEach items="${documentList}" var="document" >
        <tr>
            <td>${document.revisionNumber}</td>
            <td>${document.documentTitle}</td>
            <td>${document.documentAuthor}</td>
            <td>${document.documentCreationDate}</td>
            <td>${document.documentPath}</td>
            <td>${document.documentStatus}</td>
            <td>
                <a href="editDocument?revisionNumber=${document.revisionNumber}">Edit</a>
            </td>
            <td>
                <a href="deleteProduct?revisionNumber=${document.revisionNumber}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="createDocument" >Create Document</a>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>