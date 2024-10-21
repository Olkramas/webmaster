<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원목록</h3>
	<%
		//request.getAttribute("memberList")는 오브젝트 타입 객체를 리턴함 (List<MemberVO>)를 통해 캐스팅한 모습
	  	List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList"); 
	 	System.out.println(list);
	%>
	<table class="table">
		<tbody>
	<%
		for(MemberVO mvo : list) {
	%>
		<tr>
			<td><%=mvo.getMemberId() %></td>
			<td><%=mvo.getMemberName() %></td>
			<td><%=mvo.getPhone() %></td>
		</tr>	
	<%} %>
		</tbody>
	</table>
	
</body>
</html>

