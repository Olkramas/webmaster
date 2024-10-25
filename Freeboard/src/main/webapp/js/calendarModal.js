/*
calendarModal.js
*/



function modalShow(arg) {
	
	modalArg = arg;
	// body 태그
	let body = document.querySelector('body')
	body.className = 'modal-open';
	body.style.overflow = 'hidden';
	body.style.paddingRight = '15px';
	
	/*
	let body = document.querySelector('body');
	body.removeAttribute("style");
	body.removeAttribute("class");
	*/
	
	let div = document.createElement('div');
	div.className = 'modal-backdrop fade show';
	body.appendChild(div);
	
	/*
	let div = document.querySelector('modal-backdrop fade show');
	div.remove();
	*/

	// 모달태그
	let modal = document.querySelector('#exampleModal');
	modal.classList.add('show');
	modal.setAttribute('aria-modal', true);
	modal.setAttribute('role', 'dialog');
	modal.removeAttribute('aria-hidden');
	modal.style.display = 'block';
	
	/*
	let modal = document.querySelector('#exampleModal');
	modal.removeAttribute('class');
	modal.removeAttribute('aria-modal');
	modal.removeAttribute('role');
	modal.setAttribute('aria-hidden', true);
	modal.style.display = 'none';
	*/

	
	start.value = modalArg.startStr;
	end.value = modalArg.endStr;

}

function modalSave() {
	/*
	if(getTitle == null) {
		alert('제목을 입력해주세요');
		return;
	}
	*/	
	
	//title, startStr, endStr
	let title = document.querySelector("#title").value;
	console.log(title);
	console.log(modalArg.start);
	console.log(modalArg.end);
	let start = document.querySelector("#start").value;
	let end = document.querySelector("#end").value;
	//fetch로 url요청 보내기
	fetch('addEvent.do?title=' + title + '&start=' + start + '&end=' + end)
		.then(resolve => resolve.json())
		.then(result => {
			if (result.retCode == "OK") {
				alert("일정 추가 완료!");
				if (title) {
					console.log('실행됨');
					calendar.addEvent({
						title: title,
						start: modalArg.start,
						end: modalArg.end,
						allDay: modalArg.allDay//화면에 출력 해주는 친구
					})
					modalClose();
				}
				
			} else if (result.retCode == "FAIL") {
				alert("일정추가 실패");
			}
			
		})
		.catch(err => console.log(err))
		
}

function modalClose() {
	//body부분 속성 변경
	//div modal의 속성변경
	//backdrop 속성변경
	console.log('실행됨');
	let body = document.querySelector('body');
	body.removeAttribute("style");
	body.removeAttribute("class");
	
	let div = document.querySelector('.modal-backdrop');
	div.remove();
	
	let modal = document.querySelector('#exampleModal');
	modal.classList.remove('show');
	modal.removeAttribute('aria-modal');
	modal.removeAttribute('role');
	modal.setAttribute('aria-hidden', true);
	modal.style.display = 'none';
	
	let title = document.querySelector("#title");
	title.value = '';
}

//event가 이벤트 객체가 아니고 매개변수라는 의미
function startChange(event) {
	modalArg.start = new Date(event.target.value);	//2024-10-25 값을 바꿨을때 해당 하위로 가보면 값이 바껴있음
	console.log(modalArg.start);
}

function endChange(event) {
	modalArg.end = new Date(event.target.value);
	console.log(modalArg.end);
}