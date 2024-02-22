<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<!-- id와 pw를 입력받아 서버로 전송하는 코드를 작성. get과 post 중에 선태갷서 방식으로 전송 -->
	<form action="<%=request.getContextPath()%>/signup" method="post">
		<input type="text" name="id" placeholder="아이디를 입력하세요"> <br>
		<input type="password" name="pw" placeholder="비번을 입력하세요"> <br>
		<input type="password" name="pwc" placeholder="비번확인"> <br>
		<input type="email" name="email" placeholder="이메일을 입력하세요"> <br>
		<button>회원가입</button>
	</form>

</body>
</html>