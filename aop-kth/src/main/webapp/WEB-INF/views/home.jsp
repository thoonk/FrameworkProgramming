<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>board</title>
</head>
<body>

<div align="center">
	<h1>
	댕댕's 
	</h1>
	<form method=get>
		<a href="http://localhost:8080/myapp/board/list" target="_self">
			<img src="resources/logo.png" width = "182" height="372"> 
		</a>
	</form>
<P>  현재 시각 : ${serverTime} </P>

</div>
</body>
</html>
