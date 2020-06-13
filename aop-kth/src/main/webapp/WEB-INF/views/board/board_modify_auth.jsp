<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>권한 확인(수정)</title>

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
	
	<div class="container" >
		
		<form role="form" class="form-horizontal"
			action="http://localhost:8080/myapp/board/modifyAuth" method="post">
				<div class="col-sm-10" >
				<h3>Verification</h3><br>
				</div>
				<div class="form-inline form-group">
					
					
					<div class="col-sm-2">
						<label class=" control-label">Password:</label> </div>
					<div class="col-sm-2">
						<span><input
							type="password" style="width: 300px" class="form-control"
							name="pwd" required placeholder="Please enter without spaces"></span>
					</div>
						<input type="hidden" name="num" value="${board.num}">
				</div>
			
			<br>
			<div class="col-sm-10" align="center">
				<fieldset>
					<button type="button" class="btn btn-danger pull-right" name="취소"
						onClick="javascript:history.go(-1)">Cancel</button>
					<button type="submit" class="btn btn-success pull-right"
						name="submit">Complete</button>
				</fieldset>
			</div>
		</form>
	</div>
</div>
</body>
</html>