<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../includes/header.jsp"></jsp:include>

<%
BoardVO bvo = (BoardVO) request.getAttribute("boardvo");
String pg = (String) request.getAttribute("page");
String kw = (String) request.getAttribute("keyword");
String sc = (String) request.getAttribute("searchCondition");

kw = kw == null ? "" : kw;

SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String wdate = simpleDate.format(bvo.getWriteDate());

%>

<h3>게시물 자세히 보기(board.jsp)</h3>


<table class="table">
	<tr>
		<th>글번호</th>
		<td><%=bvo.getBoardNo() %></td>
		<th>조회수</th>
		<td><%=bvo.getViewCnt() %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><%=bvo.getTitle() %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">
			<textarea readonly rows="4" cols="30" class="form-control"><%=bvo.getContent() %></textarea>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="3">
			<%=bvo.getWriter() %>
		</td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td colspan="3">
			<%=wdate %>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<!-- 세션 받아와서 if문으로 비교해야됨. 본인이 아닐경우 수정못하게 막게! -->
			<input type="submit" value="수정" class="btn btn-primary">
			<input type="submit" value="삭제" class="btn btn-danger">
			
		</td>
	</tr>
</table>

<jsp:include page="../../includes/footer.jsp"></jsp:include>

<script>
	document.querySelector('input[value="수정"]').addEventListener('click', function(e) {
		console.log("[수정]click 정상동착");
		location.href = "modify.do?bno=<%=bvo.getBoardNo()%>&title=<%=bvo.getTitle()%>&page=<%=pg%>&searchCondition=<%=sc%>&keyword=<%=kw%>";
	});
</script>