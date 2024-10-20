<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../includes/header.jsp"></jsp:include>

<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
PageDTO paging = (PageDTO) request.getAttribute("page");
String sc = (String) request.getAttribute("searchCondition");
String kw = (String) request.getAttribute("keyword");
kw = kw == null ? "" : kw;
%>

<h3>게시글 조회(boardList.jsp)</h3>

<form action="boardList.do" class="row g-3">
	<div class="col-md-3">
		<select name="searchCondition" class="form-select">
			<option selected>선택하세요.</option>
			<!-- .equals메소드를 사용할 때 null값이면 nullpointException이 발생하기때문에 이렇게 조건을 걸었음 -->
			<option value="T" <%=(sc != null && sc.equals("T") ? "selected" : "") %>>
				제목
			</option>
			<option value="W" <%=(sc != null && sc.equals("W") ? "selected" : "") %>>
				작성자
			</option>
			<option value="TW" <%=(sc != null && sc.equals("TW") ? "selected" : "") %>>
				제목
			</option>
		</select>
	</div>
	<div class="col-md-4">
		<input type="text" class="form-control" name="keyword"
			value='<%=kw %>'>
	</div>
	<div class="col-md-5">
		<button type="submit" class="btn btn-primary">조회</button>
	</div>
</form>

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
		<% 
		for(BoardVO board : list) {
		%>
			<tr>
				<td><%=board.getBoardNo() %></td>
				<td>
					<a href="board.do?bno=<%=board.getBoardNo() %>&searchCondition=<%=sc%>&keyword<%=kw%>&page=<%=paging%>&title=<%=board.getTitle()%>">
						<%=board.getTitle() %>
					</a>
				</td>
				<td><%=board.getWriter() %></td>
				<td><%=simpleDate.format(board.getWriteDate()) %></td>
				<td><%=board.getViewCnt() %></td>
			</tr>
		<%
		}
		%>
	</tbody>
</table>
   <!-- 검색결과, 게시판에 글이 없을때 no data출력 -->
<% if(list.size() == 0) {%>
	<p style="text-align: center;">-no data-</p>
<%} %>
	<!-- 현재 페이지에서 PageDTO객체의 전달된 값을 확인 -->
<%=paging  %>

<!-- 페이징 -->
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<!-- 이전 페이지로 이동하기 -->
		<% if(paging.isPrev()) { %>
			<li class="page-item">
				<!-- 시작 페이지의 -1페이지로 이동하는 링크 // 11페이지면 10으로 그럼 이전으로 넘어가게 됨. -->
				<a class="page-link" href="boardList.do?page=<%=paging.getStartPage()-1 %>">
					Previous
				</a>
			</li>
		<%} else {%>
			<!-- paging.isNext()메소드가 거짓이면 이전 이동은 비활성화 됨. -->
			<li class="page-item disabled">
				<a class="page-link">
					Previous
				</a>
			</li>
		<%} %>
		
		<!-- 현재페이지 불 들어오게하기, 클릭하면 다른페이지 이동하기 -->
		<% for(int p = paging.getStartPage(); p <= paging.getEndPage(); p++) { %>
			<%if(paging.getPage() == p) {%>
				<!-- "page-item active"현재 페이지 파란색 채우기 디자인 -->
				<li class="page-item active">
					<span class="page-link" aria-current="page">
						<%=p %>
					</span>
				</li>
			<%} else {%>
				<li class="page-item">
					<a class="page-link" href="boardList.do?searchCondition=<%=sc %>&page=<%=p %>&keyword=<%=kw %>">
						<%=p %>
					</a>
				</li>
			<%} %>
		<%} %>
		
		<!-- 다음 페이지로 이동하는 메소드 -->
		<%if(paging.isNext()) { %>
			<li class="page-item">
				<a class="page-link" href="boardList.do?page=<%=paging.getEndPage()+1 %>">
					Next
				</a>
			</li>
		<%} else { %>
			<li class="page-item disabled">
				<a class="page-link">
					Next
				</a>
			</li>
		<%} %>
	</ul>
</nav>

<jsp:include page="../../includes/footer.jsp"></jsp:include>
    