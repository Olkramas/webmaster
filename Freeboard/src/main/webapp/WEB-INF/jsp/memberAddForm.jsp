<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../../includes/header.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- web-inf폴더 밑에 있으면 이제 직접 실행을 못함 컨트롤러에서 설정을 해야함.-->
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
				<td colspan='2' align="center"><input type="submit" value="저장" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
</body>
</html>

<jsp:include page="../../includes/footer.jsp"></jsp:include>