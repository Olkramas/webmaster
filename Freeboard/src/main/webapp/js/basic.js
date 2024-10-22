console.log("basic.js")

/*
	<ul>
		<li>Apple</li>
		<li>Banana</li>
		<!-- <li>cherry</li> -->
	</ul>	
	<table border="1">
		<tbody>
			<tr>
				<th>이름</th><td>박길동</td>
			</tr>
			<!-- 
			<tr>
				<th>이름</th><td>홍길동</td>
			</tr>
			-->
		</tbody>
	</table>
	<table id="table2" border="2">
		<thead>
			<tr>
			<th>이름</th><th>나이</th>
			</tr>
		</thead>
		<tbody>
						
		</tbody>
		
	</table>
*/
let name = "홍길동";
let age = 20;

let obj = {
	name: "홍길동",
	age: 20,
	showInfo: function() {
		return this.name + ' - ' + this.age;
	}
}
console.log(name);
console.log(age);

console.log(obj.name);
console.log(obj.age);
console.log(obj.showInfo());

//동적으로 html에 내용추가하기
/*
let li = document.createElement("li");
li.innerText = "cherry";

let ul = document.querySelector("#show ul");
ul.appendChild(li);

document.querySelectorAll("#show ul li").forEach(function(fruit) {
	fruit.style.color = "red";
	console.log(fruit.addEventListener("click", function(e) {
		fruit.remove();
	}))
})
*/
let li = document.createElement("li");
li.innerText = "cherry";

let ul = document.querySelector("#show ul");
ul.appendChild(li);

let list = document.querySelectorAll("#show ul li");
for (let i of list) {
	i.style.color = "red";
	i.addEventListener("click", function() {
		i.remove();
	})
}

let tr = document.createElement("tr");
let td = document.createElement("th");

td.innerHTML = "이름";
tr.appendChild(td);

td = document.createElement("td");
td.innerHTML = "홍길동";

let data = [obj];
data.push({ name: "박민수", age: 22 });
data.push({ name: "송민혁", age: 25 });

function makeList() {
	let table = document.querySelector("#show table:nth-of-type(2)");
	table.classList.add("table");
	let tbody = table.querySelector("tbody");

	for (let i of data) {

		let tr2 = document.createElement("tr");
		let td2 = document.createElement("td");

		td2.innerHTML = i.name;
		tr2.appendChild(td2);

		td2 = document.createElement("td");
		td2.innerHTML = i.age;
		tr2.appendChild(td2);

		tbody.appendChild(tr2);
	}
}

//makeList();

function makeList2() {
	document.querySelector("#show table:nth-of-type(2)").className ="table";
	//document.querySelector("#show table:nth-of-type(2)").classList.add("table");
	for (let i of data) {

		let tr2 = document.createElement("tr");
		let td2 = document.createElement("td");

		td2.innerHTML = i.name;
		tr2.appendChild(td2);

		td2 = document.createElement("td");
		td2.innerHTML = i.age;
		tr2.appendChild(td2);

		document.querySelector("#show table:nth-of-type(2) tbody").appendChild(tr2);
	}
	
}
makeList2();




