<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>
<html lang="${sessionScope.lang}">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registrationPageStyle.css" type="text/css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <script defer src="src/main/webapp/resources/js/registrationPageValidation.js"></script>
<body>
<div class="container">
    <div class="header">
        <h2><fmt:message key="editChiefEditorPage.header"/></h2>
    </div>
    <form id="form" class="form" action="${pageContext.request.contextPath}/chiefEditors" method="post">
        <div class="form-control">
            <label for="finishedProjectsAmount"><fmt:message key="editChiefEditorPage.finishedProjects"/></label>
            <input type="text" placeholder="<fmt:message key="editChiefEditorPage.finishedProjects"/>" name="finishedProjectsAmount" id="finishedProjectsAmount" value="${chiefEditor.finishedProjectsAmount}"/>
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <small>Error message</small>
        </div>
        <input type="hidden" name="id" id="id" value="${chiefEditor.id}"/>
        <input type="hidden" name="employeeId" id="employeeId" value="${chiefEditor.employeeID}"/>
        <input type="hidden" name="action" id="action" value="editChiefEditor"/>
        <button type="submit"><fmt:message key="editChiefEditorPage.edit"/></button>
    </form>
</div>
</body>
</html>