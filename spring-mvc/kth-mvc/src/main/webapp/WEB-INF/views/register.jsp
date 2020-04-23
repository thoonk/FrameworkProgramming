<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register JSP</title>
	<link rel="stylesheet" href="resources/member.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>학생 정보 등록</header>
		<form name=form1 action="http://localhost:8080/web/tryF" method="post">
		<table>	
			<tr><th>LoginID</th><td><input type="text" name="id" autofocus placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>LoginPWD</th><td><input type="text" name="passwd" placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>YourName</th><td><input type="text" name="username"  placeholder="공백없이 입력하세요"></td></tr>
			<tr><th>StudentNumber</th><td><input type="text" name="snum" placeholder="공백없이 입력하세요"></td></tr>
		</table>
		<dl>
			<dd><input type="submit" name="submit" value="보내기"></dd>
			<dd><input type="reset" name="reset" value="다시 작성"></dd>
		</dl>
		</form>
	</div>
</body>
</html>