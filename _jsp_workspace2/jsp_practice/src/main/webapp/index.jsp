<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<hr>
	<form action="/mem/login" method="post">
		ID : <input type="text" name="id">
		PW : <input type="password" name="pwd">
		<button type="submit">로그인</button>
	</form>
	<a href="/mem/join"><button type="button">회원가입</button></a>
	<c:if test="${ses.id ne null}">
		<hr>
		${ses.id }님이 로그인하셨습니다. 마지막접속 시간 : ${ses.lastlogin } 
		<a href="/mem/logout"><button type="button">로그아웃</button></a>
		<hr> 
		<a href="/brd/write"><button type="button">게시판 글쓰기</button></a>
		<a href="/brd/list"><button type="button">게시판 보기</button></a>
		<a href="/brd/mylist?id=${ses.id }"><button type="button">내가 쓴 글 보기</button></a>
		<a href="/mem/list"><button type="button">회원 정보 보기</button></a>
		<a href="/mem/detail?id=${ses.id }"><button type="button">회원 정보 수정</button></a>
	</c:if>
	
	<script type="text/javascript">
		const msg_login = `<c:out value="${msg_login}" />`;
		console.log(msg_login);
		if(msg_login == -1){
			alert('로그인 정보가 일치하지 않습니다.');
		}
	</script>
	<script type="text/javascript">
		const msg_modify = `<c:out value="${msg_modify}" />`;
		console.log(msg_modify);
		if(msg_modify == -1){
			alert('회원 정보가 수정되었습니다. 다시 로그인해주세요.');
		}
	</script>
	<script type="text/javascript">
		const msg_remove = `<c:out value="${msg_remove}" />`;
		console.log(msg_remove);
		if(msg_remove == -1){
			alert('회원 탈퇴가 정상적으로 되었습니다. 안녕히 돌아가십시오.');
		}
	</script>
</body>
</html>