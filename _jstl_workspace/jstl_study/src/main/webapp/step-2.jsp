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
	상품명: ${param.name } <br> 
	원산지 : ${param.address }
	<br>
	<hr>
	1. 스클립틀릿 방식으로 파라미터 전달받기<br>
	<%= request.getParameter("name") %><br>
	<%= request.getParameter("address") %><br>
	
	<hr>
	<br>
	
	2. EL 방식으로 파라미터 전달받기 <br>
	${param.name }<br>
	${param.address }<br>
	
	<form action="step-3.jsp">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<button type="submit">전송</button>
	</form>
	
</body>
</html>