<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<title>Detail Page</title>
</head>
<style>
	body{
		margin: 0;
		padding: 0;
		background-color: black;
	}
	.body {
		width: 100vw;
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
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
	}
	.inner1{
		width: 100vw;
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
	}
</style>
<body>
<div class="body">
	<div class="title">
	<h1>Detail Page</h1>
	</div>
	<hr>
	<div class="inner1">
	<div class="inner2">
	<div>
	<img alt="" src="/_fileUpload/${bvo.imageFile }">
	</div>
	<table border="1" class="table table-dark table-hover">
		<tr>
			<th>번호 </th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${bvo.title }</td>
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
			<td>${bvo.content }</td>
		</tr>
	</table>
	<c:if test="${bvo.writer eq ses.id }">
	<a href="/brd/modify?bno=${bvo.bno }"><button class="btn btn-primary">수정</button></a>
	<a href="/brd/remove?bno=${bvo.bno }"><button class="btn btn-danger">삭제</button></a>
	</c:if>
	<a href="/brd/list"><button class="btn btn-secondary">리스트로 가기</button></a>
	
	<!-- comment line -->
	<hr>
	<div>
		Comment line <br>
		<input type="text" id="cmtWriter" value="${ses.id }" readonly="readonly" class="form-control"><br>
		<input type="text" id="cmtText" placeholder="Add Comment..." class="form-control">
		<button type="button" id="cmtAddBtn" class="btn btn-primary">댓글등록</button>
	</div>
	<br>
	<hr>
	
	<!-- 댓글 표시 라인 -->
	<div id="commentLine">
	<div>
		<div>cno, bno, writer, regdate</div>
		<div>
			<button class="btn btn-primary">수정</button> <button class="btn btn-danger">삭제</button>
			<input value="content" class="form-control">
		</div>
	</div>
	</div>
	</div>
	</div>
</div>	
	<script type="text/javascript">
		const bnoVal = `<c:out value="${bvo.bno}" />`;
		const id = `<c:out value="${ses.id}" />`;
		console.log(bnoVal)
	</script>
	
	<script src="/resources/board_detail.js"></script>
	
	<script type="text/javascript">
		printCommentList(bnoVal);
	</script>
	
</body>
</html>