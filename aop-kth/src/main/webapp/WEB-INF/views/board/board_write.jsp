<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Write</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div align=center>
	<header><h1>글쓰기</h1></header><hr>
	<div class="myform form ">
	<form action = "http://localhost:8080/myapp/board/write" method="post">
	<table>	
		<tr><th>제목</th><td><input type="text" name="sub" class="form-control" autofocus placeholder="공백없이 입력하세요"></td></tr>
		<tr><th>작성자</th><td><input type="text" name="writer" class="form-control" placeholder="공백없이 입력하세요"></td></tr>
		<tr><th>비밀번호</th><td><input type="text" name="pwd" class="form-control" placeholder="공백없이 입력하세요"></td></tr>
		<tr><th>내용</th><td><input type="text" name="content" class="form-control" style="width:200px; height:100px" placeholder="공백없이 입력하세요"></td></tr>
	</table>
	<dl>
		<div class="text-center">
		<dd><button type="submit" class=" btn btn-block send-button tx-tfm">등록</dd>
		</div>
		<dd><input type="reset" name="reset" value="초기화"></dd>
		<dd><input type="button" onClick="javascript:history.go(-1)" value="목록"></dd>
	</dl>
	</form>
	</div>
</div>
</body>
</html>