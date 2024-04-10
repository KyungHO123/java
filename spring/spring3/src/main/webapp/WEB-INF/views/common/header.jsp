<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand/logo -->
		<a class="navbar-brand" href="<c:url value='/' />"> <img
			src="<c:url value='/resources/img/maple.jpg'  />" alt="logo" style="width: 140px;">
		</a>

		<!-- Links -->
		<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="<c:url value='/post/list'/>">게시글 목록 조회</a>
				</li>
			<c:if test="${user == null }">
				<li class="nav-item">
					<a class="nav-link" href="<c:url value='/signup'/>">회원가입</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<c:url value='/login'/>">로그인</a>
				</li>
			</c:if>
			<c:if test="${user != null }">
				<li class="nav-item">
					<a class="nav-link" href="<c:url value='/logout'/>">로그아웃</a>
				</li>
			</c:if>
			
		</ul>
	</nav>

</body>
</html>