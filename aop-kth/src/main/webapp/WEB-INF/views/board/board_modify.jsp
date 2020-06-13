<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
.top {
	background-color: rgb(0, 0, 0)
}
.ffon{font-family:cursive, "맑은 고딕"}

</style>
</head>
<body>
<div class="ffon">
	<div class="container me">
		<div class="row">
			<header>
				<div id="topbar" class="fixed-top clearHeader, top">
					<div class="container">
						<div class="col-sm-12">
							<nav class="navbar navbar-expand-lg navbar-dark">
								<a class="navbar-brand"
									href="http://localhost:8080/myapp/board/list" target="_self">Whatever</a>
								<button class="navbar-toggler" type="button"
									data-toggle="collapse" data-target="#navbarSupportedContent"
									aria-controls="navbarSupportedContent" aria-expanded="false"
									aria-label="Toggle navigation">
									<span class="navbar-toggler-icon"></span>
								</button>
							</nav>
						</div>
					</div>
				</div>
			</header>
		</div>
	</div>
	<br>
	<br>
	<br>
<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<form action="http://localhost:8080/myapp/board/modify" method="post">
			<div align=left>
				
					<label for="num">No: </label>
					<label>${board.num}</label>
					<input type="hidden" name="num" value="${board.num}">
				</div>
			<div align=left>
					<label for="hit">Hit: </label>
					<label>${board.hit}</label>
			</div>	
			<div align=left>
					<label for="writer">Writer: </label>
					<label>${board.writer}</label>
			</div>
			<div align=left>
					<label for="pwd">Password: </label>
					<label>${board.pwd}</label>
			</div>
			<div align=left>
					<label for="date">Date: </label>
					<fmt:formatDate value="${board.date}" pattern="yyyy/MM/dd KK:mm:ss" />
			</div>
			<div align=left>	
					<label for="sub">Subject</label>
					<input type="text" name="sub" class="form-control" value="${board.sub}" style="width:600px">
			</div>
			<div align=left>
					<label for="content">Content</label>
					<textarea name="content" class="form-control" rows="4" cols="60" style="width:600px"
						 placeholder="공백없이 입력하세요">${board.content}</textarea>
			</div>
				
			<br>
			<div class="form-check" align=center>
				<button type="submit" name="submit" class="btn btn-primary">Complete</button>	
				<button type="reset" name="reset" class="btn btn-warning">Reset</button>
				<button type="button" class="btn btn-info" onClick="location.href='http://localhost:8080/myapp/board/list'">List</button>
			</div>
		</form>
		</div>
	</div>
</div>
</div>
</body>
</html>