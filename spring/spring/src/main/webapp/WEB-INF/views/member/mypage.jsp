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
<style type="text/css">
.box-pw{
	
	background: gray; position: fixed; top:0; left:0;bottom:0;right:0;
	width:550px; height: 200px; padding: 50px;display:none;
	margin:auto;
}
</style>
<title>스프링 - 마이페이지</title>
</head>
<body>
<form action='<c:url value="/mypage"/>' method="post">
<h1>내정보</h1>
	<div class="form-group">
		<label for="id">아이디:</label> 
		<input type="text" class="form-control" id="id" name="me_id" value="${user.me_id}" readonly="readonly"> 
		<label id="id-error" class="error text-danger" for="id"></label> 
		<label id="id-error2" class="error text-danger" for="id"></label>
	</div>
	<div class="form-group">
		<label for="pw">비번</label> 
		<input type="password" class="form-control" id="pw" name="me_pw"> 
		<label id="pw-error" class="error text-danger" for="pw"></label>
	</div>
	<div class="form-group">
		<label for="pw2">비번확인</label> 
		<input type="password" class="form-control" id="pw2" name="me_pw2">
		<label id="pw2-error" class="error text-danger" for="pw2"></label>
	</div>
	<div class="form-group">
		<label for="email">이메일</label> 
		<input type="text" class="form-control" id="email" name="me_email" value="${user.me_email}"> 
		<label id="email-error" class="error text-danger" for="email"></label>
	</div>
		<button class="btn btn-outline-success col-12 btn-submit" type="button">내 정보 수정</button>
	<div class="box-pw">
		<h3>기존 비밀번호를 입력하세요.</h3>
		<input class="form-control" name="old_pw" type="password">
		<button class="btn btn-outline-success btn-pw-send" type="button">확인</button>
	</div>
</form>
<script type="text/javascript">
$(".btn-submit").click(function(){
	$('.box-pw').show();
	
	
	
});
$('.btn-pw-send').click(function() {
	$.ajax({
		async :false, //비동기 : true(비동기), false(동기)
		url : '<c:url value="/check/pw"/>', 
		type : 'post', 
		data : {
			pw :$("[name=old_pw]").val()
		}, 
		dataType : "json", 
		success : function (data){
			if(data.result){
				$("form").submit();
			}else{
				alert("비번이 일치하지 않습니다.");
			}
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
	
	
})
</script>
</body>
</html>