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
        <a href="${pageContext.request.contextPath}/view/userPages/mainUserPage.jsp">Users</a>
    </body>
</html>
