<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample.jsp</title>
<script src="js/jquery-3.7.1.js"></script>
<script>
  // 자바 스크립트가 body보다 먼저 실행되니까 body라는 요소를 찾을수가 없음 그래서 이벤트 생성
  document.addEventListener('DOMContentLoaded', function (e) {
  //jquery 객체 생성.
  $('<ul/>')	//document.createElement('ul') 이랑 같음
    .append($('<li>사과</li>')	//ul태그 하위에 사과라는 li요소를 만들었음.
    	,$('<li/>').html('바나나')	//li요소 생성후 그 요소의 .html(innerHTML과 같음)로 '바나나'라는 문자열을 넣었음
    	,$('<li/>').text('복숭아')	//innerText와 같은 속성 .text
    ).appendTo($('body'));	//화면상에 있는 body하위로 넣음		
  })
  
  
</script>
</head>
<body>
  <!-- webapp/sample.jsp -->
  
</body>
</html>