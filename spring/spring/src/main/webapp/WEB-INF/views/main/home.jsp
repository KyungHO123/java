<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<title>스프링</title>
</head>
<body>
		<h1>메인입니다.${user}</h1>
		<a href='<c:url value="/find/pw" />'>비번찾기</a>
</body>
</html>
