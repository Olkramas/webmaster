<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>삭제화면 (removeForm.jsp)</h3>
<%
	String msg = (String) request.getAttribute("msg");
	String pg = (String) request.getAttribute("page");
	String sc = (String) request.getAttribute("searchCondition");
	String kw = (String) request.getAttribute("keyword");
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
<form action="removeForm.do" method="post">
	<input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
	<input type="hidden" name="searchCondition" value="<%=sc %>">
	<input type="hidden" name="page" value="<%=pg %>">
	<input type="hidden" name="keyword" value="<%=kw %>">
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
				<input type="reset" value="취소" class="btn btn-danger">
			</td>
		</tr>
	</table>
</form>


<script>
document.querySelector('input[value="취소"]')	.addEventListener('click', function(e) {
	//input[value="수정"]가 클릭됐을 때
	location.href = 'boardList.do?&page=<%=pg%>&searchCondition=<%=sc%>&keyword=<%=kw%>';
	//location.href자바스크립트 에서 페이지 이동할 때 이렇게 사용함. get방식 bno에서 파라미터 값을 받아와서 이동함.
});
</script>