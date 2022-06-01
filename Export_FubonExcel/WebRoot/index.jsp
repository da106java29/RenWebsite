<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link href="resource/css/export.css" rel="stylesheet">
<script type="text/javascript" src="resource/js/export.js"></script>

<title>Export Excel</title>
	
</head>
<body>
	
	<form id="form_Export" action="WebController" method="post" return="false">
		<div>
			<h3 align="center" style="color:blue;font-family:verdana;">
<!-- 				<a href="javascript:void(0);" onclick="document.getElementById('form_Export').submit();">Export Excel Click Here</a> -->
				<a href="javascript:void(0);" onclick="doExportExcel();">Export Excel Click Here</a>
			</h3>
		</div>
	</form>
	
	<div class="file_div" align="center">
		<input class="file_input" id="filename" type="text" placeholder="Pleace Enter The File Name"> 
	</div>
	
	<iframe id="iframepage" src="http://www.top8889.com.tw/AccPlate/ind.htm" frameborder="0" scrolling="yes" onload="changeFrameHeight()" />
	
</body>
</html>