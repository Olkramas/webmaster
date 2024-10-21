<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>등록화면 (boardForm.jsp)</h3>
<%
	String logId = (String) session.getAttribute("logId");
	String msg = (String) request.getAttribute("msg");
%>
<%
%>

<c:if test="${msg != null }">
	<p style="color:red;">${msg }</p>
</c:if> 

<!-- addBoard.do에 파라미터들을 전달해서 처리할거임 -->
<!-- enctype="multipart/form-data" 주로 파일 데이터를 서버로 전송할 때 사용하는 인코딩 타입 -->
<form action="addBoard.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="writer" class="form-control" value="${logId }">
	<table class="table">
		<tr>
			<th>제목</th><td><input type="text" name="title" class="form-control"></td>
		</tr>
		<tr>
			<!-- textarea가 여러라인을 처리 -->
			<th>내용</th><td><textarea class="form-control" rows="3" cols="30" name="content"></textarea></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td>
				<input type="file" name="img" class="form-control">
			</td>
		</tr>
		<tr>
			<th>작성자</th><td>${logId }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="저장"  class="btn btn-primary">
				<input type="reset" value="취소" class="btn btn-danger">
			</td>
		</tr>
	</table>
</form>

