<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>

<!-- 부트스트랩5 css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div class="container">
		<h1>게시글 수정</h1>
		<form action="<c:url value="/board/update"/>" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${board.bo_num}">
			<div class="mb-3 mt-3">
				<label for="community" class="form-label">게시판 :</label> <select
					class="form-control" id="community" name="community">
					<c:forEach items="${list}" var="community">
						<option value="${community.co_num}">${community.co_name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3 mt-3">
				<label for="title" class="form-label">제목 :</label> <input
					type="text" class="form-control" id="title" placeholder="제목을 입력하세요"
					name="title" value="${board.bo_title}">
			</div>
			<div class="mb-3 mt-3">
				<label for="writer" class="form-label">작성자 :</label> <input
					type="text" class="form-control" id="writer" name="writer"
					value="${user.me_id}" readonly>
			</div>
			<div class="mb-3 mt-3">
				<label for="content" class="form-label">내용 :</label>
				<textarea rows="10" class="form-control" id="content"
					placeholder="내용을 입력하세요" name="content">${board.bo_content}</textarea>
			</div>
			<div class="mb-3 mt-3" id="attachment">
				<label for="content" class="form-label">첨부파일</label>
				<c:choose>
					<c:when test="${file != null }">
						<span class="form-control">${file.fi_ori_name}<span
							id="btnDel" data-target="${file.fi_num}">X</span></span>
					</c:when>
					<c:otherwise>
						<input type="file" name="file" class="form-control">
					</c:otherwise>
				</c:choose>
			</div>

			<button class="btn btn-outline-warning col-12">글 수정</button>
		</form>
	</div>
	<script type="text/javascript">
		let attachment = document.querySelector("#attachment");
		let btnDel = document.querySelector("#btnDel");
		btnDel.onclick = function(e) {
			e.preventDefault();
			//input hiden으로 삭제할 첨부파일 번호를 추가
			let num = this.getAttribute("data-target");
			alert(num);
			let str = `<input type="hidden" name="fi_num" value="\${num}">`
			attachment.innerHTML +=str;
			//span태그를 삭제
			let span = attachment.querySelector("span.form-control")
			attachment.remobeChild(span);
			let input =`<input type="file" name="file" class="form-control">`
				attachment.innerHTML += input;
		}
	</script>
</body>
</html>