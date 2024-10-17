<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../includes/header.jsp"></jsp:include>
<h3>글 목록</h3>
<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	</thead>
	
	<tbody>
	<%for(BoardVO board : list) {
		//.format안에 Date타입 변수의 포멧을 바꿔줌
		//date 포멧(2024-10-09 12:22:33)이런식으로 나옴
		String wdate = simpleDate.format(board.getWriteDate());
	%>
		<tr>
			<td><%=board.getBoardNo() %></td>
			<td><a href='board.do?bno=<%=board.getBoardNo() %>'> <%=board.getTitle() %></a></td>
			<td><%=board.getWriter() %></td>
			<td><%=wdate %></td>
		</tr>
	<%} %>
	</tbody>
</table>
<%
	PageDTO paging = (PageDTO) request.getAttribute("page");
%>

<%=paging %>
<!-- paging -->
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item disabled">
      <a class="page-link">Previous</a>
    </li>
    <% for(int p = paging.getStartPage(); p <= paging.getEndPage(); p++) { %>
    <li class="page-item"><a class="page-link" href="boardList.do?page=<%=p %>"><%=p %></a></li>
    <%} %>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>

<jsp:include page="../../includes/footer.jsp"></jsp:include>