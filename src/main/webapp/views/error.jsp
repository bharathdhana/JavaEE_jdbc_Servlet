<%--
  Created by IntelliJ IDEA.
  User: Bharath
  Date: 24-08-2025
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <div>
        <h1>Oops! Something went wrong</h1>
        <p href="<%= request.getContextPath() %>/offers">Back to Offers</p>
    </div>
</body>
</html>
