<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/taskStyle.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/toolbarStyles/toolbarTaskStyle.css" type="text/css">
</head>
<body>
<div class="topnav">
    <a class="active" href="${pageContext.request.contextPath}/view/main.jsp">Home</a>
    <a class="active" href="${pageContext.request.contextPath}/view/projects/books/reviews/addReviewPage.jsp">Add</a>
    <a class="active" href="${pageContext.request.contextPath}/reviews?action=getAllReviews">All</a>
    <a class="active" style="float:right" href="${pageContext.request.contextPath}/books?action=getBooks">Back</a>
</div>
<br><br><br>
<div class="courses-container">
    <c:forEach var="review" items="${reviews}">
        <div class="course">
            <div class="course-preview">
                <h6>Review to</h6>
                <h2>${review.bookName}</h2>
            </div>
            <div class="course-info">
                <h2>Rating: ${review.rating}</h2>
                <p>${review.description}</p>
                <br><br>
                <form id="finishButton" action="${pageContext.request.contextPath}/reviews" method="get">
                    <input type="hidden" name="reviewId" value="${review.id}">
                    <input type="hidden" name="bookId" value="${review.bookID}">
                    <input type="hidden" name="action" value="deleteReview">
                    <button type="submit" class="btn">Delete</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
