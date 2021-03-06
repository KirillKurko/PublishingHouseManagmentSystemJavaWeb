<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/personalPageStyle.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/toolbarStyles/toolbarPersonalPages.css" type="text/css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
<body>
<div class="topnav">
    <a class="active" href="${pageContext.request.contextPath}/view/main.jsp">Home</a>
    <a class="active" style="float:right" href="${pageContext.request.contextPath}/login">Logout</a>
    <a class="active" style="float:right" href="${pageContext.request.contextPath}/personalPage?action=getUser">Back</a>
</div>
<div class="container-center">
    <div class="container">
        <div class="header">
            <h2>Employee Information</h2>
        </div>
        <form id="form" class="form" action="${pageContext.request.contextPath}/personalPage" method="post">
            <div class="form-control">
                <label for="name">Name</label>
                <input type="text" placeholder="Name" name="name" id="name" value="${employee.name}"/>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <div class="form-control">
                <label for="surname">Surname</label>
                <input type="text" placeholder="Surname" name="surname" id="surname" value="${employee.surname}"/>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <div class="form-control">
                <label for="experience">Experience</label>
                <input type="text" placeholder="Experience" name="experience" id="experience" value="${employee.experience}"/>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <div class="form-control">
                <label for="salary">Salary</label>
                <input type="text" placeholder="Salary" name="salary" id="salary" value="${employee.salary}"/>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <input type="hidden" name="id" id="id" value="${employee.id}"/>
            <input type="hidden" name="userId" id="userId" value="${employee.userID}">
            <input type="hidden" name="action" id="action" value="editEmployee"/>
            <button type="submit">Edit</button>
        </form>
    </div>
</div>
</body>
</html>