<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail Page</h1>
	<hr>
	<form action="/brd/edit" method="post">
	<table border="1">
		<input type="hidden" name="bno" value="${bvo.bno }">
		<tr>
			<th>번호 </th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${bvo.title }"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${bvo.regdate }</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td>${bvo.moddate }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${bvo.readcount }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="30">${bvo.content }</textarea></td>
		</tr>
	</table>
	<button type="submit">수정</button>
	</form>
	<a href="/brd/remove?bno=${bvo.bno }"><button>제거</button></a>
	<a href="/index.jsp"><button type="button">처음으로</button></a>
</body>
</html>