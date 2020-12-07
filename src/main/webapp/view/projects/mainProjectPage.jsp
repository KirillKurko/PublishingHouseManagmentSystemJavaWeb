<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Projects</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cardStyle.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/toolbarStyles/toolbar.css" type="text/css">
</head>
<body>
<div class="topnav">
    <a class="active" href="${pageContext.request.contextPath}/view/main.jsp">Home</a>
    <c:if test='${sessionScope.role.equals("publisher") || sessionScope.role.equals("chiefEditor")}'>
        <a class="active" href="${pageContext.request.contextPath}/view/projects/addProjectPage.jsp">Add</a>
    </c:if>
    <a class="active" style="float: right" href="${pageContext.request.contextPath}/view/main.jsp">Back</a>
</div>
<br><br><br>
<div class="container center">
    <c:forEach var="project" items="${projects}">
        <div class="card">
            <h2>Project</h2>
            <hr>
            <p>Pages: ${project.pagesAmount}</p>
            <p>Page Price: ${project.pagePrice}</p>
            <p>Books: ${project.booksAmount}</p>
            <br>
            <form id="infoForm" class="form" action="${pageContext.request.contextPath}/projects" method="get">
                <input type="hidden" name="projectId" value="${project.id}">
                <input type="hidden" name="action" value="getProjectInfo">
                <button type="submit">More</button>
            </form>
            <c:if test='${!sessionScope.role.equals("employee")}'>
                <form id="editForm" class="form" action="${pageContext.request.contextPath}/projects" method="get">
                    <input type="hidden" name="projectId" value="${project.id}">
                    <input type="hidden" name="action" value="getProject">
                    <button type="submit">Edit</button>
                </form>
            </c:if>
            <c:if test='${sessionScope.role.equals("publisher")}'>
                <form id="deleteForm" class="form" action="${pageContext.request.contextPath}/projects" method="get">
                    <input type="hidden" name="projectId" value="${project.id}">
                    <input type="hidden" name="action" value="deleteProject">
                    <button type="submit">Delete</button>
                </form>
            </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>