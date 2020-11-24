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
            <a class="active" href="#">Add User</a>
            <a class="active" href="@">Manufacturers</a>
            <a class="active" style="float:right" href="#">Logout</a>
        </div>
        <br><br><br>
        <div class="container center">
            <c:forEach var="user" items="${users}">
                <div class="card">
                    <h2>${user.login}</h2>
                    <hr>
                    <p>Email: ${user.email}</p>
                    <p>Password: ${user.password}</p>
                    <p>Role: ${user.role}</p>
                    <br>
                    <form id="editForm" class="form" action="${pageContext.request.contextPath}/users" method="get">
                        <input type="hidden" name="userId" value="${user.id}">
                        <input type="hidden" name="action" value="getUser">
                        <button type="submit">Edit</button>
                    </form>
                    <form id="deleteForm" class="form" action="${pageContext.request.contextPath}/users" method="get">
                        <input type="hidden" name="userId" value="${user.id}">
                        <input type="hidden" name="action" value="deleteUser">
                        <button type="submit">Delete</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
