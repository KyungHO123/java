<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		<form action="<c:url value='/signup'/>" method="post">
			<div class="form-group">
				<label>아이디</label>
				<input class="form-group" type="text" id="id" name="me_id"
					placeholder="아이디" required>
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input class="form-group" type="password" id="pw" name="me_pw"
					placeholder="비밀번호" required>
			</div>
			<div class="form-group">
				<label>비밀번호 확인</label>
				<input class="form-group" type="password" id="pw2 " name="pw2"
					placeholder="비밀번호 확인">
			</div>
			<div class="form-group">
				<label>이메일</label>
				<input class="form-group" type="text" id="email" name="me_email"
					placeholder="이메일" required>
			</div>
			<button type="submit" class="btn btn-secondary">회원가입</button>
		</form>
	</div>

</body>
</html>