/*
	reply.js
	board.jsp에서 가져왔음 html코드
	<!-- 댓글관련 -->
<table id="replyList" class="table">
	<thead>
		<tr>
			<th>댓글번호</th><th>내용</th><th>작성자</th>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
*/

//replyService에서 생성했던 메소드들을 호출해서 사용하려고 함.

//svc.showMsg('hello');

// 현재 페이지의 URL을 가져옴
//let url = new URL(window.location.href);
// URLSearchParams 객체를 생성
//let params = new URLSearchParams(url.search);
// 특정 파라미터 값 가져오기. "bno"
//let bno = params.get('bno');
let page = 1; //댓글에 대한 페이지 변수


//댓글등록 버튼 이벤트
document.querySelector('#addReply').addEventListener('click', addReplyHandlerFnc);

//댓글 등록 버튼 이벤트 핸들러
function addReplyHandlerFnc(e) {
	//사용자가 입력한 댓글 내용 가져오기
	let reply = document.querySelector('#reply').value;
	//replyer: logId세션에 저장한것을 board.jsp 스크립트 쪽에서 불러와서 가져옴
	//댓글 내용이 없거나 로그인이 안됐으면 메세지 띄우기
	if (!reply || !logId) {
		alert('필수값이 없습니다.');
		return;
	}
	//댓글 추가 메소드	글 번호, 댓글 내용, 작성자 넣었음
	svc.addReply({ bno, reply, replyer: logId },
		result => {
			if (result.retCode == "OK") {
				alert("정상 처리");
				showList();
				// 새로 추가된 댓글을 바로 리스트에 반영
				//let template = makeLi(result.retVal);  
				// result.retVal은 새로 추가된 댓글 데이터 db에서 가져오고 그걸 컨트롤에서 제이슨 형식으로 넘겼음 result.retVal는 자바스크립트 객체
				document.querySelector(".reply ul").appendChild(template);
			} else if (result.retCode == "FAIL") {
				alert("처리 중 예외 발생");
			} else {
				alert('알 수 없는 코드');
			}
		},
		err => {
			console.log(err);
		}
	);

}

//pagination a 클릭 이벤트.
//.forEach(innerText, index, nodelist)
function linkMove() {
	document.querySelectorAll("nav ul.pagination a").forEach(function(aTag) {
		aTag.addEventListener('click', function(e) {
			e.preventDefault();//a태그의 이동 차단
			console.log(aTag.innerHTML);
			page = aTag.dataset.page;	//a태그의 data-page="n" 이것의 n값을 가져옴
			showList();	//목록 보여주기
			svc.getReplyCount(bno, createPageList, err => console.log(err));	//페이지 목록도 보여주기
		})
	})
}

svc.getReplyCount(bno, createPageList, err => console.log(err));
//페이지 목록을 출력하는 함수
function createPageList(result) {	//ex) totalCnt가 20일때, 현재 2page
	//console.log(result.totalCount);
	let totalCnt = result.totalCount;
	let startPage, endPage, realEnd;
	let prev, next;
	
	endPage = Math.ceil (page / 5) * 5;	//5page
	startPage = endPage - 4; //1page
	realEnd = Math.ceil(totalCnt / 5); //13page
	endPage = endPage > realEnd ? realEnd : endPage;
	
	prev = startPage > 1;	//false
	next = endPage < realEnd;	//ture
	
	let list ="";
	/*
	<li class="page-item">
	      <a class="page-link" href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	*/
	
	//이전 페이지 이동
	list += '<li class="page-item">';
	if(prev)
		list += '  <a class="page-link" href="#" aria-label="Previous" data-page="' + (startPage - 1) + '">&laquo;</a>';
	else
		list += '  <span class="page-link" aria-hidden="true">&laquo;</span>';
	list += '    </li>'; 
	
	//<li class="page-item"><a class="page-link" href="#">1</a></li>
	for(let p = startPage; p<=endPage; p++) {
		/*
		let li = document.createElement('li');
		li.className = 'page-item';
		let a = document.createElement('a');
		a.className = 'page-link';
		a.setAttribute('href', '#');
		a.innerText = p;
		li.appendChild(a);
		*/
		list += '<li class="page-item"><a class="page-link" href="#" data-page="' + p + '">' + p + '</a></li>';
		
	}
	
	/*
	<li class="page-item">
	      <a class="page-link" href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	*/
	//다음 페이지 이동
	list += '<li class="page-item">';
	if(next)
		list += '  <a class="page-link" href="#" aria-label="Next" data-page="' + (endPage + 1) + '">&raquo;</a>';
	else
		list += '  <span class="page-link" disabled aria-hidden="true">&raquo;</span>';
	list += '    </a></li>';
	//document.querySelector('nav ul.pagination').appendChild(li);
	document.querySelector('nav ul.pagination').innerHTML = list;
	
	//a태그 링크 달기
	linkMove();	
}



//댓글 목록을 만드는 함수
showList();
function showList() {
	//출력목록을 화면에서 지우고, 다시 출력해야 중복되게 안나옴
	document.querySelectorAll('div.reply div.content ul li').forEach((li, idx) => {
		//li 는 'div.reply div.content ul li'에서 선택된 모든 li요소
		//인덱스는 위에서 가져온 li태그들의 인덱스 번호
		if(idx > 0) 
		//첫번째 li요소의 인덱스 번호가 0이라서 그 외 모든 요소들은 삭제됨.
			li.remove();
		
	})
	
	// 댓글 목록 출력
	svc.rlist({ bno, page }	//bno 파라미터
		,	//successFnc
		function(result) {
			console.log(result);
			for (let i = 0; i < result.length; i++) {
				let template = makeLi(result[i]);
				document.querySelector(".reply ul").appendChild(template);
			}
		}
		, function(err) {
			console.log(err);

		}	//errorFunc
	)
}	//end of showList()

//댓글 삭제하는 함수
function delRow(e) {
	let rno = e.target.parentElement.parentElement.dataset.id;
	//let rno2 = e.target.parentElement.parentElement.firstElementChild.innerText;
	console.log(rno);

	//삭제기능 호출(replyService.js)

	svc.removeReply(rno,//삭제할 댓글번호
		(result) => {	
			if (result.retCode == "OK") {
				alert("정상 처리");
				//tr을 삭제함
				svc.getReplyCount(bno, createPageList, err => console.log(err));
				showList();
				e.target.parentElement.parentElement.remove();
			} else if (result.retCode == "FAIL") {
				alert("처리중 예외");
			} else {
				alert('알수 없는 코드');
			}
		}
		, (err) => {	//정상처리 실행함수
			console.log(err);
		}
	)


}

//댓글 목록 만들기
function makeList(result) {
	let fields = ['replyNo', 'reply', 'replyer']
	console.log(result);	//배열
	for (let i = 0; i < result.length; i++) {
		let tr = document.createElement("tr");
		for (let j = 0; j < fields.length; j++) {
			let td = document.createElement("td");
			td.innerHTML = result[i][fields[j]];
			tr.appendChild(td);
		}
		document.querySelector("#replyList tbody").appendChild(tr);
	}
}

//댓글 정보가 한건 있으면 <li>...</li>만드는 함수 생성
function makeLi({ replyNo, reply, replyer }) {
	//reply ul li를 클론으로 만들겠다는 의미					//closeNode(매개값) 매개값을 ture로 하면 하위요소의 값을 모두 가져오게 됨.
	let template = document.querySelector(".reply ul li").cloneNode(true);
	template.setAttribute('data-id', replyNo)
	//.reply ul li의 첫번째 span태그의 값을 30으로 설정
	template.querySelector('span').innerText = replyNo;
	template.querySelector('span:nth-of-type(2)').innerText = reply;
	template.querySelector('span:nth-of-type(3)').innerText = replyer;
	let delBtn = template.querySelector('span:nth-of-type(4)');
	delBtn.innerHTML = '<button>삭제</button>';//innerHTML 은 html로 적용이 됨.
	delBtn.addEventListener('click', delRow);


	return template;
}
