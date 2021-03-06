<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Task</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registrationPageStyle.css" type="text/css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <script defer src="resources/js/registrationPageValidation.js"></script>
<body>
<div class="container">
    <div class="header">
        <h2>Add Task</h2>
    </div>
    <form id="form" class="form" action="${pageContext.request.contextPath}/tasks" method="post">
        <div class="form-control">
            <label for="name">Name</label>
            <input type="text" placeholder="Name" name="name" id="name" />
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
            <label for="employee">Employee</label>
            <input type="text" placeholder="Employee" name="employee" id="employee" />
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <input type="hidden" name="action" value="addTask"/>
        <button type="submit">Add</button>
    </form>
</div>
</body>
</html>
