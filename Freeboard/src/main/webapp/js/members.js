/*
	members.js
*/

//등록버튼에 대한 이벤트 추가
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


//1. 목록 출력
//json형태의 데이터가 필요함
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

//배열이 보내지지 않으면 빈 배열을 받겠다는 의미 obj = [] 안정성을 높임
function makeList(obj = []) {
	//작성
	for (let i = 0; i < obj.length; i++) {
		tr = makeRow(obj[i]);
		document.querySelector("#show tbody").appendChild(tr);
	}
}

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
	

}