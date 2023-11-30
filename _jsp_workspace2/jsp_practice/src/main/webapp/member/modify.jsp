<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Detail Page</title>
</head>
<body>
	<h1>Member Detail Page</h1>
	<hr>
	<form action="/mem/modify" method="post">
	<input type="hidden" name="id" value="${mvo.id }">
		ID : ${mvo.id }<br>
		PW : <input type="text" name="pwd" value="${mvo.pwd }"><br>
		E-Mail : <input type="text" name="email" value="${mvo.email }"><br>
		Age : <input type="text" name="age" value="${mvo.age }"><br>
		Regdate : ${mvo.regdate }<br>
		Lastlogin : ${mvo.lastlogin }<br>
		<button type="submit">수정</button>
	</form>
	<a href="/index.jsp"><button type="button">처음으로</button></a>
	<a href="/mem/remove?id=${mvo.id }"><button>회원탈퇴</button></a>
</body>
</html>