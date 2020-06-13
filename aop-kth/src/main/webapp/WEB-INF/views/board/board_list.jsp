<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
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

									<div class="collapse navbar-collapse"
										id="navbarSupportedContent">
										<ul class="navbar-nav ml-auto mr-3">
											<li class="nav-item active"><c:url value="/board/write"
													var="url" /><a class="nav-link text-uppercase"
												href="${url}">Write <span class="sr-only">(current)</span></a></li>
										</ul>
									</div>
								</nav>
							</div>
						</div>
					</div>
				</header>
			</div>
		</div>
	</div>
	<br>
	<br>

	<div class="container">
		<br>
		<br>

		<table class="table table-list-search">
			<tr>
				<th>No</th>
				<th>Subject</th>
				<th>Writer</th>
				<th>Date</th>
				<th>Hit</th>
				<th></th>
			</tr>
			<c:forEach var="board" items="${boards}">
				<tr>
					<td><c:out value="${board.num}" /></td>
					<td><c:out value="${board.sub}" /></td>
					<td><c:out value="${board.writer}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.date}"/></td>
					<td><c:out value="${board.hit}" /></td>
					<td><c:url value="/board/read?num=${board.num}" var="url" /><a
						href="${url}">View Detail</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>