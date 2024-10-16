<%@page import="com.yedam.service.MemberService"%>
<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- url로 접근할수있는건 index만 가능함 WEB-INF하위 폴더JSP는 접근이 불가능함. -->
<!--  mvc디자인: view(jsp페이지), model(db처리), 컨트롤 -->
	<!-- 자바 프로그래밍 언어를 사용가능함 -->
	<% 	String myName = "이창호";
		//컨트롤 스페이스로 임포트 가능
		MemberService svc = new MemberServiceImpl();	
		if(svc.retireMember("guest")) {
	%>
		<p>삭제되었습니다</p>
	<%
		} else {
	%>
		<p>회원정보가 없습니다.</p>
	<%
		}
	%>
	
	<h3>내 이름은 <%=myName %>입니다.</h3>
</body>
</html>