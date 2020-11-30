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
        <h2>Edit Book</h2>
    </div>
    <form id="form" class="form" action="${pageContext.request.contextPath}/books" method="post">
        <div class="form-control">
            <label for="name">Name</label>
            <input type="text" placeholder="Name" name="name" id="name" value="${book.name}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="title">Title</label>
            <input type="text" placeholder="Title" name="title" id="title" value="${book.title}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="link">Link</label>
            <input type="text" placeholder="Link" name="link" id="link"value="${book.fileLink}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <input type="hidden" name="bookId" value="${book.id}"/>
        <input type="hidden" name="action" value="editBook"/>
        <button type="submit">Edit</button>
    </form>
</div>
</body>
</html>
