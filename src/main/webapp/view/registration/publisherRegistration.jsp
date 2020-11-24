<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registrationPageStyle.css" type="text/css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
<body>
<div class="container">
    <div class="header">
        <h2>Enter Information</h2>
    </div>
    <form id="form" class="form" action="${pageContext.request.contextPath}/registration/employeeInformation/publisher" method="post">
        <div class="form-control">
            <label for="finances">Finances</label>
            <input type="text" placeholder="Finances" name="finances" id="finances" />
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>