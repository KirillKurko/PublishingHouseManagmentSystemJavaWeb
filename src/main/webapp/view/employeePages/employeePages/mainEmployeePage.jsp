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
            <a class="active" href="${pageContext.request.contextPath}/view/registration/userRegistration.jsp?action=add">Add</a>
            <a class="active" style="float:right" href="${pageContext.request.contextPath}/login">Logout</a>
        </div>
        <br><br><br>
        <div class="container center">
            <c:forEach var="employee" items="${employees}">
                <div class="card">
                    <h2>${employee.name}</h2>
                    <h2>${employee.surname}</h2>
                    <hr>
                    <p>Experience: ${employee.experience}</p>
                    <p>Salary: ${employee.salary}</p>
                    <br>
                    <form id="editForm" class="form" action="${pageContext.request.contextPath}/employees" method="get">
                        <input type="hidden" name="employeeId" value="${employee.id}">
                        <input type="hidden" name="action" value="getEmployee">
                        <button type="submit">Edit</button>
                    </form>
                    <form id="deleteForm" class="form" action="${pageContext.request.contextPath}/employees" method="get">
                        <input type="hidden" name="userId" value="${employee.userID}">
                        <input type="hidden" name="action" value="deleteEmployee">
                        <button type="submit">Delete</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
