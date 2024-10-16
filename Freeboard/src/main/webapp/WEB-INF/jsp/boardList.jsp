<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../../includes/header.jsp"></jsp:include>

<h3>글 목록(boardList.jsp)</h3>
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
PageDTO paging = (PageDTO) request.getAttribute("page");
String sc = (String) request.getAttribute("searchCondition");
String kw = (String) request.getAttribute("keyword");
kw = kw == null ? "" : kw; //null값을 처리하기
%>
<!-- 검색조건 -->
<form action="boardList.do" class="row g-3">
	<div class="col-md-3">
		<select name="searchCondition" class="form-select">
			<option selected>선택하세요.</option>
			<option value="T"
				<%=(sc != null && sc.equals("T") ? "selected" : "")%>>제목</option>
			<option value="W"
				<%=(sc != null && sc.equals("W") ? "selected" : "")%>>작성자</option>
			<option value="TW"
				<%=(sc != null && sc.equals("TW") ? "selected" : "")%>>제목&작성자</option>
		</select>
	</div>
	<div class="col-md-4">
		<input type="text" class="form-control" name="keyword"
			value='<%=kw == null || kw.equals("") ? "" : kw%>'>
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
		<c:forEach var="board" items="${boardList }">
		<tr>
			<td><c:out value="${board.boardNo }"/></td>
			<td><a href="board.do?searchCondition=${searchCondition}&keyword=${keyword }&bno=${board.boardNo }&page=${page.page}&title=${board.title}">
			<c:out value="${board.title}" /></a></td>
			<td><c:out value="${board.writer }"/></td>
			<td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td><c:out value="${board.viewCnt }"/></td>
		</tr>
		</c:forEach>

	</tbody>
</table>

<% if(list.size() == 0) { %>
	<tr>  
		<td align="center" colspan="5"> - no data -</td>
	</tr>
	
<%} %>
<%=paging%>
<!-- paging -->
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<!-- 이전페이지 -->
		<%
		if (paging.isPrev()) {
		%>
		<li class="page-item"><a class="page-link"
			href="boardList.do?page=<%=paging.getStartPage() - 1%>">Previous</a></li>
		<%
		} else {
		%>
		<li class="page-item disabled"><a class="page-link">Previous</a>
		</li>
		<%
		}
		%>

		<!-- 현재 페이지 색들어오게 해주기. -->
		<%
		for (int p = paging.getStartPage(); p <= paging.getEndPage(); p++) {
			if (paging.getPage() == p) {
		%>
		<li class="page-item active"><span class="page-link"
			aria-current="page"><%=p%></span></li>
		<%
		} else {
		%>
		<li class="page-item"><a class="page-link"
			href="boardList.do?searchCondition=<%=sc%>&page=<%=p%>&keyword=<%=kw%>"><%=p%></a></li>
		<%
		}
		}
		%>


		<!-- 다음페이지 -->
		<%
		if (paging.isNext()) {
		%>
		<li class="page-item"><a class="page-link"
			href="boardList.do?page=<%=paging.getEndPage() + 1%>">Next</a></li>
		<%
		} else {
		%>
		<li class="page-item disabled"><a class="page-link">Next</a></li>
		<%
		}
		%>
	</ul>
</nav>

<jsp:include page="../../includes/footer.jsp"></jsp:include>