//obj = {}객체라는 의미
function makeRow(obj = {}) {
	let field = ['memberId', 'memberName', 'phone'];
	let tr = document.createElement("tr");
	for (let j = 0; j < field.length; j++) {
		let td = document.createElement("td");
		td.innerHTML = obj[i][field[j]];
		tr.appendChild(td);
	}
	let td = document.createElement("td");
	let button = document.createElement("button");
	button.innerHTML = "삭제";
	td.appendChild(button);
	tr.appendChild(td);
	button.addEventListener("click", function(e) {
		tr.remove();
	});
	return tr;
}
