<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../includes/header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meberAddForm</title>
</head>
<body>
	<form action="memberAdd.do">
		<table class="table">
			<tr>
				<th>회원</th><td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<th>회원이름</th><td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<th>비밀번호</th><td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<th>연락처</th><td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td colspan='2'><input type="submit" value="저장"></td>
			</tr>
		</table>
	</form>
		
</body>
</html>
<jsp:include page="../../includes/footer.jsp"></jsp:include>