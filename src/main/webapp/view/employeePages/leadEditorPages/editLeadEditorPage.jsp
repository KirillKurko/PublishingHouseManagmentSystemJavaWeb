<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registrationPageStyle.css" type="text/css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <script defer src="src/main/webapp/resources/js/registrationPageValidation.js"></script>
<body>
<div class="container">
    <div class="header">
        <h2>Edit Lead Editor</h2>
    </div>
    <form id="form" class="form" action="${pageContext.request.contextPath}/leadEditors" method="post">
        <div class="form-control">
            <label for="finishedProjectsAmount">Finished Projects</label>
            <input type="text" placeholder="Finished Projects" name="finishedProjectsAmount" id="finishedProjectsAmount" value="${leadEditor.finishedProjectsAmount}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="mainGenre">Main Genre</label>
            <input type="text" placeholder="Main Genre" name="mainGenre" id="mainGenre" value="${leadEditor.mainGenre}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <input type="hidden" name="id" id="id" value="${leadEditor.id}"/>
        <input type="hidden" name="employeeId" id="employeeId" value="${leadEditor.employeeID}"/>
        <input type="hidden" name="action" id="action" value="editLeadEditor"/>
        <button type="submit">Edit</button>
    </form>
</div>
</body>
</html>