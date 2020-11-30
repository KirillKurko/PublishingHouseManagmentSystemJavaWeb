<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/taskStyle.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/toolbarStyles/toolbarTaskStyle.css" type="text/css">
</head>
<body>
<div class="topnav">
    <a class="active" href="${pageContext.request.contextPath}/view/main.jsp">Home</a>
    <a class="active" href="${pageContext.request.contextPath}/view/tasks/addTaskPage.jsp">Add</a>
    <a class="active" href="${pageContext.request.contextPath}/tasks?action=getTasks">All</a>
    <a class="active" href="${pageContext.request.contextPath}/tasks?action=getAppointedTasks">Appointed</a>
    <a class="active" href="${pageContext.request.contextPath}/tasks?action=getReceivedTasks">Received</a>
    <a class="active" style="float:right" href="${pageContext.request.contextPath}/login">Logout</a>
</div>
<br><br><br>
<div class="courses-container">
    <c:forEach var="task" items="${tasks}">
        <div class="course">
            <div class="course-preview">
                <h6>from</h6>
                <h2>${task.customerName}</h2>
                <br>
                <h6>to</h6>
                <h2>${task.executorName}</h2>
            </div>
            <div class="course-info">
                <h2>${task.name}</h2>
                <p>${task.description}</p>
                <br><br>
                <form id="finishButton" action="${pageContext.request.contextPath}/tasks" method="get">
                    <input type="hidden" name="taskId" value="${task.id}">
                    <input type="hidden" name="action" value="finishTask">
                    <button type="submit" class="btn">Finish</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
