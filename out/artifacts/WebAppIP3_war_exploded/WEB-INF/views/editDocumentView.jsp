<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Document</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Edit Product</h3>

<p style="color: red;">${errorString}</p>

<c:if test="${not empty document}">
    <form method="POST" action="doEditDocument">
        <input type="hidden" name="code" value="${document.revisionNumber}" />
        <table border="0">
            <tr>
                <td>Code</td>
                <td style="color:red;">${document.revisionNumber}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${document.documentTitle}" /></td>
            </tr>
            <tr>
                <td>Author</td>
                <td><input type="text" name="price" value="${document.documentAuthor}" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/documentList">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>