<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<meta charset='utf-8' />
<script src='./dist/index.global.js'></script>
<script>
  //'DOMContentLoaded'페이지가 다 로딩되면 이 함수가 실행됨
  //자바스크립트 코드가 html보다 위에 와서 이 이벤트를 설정했음
	
  
  
  document.addEventListener('DOMContentLoaded', async function() {
    var calendarEl = document.getElementById('calendar');
    
    var eventData = [];
    
    //Ajax호출
    //new Promise(function() {}. function() {})
  //Primise객체가 반환될 때 await 수행코드 --> 그 후에 다음 코드 실행(동기 방식으로 바꿔줌) async 함수 안에 있어야 함
    let resolve = await fetch("getEvent.do")	//await의 덕분에 모든 데이터를 가져오고 동기적 방식으로 처리가 가능함
  	let result = await resolve.json() 
  	//함수내 로컬변수로 선언한 배열에 모든 일정에 대한 결과를 받았음
  	//hashMap으로 리턴된 결과물을 제이슨 문자열로 변환 시켜서 키:값의 형태로 들어가있음.{"000":"000"} 이런식
  	eventData = result 				  
  		
  		var calendar = new FullCalendar.Calendar(calendarEl, {
  	      headerToolbar: {
  	        left: 'prev,next today',
  	        center: 'title',
  	        right: 'dayGridMonth,timeGridWeek,timeGridDay'
  	      },
  	      initialDate: '2024-10-01',
  	      navLinks: true, // can click day/week names to navigate views
  	      selectable: true,
  	      selectMirror: true,
  	      select: function(arg) {
  	    	//제목 받기
  	        var title = prompt('Event Title:');
  	        console.log(arg);
  	        //startStr endStr
  	        //등록하려면, title, start, end값이 있어야 함.
  	        if(title == null || title == "") {	//만약 사용자가 일정 제목을 입력하지 않았을 경우에는 아래 코드가 실행되지 않도록 만들었음.
  	        	alert('일정 제목을 입력해주세요');
  	        } else {
  	        	//fetch로 url요청 보내기
  	        	 fetch('addEvent.do?title='+ title +'&start='+ arg.startStr +'&end=' + arg.endStr)
   	        	.then(resovle => resolve.json())
   	        	.then(result => {
   	        		if(result.retCode == "OK") {
   	        			alert("일정 추가 완료!");
   	        			//title이 공백이 아니면 아래코드 실행
   	        			if (title) {
   	          	          	calendar.addEvent({
   	          	            title: title,
   	          	            start: arg.start,
   	          	            end: arg.end,
   	          	            allDay: arg.allDay//화면에 출력 해주는 친구
   	          	          })
   	          	        }
   	        		} else if(result.retCode == "FAIL"){
   	        			alert("일정추가 실패");
   	        		}
   	        	})
   	        	.catch(err => console.log(err)) 	
  	        }
  	        
  	        //화면에 출력
  	        if (title) {
  	          calendar.addEvent({
  	            title: title,
  	            start: arg.start,
  	            end: arg.end,
  	            allDay: arg.allDay
  	          })	//화면에 출력 해주는 친구
  	        }
  	        calendar.unselect()
  	      },
  	      eventClick: function(arg) {
  	    	  console.log(arg)
  	          //console.log(arg.event._def.title);
  	          let getTitle = arg.event._def.title;
  	          
  	        if (confirm('Are you sure you want to delete this event?')) {
  	          arg.event.remove()
  	          fetch('removeEvent.do?title='+ getTitle)
   	        	.then(resovle => resolve.json())
   	        	.then(result => {
   	        		if(result.retCode == "OK") {
   	        			alert("일정 삭제 완료!");
   	        			
   	        		} else if(result.retCode == "FAIL"){
   	        			alert("일정 삭제 실패!");
   	        		}
   	        	})
   	        	.catch(err => console.log(err))
  	          
  	        }
  	      },
  	      editable: true,
  	      dayMaxEvents: true, // allow "more" link when too many events
  	      events: eventData // [{},{},{}..{}}] 이런식으로 있었음

  	    });
  		//얘를 호출해야 캘린더가 그려짐
  	    calendar.render();
  		console.log(eventData);
  	});
  	//.catch(err => console.log(err))
  
  

</script>
<style>


#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id='calendar'></div>

</body>
</html>