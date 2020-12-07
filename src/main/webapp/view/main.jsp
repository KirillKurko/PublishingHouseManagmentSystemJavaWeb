<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>
<html lang="en">
    <head>
        <title>Home</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/personalPageStyle.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/toolbarStyles/toolbarPersonalPages.css" type="text/css">
    </head>
    <body>
    <div class="topnav">
        <a class="active" style="float:right" href="${pageContext.request.contextPath}/login">Logout</a>
    </div>
    <br><br><br><br>
    <div class="container-center">
        <c:if test='${sessionScope.role.equals("publusher")}'>
            <div class="container">
                <form id="formUsers" class="form" action="${pageContext.request.contextPath}/users" method="get">
                    <input type="hidden" name="action" value="getUsers">
                    <button type="submit">Users</button>
                </form>
            </div>
            <br>
        </c:if>
        <div class="container">
            <form id="formEmployees" class="form" action="${pageContext.request.contextPath}/employees" method="get">
                <input type="hidden" name="action" value="getEmployees">
                <button type="submit">Employees</button>
            </form>
        </div>
        <br>
        <c:if test='${!sessionScope.role.equals("employee")}'>
            <div class="container">
                <form id="formLeadEditors" class="form" action="${pageContext.request.contextPath}/leadEditors" method="get">
                    <input type="hidden" name="action" value="getLeadEditors">
                    <button type="submit">Lead Editors</button>
                </form>
            </div>
            <br>
        </c:if>
        <c:if test='${sessionScope.role.equals("publisher") || sessionScope.role.equals("chiefEditor")}'>
            <div class="container">
                <form id="formChiefEditors" class="form" action="${pageContext.request.contextPath}/chiefEditors" method="get">
                    <input type="hidden" name="action" value="getChiefEditors">
                    <button type="submit">Chief Editors</button>
                </form>
            </div>
            <br>
        </c:if>
        <div class="container">
            <form id="formTasks" class="form" action="${pageContext.request.contextPath}/tasks" method="get">
                <input type="hidden" name="action" value="getTasks">
                <button type="submit">Tasks</button>
            </form>
        </div>
        <br>
        <div class="container">
            <form id="formPersonalPage" class="form" action="${pageContext.request.contextPath}/personalPage" method="get">
                <input type="hidden" name="action" value="getUser">
                <button type="submit">Personal Page</button>
            </form>
        </div>
        <br>
        <div class="container">
            <form id="formBooks" class="form" action="${pageContext.request.contextPath}/books" method="get">
                <input type="hidden" name="action" value="getBooks">
                <button type="submit">Books</button>
            </form>
        </div>
        <br>
        <div class="container">
            <form id="formProjects" class="form" action="${pageContext.request.contextPath}/projects" method="get">
                <input type="hidden" name="action" value="getProjects">
                <button type="submit">Projects</button>
            </form>
        </div>
    </div>
    </body>
</html>
