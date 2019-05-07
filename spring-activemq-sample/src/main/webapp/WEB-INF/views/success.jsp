<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Confirmation</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="generic-container">
    <div class="alert alert-success lead">
        ${message}
    </div>
    <span class="well floatRight">
		<a href="<c:url value='/product/save'/>">Buy More</a>
	</span>
    <span class="well floatRight">
		<a href="<c:url value='/product/find/all'/>">View All Products</a>
	</span>
</div>
</body>
</html>