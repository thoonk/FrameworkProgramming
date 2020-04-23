<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student List</title>
	<link rel="stylesheet" href="../resources/member.css" type="text/css"></link>
</head>
<body>
	<div align=center>
		<header>학생 목록</header><br>
		<c:url value="/member/register" var="url"/><a href="${url}">학생 등록</a><br><br>
		<table>
		  <tr>
		    <th>ID</th><th>PWD</th><th>USERNAME</th><th>SNUM</th><th>DEPART</th><th>MOBILE</th><th>EMAIL</th><th></th>
		  </tr>
		  <c:forEach var="member" items="${students}" >
			  <tr>
			    <td><c:out value="${member.id}"/></td>
			    <td><c:out value="${member.passwd}"/></td>
			    <td><c:out value="${member.username}"/></td>
			    <td><c:out value="${member.snum}"/></td>
			    <td><c:out value="${member.depart}"/></td>
			    <td><c:out value="${member.mobile}"/></td>
			    <td><c:out value="${member.email}"/></td>
			    <td>
			      <c:url value="/member/read?id=${member.id}" var="url"/><a href="${url}">정보 보기</a>
			      <c:url value="/member/modify?id=${member.id}" var="url"/><a href="${url}">정보 수정</a>
			    </td>
			  </tr>
		  </c:forEach>
		</table>
	</div>
</body>
</html>