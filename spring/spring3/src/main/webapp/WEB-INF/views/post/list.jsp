<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>게시글 목록</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="post" varStatus="vs">
					<tr>
						<!-- 1부터 순차적으로 증가함 
					 		오토 인크리먼트로 인해 
					 		중간에 숫자가 빠지는 현상이 사라짐
					 		 -->
						<td>${pm.totalCount - vs.index - pm.cri.pageStart}</td>
						<td><a href="#">${post.bo_title }</a></td>
						<td>${post.bo_me_id }</td>
						<td>${post.bo_view }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<ul class="pagination">
				<c:if test="${pm.prev}">
					 <li class="page-item">
							<c:url var="url" value="/post/list">
						 			<c:param name="page" value="${pm.startPage - 1 }"/>
						 	</c:url>
							<a class="page-link" href="${url}">이전</a></li>
				 </c:if>
				 <c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
				 			<c:set var="active" value="${pm.cri.page == i ?'active':'' }" />
		 					<li class="page-item ${active }">
					 		 		<c:url var="url" value="/post/list">
							 				<c:param name="page" value="${i }"/>
						 			</c:url>
									<a class="page-link" href="${url }">${i}</a>
							</li>
				 </c:forEach>
				 <c:if test="${pm.next}">
						 <li class="page-item">
						 		<c:url var="url" value="/post/list">
							 			<c:param name="page" value="${pm.endPage + 1 }"/>
						 		</c:url>
						 		<a class="page-link" href="${url}">다음</a>
			 			 </li>
		 			</c:if>
		</ul>
	</div>

</body>
</html>