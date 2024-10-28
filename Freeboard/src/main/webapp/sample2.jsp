<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>jQuery Element Selection</title>
	
	<script>
	/*
	// document.addEventListener('DOMContentLoaded', function (e) {이거랑 똑같은 시작
	$(function() {
		$("p").on("click", function() {
			$(".jq").css("backgroundColor", "lightgray");	// 클래스가 "jq"인 요소를 모두 선택함.
		});
	});
	*/
	
	//javascript 기준으로 이벤트 생성 / style.backgroundColor = 'lightgray';
	document.addEventListener('DOMContentLoaded', function(e) { 
		document.querySelectorAll('p').forEach(item => {		
			item.addEventListener('click', function(e) {
				document.querySelectorAll('.jq').forEach(jq => {
					jq.style.backgroundColor = 'lightgray';
				})
			})
		})
	})

	</script>
</head>

<body>

	<h1>클래스 선택자</h1>

	<p class="jq">이제부터 제이쿼리를 다 같이 공부해보죠!!</p>
	<p class="jq">클래스 선택자로 특정 요소들을 한 번에 선택할 수 있어요!!</p>
	<p>마우스로 글씨를 클릭해보세요!!</p>
	
</body>

</html>