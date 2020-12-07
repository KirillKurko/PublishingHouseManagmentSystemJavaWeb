<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Project</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registrationPageStyle.css" type="text/css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
<body>
<div class="container">
    <div class="header">
        <h2>Edit Project</h2>
    </div>
    <form id="form" class="form" action="${pageContext.request.contextPath}/projects" method="post">
        <div class="form-control">
            <label for="pagesAmount">Pages</label>
            <input type="text" placeholder="Pages" name="pagesAmount" id="pagesAmount" value="${project.pagesAmount}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="pagePrice">Page Price</label>
            <input type="text" placeholder="Page Price" name="pagePrice" id="pagePrice" value="${project.pagePrice}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="booksAmount">Books</label>
            <input type="text" placeholder="Books" name="booksAmount" id="booksAmount" value="${project.booksAmount}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="leadEditorLogin">Lead Editor</label>
            <input type="text" placeholder="Lead Editor" name="leadEditorLogin" id="leadEditorLogin" value="${user.login}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="bookName">Book Name</label>
            <input type="text" placeholder="Book Name" name="bookName" id="bookName" value="${book.name}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <input type="hidden" name="projectId" value="${project.id}"/>
        <input type="hidden" name="action" value="editProject"/>
        <button type="submit">Edit</button>
    </form>
</div>
</body>
</html>