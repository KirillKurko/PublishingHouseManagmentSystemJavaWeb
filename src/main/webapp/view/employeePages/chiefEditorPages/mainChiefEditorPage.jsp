<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cardStyle.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/toolbar.css" type="text/css">
</head>
<body>
<div class="topnav">
    <a class="active" href="${pageContext.request.contextPath}/view/main.jsp">Home</a>
    <a class="active" style="float:right" href="${pageContext.request.contextPath}/login">Logout</a>
</div>
<br><br><br>
<div class="container center">
    <c:forEach var="chiefEditor" items="${chiefEditors}">
        <div class="card">
            <h2>Chief Editor</h2>
            <hr>
            <p>Finished Projects: ${chiefEditor.finishedProjectsAmount}</p>
            <br>
            <form id="editForm" class="form" action="${pageContext.request.contextPath}/chiefEditors" method="get">
                <input type="hidden" name="chiefEditorId" value="${chiefEditor.id}">
                <input type="hidden" name="action" value="getChiefEditor">
                <button type="submit">Edit</button>
            </form>
            <form id="deleteForm" class="form" action="${pageContext.request.contextPath}/chiefEditors" method="get">
                <input type="hidden" name="chiefEditorId" value="${chiefEditor.id}">
                <input type="hidden" name="employeeId" value="${chiefEditor.employeeID}">
                <input type="hidden" name="action" value="deleteChiefEditor">
                <button type="submit">Delete</button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>
