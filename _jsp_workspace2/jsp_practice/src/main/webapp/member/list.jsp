<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<title>Member List Page</title>
</head>
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
		height: 800px;
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
	}
	.inner1{
		display: flex;
		flex-direction: row;
		justify-content: center;
		align-items: center;
	}
	</style>
<body>
<div class="body">
	<div class="title">
	<h1>Member List Page</h1>
	</div>
	<hr>
	<div class="container">
	<!-- search line -->
	<div>
	<form action="/brd/list" method="get">
	<div class="inner1">
	<c:set value="${ph.pgvo.type}" var="typed"></c:set>
	  <select name="type" class="form-select">
	  	<option ${typed==null ? 'selected' : '' }>Choose</option>
	  	<option value="t" ${typed eq 't' ? 'selected' : ''}>title</option>
	  	<option value="w" ${typed eq 'w' ? 'selected' : ''}>writer</option>
	  	<option value="c" ${typed eq 'c' ? 'selected' : ''}>content</option>
	  	<option value="tc" ${typed eq 'tc' ? 'selected' : ''}>title&content</option>
	  	<option value="tw" ${typed eq 'tw' ? 'selected' : ''}>title&writer</option>
	  	<option value="wc" ${typed eq 'wc' ? 'selected' : ''}>writer&content</option>
	  	<option value="twc" ${typed eq 't' ? 'selected' : ''}>title&writer&content</option>
	  </select>
	  <input type="text" name="keyword" placeholder="Search" value="${ph.pgvo.keyword}" class="form-select">
	  <input type="hidden" name="pageNo" value="1">
	  <input type="hidden" name="qty" value="${ph.pgvo.qty }"> 
	  <button type="submit" class="btn btn-primary position-relative">Search  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">${ph.totalCount }</span></button>
	 
	  </div>
	</form>
	</div>
	
	<hr>
	<table border="1" class="table table-dark table-hover">
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


	<a href="/index.jsp"><button type="button" class="btn btn-secondary">처음으로</button></a>
	</div>
	</div>
</body>
</html>