<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />

	<div class="container">
		<h1>게시글 리스트</h1>
		<table class="table table-white table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>게시판</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board">
					<tr>
						<td>${board.bo_num }</td>
						<td>${board.community.co_name}</td>

						<td><c:url var="url" value="/board/detail">
								<c:param name="num" value="${board.bo_num}" />
							</c:url> <a href="${url }">${board.bo_title}</a></td>
						<td><c:url var="page" value="/board/list">
								<c:param name="type" value="writer" />
								<c:param name="search" value="${board.bo_me_id}" />
								<c:param name="page" value="1" />
							</c:url> <a href="${page}"> ${board.bo_me_id}</a></td>
						<td>${board.bo_view }</td>
					</tr>
				</c:forEach>
				<c:if test="${list.size() == 0 }">
					<tr>
						<th colspan="5">
							<h3 class="text-center">등록된 게시글이 없습니다.</h3>
						</th>
					</tr>
				</c:if>
			</tbody>
		</table>
		<a href="<c:url value="/board/insert"/>"
			class="btn btn-outline-danger">게시글등록</a>
	</div>
</body>
</html>