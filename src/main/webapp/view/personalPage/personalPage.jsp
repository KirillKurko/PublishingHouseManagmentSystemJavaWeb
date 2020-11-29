<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Personal Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/personalPageStyle.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/toolbarStyles/toolbarPersonalPages.css" type="text/css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
    <div class="topnav">
        <a class="active" href="${pageContext.request.contextPath}/view/main.jsp">Home</a>
        <a class="active" href="${pageContext.request.contextPath}/personalPage?action=getEmployee">Employee</a>
        <c:if test="${sessionScope.role.equals('chiefEditor')}">
            <a class="active" href="${pageContext.request.contextPath}/personalPage?action=getChiefEditor">Chief Editor</a>
        </c:if>
        <c:if test="${sessionScope.role.equals('leadEditor')}">
            <a class="active" href="${pageContext.request.contextPath}/personalPage?action=getLeadEditor">Lead Editor</a>
        </c:if>
        <a class="active" style="float:right" href="${pageContext.request.contextPath}/login">Logout</a>
        <a class="active" style="float:right" href="${pageContext.request.contextPath}/personalPage?action=deleteAccount">Delete Account</a>
    </div>
    <div class="container-center">
        <div class="container">
            <div class="header">
                <h2>User Information</h2>
            </div>
            <form id="userForm" class="form" action="${pageContext.request.contextPath}/personalPage" method="post">
                <div class="form-control">
                    <label for="username">Username</label>
                    <input type="text" placeholder="Username" name="username" id="username" value="${user.login}"/>
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                    <small>Error message</small>
                </div>
                <div class="form-control">
                    <label for="email">Email</label>
                    <input type="text" placeholder="Email" name="email" id="email" value="${user.email}"/>
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                    <small>Error message</small>
                </div>
                <div class="form-control">
                    <label for="password">Password</label>
                    <input type="text" placeholder="Password" name="password" id="password" value="${user.password}"/>
                    <i class="fas fa-check-circle"></i>
                    <i class="fas fa-exclamation-circle"></i>
                    <small>Error message</small>
                </div>
                <input type="hidden" name="role" id="role" value="${user.role}"/>
                <input type="hidden" name="id" id="id" value="${user.id}"/>
                <input type="hidden" name="action" id="action" value="editUser"/>
                <button type="submit">Edit</button>
            </form>
        </div>
    </div>
</body>
</html>