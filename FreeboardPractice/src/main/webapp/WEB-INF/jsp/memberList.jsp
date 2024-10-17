<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
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
	<h3>회원목록</h3>
	<%
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
	<%
			}
	%>
		</tbody>
	</table>
		
		
</body>
</html>
<jsp:include page="../../includes/footer.jsp"></jsp:include>