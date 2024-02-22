<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/>">Lost
				Ark</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/signup">회원가입</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/login">로그인</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<!-- id와 pw를 입력받아 서버로 전송하는 코드를 작성. get과 post 중에 선태갷서 방식으로 전송 -->
		<h1>회원가입</h1>

		<form action="<%=request.getContextPath()%>/signup" method="post">
			<div class="mb-3 mt-3">
				<label for="id" class="form-label">아이디:</label> <input type="text"
					class="form-control" id="id" placeholder="아이디" name="id">
			</div>
			<div class="mb-3 mt-3">
				<label for="pw" class="form-label">비밀번호:</label> <input type="text"
					class="form-control" id="pw" placeholder="비밀번호" name="pw">
			</div>
			<div class="mb-3 mt-3">
				<label for="pwc" class="form-label">비밀번호 확인:</label> <input
					type="password" class="form-control" id="pwc" placeholder="비밀번호 확인"
					name="pwc">
			</div>
			<div class="mb-3 mt-3">
				<label for="email" class="form-label">이메일:</label> <input
					type="email" class="form-control" id="email" placeholder="이메일"
					name="email">
			</div>
			<button class="btn btn-outline-success col-12">회원가입</button>
		</form>
	</div>

</body>
</html>