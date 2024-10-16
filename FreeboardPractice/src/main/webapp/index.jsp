<%@page import="com.yedam.service.MemberService"%>
<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<%
		String myName = "최태백";
		MemberService svc = new MemberServiceImpl();
		if(svc.retireMember("user1")) {
	%>
		<p>삭제되었습니다.</p>
	<%	
		} else {
	%>	
		<p>회원정보가 없습니다.</p>
	<%
		}
	%>
	<h3>내 이름은 <%=myName %>입니다</h3>
</body>
</html>