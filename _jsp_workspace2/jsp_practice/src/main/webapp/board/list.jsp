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
	<!-- search line -->
	<div>
	<form action="/brd/list" method="get">
		<c:set value="${ph.pgvo.type }" var="typed"></c:set>
			<select name="type">
				<option ${typed == null ? 'selected' : '' }>Choose...</option>
				<option value="t" ${typed eq 't' ? 'selected' : '' }>title</option>
				<option value="w" ${typed eq 'w' ? 'selected' : '' }>writer</option>
				<option value="c" ${typed eq 'c' ? 'selected' : '' }>content</option>
				<option value="tc" ${typed eq 'tc' ? 'selected' : '' }>title&content</option>
				<option value="wc" ${typed eq 'wc' ? 'selected' : '' }>writer&content</option>
				<option value="twc" ${typed eq 'twc' ? 'selected' : '' }>title&writer&content</option>			
			</select>
			<input type="text" name="keyword" placeholder="Search" value="${ph.pgvo.keyword }">
			<input type="hidden" name="pageNo" value="1">
			<input type="hidden" name="qty" value="${ph.pgvo.qty }">
			<button type="submit">Search</button>
			<span>${ph.totalCount }</span>
	</form>
	</div>
	
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
	
	<!-- 페이지네이션 표시 구역 -->
	<div>
		<!-- prev -->
		<c:if test="${ph.prev }">
			<a href="/brd/list?pageNo=${ph.startPage-1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"> ← | </a>
		</c:if>
		<!-- paging -->
		<c:forEach begin="${ph.startPage}" end="${ph.endPage }" var="i">
			<a href="/brd/list?pageNo=${i}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"> ${i} </a>
		</c:forEach>
		<!-- next -->
		<c:if test="${ph.next}">
			<a href="/brd/list?pageNo=${ph.endPage+1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"> | → </a>
		</c:if>
	</div>
	
	<a href="/index.jsp"><button type="button">처음으로</button></a>
	<a href="/brd/write"><button type="button">글쓰기</button></a>
		
</body>
</html>