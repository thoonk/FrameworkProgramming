<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Information</title>
</head>
<body>
	<div align=center>
		<c:if test="${student != null}">
			<dl>
			  <dt>계정</dt>
			  <dd><c:out value="${student.id}"/></dd>
			  <dt>암호</dt>
			  <dd><c:out value="${student.passwd}"/></dd>
			  <dt>이름</dt>
			  <dd><c:out value="${student.username}"/></dd>
			  <dt>학번</dt>
			  <dd><c:out value="${student.snum}"/></dd>
			</dl>
		</c:if>
	</div>
</body>
</html>