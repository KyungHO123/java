<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<h1>메인페이지</h1>
	<div class="container">
		<!-- 
1. 버튼을 추가해서 버튼을 클릭하면 ajax로 숫자 1을 서버에 전송하고.
2. 서버에서 넘겨받은 1을 콘솔에 출력한 후 화면에 abc를 전송.  
3. 화면에서 서버에서 보낸 abc를 alert으로 출력
-->
		<button class="btn btn-outline-success" id="test">ajax 테스트</button>
	</div>
	<script type="text/javascript">
		$("#test").click(function() {
			$.ajax({
				url : '<c:url value="/"/>',
				method : "post",
				data : {
					num : 1
				},
				success : function(data) {
					console.log(data);
				},
				error : function(xhr, status, error) {

				}
			});//ajax end
		});//function end
	</script>

</body>
</html>