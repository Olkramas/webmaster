

let delBtn = document.querySelector("#delBtn");
delBtn.onclick = removeEle;
//delBtn.addEventListener('click', removeEle);

function removeEle() {
	let searchVal = document.querySelector("#userValue").value;
	console.log(searchVal);
	
	let allSpan = document.querySelectorAll(".container span");
	console.log(allSpan);
	for(let i of allSpan) {
		
		if(i.innerHTML == searchVal) {
			i.remove();
		}
	}
}
