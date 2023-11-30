<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>
</head>
<body>
	<h1>Board Write Page</h1>
	<hr>
	<form action="/brd/insert" method="post">
		제목 : <input type="text" name="title"><br>
		작성자 : <input type="text" name="writer" value="${ses.id }" readonly="readonly"><br>
		내용 : <br>
		<textarea rows="30" cols="100" name="content"></textarea><br>
		<button type="submit">등록</button>
	</form>
	<a href="/brd/list"><button type="button">취소</button></a>
</body>
</html>