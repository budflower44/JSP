<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list Page</title>
</head>
<body>
	<h1>List Page</h1>
	<hr>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>수정일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list }" var="bvo">
			<tr>
				<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.bno }</a></td>
				<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
				<td>${bvo.writer }</td>
				<td>${bvo.moddate }</td>
				<td>${bvo.readcount }</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="/index.jsp"><button type="button">처음으로</button></a>
	<a href="/brd/write"><button type="button">글쓰기</button></a>
		
</body>
</html>