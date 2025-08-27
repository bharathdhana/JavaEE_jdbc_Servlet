<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Bharath
  Date: 23-08-2025
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Details</title>
</head>
<body>
<h1>View Page</h1>

<%-- Check if data is available --%>
<% if (request.getAttribute("data") != null) { %>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Rate of Interest</th>
    </tr>
    <%-- Example: Loop through a list of loan or offer data --%>
    <% java.util.List<Map<String, String>> data = (java.util.List<Map<String, String>>) request.getAttribute("data"); %>
    <% for (Map<String, String> item : data) { %>
    <tr>
        <td><%= item.get("offer_id") %></td>
        <td><%= item.get("offer_name") %></td>
        <td><%= item.get("rate_of_interest") %></td>
    </tr>
    <% } %>
</table>
<% } else { %>
<p>No data available.</p>
<% } %>

<a href="index.jsp">Back to Home</a>
</body>
</html>