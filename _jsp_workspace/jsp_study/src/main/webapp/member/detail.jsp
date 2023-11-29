<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Detail Page</h1>
	<form action="/memb/modify" method="post">
	<table border="1">
		<input type="hidden" name="id" value="${ses.id }">
		<tr>
			<th>ID</th>
			<td>${ses.id }</td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" name="pwd" value="${ses.pwd }"></td>
		</tr>
		<tr>
			<th>Email</th>
			<td><input type="text" name="email" value="${ses.email }"></td>
		</tr>
		<tr>
			<th>Age</th>
			<td><input type="text" name="age" value="${ses.age }"></td>
		</tr>
	</table>
	<button type="submit">modify</button>
</form>
	<a href="/index.jsp"><button>돌아가기</button></a>
	<a href="/memb/remove"><button type="button">회원탈퇴</button></a>
</body>
</html>