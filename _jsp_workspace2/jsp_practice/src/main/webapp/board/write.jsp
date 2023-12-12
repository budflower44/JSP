<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
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
	width: 1000px;
	height: 800px;
	display: flex;
	justify-content: center;
	align-items: center;
}

</style>
<title>글쓰기 페이지</title>
</head>
<body>
	<div class="body">
	<div class="title">
	<h1>Board Write Page</h1>
	</div>
	<hr>
	<div class="container">
	<form action="/brd/insert" method="post" enctype="multipart/form-data"><br>
		제목 : <input type="text" name="title" class="form-control"><br>
		작성자 : <input type="text" name="writer" value="${ses.id }" readonly="readonly" class="form-control"><br>
		내용 : <br>
		<textarea rows="10" cols="30" name="content" class="form-control"></textarea><br>
		첨부파일 : <input type="file" name="image_file" accept="image/png, image/jpg, image/gif, image/jpeg" class="form-control"><br>
		<button type="submit" class="btn btn-primary">등록</button>
		<a href="/brd/list"><button type="button" class="btn btn-secondary">취소</button></a>
	</form>
	</div>
	</div>
</body>
</html>