<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 페이지</title>
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
								</nav>
							</div>
						</div>
					</div>
				</header>
			</div>
		</div><br><br><br><br>
<div align=center>
<c:if test="${msg=='failure'}">
	<h2>Wrong Password.</h2>
</c:if>
</div>
</div>
</body>
</html>