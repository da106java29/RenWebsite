<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${pageContext.request.contextPath}/resource/bootstrap/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resource/mycss/background.css" rel="stylesheet" crossorigin="anonymous">

<title>Demo In Ren Web</title>

</style>
</head>

<body>

	<tiles:insertAttribute name="header" />
	
	<tiles:insertAttribute name="menu" />
	
	<tiles:insertAttribute name="body" ignore="true"/>
	
	<tiles:insertAttribute name="footer" />
	
</body>
</html>