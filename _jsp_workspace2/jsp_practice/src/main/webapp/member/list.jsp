<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List Page</title>
</head>
<body>
	<h1>Member List Page</h1>
	<hr>
	<!-- search line -->
	<div>
	<form action="/brd/list" method="get">
	<c:set value="${ph.pgvo.type}" var="typed"></c:set>
	  <select name="type">
	  	<option ${typed==null ? 'selected' : '' }>Choose</option>
	  	<option value="t" ${typed eq 't' ? 'selected' : ''}>title</option>
	  	<option value="w" ${typed eq 'w' ? 'selected' : ''}>writer</option>
	  	<option value="c" ${typed eq 'c' ? 'selected' : ''}>content</option>
	  	<option value="tc" ${typed eq 'tc' ? 'selected' : ''}>title&content</option>
	  	<option value="tw" ${typed eq 'tw' ? 'selected' : ''}>title&writer</option>
	  	<option value="wc" ${typed eq 'wc' ? 'selected' : ''}>writer&content</option>
	  	<option value="twc" ${typed eq 't' ? 'selected' : ''}>title&writer&content</option>
	  </select>
	  <input type="text" name="keyword" placeholder="Search" value="${ph.pgvo.keyword}">
	  <input type="hidden" name="pageNo" value="1">
	  <input type="hidden" name="qty" value="${ph.pgvo.qty }"> 
	  <button type="submit">Search</button>
	  <span>${ph.totalCount }</span>
	</form>
	</div>
	
	<hr>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>E-mail</th>
			<th>Age</th>
			<th>Regdate</th>
			<th>Lastlogin</th>
		</tr>
		<c:forEach items="${list }" var="mvo">
			<tr>
				<td>${mvo.id }</td>
				<td>${mvo.email }</td>
				<td>${mvo.age }</td>
				<td>${mvo.regdate }</td>
				<td>${mvo.lastlogin }</td>
			</tr>
		</c:forEach>
	</table>


	<a href="/index.jsp"><button type="button">처음으로</button></a>
</body>
</html>