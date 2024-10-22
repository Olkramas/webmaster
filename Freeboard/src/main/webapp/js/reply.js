/*
	reply.js
*/

//replyService에서 생성했던 메소드들을 호출해서 사용하려고 함.

svc.showMsg('hello');

svc.rlist(173	//bno 파라미터
		,function(result) {
			let fields = ['replyNo', 'reply', 'replyer']
			console.log(result);	//배열
			for(let i=0; i<result.length; i++) {
			let tr = document.createElement("tr");
				for(let j=0; j<fields.length; j++) {
					let td = document.createElement("td");
					td.innerHTML = result[i][fields[j]];
					tr.appendChild(td);
				}					
			document.querySelector("#replyList tbody").appendChild(tr);
			}
		}	//successFnc
		,function(err) {
			console.log(err);
			
		}	//errorFunc
		)