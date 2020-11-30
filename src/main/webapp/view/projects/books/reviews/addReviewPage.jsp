<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registrationPageStyle.css" type="text/css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
<body>
<div class="container">
    <div class="header">
        <h2>Add Review</h2>
    </div>
    <form id="form" class="form" action="${pageContext.request.contextPath}/reviews" method="post">
        <div class="form-control">
            <label for="rating">Rating</label>
            <input type="text" placeholder="Rating" name="rating" id="rating" />
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="description">Description</label>
            <input type="text" placeholder="Description" name="description" id="description" />
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="bookName">Book Name</label>
            <input type="text" placeholder="Book Name" name="bookName" id="bookName" />
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <input type="hidden" name="action" value="addReview"/>
        <button type="submit">Add</button>
    </form>
</div>
</body>
</html>

