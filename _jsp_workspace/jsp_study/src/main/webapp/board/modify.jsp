<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Modify Page</h1>
	<hr>
	<br>
	<img alt="" src="/_fileUpload/${bvo.imageFile }">
	<form action="/brd/edit" method="post" enctype="multipart/form-data">
	<input type="hidden" name="bno" value="${bvo.bno }">
	<table border="1" class="table">
		<tr>
			<th>bno</th>
			<%-- <td><input type="text" name="bno" value="${bvo.bno }" readonly="readonly"></td> --%>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>title</th>
			<td><input type="text" name="title" value="${bvo.content }"></td>
		</tr>
		<tr>
			<th>writer</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>regdate</th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>moddate</th>
			<td>${bvo.moddate }</td>
		</tr>
		<tr>
			<th>readcount</th>
			<td>${bvo.readCount }</td>
		</tr>
		<tr>
			<th>content</th>
			<td><textarea rows="10" cols="30" name="content">${bvo.content }</textarea></td>
		</tr>
		<tr>
			<th>image_file</th>
			<td>
				<input type="hidden" name="image_file" value="${bvo.imageFile }">
				<input type="file" name="new_file" accept="image/png, image/jpg, image.gif, imape/jpeg">
			</td>
		</tr>
	</table>
	
	<a href="/brd/modify?bno=${bvo.bno }"><button type="submit" class="btn btn-outline-primary">modify</button></a>
	<a href="/brd/remove?bno=${bvo.bno }"><button>remove</button></a>
	<a href="/brd/list"><button>list</button></a>
	
	</form>
	<hr>
	


</body>
</html>