/*
	ajax1.js
	= Asynchronous Javascript And Xml.
	비동기방식 처리
	서버의 리소스를 가져오는 작업
	
	자바스크립트는 비동기방식 처리를 지원해줌
*/

let xhtp = new XMLHttpRequest();	//비동기 방식 처리
xhtp.open('get', "memberJson.do");//서버상의 리소스를 호출할때 사용하는 메소드 (준비만 함)
xhtp.send(); //서버상의 리소스를 가져오는 작업을 함

let data = [];
xhtp.onload = function() {
	let obj = JSON.parse(xhtp.responseText);
	console.log(obj);
	data = obj;
	console.log('1', data);
	for(let i=0; i<data.length; i++) {
	console.log(data[i]);
}
}
console.log('2', data);	//onload메소드보다 먼저 실행됨


