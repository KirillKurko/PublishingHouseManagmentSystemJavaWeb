<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Username: ${sessionScope.user.login}
    Password: ${sessionScope.user.password}
    Role: ${sessionScope.user.role}
</body>
</html>
