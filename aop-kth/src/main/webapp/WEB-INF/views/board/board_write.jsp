<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Write</title>
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
.mar{left-margin:150px}
.ffon{font-family:cursive, "맑은 고딕"}
</style>
</head>
<body>
	<div align=center class="ffon">

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
		
		<div class="container">
		<br><br><br><br>
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<form action="http://localhost:8080/myapp/board/write" method="post">
						
						<div  align=left>
							<label for="sub">Subject</label>
							<input type="text" name="sub" class="form-control" size=80 style="width:600px"
								autofocus placeholder="Please enter without spaces">
						</div>
						<div align=left>
							<label for="sub" >Writer</label>
							<input type="text" name="writer" class="form-control" style="width:600px"
								placeholder="Please enter without spaces">
						</div>
						<div align=left>
							<label for="passwd" >Password</label>
							<input type="text" name="pwd" class="form-control" style="width:600px;"
								placeholder="Please enter without spaces">
						</div>
						<div align=left>
							<label for="content" >Content</label><br>
							<textarea name="content" class="form-control" rows="4" cols="60"
								style="width:600px; height:200px;" >Please enter without spaces</textarea><br><br>
						</div>
						
					<div class="form-check" align=center>
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button class="btn btn-warning" type="reset" name="reset">Reset</button>
                        <button type="button" class="btn btn-info" onClick="javascript:history.go(-1)">List</button>
                      </div>
				</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>