<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
	<div class = "container">
		<header>게시판 목록</header>
		<br>
		<c:url value="/board/write" var="url" />
		<a href="${url}">글쓰기</a><br>
		<br>
		
		<table class="table table-list-search">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
				<th>조회</th>
				<th></th>
			</tr>
			<c:forEach var="board" items="${boards}">
				<tr>
					<td><c:out value="${board.num}" /></td>
					<td><c:out value="${board.sub}" /></td>
					<td><c:out value="${board.writer}" /></td>
					<td><fmt:formatDate value="${board.date}"
							pattern="yyyy/MM/dd KK:mm:ss" /></td>
					<td><c:out value="${board.hit}" /></td>
					<td><c:url value="/board/read?num=${board.num}" var="url" /><a
						href="${url}">상세 정보</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>