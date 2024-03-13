<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

	<!-- jquery validtaion -->	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
   
	
<title>회원가입</title>

</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href='<c:url value="/"/>'>Logo</a>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href='<c:url value="/signup"/>'>회원가입</a></li>
			<li class="nav-item"><a class="nav-link"
				href='<c:url value="/login"/>'>로그인</a></li>
		</ul>
	</nav>
	<div class="container">
		<form action='<c:url value="/signup"/>' method="post">
			<div class="form-group">
				<label for="id">아이디:</label> 
				<input type="text"class="form-control" id="id" name="me_id">
				<label id="id-error" class="error text-danger" for="id"></label>
			</div>
			<div class="form-group">
				<label for="pw">비번</label> 
				<input type="password"class="form-control" id="pw" name="me_pw">
				<label id="pw-error" class="error text-danger" for="pw"></label>
			</div>
			<div class="form-group">
				<label for="pw2">비번확인</label> 
				<input type="password"class="form-control" id="pw2" name="me_pw2">
				<label id="pw2-error" class="error text-danger" for="pw2"></label>
			</div>
			<div class="form-group">
				<label for="email">이메일</label> 
				<input type="text"class="form-control" id="email" name="me_email">
				<label id="email-error" class="error text-danger" for="email"></label>
			</div>
			<button class="btn btn-outline-success col-12">회원가입</button>
		</form>
	</div>
<script type="text/javascript">
$("form").validate({
		rules : {
			me_id : {
				required : true,
				regex : /^\w{6,13}$/
			},
			me_pw :{
				required : true,
				regex : /^[a-zA-Z0-9!@#]{6,15}$/
			},
			//비번 확인
			me_pw2 :{
				equalTo : pw //name이 아닌 id를 써 줌
			},
			me_email :{
				required : true,
				email : true
			}
		}, // rules end
		
		//메세지 
		messages : {
			me_id : {
				required :"필수 항목입니다.",
				regex : "아이디는 숫자 영문 6~13입니다."
			},
			me_pw :{
				required : "필수 항목입니다.",
				regex : "비밀번호는 숫자 영문 !@#만 사용 가능하며 6~15입니다."
			},
			//비번 확인
			me_pw2 :{
				equalTo :"비밀번호와 일치하지 않습니다."
			},
			me_email :{
				required : "필수 항목입니다.",
				email : "이메일 형식이 아닙니다."
			}
		} // messages end
}); // form end
	
$.validator.addMethod(
	"regex",
	function (value, element , regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
	},
	"정규표현식에 맞지 않습니다."
)
		
		
	</script>
	
</body>
</html>