<%--
  Created by IntelliJ IDEA.
  User: Bharath
  Date: 23-08-2025
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="alp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="bet" %>
<html>
<head>
    <title>Edit Offers</title>
</head>
<body>


<bet:setDataSource var="bharath" driver="com.mysql.cj.jdbc.Driver" url="mysql-744eeba-bharathdhanavan2612-cb02.b.aivencloud.com" user="avnadmin" password="{DB-PASSWORD}" />
    <bet:query var = "extracted" datasource="${bharath}" sql="select * from offers where offer_id=?">
        <bet:param value="${param.key}" />
    </bet:query>

    <alp:forEach var="each" items="${extracted.rows}">
        <form action="update" method="post" enctype="multipart/form-data">
            <input type="text" readonly name="offer_id" value="${each.offer_id}"/>
            <input type="text" name="offer_name" value="${each.offer_name}" placeholder="enter offer name"/>
            <input type="text" name="rate_of_interest" value="${each.rate_of_interest}" placeholder="enter rate of interest"/>
            <input type="file" name="terms"/>
            <input type="submit" value="submit"/>
        </form>
    </alp:forEach>

</body>
</html>
