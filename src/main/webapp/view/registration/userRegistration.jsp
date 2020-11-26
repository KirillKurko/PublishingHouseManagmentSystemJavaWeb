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
            <h2>Login</h2>
        </div>
        <form id="form" class="form" action="${pageContext.request.contextPath}/<%=
        request.getParameter("action").equals("add") ? "add" : "registration"%>" method="post">
            <div class="form-control">
                <label for="username">Username</label>
                <input type="text" placeholder="Username" name="username" id="username" />
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <div class="form-control">
                <label for="email">Email</label>
                <input type="text" placeholder="Email" name="email" id="email" />
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <div class="form-control">
                <label for="role">Role</label>
                <input type="text" placeholder="Role" name="role" id="role"/>
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
            <div class="form-control">
                <label for="confirmedPassword">Confirm Password</label>
                <input type="password" placeholder="Password" name="confirmedPassword" id="confirmedPassword"/>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <input type="hidden" name="caller" value=view/registration/userRegistration.jsp"/>
            <input type="hidden" name="method" value="registerUser"/>
            <button type="submit">Submit</button>
            <button onclick="location.href='${pageContext.request.contextPath}/index.jsp'">Sign Up</button>
        </form>
    </div>
    </body>
</html>

