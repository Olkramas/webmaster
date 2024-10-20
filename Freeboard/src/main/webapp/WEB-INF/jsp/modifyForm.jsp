<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../includes/header.jsp"></jsp:include>
<h3>수정화면 (modifyForm.jsp)</h3>
<%
	String msg = (String) request.getAttribute("msg");
	BoardVO board = (BoardVO) request.getAttribute("boardvo");
	String pg = (String) request.getAttribute("page");
	String sc = (String) request.getAttribute("searchCondition");
	String kw = (String) request.getAttribute("keyword");
	//세션 가져오기
	String logId = (String) session.getAttribute("logId");
	
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
	<input type="hidden" name="page" value="<%=pg %>">
	<input type="hidden" name="searchCondition" value="<%=sc %>">
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
			<td colspan="2" align="center">		<!-- 로그인 아이디가 널이아니고 작성자와 같으면 활성화, 아니면 비활성화 /// logId != null하는 이유는 만약 널일경우 널포인트 익셉션이 발생함. -->
				<input type="submit" value="저장" <%=logId != null && logId.equals(board.getWriter()) ? "" : "disabled" %> class="btn btn-primary">
				<input type="reset" value="취소" class="btn btn-danger">
			</td>
		</tr>
	</table>
</form>



<jsp:include page="../../includes/footer.jsp"></jsp:include>

<script>
	document.querySelector('input[value="취소"]').addEventListener('click',function(e) {
		location.href = 'boardList.do?&page=<%=pg%>&searchCondition=<%=sc%>&keyword=<%=kw%>';
	});

</script>