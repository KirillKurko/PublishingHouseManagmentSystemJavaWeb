<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registrationPageStyle.css" type="text/css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <script defer src="../../resources/js/registrationPageValidation.js"></script>
<body>
<div class="container">
    <div class="header">
        <h2>Edit User</h2>
    </div>
    <form id="form" class="form" action="${pageContext.request.contextPath}/users" method="post">
        <div class="form-control">
            <label for="username">Username</label>
            <input type="text" placeholder="Username" name="username" id="username" value="${user.login}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="email">Email</label>
            <input type="text" placeholder="Email" name="email" id="email" value="${user.email}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="password">Password</label>
            <input type="text" placeholder="Password" name="password" id="password" value="${user.password}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <input type="hidden" name="role" id="role" value="${user.role}"/>
        <input type="hidden" name="id" id="id" value="${user.id}"/>
        <input type="hidden" name="action" id="action" value="editUser"/>
        <button type="submit">Edit</button>
    </form>
</div>
</body>
</html>