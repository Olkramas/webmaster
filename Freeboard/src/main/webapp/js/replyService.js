/*
	replyService.js

*/

const svc = {
	//.then(result => {})					//중괄호 안에 함수 정의하면 됨.
	//.then(data => functionName(data))		//매개변수를 요구하는 함수 외부에서 함수를 정의하면 됨.
	//.then(functionName => functionName())	//매개변수를 요구하지 않는 함수라면 이렇게 처리도 가능

	rlist(param = {bno, page}, successFunc, errorFunc) {
		fetch("replyList.do?bno=" + param.bno +"&page=" + param.page)
			.then(resolve => resolve.json())
			.then(successFunc)
			.catch(errorFunc)
	}
	,removeReply(rno=1, successFunc, errorFunc) {
		fetch("removeReply.do?rno=" + rno)
			.then(resolve => resolve.json())
			.then(successFunc)
			.catch(errorFunc)
	}
	,addReply(param = {bno, reply, replyer}, successFunc, errorFunc) {
		fetch('addReply.do?bno=' + param.bno + '&reply=' + param.reply + '&replyer=' + param.replyer)
			.then(resolve => resolve.json())
			.then(successFunc)
			.catch(errorFunc)
	}
	,getReplyCount(bno = 1, successFunc, errorFunc) {
		fetch("replyCount.do?bno=" + bno)
			.then(resolve => resolve.json())
			.then(successFunc)
			.catch(errorFunc)
	}
	
}

