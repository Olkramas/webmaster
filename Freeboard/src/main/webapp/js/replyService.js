/*
	replyService.js
*/

/*
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
*/

const svc = {
	//bno = 게시물 번호 기본값:1 / successFunc 댓글 리스트 가져오기 성공하면 실행 / errorFunc 가져오기 실패하면 실행
	rlist(param = {bno, page}, successFunc, errorFunc) {
		fetch("replyList.do?bno=" + param.bno + "&page=" + param.page)
			.then(resolve => resolve.json())
			.then(successFunc)
			.catch(errorFunc)
			//successFunc는 함수를 호출하지 않고 넘기는 방식
			//이 경우 제이슨 형태로 넘어온 데이터를 자바 객체로 바꾸고 이를 successFunc내부에서 처리하게 됨.
	}
	//.then(result => {})					//중괄호 안에 함수 정의하면 됨.
	//.then(data => functionName(data))		//매개변수를 요구하는 함수 외부에서 함수를 정의하면 됨.
	//.then(functionName => functionName())	//매개변수를 요구하지 않는 함수라면 이렇게 처리도 가능
	,removeReply(rno = 1, successFunc, errorFunc) {
		fetch('removeReply.do?rno=' + rno)
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

