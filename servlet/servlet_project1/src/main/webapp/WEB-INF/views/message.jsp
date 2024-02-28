<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script type="text/javascript">
		let msg = '${msg}'; //서버에서 보낸 msg값을 변수에 저장
		if (msg != '') {
			alert(msg);
		}
		location.href = '<c:url value = "/${url}"/>';
	</script>
</body>
</html>