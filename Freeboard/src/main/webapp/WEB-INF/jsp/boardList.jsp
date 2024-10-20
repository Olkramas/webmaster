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

<!-- 검색 하고 페이지 넘겨도 제목이 그대로 있게 해줌 -->
<p style="display: none;">${keyword = keyword == null ? "" : keyword }</p>


<!-- 검색조건 -->
<form action="boardList.do" class="row g-3">
	<div class="col-md-3">
		<select name="searchCondition" class="form-select">
			<option selected>선택하세요.</option>
			<!-- 검색후 페이지 넘겨도 00으로 검색한 옵션 그대로 있게 해줌 -->
			<option value="T" 
				${searchCondition != null && searchCondition.equals("T") ? "selected" : ""}>제목</option>
			<option value="W"
				${searchCondition != null && searchCondition.equals("W") ? "selected" : ""}>작성자</option>
			<option value="TW"
				${searchCondition != null && searchCondition.equals("TW") ? "selected" : ""}>제목&작성자</option>
		</select>
	</div>
	<div class="col-md-4">
		<input type="text" class="form-control" name="keyword"
			value='${keyword == null || keyword.equals("") ? "" : keyword}'>
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

<c:if test="${boardList.size() == 0 }">
	<p style="text-align: center">- no data -</p>
	<hr style="border: 1px solid #ddd;">
</c:if>
${page}
<!-- paging -->
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<!-- 이전페이지 -->
		<c:choose>
			<c:when test="${page.prev }"> 
					<li class="page-item">
						<a class="page-link" href="boardList.do?page=${page.startPage - 1}">Previous</a>
					</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<a class="page-link">Previous</a>
				</li>
			</c:otherwise>
		</c:choose>

		<!-- 현재 페이지 색들어오게 해주기. -->
		<c:forEach var="p" begin="${page.startPage }" end="${page.endPage }" step="1">
			<c:choose>
				<c:when test="${page.page == p }">
					<li class="page-item active">
						<span class="page-link" aria-current="page">${p}</span>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="boardList.do?searchCondition=${searchCondition }&page=${p}&keyword=${keyword}">${p }</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>


		<!-- 다음페이지 -->
		<c:choose>
			<c:when test="${page.next }">
				<li class="page-item">
					<a class="page-link" href="boardList.do?page=${page.endPage + 1}">Next</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<a class="page-link">Next</a>
					</li>
			</c:otherwise>
		</c:choose>

	</ul>
</nav>

<jsp:include page="../../includes/footer.jsp"></jsp:include>