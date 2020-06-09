<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" import="org.kpu.myapp.domain.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
</head>
<body>
	<div align=center>
	
		<header>글 상세보기</header>
		<table>
			<tr>
				<td>글 번호</td>
				<td>${board.num}</td>
			</tr><br><br>
			<tr>
				<td>조회수</td>
				<td>${board.hit}</td>
			</tr><br><br>
			<tr>
				<td>글쓴이</td>
				<td>${board.writer}</td>
			</tr><br><br>
			<tr>
				<td>작성일</td>
				<td><fmt:formatDate value="${board.date}" pattern="yyyy/MM/dd KK:mm:ss"/></td>
			</tr><br><br>
			<tr>
				<td>제목</td>
				<td>${board.sub}</td>
			</tr><br><br>
			<tr>
				<td>내용</td>
				<td>${board.content}</td>
			</tr><br><br>			
		</table>
		<c:url value="/board/list" var="url"/><a href="${url}">게시판 목록 보기</a>
		<c:url value="/board/modify?num=${board.num}" var="url"/><a href="${url}">글 수정</a>
		<c:url value="/board/delete?num=${board.num}" var="url"/><a href="${url}">글 삭제</a>
	
	</div>
</body>
</html>