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
		<h1>게시글 상세페이지</h1>
		<div class="form-group">
			<label >게시판</label>
		<input type="text" class="form-control" value="${board.bo_co_num}" readonly="readonly" name="co_num">
		</div>
		<div class="form-group">
			<label>제목</label>
			<input class="form-control" type="text" id="title" value="${board.bo_title }"  readonly="readonly">
		</div>
		<div class="form-group">
			<label>조회수</label>
			<input class="form-control" type="text" id="title" value="${board.bo_view}"  readonly="readonly">
		</div>
		<div class="form-group">
			<label>작성자</label>
			<input class="form-control" type="text" id="title" value="${board.bo_me_id}"  readonly="readonly">
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea rows="15" class="form-control"  id="content" readonly="readonly">${board.bo_content }</textarea>
		</div>
		 <div class="form-group">	
		 	<c:forEach items="${list}" var="file">		
		 			<c:if test="${file.img}">
		 					<a href="<c:url value="/download${file.fi_name}"/>" download="${file.fi_ori_name }">${file.fi_ori_name }
		 						<img height="100" alt="이미지" src="<c:url  value='/download${file.fi_name }'/>">
	 						</a>
		 			</c:if>
		 			<c:if test="${!file.img }">
				 			<a href="<c:url value="/download${file.fi_name}"/>" download="${file.fi_ori_name }">${file.fi_ori_name }</a>
		 			</c:if>
		 	</c:forEach>
		 </div>
	<a href="<c:url value="/post/list"/>"  class="btn btn-outline-success">목록으로</a>
	</div>
</body>
</html>