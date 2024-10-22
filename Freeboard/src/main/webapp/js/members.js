/*
	members.js
*/

//등록버튼에 대한 이벤트 추가
/*
document.querySelector("#addBtn").addEventListener('click', function(e) {
	let id = document.querySelector("#mid").value;
	let name = document.querySelector("#mname").value;
	let phone = document.querySelector("#mphone").value;

	//값을 보낼때도 fetch
	fetch('addMemberJson.do?id=' + id + '&name=' + name + "&phone=" + phone)
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result)
			if (result.retCode == "OK") {
				let tr = makeRow({ memberId: id, memberName: name, phone: phone })
				document.querySelector("#show tbody").appendChild(tr);
			} else if (result.retCode == "FAIL") {
				alert("처리중 에러가 발생.");
			}
		})
		.catch(err => { console.log(err) })
})
*/
document.querySelector("#addBtn").addEventListener('click', function(e) {
	let id = document.querySelector('#mid').value;
	let name = document.querySelector('#mname').value;
	let phone = document.querySelector('#mphone').value;
	
	fetch("addMemberJson.do?id=" + id + "&name=" + name + "&phone=" + phone)
		.then(resolve => resolve.json())
		.then(result => {
			if(result.retCode == "OK") {
				let tr = makeRow({memberId: id, memberName: name, phone: phone})
				document.querySelector("#show tbody").appendChild(tr);
			} else if(result.retCode == "FAIL") {
				alert("처리중 에러가 발생");
			}
		})
		.catch(err => {console.log(err)})
})


//1. 목록 출력
//json형태의 데이터가 필요함
/*
fetch('memberJson.do')
	//resolve를 받아서 resolve.json()를 리턴하겠다
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		makeList(result);
	})
	.catch(err => {
		//.then(function(resolve)여기가 실행이 안되면 catch로 오게됨/
		console.log(err);
	})
*/
//이 요청이 들어오면 서버에서 json형태의 데이터를 반환하게 됨.
fetch('memberJson.do')
		//resolve는 서버에서 받은 응답의 객체(response). 웅답 형식이 json형식일때 자바스크립트 객체로 파싱해줌 그 파싱된 객체가 아래의 result
		.then(resolve => resolve.json())
		//json형식의 데이터를 자바스크립트 객체로 파싱된 결과를 result에 담아서 정보를 처리할 수 있음
		.then(result => {
			console.log(result);
			makeList(result);
		})
		//json 파싱중 오류가 생기면 여기로 오게 됨. err는 오류 객체
		.catch(err => {
			console.log(err);
		})
/*
//배열이 보내지지 않으면 빈 배열을 받겠다는 의미 obj = [] 안정성을 높임
function makeList(obj = []) {
	//작성
	for (let i = 0; i < obj.length; i++) {
		tr = makeRow(obj[i]);
		document.querySelector("#show tbody").appendChild(tr);
	}
}
*/

//result객체에서 정보를 가지고 html에 추가해주는 작업
function makeList(obj = []) {	//obj = []만약 배열이 보내지지 않으면 빈 배열을 받겠다는 의미. 안정성을 높히기위해 사용.
	for(let i=0; i<obj.length; i++) {
		//result객체의 배열에서 하나를 선택해서 makeRow 함수로 보냈음 안에서 처리됨.
		tr = makeRow(obj[i]);
		//tr을 #show tbody의 자식 태그로 넣었음.
		document.querySelector('#show tbody').appendChild(tr);
	}
}

/*
//obj = {}객체라는 의미
function makeRow(obj = {}) {
	let field = ['memberId', 'memberName', 'phone'];
	let tr = document.createElement("tr");
	//data-id = 회원아이디 아래 함수에서 dataset.id로 불러올 수 있음
	tr.setAttribute('data-id', obj.memberId);
	
	for (let j = 0; j < field.length; j++) {
		let td = document.createElement("td");
		td.innerHTML = obj[field[j]];
		tr.appendChild(td);
	}
	let td = document.createElement("td");
	let button = document.createElement("button");
	button.className = "btn btn-danger";
	button.innerHTML = "삭제";
	td.appendChild(button);
	tr.appendChild(td);
	button.addEventListener("click", deleteRowFnc);
	return tr;
}
*/
//만약 매개변수로 오는 객체가 undefinded나 잘못 오게 돼도 빈객체를 기본으로 넣어줘서 오류의 확률이 줄어듦.
function makeRow(obj = {}) {
	//매개변수로 받은 객체의 'memberId', 'memberName', 'phone'들을 가지고 오기 위한 배열을 선언(중복을 피하기 위해 이렇게 선언해서 사용하면 편함)
	let field = ['memberId', 'memberName', 'phone'];
	//tr 태그 선언
	let tr = document.createElement("tr");
	//tr태그의 속성으로 data-id를 매개변수로 받은 객체의 memberId로 지정함. / data-id는 사용자 정의 속성
	tr.setAttribute('data-id', obj.memberId);
	for(let j=0; j<field.length; j++) {
		//td 태그 선언
		let td = document.createElement("td");
		//td에 매개변수로 받은 객체의 필드를 넣어서 값을 가져옴. 이를 td에 저장
		td.innerHTML = obj[field[j]];
		//만들어진 td를 tr에 넣기
		tr.appendChild(td);
	}
	//버튼을 넣을 td태그 만들기
	let td = document.createElement('td');
	//버튼 만들기
	let button = document.createElement('button')
	button.className = "btn btn-danger"
	button.innerHTML = '삭제';
	//버튼 td에 넣기
	td.appendChild(button);
	//만든 버튼 tr에 넣기
	tr.appendChild(td);
	//클릭 이벤트가 발생하면 deleteRowFnc함수 실행하기
	button.addEventListener('click', deleteRowFnc);
	//tr을 호출한 곳으로 리턴해주기
	return tr;
}

function deleteRowFnc(e) {
	//콘솔로 이 경로에 있는 값 확인할 수 있음.
	console.log(e.target.parentElement.parentElement.dataset.id);
	
	//설정된 id를 가져옴
	let id = e.target.parentElement.parentElement.dataset.id;
	
	fetch('removeMemberJson.do?id=' + id)
		.then(resolve => resolve.json())
		.then(result => {
			if(result.retCode == "OK") {
				alert("성공");
				//tr을 삭제함
				e.target.parentElement.parentElement.remove();
			} else if(result.retCode == "FAIL") {
				alert("실패");
			}
		})
		.catch(err => console.log(err));
}
	
/*
//이벤트 핸들러 함수에는 이벤트가 전달되게 됨.
function deleteRowFnc(e) {
	//삭제하고 싶은 아이디 콘솔로 출력
	console.dir(e.target.parentElement.parentElement.firstElementChild.innerText);
	let id = e.target.parentElement.parentElement.dataset.id;
	
	fetch('removeMemberJson.do?id='+id)
		.then(resolve => resolve.json())
		.then(result => {
			if(result.retCode == "OK") {
				alert('성공');
				e.target.parentElement.parentElement.remove();
			} else if(result.reCode == "FAIL") {
				alert("처리중 에러가 발생.");
			}
		})
		.catch(err => console.log(err))
*/

