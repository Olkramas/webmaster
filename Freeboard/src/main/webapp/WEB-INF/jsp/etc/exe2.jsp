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
      for (let d = 1; d <= 31; d++) {
        let td = document.createElement('td');
        td.innerHTML = d;
        tr.appendChild(td);
        if (d % 7 == 0) {
          document.querySelector('#list').appendChild(tr);
          tr = document.createElement('tr'); // 토요일(7번 td를 생성하면)이 되면 tr을 새롭게 생성.
        }
      }
      target.appendChild(tr);
    }
    
    function createCal(target) {
    	let tr = document.createElement('tr');
    	let td = null;
    	let startSpace = 2;
    	
        for (let d = 1; d <= 35; d++) {
          td = document.createElement('td');
        }
        let list = document.querySelectorAll('#list td');
        for(int d=1; d<=(31 + 2) && )
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