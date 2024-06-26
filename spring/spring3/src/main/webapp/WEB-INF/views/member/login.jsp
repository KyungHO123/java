<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="container">
		<h1>로그인</h1>
		<form action="<c:url value='/login'/>" method="post">
			<div class="form-group">
				<label>아이디</label>
				 <input class="form-control" type="text" id="id" name="me_id" placeholder="아이디" required>
			</div>
			<div class="form-group">
				<label>비밀번호</label> 
				<input class="form-control" type="password" id="pw" name="me_pw" placeholder="비밀번호" required>
			</div>
			<button type="submit" class="btn btn-outline-success ">로그인</button>
		</form>
	</div>
</body>
</html>