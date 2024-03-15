<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- jquery validation -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>


<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<title>스프링 - 게시글등록</title>

</head>
<body>
	<form action='<c:url value="/board/insert"/>' method="post" enctype="multipart/form-data">
		<h1>게시글 등록</h1>
		<div class="form-group">
			<label for="co_name">게시판</label> <select name="bo_co_num"
				class="form-control">
				<c:forEach items="${list}" var="co">
					<option value="${co.co_num}">${co.co_name}</option>
				</c:forEach>

			</select>
		</div>
		<div class="form-group">
			<label for="bo_title">제목</label> <input type="text"
				class="form-control" id="bo_title" name="bo_title">
		</div>
		<div class="form-group">
			<label for="bo_content">내용</label>
			<textarea class="form-control" id="bo_content" name="bo_content"></textarea>
		</div>
		<div class="form-group">
			<label>첨부파일(최대 3개)</label>
			<input type="file" class="form-control" name="file">
			<input type="file" class="form-control" name="file">
			<input type="file" class="form-control" name="file">
		</div>
		<button class="btn btn-outline-success col-12">게시글 등록</button>
	</form>
	<script type="text/javascript">
		$("form").submit(function() {
			let title = $("[name=bo_title]").val();
			if (title.length == 0) {
				$("[name=bo_title]").focus();
				return false;
			}// if end;
			let content = $("[name=bo_content]").val();
			if (content.length == 0) {
				alert("내용은 1글자 이상 입력해야 합니다.");
				$("[name=bo_content]").focus();
				return false;

			}// if end;

		}); //function end;
	</script>
	
	  <script>
    $('[name=bo_content]').summernote({ 
    	placeholder: '내용을 입력하세요',
    	tansize:2,
    	height: 400
    
    });
  </script>

</body>
</html>