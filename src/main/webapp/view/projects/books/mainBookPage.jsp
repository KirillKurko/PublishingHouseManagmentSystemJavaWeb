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
    <a class="active" href="${pageContext.request.contextPath}/view/projects/books/addBookPage.jsp">Add</a>
    <a class="active" style="float: right" href="${pageContext.request.contextPath}/view/main.jsp">Back</a>
</div>
<br><br><br>
<div class="container center">
    <c:forEach var="book" items="${books}">
        <div class="card">
            <h2>${book.name}</h2>
            <hr>
            <p>${book.title}</p>
            <p><a style="text-decoration: none; font: inherit; color: black" href="${book.fileLink}">Text</a></p>
            <br>
            <form id="reviewsForm" class="form" action="${pageContext.request.contextPath}/reviews" method="get">
                <input type="hidden" name="bookId" value="${book.id}">
                <input type="hidden" name="action" value="getBookReviews">
                <button type="submit">Reviews</button>
            </form>
            <form id="editForm" class="form" action="${pageContext.request.contextPath}/books" method="get">
                <input type="hidden" name="bookId" value="${book.id}">
                <input type="hidden" name="action" value="getBook">
                <button type="submit">Edit</button>
            </form>
            <form id="deleteForm" class="form" action="${pageContext.request.contextPath}/books" method="get">
                <input type="hidden" name="bookId" value="${book.id}">
                <input type="hidden" name="action" value="deleteBook">
                <button type="submit">Delete</button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>
