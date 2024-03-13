<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>스프링</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href='<c:url value="/"/>'>Logo</a>
		<ul class="navbar-nav">
		<c:if test="${user == null}">
			<li class="nav-item">
				<a class="nav-link" href='<c:url value="/signup"/>'>회원가입</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href='<c:url value="/login"/>'>로그인</a>
			</li>
		</c:if>
		</ul>
	</nav>
	<div class="container">
		<h1>메인입니다.${user}</h1>
	</div>
</body>
</html>
