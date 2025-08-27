<%--
  Created by IntelliJ IDEA.
  User: Bharath
  Date: 23-08-2025
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Offers</title>
</head>
<body>
    <form action="admit" method="post" enctype="multipart/form-data">
        <input type="text" name="offer_id" placeholder="enter your offer id"/>
        <input type="text" name="offer_name" placeholder="enter your offer name"/>
        <input type="text" name="rate_of_interest" placeholder="enter your rate of interest"/>
        <input type="file" name="terms"/>
        <input type="submit" value="submit" />
    </form>
</body>
</html>
