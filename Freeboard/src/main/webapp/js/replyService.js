/*
	replyService.js
*/

const svc = {
	rlist(bno = 1, successFunc, errorFnc) {
		//Ajax호출
		fetch('replyList.do?bno=' + bno)
			.then(resolve => resolve.json())
			.then(successFunc)
			.catch(errorFnc)
	},
	showMsg(msg) {
		console.log(msg);
	}
	
}