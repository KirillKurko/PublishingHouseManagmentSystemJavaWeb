<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registrationPageStyle.css" type="text/css">
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        <script defer src="resources/js/registrationPageValidation.js"></script>
    <body>
    <div class="container">
        <div class="header">
            <h2>Sign Up</h2>
        </div>
        <form id="form" class="form" action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-control">
                <label for="username">Username</label>
                <input type="text" placeholder="Username" name="username" id="username" />
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <div class="form-control">
                <label for="password">Password</label>
                <input type="password" placeholder="Password" name="password" id="password"/>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <button type="submit">Submit</button>
            <button onclick="location.href='${pageContext.request.contextPath}/view/registration/userRegistration.jsp?action=registration'">Login</button>
        </form>
    </div>
    </body>
</html>
