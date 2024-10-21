console.log("basic.js")

let name = "홍길동";
let age = 20;
let obj = {name: "홍길동"
		   ,age: 20
		   ,showInfo: function() {
			   return this.name + " - " + this.age;
		   }}
		   
console.log(obj.name);
console.log(obj['age']);
console.log(obj.showInfo());

//DOM

let li = document.createElement("li");
li.innerText = 'cherry';

//아이디 값이 show아래에 잇는 ul을 가지고 옴
let ul =  document.querySelector("#show ul");
ul.appendChild(li);	//특정 요소의 자식 요소로 다른 요소를 추가할 때 사용

console.log(ul); //ul태그의 하위에 가면 apple, banana, chery다 있게됨.

document.querySelectorAll("#show ul li").forEach(function(fruit) {
	fruit.style.color = "red";
	console.log(fruit.addEventListener("click", function(e) {
		//지울때 .remove();
		fruit.remove();
	}));	//fruit.innerHTML하면 값을 볼 수 있음
});


let tr = document.createElement("tr");	//tr태그 만들기
let td = document.createElement("th");	//th태그 만들기

td.innerText = "이름";					//th태그안에 이름 넣기
tr.appendChild(td);						//tr태그의 자식 태그로 넣기

td = document.createElement("td");		//td태그 만들기
td.innerText = "홍길동";					//td태그안에 홍길동 넣기
tr.appendChild(td);						//td를 tr의 자식태그로 넣기

//let tbody = document.querySelector("#show table tbody");	//tbody 태그 가져오기
//tbody.appendChild(tr);					//tbody태그의 자식태그로 넣기


let data = [obj];
data.push({name: "박민수", age: 22});
data.push({name: "송민혁", age: 25});

//data배열에 있는 정보를 출력하기
/*
let tbody1 = document.querySelector("#show table:nth-of-type(2) tbody");

for(let i of data ) {
	let tr = document.createElement("tr");
	let td = document.createElement("td");
	td.innerText = i.name;
	tr.appendChild(td);
	
	td = document.createElement("td");
	td.innerText = i.age;
	tr.appendChild(td);
	tbody1.appendChild(tr);
}
*/
//교수님 해설
makeList();
function makeList() {
	document.querySelector("#show table:nth-of-type(2) tbody").class = 'table';
	
	for(let i=0; i<data.length; i++) {
		let tr = document.createElement("tr");
		let td = document.createElement("td");
		td.innerText = data[i].name;
		tr.appendChild(td);
		
		td = document.createElement("td");
		td.innerText = data[i].age;
		tr.appendChild(td);
		
		document.querySelector("#show table:nth-of-type(2) tbody").appendChild(tr);
	}
}









