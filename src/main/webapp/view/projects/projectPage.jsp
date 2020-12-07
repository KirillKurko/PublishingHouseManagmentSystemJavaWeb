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
    <a class="active" style="float:right" href="${pageContext.request.contextPath}/projects?action=getProjects">Back</a>
</div>
<br><br><br>
<div class="courses-container">
    <div class="course">
        <div class="course-preview">
            <h6>Project</h6>
            <h2>Project</h2>
        </div>
        <div class="course-info">
            <h2>Project Information</h2>
            <p>Pages: ${project.pagesAmount}</p>
            <p>Page Price: ${project.pagePrice}</p>
            <p>Books: ${project.booksAmount}</p>
            <br><br>
            <c:if test='${sessionScope.role.equals("publisher") || sessionScope.role.equals("chiefEditor")}'></c:if>
            <form id="finishButton" action="${pageContext.request.contextPath}/projects" method="get">
                <input type="hidden" name="projectId" value="${project.id}">
                <input type="hidden" name="action" value="finishProject">
                <button type="submit" class="btn">Finish</button>
            </form>
        </div>
    </div>

    <div class="course">
        <div class="course-preview">
            <h6>Book</h6>
            <h2>${book.name}</h2>
        </div>
        <div class="course-info">
            <p>Title: ${book.title}</p>
            <p>Text link: <a href="${book.fileLink}">Link</a></p>
            <br><br>
        </div>
    </div>

    <div class="course">
        <div class="course-preview">
            <h6>Lead Editor</h6>
            <h2>Lead Editor</h2>
        </div>
        <div class="course-info">
            <h2>${employee.name} ${employee.surname}</h2>
            <p>Main Genre: ${leadEditor.mainGenre}</p>
            <p>Experience: ${employee.experience}</p>
            <p>Finished Projects: ${leadEditor.finishedProjectsAmount}</p>
        </div>
    </div>
</div>
</body>
</html>

