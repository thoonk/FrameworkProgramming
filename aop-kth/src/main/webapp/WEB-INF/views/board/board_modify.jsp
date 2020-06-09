<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<div align=center>
		<header>글 수정</header>
		<form action="http://localhost:8080/myapp/board/modify" method="post">
			<table>
			<tr><th>글 번호</th><td><input type="text" name="num" readonly value="${board.num}"></td></tr>
			<tr><th>조회수</th><td><input type="text" name="hit" readonly value="${board.hit}"></td></tr>
			<tr><th>글쓴이</th><td><input type="text" name="writer" readonly value="${board.writer}"></td></tr>
			<tr><th>비밀번호</th><td><input type="text" name="pwd" readonly value="${board.pwd}"></td></tr>			
			<tr><th>작성일</th><td><input type="text" name="date" readonly value="${board.date}"></td></tr>			
			<tr><th>제목</th><td><input type="text" name="sub" readonly value="${board.sub}"></td></tr>
			<tr><th>내용</th><td><input type="text" name="content" value="${board.content}"></td></tr>
		</table><br>
		<input type="submit" class="btn btn-default" name="submit" value="수정 완료">
		<input type="reset" name="reset" value="다시 작성">
		</form>
	</div>
</body>
</html>