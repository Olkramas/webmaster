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


//댓글 페이지 변수의 기본값 1로 설정
//페이지가 바뀌면서 linkMove 함수에서 page값을 재할당하게 됨.
let page = 1;


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
				//댓글 추가후 댓글리스트 다시 불러오기
				showList();
				
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

svc.getReplyCount(bno, createPageList, err => console.log(err));

//pagination a 클릭 이벤트.
//.forEach(innerText, index, nodelist)
function linkMove() {
	//nav ul.pagination 밑에 있는 모든 a 태그들을 노드리스트로 반환 받고 그 a태그 리스트들 각각에 클릭이벤트를 달았음.
	document.querySelectorAll("nav ul.pagination a").forEach(function(aTag) {
		aTag.addEventListener('click', function(e) {
			console.log(aTag.innerHTML);
			//a태그는 원래 누르면 다른 페이지로 이동하지만, 이 코드를 통해 이동하지 않고 현재 페이지에서만 동작하도록 만들었음
			e.preventDefault();
			page = aTag.dataset.page;	//a태그의 data-page="n" 이것의 n값을 가져옴
			showList();	//목록 보여주기
			
			//페이지가 바뀔때마다 페이지 정보를 업데이트해야함 그래야 이전, 다음페이지 이동이 작동될 수 있음
			svc.getReplyCount(bno, createPageList, err => console.log(err));
		})
	})
}


//페이지 목록을 출력하는 함수
function createPageList(result) {	//ex) totalCnt가 38일때, 현재 1page
	//db에서 가져온 해당 게시물의 댓글의 총개수를 가져왔음. {"totalCount":"n"}
	let totalCnt = result.totalCount;
	let startPage, endPage, realEnd;
	let prev, next;
	
	endPage = Math.ceil (page / 5) * 5;	//5page
	startPage = endPage - 4; //1page
	realEnd = Math.ceil(totalCnt / 5); //8page
	endPage = endPage > realEnd ? realEnd : endPage;
	
	prev = startPage > 1;	//false
	next = endPage < realEnd;	//ture
	
	let list ="";
	
	//이전 페이지 이동
	list += '<li class="page-item">';
	if(prev)	//이전이 true면 a태그로 이동가능 아니면 span태그로 이동 불가
		list += '  <a class="page-link" href="#" aria-label="Previous" data-page="' + (startPage - 1) + '">&laquo;</a>';
	else
		list += '  <span class="page-link" aria-hidden="true">&laquo;</span>';
	list += '    </li>'; 
	
	//페이징	
	for(let p = startPage; p<=endPage; p++) {
																	//data-page 설정 linkmove함수에서 불러오게 됨.
		list += '<li class="page-item"><a class="page-link" href="#" data-page="' + p + '">' + p + '</a></li>';
		
	}
	
	//다음페이지 이동
	list += '<li class="page-item">';
	if(next)
		list += '  <a class="page-link" href="#" aria-label="Next" data-page="' + (endPage + 1) + '">&raquo;</a>';
	else
		list += '  <span class="page-link" disabled aria-hidden="true">&raquo;</span>';
	list += '    </a></li>';
	//document.querySelector('nav ul.pagination').appendChild(li);
	document.querySelector('nav ul.pagination').innerHTML = list;
	
	//댓글 페이징
	linkMove();	
}



//댓글 목록을 만드는 함수
showList();
//댓글 리스트 가져오기
function showList() {
	//.content ul li li들을 모두 가져옴. 그런데 .forEach함수로 반복문 실행. 
	//li가 li태그 idx가 li태그들의 인덱스 번호임.
	//제일 첫번째 외에는 모두 제거됨.remove()를 통해
	//가이드(댓글번호, 내용, 작성자, 삭제)이거 외에 모두 삭제됨.
	document.querySelectorAll('.content ul li').forEach((li, idx) => {
		if(idx > 0) li.remove();
	})
	//삭제된 다음 리스트를 가져옴
	//makeLi 함수 안에서 데이터들을 li태그안에 담아서 리턴했음.
	svc.rlist({bno, page},
		result => {
			for(let i=0; i<result.length; i++) {
				let template = makeLi(result[i]);
				document.querySelector('.content ul').appendChild(template);
			}
		}, err=> console.log(err))
}

//댓글 템플릿 만들기
//db에서 가져온 결과를 받아서 span안에 넣고 그걸 li안에 넣어서 template리턴
function makeLi({replyNo, reply, replyer}) {
	//.content ul li태그를 복사하고 그 하위 span태그도 같이 복사됨.
	let template = document.querySelector('.content ul li').cloneNode(true);
	
	//li태그 하위요소인 span에 값을 설정해주는 모습
	template.querySelector('span').innerText = replyNo;
	template.querySelector('span:nth-of-type(2)').innerText = reply;
	template.querySelector('span:nth-of-type(3)').innerText = replyer;
	let delBtn = template.querySelector('span:nth-of-type(4)'); 
	delBtn.innerHTML = '<button>삭제</button>';
	//삭제버튼에 온클릭 이벤트 설정
	delBtn.addEventListener('click', delRow);
	
	return template;
}

//댓글 삭제 함수
function delRow(e) {
	//li의 첫번째 span의 텍스트를 가져옴 = rno
	let rno = e.target.parentElement.parentElement.firstElementChild.innerText;
	
	svc.removeReply(rno, 
		result => {
			if(result.retCode == "OK") {
				alert('삭제 완료');
				//삭제 후 댓글 리스트 출력
				showList();
				//삭제 후 페이징 출력
				svc.getReplyCount(bno, createPageList, err => console.log(err));
			} else if(result.retCode == "FAIL") {
				alert('처리중 예외');
			} else {
				alert('알수없는 코드')
			}
		},
		err => console.log(err))
}


