<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      
      //db에서 데이터를 가져와서 저장할 배열변수 arr
   	  var arr = [['Writer', 'Count per Writer']];
      
      document.addEventListener('DOMContentLoaded', async function() {
          
          let resolve = await fetch("countByWriter.do")
          let result = await resolve.json()
          console.log(result);
    	  result.forEach(row => {
    		  arr.push([row.member_name, row.count]);
    	  })
    	  //Google Charts 라이브러리를 로드하는 함수 호출
    	  google.charts.load("current", {'packages':["corechart"]});
    	  
          google.charts.setOnLoadCallback(drawChart);
      })
      
      
      function drawChart() {
    	  
        var data = google.visualization.arrayToDataTable(
        	//데이터가 들어가는 곳
        	//[[],[],[]...[]]	배열안에 배열이 있는 모습.
          arr
        );

        var options = {
          title: '사용자별 게시글 현황',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
  </body>
</html>