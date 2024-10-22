/*
 json.js
 자바스크립트는 키: 값 => java object
 {name: "홍길동", age:20}
 
 
 제이슨방식 => jason object 
 {"name": "홍길동", "age": 20}
 json문자열을 파싱하면 자바스크립트 객체가 되고 이를 또 jason문자열로 바꿀 수 있음
 
 <table class="table">
		<thead>
			<tr>
				<th>ID</th><th>firstName</th><th>lastName</th><th>Email</th><th>salary</th><th>삭제</th>
			</tr>
		</thead>
		<tbody>
				
		</tbody>
	</table>
*/

let obj = { name: "홍길동", age: 20 }

//자바스크립트 객체를 json문자열로 만들기
let json = JSON.stringify(obj);	//obj -> string

//json문자열을 자바스크립트 객체로 바뀜
obj = JSON.parse(json);		//string -> obj

//파일들을 가져와서. then으로 읽음
fetch('js/MOCK_DATA.json').then(function(resolve) {
	console.log(resolve);
	return resolve.json();//자바스크립트의 객체타입으로 변환시켜줌
	}).then(function(result) {
		//객체로 변환된 결과를 여기서 처리할 수 있음.
		console.log(result);
		makeList(result);
	})

//jsp에서는 페이지를 직접 받아와서 출력했음
//이제부터는 json형태의 데이터를 받아와서 웹페이지를 작성하려고 함.

//console.log(obj);	//javascript object
//console.log(json);	//제이슨 문자열

//obj = JSON.parse(data);
//console.log(obj);

//obj배열에 있는 건수만큼 tr생성하고 tbody 하위요소로 넣으면 됨.

function makeList(obj = []) {
	let fields = ['id', 'first_name', 'last_name', 'email', 'salary'];

	for (let i = 0; i < obj.length; i++) {
		//tr태그 선언
		let tr = document.createElement("tr");
		tr.addEventListener('mouseover', function(e) {
			tr.style.backgroundColor = 'gray';
		});
		tr.addEventListener('mouseout', function(e) {
			tr.style.backgroundColor = '';
		});
		for (let j = 0; j < fields.length; j++) {
			//td태그 선언
			let td = document.createElement("td");
			//obj[0]의 fields[0-3]까지의 필드'id', 'first_name', 'last_name', 'email'하나씩 다 가져오고
			//tr 밑으로 넣고  fields.length만큼 반복하게 됨.
			td.innerHTML = obj[i][fields[j]]; //obj.name, obj['name'] / [fields[j]]필드 이름임
			tr.appendChild(td);
		}
		//버튼을 넣을 td를 만들기
		let td = document.createElement("td");
		//버튼 태그 만들기
		let button = document.createElement("button");
		//버튼 안에 "삭제" 문자열 추가
		button.innerHTML = "삭제";
		//버튼을 td안에 넣기
		td.appendChild(button);
		//버튼을 넣은 td를 tr에 넣기
		tr.appendChild(td);
		//버튼이 클릭되면 해당 tr은 삭제됨.
		button.addEventListener("click", function(e) {
			//button.parentNode.parentNode.remove();
			tr.remove();
		})
		//다 만들어진 tr을 tbody에 넣기
		document.querySelector("#show tbody").appendChild(tr);

	}
}

//makeList();