<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/resource/bootstrap/css/**" rel="stylesheet" crossorigin="anonymous">
<link href="<%=request.getContextPath()%>/resource/mycss/background.css" rel="stylesheet" crossorigin="anonymous">

<sitemesh:write property="head" />

<title>Ren Website - </title>
</head>

<body class="tm-body-bg-img">

<sitemesh:write property="body" />

<footer>this is a footer</footer>

</body>
</html>