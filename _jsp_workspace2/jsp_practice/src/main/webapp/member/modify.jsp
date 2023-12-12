<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<title>Member Detail Page</title>
</head>
<style>
	body{
		margin: 0;
		padding: 0;
	}
	.body {
		width: 100vw;
		height: 100vh;
		background-color: rgba(30, 30, 30, 0.928);
		background-image: linear-gradient(rgba(0, 0, 0, 0.327), rgba(0, 0, 0, 0.3)), url(../image/tokyo.jpg);
		background-repeat: no-repeat;
		background-size: 100vw;
		color: white;
	}
	.title {
		width: 100vw;
		height: 60px;
		text-align: center;
		background-color: transparent;
	}
	.container{
		width: 100vw;
		height: 800px;
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
	}
	.inner1{
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
	}
	</style>
<body>
<div class="body">
	<div class="title">
	<h1>Member Detail Page</h1>
	</div>
	<hr>
	<form action="/mem/modify" method="post">
	<div class="inner1">
	<div class="inner2">
		<input type="hidden" name="id" value="${mvo.id }" class="form-control">
		ID : ${mvo.id }<br>
		PW : <input type="text" name="pwd" value="${mvo.pwd }" class="form-control"><br>
		E-Mail : <input type="text" name="email" value="${mvo.email }" class="form-control"><br>
		Age : <input type="text" name="age" value="${mvo.age }" class="form-control"><br>
		Regdate : ${mvo.regdate }<br>
		Lastlogin : ${mvo.lastlogin }<br>
		<button type="submit" class="btn btn-primary">수정</button>
		<a href="/mem/remove?id=${mvo.id }"><button type="button" class="btn btn-danger">회원탈퇴</button></a><br>
	</form>
	<a href="/index.jsp"><button type="button" class="btn btn-secondary">처음으로</button></a>
	</div>
	</div>
	</div>
</body>
</html>