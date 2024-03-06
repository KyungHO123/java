<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div class="container">
		<form action="<c:url value="/board/update" />" method="post" enctype="multipart/form-data">
			<h1>게시글 수정</h1>
			<input type="hidden" name="num" value="${board.bo_num }">
			<div class="mb-3 mt-3">
				<label for="community" class="form-label">게시판:</label> <select
					class="form-control" id="community" name="community">
					<c:forEach items="${list}" var="community">
						<option value="${community.co_num }">${community.co_name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3 mt-3">
				<label for="title" class="form-label">제목:</label> <input type="text"
					class="form-control" id="title" placeholder="제목" name="title"
					value="${board.bo_title}">
			</div>
			<div class="mb-3 mt-3">
				<label for="writer" class="form-label">작성자:</label> <input
					type="text" class="form-control" id="writer" name="writer"
					value="${user.me_id}" readonly>
			</div>
			<div class="mb-3 mt-3">
				<label for="content" class="form-label">내용:</label>
				<textarea rows="10" class="form-control" id="content" name="content"
					placeholder="내용">${board.bo_content }</textarea>
			</div>
			<div class="mb-3 mt-3" id="attachment">
				<label class="form-label">첨부파일:</label>
				<!-- 첨부파일을 출력할 forEach -->
				<c:forEach items="${fileList}" var="file">
					<span class="form-control">
					${file.fi_ori_name}
					<a href="" class="btn-del" data-target="${file.fi_num}">&times;</a>
					</span>
				</c:forEach>
				<!-- 남은 첨부파일 자리에 출력할 input태그 forEach -->
				<c:forEach begin="1" end="${3 - fileList.size()}">
					<input type="file" name="file" class="form-control">
				</c:forEach>
			</div>
			<button class="btn btn-outline-warning col-12">수정 하기</button>
		</form>
	</div>
	<script src="//code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
		$(".btn-del").click(function(e){
			e.preventDefault();
			//X버튼의 data-target값을 가져옴
			let fi_num = $(this).data("target");
			
			//input file을 추가
			let str = '<input type="file" class="form-control" name="file">';
			$("#attachment").append(str);
			//input hidden을 추가. 삭제하려는 첨부 파일을 번호를 이용하여 
			let inputHidden = `<input type="hidden" name="fi_num" value="\${fi_num}">`;
			$("#attachment").prepend(inputHidden);
			//클릭한 X버튼이 있는 첨부파일을 삭제
			$(this).parent().remove();
		});
			
	
	</script>

</body>
</html>