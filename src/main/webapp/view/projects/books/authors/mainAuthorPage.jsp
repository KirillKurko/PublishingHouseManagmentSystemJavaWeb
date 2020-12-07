<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cardStyle.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/toolbarStyles/toolbar.css" type="text/css">
</head>
<body>
<div class="topnav">
    <a class="active" href="${pageContext.request.contextPath}/view/main.jsp">Home</a>
    <c:if test='${sessionScope.role.equals("publisher")}'>
        <a class="active" href="${pageContext.request.contextPath}/view/projects/books/authors/addAuthorPage.jsp">Add</a>
    </c:if>
    <a class="active" style="float: right" href="${pageContext.request.contextPath}/books?action=getBooks">Back</a>
</div>
<br><br><br>
<div class="container center">
    <c:forEach var="author" items="${authors}">
        <div class="card">
            <h2>${author.name}</h2>
            <hr>
            <p>${author.surname}</p>
            <br>
            <c:if test='${sessionScope.role.equals("publisher")}'>
                <form id="editForm" class="form" action="${pageContext.request.contextPath}/authors" method="get">
                    <input type="hidden" name="authorId" value="${author.id}">
                    <input type="hidden" name="action" value="getAuthor">
                    <button type="submit">Edit</button>
                </form>
                <form id="deleteForm" class="form" action="${pageContext.request.contextPath}/authors" method="get">
                    <input type="hidden" name="authorId" value="${author.id}">
                    <input type="hidden" name="action" value="deleteAuthor">
                    <button type="submit">Delete</button>
                </form>
            </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>