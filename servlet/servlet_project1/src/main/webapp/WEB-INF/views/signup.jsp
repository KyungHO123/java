<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<h1>회원가입</h1>
	<!-- 아이디, 비번, 비번확인, 이메일을 입력받아 서버로 전송하는 코드 get과 post 중에 선택해서 전송 -->
	<form action="<%=request.getContextPath()%>" method="post">
		<div class="mb-3 mt-3">
		    <label for="id" class="form-label">아이디:</label>
		    <input type="text" class="form-control" id="id" placeholder="아이디" name="id">
	  	</div>
	  	<div class="mb-3 mt-3">
		    <button type="button" id="idCheck" class="btn btn-outline-success col-12">아이디 중복 검사</button>
	  	</div>
	  	<div class="mb-3 mt-3">
		    <label for="pw" class="form-label">비번:</label>
		    <input type="password" class="form-control" id="pw" placeholder="비번" name="pw">
	  	</div>
		<div class="mb-3 mt-3">
		    <label for="pw2" class="form-label">비번확인:</label>
		    <input type="password" class="form-control" id="pw2" placeholder="비번확인" name="pw2">
	  	</div>
		<div class="mb-3 mt-3">
		    <label for="email" class="form-label">이메일:</label>
		    <input type="text" class="form-control" id="email" placeholder="이메일" name="email">
	  	</div>
		<button class="btn btn-outline-success col-12">회원가입</button>
	</form>
</div>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript">
	let flag = false;
	$("#idCheck").click(function(){
		let id = $("[name=id]").val();
		fetch(`<c:url value="/id/check"/>?id=\${id}`)
		.then(response=>response.text())
		.then(data => {
			if(data == "true"){
				alert("사용 가능한 아이디입니다.");
				flag = true;
			}else{
				alert("이미 사용 중인 아이디입니다.");
			}
		})
		.catch(error => console.error("Error : ", error));
	});
	$("[name=id]").change(function(){
		flag = false;
	});
	$("form").submit(function(){
		//정규표현식을 구현 
		
		if(!flag){
			alert("아이디 중복 확인을 하세요.");
			return false;
		}
	});
</script>
</body>
</html>