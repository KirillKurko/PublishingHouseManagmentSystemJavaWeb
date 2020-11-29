<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        employeeId: ${sessionScope.userId}
        <hr>
        userId: ${sessionScope.employeeId}
        <hr>
        role: ${sessionScope.role}
        <hr>

        <form id="form" class="form" action="${pageContext.request.contextPath}/users" method="get">
            <input type="hidden" name="action" value="getUsers">
            <button type="submit">Users</button>
        </form>
        <form id="form" class="form" action="${pageContext.request.contextPath}/employees" method="get">
            <input type="hidden" name="action" value="getEmployees">
            <button type="submit">Employees</button>
        </form>
        <form id="form" class="form" action="${pageContext.request.contextPath}/leadEditors" method="get">
            <input type="hidden" name="action" value="getLeadEditors">
            <button type="submit">Lead Editors</button>
        </form>
        <form id="form" class="form" action="${pageContext.request.contextPath}/chiefEditors" method="get">
            <input type="hidden" name="action" value="getChiefEditors">
            <button type="submit">Chief Editors</button>
        </form>
        <hr>
        <form id="form" class="form" action="${pageContext.request.contextPath}/tasks" method="get">
            <input type="hidden" name="action" value="getTasks">
            <button type="submit">Tasks</button>
        </form>
        <form id="form" class="form" action="${pageContext.request.contextPath}/personalPage" method="get">
            <input type="hidden" name="action" value="getUser">
            <button type="submit">Personal Page</button>
        </form>
    </body>
</html>
