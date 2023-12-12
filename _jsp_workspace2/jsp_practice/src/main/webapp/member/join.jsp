<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<title>Join Page</title>
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
	<h1>Join Page</h1>
	</div>
	<hr>
	<div class="inner1">
	<div class="inner2">
	<form action="/mem/insert" method="post">
		ID : <input type="text" name="id" class="form-control"><br>
		PW : <input type="text" name="pwd" class="form-control"><br>
		E-Mail : <input type="text" name="email" class="form-control"><br>
		Age : <input type="text" name="age" class="form-control"><br>
		<button type="submit" class="btn btn-primary">등록</button>
	<a href="/index.jsp"><button type="button" class="btn btn-secondary">취소</button></a>
	</form>
	</div>
	</div>
</div>
</body>
</html>