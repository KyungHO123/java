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
		<h1>게시글 등록</h1>
		<form action="<c:url value='/post/insert'/>" method="post">
			<div class="form-group">
				<label>제목</label>
				<input class="form-control" type="text" id="title" name="bo_title"
					placeholder="아이디" required>
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea rows="15" class="form-control" type="password" id="content" name="bo_content"
					placeholder="비밀번호" required></textarea>
			</div>
			 
			<button type="submit" class="btn btn-outline-success">게시글 등록</button>
		</form>
	</div>

</body>
</html>