<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="org.kpu.myapp.domain.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
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

.mar {
	margin-right: 150px;
	margin-left: 150px;
}

.pad {
	padding-right: 150px
}

.ffon {
	font-family: cursive, "맑은 고딕"
}
</style>
</head>
<body>
	<div class="ffon">
		<div align=center>

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
		</div>
		<br>
		<br>
		<br>

		<div class="container, mar">
			<h3>View Detail</h3>
			<table class="table table-list-search, pad">
				<tr>
					<td>No</td>
					<td>${board.num}</td>
				</tr>
				<tr>
					<td>Hit</td>
					<td>${board.hit}</td>
				</tr>
				<tr>
					<td>Writer</td>
					<td>${board.writer}</td>
				</tr>
				<tr>
					<td>Date</td>
					<td><fmt:formatDate value="${board.date}"
							pattern="yyyy/MM/dd KK:mm:ss" /></td>
				</tr>
				<tr>
					<td>Subject</td>
					<td>${board.sub}</td>
				</tr>
				<tr>
					<td>Content</td>
					<td>${board.content}</td>
				</tr>
			</table>
			<div align=right>
				<button type="button" class="btn btn-info"
					onClick="location.href='http://localhost:8080/myapp/board/list'">List</button>
				<button class="btn btn-primary"
					onClick="location.href='http://localhost:8080/myapp/board/modify?num=${board.num}'">Update</button>
				<button class="btn btn-warning"
					onClick="location.href='http://localhost:8080/myapp/board/delete?num=${board.num}'">Delete</button>
			</div>
		</div>
	</div>
</body>
</html>