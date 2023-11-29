<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 메뉴판을 체크박스형태로 만들어 step-6.jsp로 전송 -->
	<!-- step-6.jsp에서 주문자명 어떤 메뉴를 주문했는지 출력 (번호 포함) -->
	<form action="step-6.jsp" method="post">
		주문자명 : <input type="text" name="customer"><br>
		<input type="checkbox" name="menu" value="김치찌개">김치찌개<br>
		<input type="checkbox" name="menu" value="된장찌개">된장찌개<br>
		<input type="checkbox" name="menu" value="백반">백반<br>
		<input type="checkbox" name="menu" value="계란말이">계란말이<br>
		<input type="checkbox" name="menu" value="샐러드">샐러드<br>
		<input type="checkbox" name="menu" value="주먹밥">주먹밥<br>
		<button type="submit">주문</button>
	</form>
	
</body>
</html>