<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../includes/header.jsp"></jsp:include>
<h3>수정화면 (removeForm.jsp)</h3>
<%
	String msg = (String) request.getAttribute("msg");
	BoardVO board = (BoardVO) request.getAttribute("boardvo");
	
%>
<%
	//msg가 null이 아니고 값이 있을때
	//등록한는중에 오류가 나면 아래 메세지 출력
	if(msg != null) {
%>
<p style="color:red;"><%=msg %></p>
<%
	}
%>

<!-- addBoard.do에 파라미터들을 전달해서 처리할거임 -->
<form action="modifyBoard.do" method="post">
	<input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
	<table class="table">
		<tr>
			<th>글번호</th><td><%=board.getBoardNo() %></td>
			<th>조회</th><td><%=board.getViewCnt() %></td>
		</tr>
		<tr>
			<th>제목</th><td><input type="text" name="title" class="form-control" value="<%=board.getTitle() %>"></td>
		</tr>
		<tr>
			<!-- textarea가 여러라인을 처리 -->
			<th>내용</th><td><textarea class="form-control" rows="3" cols="30" name="content"><%=board.getContent() %></textarea></td>
		</tr>
		<tr>
			<th>작성자</th><td><%=board.getWriter() %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="삭제"  class="btn btn-primary">
				<input type="submit" value="취소" class="btn btn-danger">
			</td>
		</tr>
	</table>
</form>

<jsp:include page="../../includes/footer.jsp"></jsp:include>

<script>
	document.querySelector('input[value="삭제"]')	.addEventListener('click', function(e) {
		//input[value="수정"]가 클릭됐을 때
		location.href = 'boardList.do';
		//location.href자바스크립트 에서 페이지 이동할 때 이렇게 사용함. get방식 bno에서 파라미터 값을 받아와서 이동함.
	});
	document.querySelector('input[value="취소"]')	.addEventListener('click', function(e) {
		//input[value="수정"]가 클릭됐을 때
		location.href = 'boardList.do';
		//location.href자바스크립트 에서 페이지 이동할 때 이렇게 사용함. get방식 bno에서 파라미터 값을 받아와서 이동함.
	});
</script>