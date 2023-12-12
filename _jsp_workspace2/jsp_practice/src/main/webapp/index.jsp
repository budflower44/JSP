<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<title>Insert title here</title>
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
	height: 500px;
	display: flex;
	align-items: center;
	justify-content: center;
	text-align: center;
	flex-direction: column;
}
.login{
	width: 300px;
	height: 600px;
	font-size: 20px;
}
.login inner1{
	width: 300px;
	height: 300px;
}
.login inner2{
	width: 300px;
	height: 50px;
}
.info{
	width: 500px;
	height: 150px;
}

</style>
</head>
<body>
	<div class="body">
	<div class="title">
		<h1>Hello JIBOK's Page</h1>
	</div>
	<hr>
	<div class="container">
		<c:if test="${ses.id eq null}">
		<div class="login">
		<form action="/mem/login" method="post">
					<span>ID : </span><input type="text" name="id" class="form-control"><br>
					<span>PW : </span><input type="password" name="pwd" class="form-control"><br>
					<button type="submit" class="btn btn-primary">로그인</button>
					<a href="/mem/join"><button type="button" class="btn btn-primary">회원가입</button></a>
		</form>
		</div>
		</c:if>
		<c:if test="${ses.id ne null}">
		<div class="info">
		<hr>
		${ses.id }님이 로그인하셨습니다. <br>
		마지막접속 시간 : ${ses.lastlogin } <br>
		<a href="/mem/logout"><button type="button" class="btn btn-secondary">로그아웃</button></a>
			<hr>
			<a href="/brd/write"><button type="button" class="btn btn-secondary">게시판 글쓰기</button></a>
			<a href="/brd/list"><button type="button" class="btn btn-secondary">게시판 보기</button></a>
			<a href="/brd/mylist?id=${ses.id }"><button type="button" class="btn btn-secondary">내가 쓴 글 보기</button></a><br>
			<a href="/mem/list"><button type="button" class="btn btn-secondary">회원 정보 보기</button></a>
			<a href="/mem/detail?id=${ses.id }"><button type="button" class="btn btn-secondary">회원 정보 수정</button></a>
		</div>
		</c:if>
	</div>
</div>
	<script type="text/javascript">
		const msg_login = `<c:out value="${msg_login}" />`;
		console.log(msg_login);
		if (msg_login == -1) {
			alert('로그인 정보가 일치하지 않습니다.');
		}
	</script>
	<script type="text/javascript">
		const msg_modify = `<c:out value="${msg_modify}" />`;
		console.log(msg_modify);
		if (msg_modify == -1) {
			alert('회원 정보가 수정되었습니다. 다시 로그인해주세요.');
		}
	</script>
	<script type="text/javascript">
		const msg_remove = `<c:out value="${msg_remove}" />`;
		console.log(msg_remove);
		if (msg_remove == -1) {
			alert('회원 탈퇴가 정상적으로 되었습니다. 안녕히 돌아가십시오.');
		}
	</script>
</body>
</html>