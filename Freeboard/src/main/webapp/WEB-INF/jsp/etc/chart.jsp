<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      var chartData = [['Writer', 'Count per Writer']];
      
      //서버 리소스를 호출함
      fetch("countByWriter.do")
      	.then(resolve => resolve.json())
      	.then(result => {
      		console.log(result);
      		result.forEach(row => {
      			//chartData 배열에 제이슨 문자열 각 하나를 선택(row) 그리고 그 row에 대해서
      			//member_name, count를 가져와서 추가하게 됨.
      			chartData.push([row.member_name, row.count]);
      		});
      		console.log(chartData);
      		google.charts.load('current', {'packages':['corechart']});
      		
            //함수를 콜백함수로 받아서 사용중
            google.charts.setOnLoadCallback(drawChart);
      	})
      	.catch(err => console.log(err))
      	
      

      function drawChart() {

        var data = google.visualization.arrayToDataTable(
        	chartData
        /*[
        	//배열안에 배열이 있는 형식
        	//이 형태로 데이터를 반환해주는 컨트롤이 있어야 함.
          ['Task', 'Hours per Day'],
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7],
          ['test',     3]
        ]*/);
		
        var options = {
          title: '사용자별 게시글 현황'
        };
		
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      } // end of drawChart
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
