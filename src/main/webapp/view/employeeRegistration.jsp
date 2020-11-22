<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="../resources/css/registrationPageStyle.css" type="text/css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
<body>
<div class="container">
    <div class="header">
        <h2>Enter Information</h2>
    </div>
    <form id="form" class="form" action="${pageContext.request.contextPath}/registration/employeeInformation" method="post">
        <div class="form-control">
            <label for="name">Name</label>
            <input type="text" placeholder="Name" name="name" id="name" />
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="surname">Surname</label>
            <input type="text" placeholder="Surname" name="surname" id="surname" />
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="experience">Experience</label>
            <input type="text" placeholder="Experience" name="experience" id="experience"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="salary">Salary</label>
            <input type="text" placeholder="Salary" name="salary" id="salary"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>
