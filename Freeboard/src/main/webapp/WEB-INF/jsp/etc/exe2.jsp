<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script>
    document.addEventListener('DOMContentLoaded', function (e) {
    	//#list는 실제날짜를 넣어주는 div
      createCalender(document.querySelector('#list'));
    })

    // 달력생성함수.
    function createCalender(target) {
      let tr = document.createElement('tr');
      //for문 안에 있는 d의 값만 규칙을 찾아서 바꾸면 10월 말고 다른 월에도 사용가능
      for(let d=1; d<=2; d++) {
        let tdSpace = document.createElement('td');
    	tdSpace.innerHTML = "&nbsp;";
        tr.appendChild(tdSpace);
      }
	  //완성된 공백을 tr안에 넣기      
      target.appendChild(tr);
	  //공백이 몇개인지 가져오기 위해서 공백이 들어간 노드리스트 반환
      let spaceLength = document.querySelectorAll('#list td');
      
      for (let d = 1; d <= 31; d++) {
    	  
        let td = document.createElement('td');
        td.innerHTML = d;
        tr.appendChild(td);
        
        //공백 개수에 따라 첫째줄에 들어가는 숫자 개수를 다르게 하기 위한 조건
        if ((d + spaceLength.length) % 7 == 0) {
       	  td.style.color = "blue";
          document.querySelector('#list').appendChild(tr);
          tr = document.createElement('tr'); // 토요일(7번 td를 생성하면)이 되면 tr을 새롭게 생성.
        }
        
        if(d-6 == 0 || (d-6) % 7 == 0) {
       	  td.style.color = "red";
        }
        
        
        
      }
      target.appendChild(tr);
      
      /*
      //모든 날짜가 들어간 후의 노드리스트 반환
      let dayOfCalendar = document.querySelectorAll("#list td");
      
      console.log(dayOfCalendar);
      for(let i = 1; i <= dayOfCalendar.length; i++) {
    	  
    	  
    	  if (i%7 == 0) {
    		  dayOfCalendar[i].style.color = "red";
    	  }
      }
      */
    }
  </script>
</head>

<body>

  <div id="show">
    <table border="1">
      <thead>
        <tr>
          <th>Sun</th>
          <th>Mon</th>
          <th>Tue</th>
          <th>Wed</th>
          <th>Thr</th>
          <th>Fri</th>
          <th>Sat</th>
        </tr>
      </thead>
      <tbody id="list"></tbody>
    </table>

  </div>

</body>

</html>