<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
</head>
<body>
	<h1>Join Page</h1>
	<hr>
	<form action="/mem/insert" method="post">
		ID : <input type="text" name="id"><br>
		PW : <input type="text" name="pwd"><br>
		E-Mail : <input type="text" name="email"><br>
		Age : <input type="text" name="age"><br>
		<button type="submit">등록</button>
	</form>
	<a href="/index.jsp"><button type="button">취소</button></a>
</body>
</html>