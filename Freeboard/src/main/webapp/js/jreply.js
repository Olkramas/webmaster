/*
	jreply.js
*/
console.log('start');

//jquery방식의 Ajax호출
$.ajax('replyList.do?bno=' + bno + '&page=1')
.done(function(result) {
	console.log(result);	//result 는 [{},{},{}] 이 형태로 있음
	result.forEach((item) => {
		$('<li/>').append(
			$('<span/>').addClass('col-sm-2').text(item.replyNo),	//글번호
			$('<span/>').addClass('col-sm-5').text(item.reply),		//댓글 내용
			$('<span/>').addClass('col-sm-2').text(item.replyer),		//작성자
			$('<span/>').addClass('col-sm-2').append($('<button>삭제</button>'))		//삭제버튼
		)
		.appendTo($('div.content ul'));
	});
	
})
.fail(function(err) {
	console.log(err);	
})
	//클릭 이벤트가 생기면 ul하위의 button을 가져와서 처리가능
$('div.content ul').on('click', 'button', function(e) {
	console.log($(e.target).parent().parent().find('span:eq(0)').text());
	
	let rno = $(e.target).parent().parent().find('span:eq(0)').text();
	//삭제
	$.ajax({
		url: 'removeReply.do',
		data: {rno: rno},
		method: 'get',
		dataType: 'json'	//json문자열을 자바스크립트 객체로 바꿔놓음
	})	
	.done(function(result) {
		if(result.retCode == 'OK') {
			$(e.target).closest('li').remove();
		}
	})
	.fail(function(err) {
		console.log(err)
	})
	
})

$('#addReply').on('click', function(e) {
	//console.log('작동OK'); 작동 확인
	console.log($('.table tr:eq(0) td:eq(0)').text());
	
	$.ajax({
		url: 'addReply.do',
		data: {bno: $('.table tr:eq(0) td:eq(0)').text(),
			   reply: $('.reply').val(),
		       replyer: logId},
		method: 'post',
		dataType: 'json'
	})
	.done(function(result) {
		
	})
	.fail(function(err) {
		console.log(err);
	})
})
