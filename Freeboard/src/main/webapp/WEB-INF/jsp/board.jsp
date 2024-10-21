<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../../includes/header.jsp"></jsp:include>
<h3>상세페이지(board.jsp)</h3>
<br>
<%
BoardVO bvo = (BoardVO) request.getAttribute("boardvo");
//내장으로 있는 page가 있어서 이렇게 변수이름 선언
String pg = (String) request.getAttribute("page");
String sc = (String) request.getAttribute("searchCondition");
String kw = (String) request.getAttribute("keyword");
SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String wdate = simpleDate.format(bvo.getWriteDate());
%>
<p style="display: none;">${keyword = keyword == null ? "" : keyword }</p>


<table class="table">
	<tr>
		<th>글번호</th>
		<td>${boardvo.boardNo}</td>
		<th>조회수</th>
		<td>${boardvo.viewCnt }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${boardvo.title }</td>
		<th>작성자</th>
		<td>${boardvo.writer }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="4"><textarea readonly rows="4" cols="30"
				class="form-control">${boardvo.content }</textarea></td>
	</tr>
	<c:if test="${boardvo.img != null}">
		<tr>
			<th>이미지</th>
			<td colspan="4">
				<img src="images/${boardvo.img}" width="150px">
			</td>
		</tr>	
	</c:if>
	<tr>
		<th>작성일시</th>
		<td colspan="3"><fmt:formatDate value="${board.writeDate}"/></td>
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
		console.log("click정상동작");
		location.href = 'modifyBoard.do?bno=${boardvo.boardNo}&title=${boardvo.title}&page=${page}&searchCondition=${searchCondition}&keyword=${keyword}';
		//location.href자바스크립트 에서 페이지 이동할 때 이렇게 사용함. get방식 bno에서 파라미터 값을 받아와서 이동함.
	});
	document.querySelector('input[value="삭제"]')	.addEventListener('click', function(e) {
		//input[value="삭제"]가 클릭됐을 때
	location.href = 'removeForm.do?bno=${boardvo.boardNo}&title=${boardvo.title}&page=${page}&searchCondition=${searchCondition}&keyword=${keyword}';
	});
</script>