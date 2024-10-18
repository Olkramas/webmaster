<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../../includes/header.jsp"></jsp:include>
<h3>로그인 화면(loginForm.jsp)</h3>
<%
	String msg = (String) request.getAttribute("msg");
%>
<%
	if(msg != null) {
%>
<p style="color:red;"><%=msg %></p>
<%
	}
%>

<form action="loginForm.do" method="post">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="logId"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="logPw"></td>
		</tr>
		<td colspan="2">
			<button type="submit">로그인</button>
		</td>
	</table>
</form>

<jsp:include page="../../includes/footer.jsp"></jsp:include>