<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../../includes/header.jsp"></jsp:include>
<h3>상세페이지(board.jsp)</h3>
<br>
<%
BoardVO bvo = (BoardVO) request.getAttribute("boardvo");
//내장으로 있는 page가 있어서 이렇게 변수이름 선언
String pg = (String) request.getAttribute("page");
String sc = (String) request.getAttribute("searchCondition");
String kw = (String) request.getAttribute("keyword");
kw = kw == null ? "" : kw;	//null값을 처리하기
SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String wdate = simpleDate.format(bvo.getWriteDate());
%>



<table class="table">
	<tr>
		<th>글번호</th>
		<td><%=bvo.getBoardNo()%></td>
		<th>조회수</th>
		<td><%=bvo.getViewCnt()%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><%=bvo.getTitle()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea readonly rows="4" cols="30"
				class="form-control"><%=bvo.getContent()%></textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="3"><%=bvo.getWriter()%></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td colspan="3"><%=wdate%></td>
	</tr>
	<tr>
		<td colspan='4' align="center"><input type="submit" value="수정"
			class="btn btn-primary"> <input type="submit" value="삭제"
			class="btn btn-danger"></td>
	</tr>
</table>




<jsp:include page="../../includes/footer.jsp"></jsp:include>
<script>
	document.querySelector('input[value="수정"]')	.addEventListener('click', function(e) {
		//input[value="수정"]가 클릭됐을 때
		location.href = 'modifyBoard.do?bno=<%=bvo.getBoardNo()%>&page=<%=pg%>&searchCondition=<%=sc %>&keyword=<%= kw%>';
		//location.href자바스크립트 에서 페이지 이동할 때 이렇게 사용함. get방식 bno에서 파라미터 값을 받아와서 이동함.
	});
	document.querySelector('input[value="삭제"]')	.addEventListener('click', function(e) {
		//input[value="삭제"]가 클릭됐을 때
	location.href = 'removeBoard.do?bno=<%=bvo.getBoardNo()%>&page=<%=pg%>&searchCondition=<%=sc %>&keyword=<%= kw%>';
			//location.href자바스크립트 에서 페이지 이동할 때 이렇게 사용함. get방식 bno에서 파라미터 값을 받아와서 이동함.
	});
</script>