<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../includes/header.jsp"></jsp:include>
<h3>상세페이지(board.jsp)</h3>
<br>
<% 
	BoardVO bvo = (BoardVO) request.getAttribute("boardvo"); 
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	String wdate = simpleDate.format(bvo.getWriteDate());
%>
<table class="table">
	<tr>
		<th>글번호</th><td><%=bvo.getBoardNo() %></td><th>조회수</th><td><%=bvo.getViewCnt() %></td>
	</tr>
	<tr>
		<th>제목</th><td colspan="3"><%=bvo.getTitle() %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">
		<textarea readonly rows="4" cols="30" class="form-control"><%=bvo.getContent() %></textarea>
		</td>
	</tr>
	<tr>
		<th>작성자</th><td colspan="3"><%=bvo.getWriter() %></td>
	</tr>
	<tr>
		<th>작성일시</th><td colspan="3"><%=wdate %></td>
	</tr>
	<tr>
		<td colspan='4' align="center">
			<input type="submit" value="수정" class="btn btn-primary">
			<input type="reset" value="취소" class="btn btn-danger">
		</td>
	</tr>
</table>




<jsp:include page="../../includes/footer.jsp"></jsp:include>
<script>
	document.querySelector('input[value="수정"]')	.addEventListener('click', function(e) {
		//input[value="수정"]가 클릭됐을 때
		location.href = 'modifyBoard.do?bno=<%=bvo.getBoardNo() %>';
		//location.href자바스크립트 에서 페이지 이동할 때 이렇게 사용함. get방식 bno에서 파라미터 값을 받아와서 이동함.
	});
	document.querySelector('input[value="취소"]')	.addEventListener('click', function(e) {
		//input[value="수정"]가 클릭됐을 때
		location.href = 'boardList.do';
		//location.href자바스크립트 에서 페이지 이동할 때 이렇게 사용함. get방식 bno에서 파라미터 값을 받아와서 이동함.
	});
</script>