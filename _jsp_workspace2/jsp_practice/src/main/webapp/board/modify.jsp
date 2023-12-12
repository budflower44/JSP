<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>Detail Page</h1>
	<hr>
		<br>
	<img alt="" src="/_fileUpload/${bvo.imageFile }">
	<form action="/brd/edit" method="post" enctype="multipart/form-data">
	<input type="hidden" name="bno" value="${bvo.bno }">
	<table border="1">
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
			<th>이미지</th>
			<td>
				<input type="hidden" name="image_file" value="${bvo.imageFile }">
				<input type="file" name="new_file" accept="image/png, image/jpg, image/gif, image/jpeg">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="30">${bvo.content }</textarea></td>
		</tr>
	</table>
	<a href="/brd/modify?bno=${bvo.bno }"><button type="submit" class="btn byn-outline-primary">수정</button></a>
	<a href="/brd/remove?bno=${bvo.bno }"><button>제거</button></a>
	</form>
	<a href="/brd/list"><button type="button">리스트로..</button></a>
</body>
</html>