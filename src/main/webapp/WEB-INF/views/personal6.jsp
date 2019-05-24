<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#personal').click(function() {
			var  v1= parseFloat($('#score1').text());
			var  v2= parseFloat($('#score2').text());
			var  v3= parseFloat($('#score3').text());
			var  v4= parseFloat($('#score4').text());
			var  v5= parseFloat($('#score5').text());
			// 구글 오픈 API에서 차트 객체 로드 
			google.charts.load('current', {
				'packages' : [ 'corechart' ]
			});
			// Google Visualization API  로드시 callback 사용할 콜백 함수 설정.
			google.charts.setOnLoadCallback(drawChart);
			// 이 함수에서 데이터 설정 및 차트를 그린다.
			function drawChart() {
				// 구글 차트는 데이터 테이블이라는 객체로 차트의 데이터를 전달한다.
				
				var data = new google.visualization.DataTable();
				//열 설정 2개를 설정하고 데이터 타입, 열이름
				data.addColumn('string', 'big5');
				data.addColumn('number', 'score');
				//행 추가 5개의 행을 추가한다. 
				//파이차트는  전체 합의 비율로 표시
				data.addRows([ [ 'Self-transcendence', 	v1    ],
						[ ' Tradition', v2 ], [ 'Hedonism ', v3 ],
						[ 'Self-enhancement', v4 ], [ 'Excitement', v5 ] ]);
				// chart 옵션 설정 범례, 가로 세로 
				var options = {
					'title' : '자소서 분석 결과',
					'width' : 800,
					'height' : 600
				};
				// 파이 차트 객체 생성 및 div 태그에 내용 전달
				var chart = new google.visualization.PieChart(document
						.getElementById('chart_div'));
				//차트 그리고 태그, 옵션
				chart.draw(data, options);
			}

		});//end click
		$('#personal2').click(function() {
			//parseInt()
		var  v1= parseFloat($('#score1').text());
		var  v2= parseFloat($('#score2').text());
		var  v3= parseFloat($('#score3').text());
		var  v4= parseFloat($('#score4').text());
		// 구글 오픈 API에서 차트 객체 로드 
		 google.charts.load('current', {'packages':['corechart']});
     	 google.charts.setOnLoadCallback(drawChart);
		// 이 함수에서 데이터 설정 및 차트를 그린다.
		function drawChart() {
  		   var data = google.visualization.arrayToDataTable([
				      [$('#name').text(), v1 , v2, v3, v4],
      				  ['Tue', 0.2 , 0.77, 0.5, 0.56],
      				['Wed', v2, v1, v3, v4]
      				
      			    ], true);
       var options = {       legend:'none'    };
       var chart = new google.visualization.CandlestickChart(document.getElementById('chart_div'));
       chart.draw(data, options);
		}

		});//end click

	});//end ready
</script>
</head>
<body>
	<div>
		<h3>자소서 분석 사이트</h3>
	</div>
	<div>
		<a href="list"><h3>전체 리스트</h3></a>
		<a href="home">home</a>
	</div>

	<table border="1">
		<tr>
			<th>no</th>
			<th>name</th>
			<th>WordCount</th>
	<th>자기초월 [Self-transcendence ]</th>
	<th>보수 [ Tradition)]</th>
	<th>쾌락주의[Extraversion]</th>
	<th>친화성[Hedonism ]</th>
	<th>자기개선[(Self-enhancement ] </th>
		</tr>
		<tr>
			<td><label id="no">${list.no}</label></td>
			<td><label id="name">${list.name}</label></td>
			<td><label id="count">${list.count}</label></td>
			<td><div id="score1" >${list.score1}</div></td>
			<td><div id="score2" >${list.score2}</div></td>
			<td><div id="score3" >${list.score3}</div></td>
			<td><div id="score4" >${list.score4}</div></td>
			<td><div id="score5" >${list.score5}</div></td>
		</tr>
	</table>
	<div>
		<br />
		<button id="personal">그래프 클릭</button>
		<button id="personal2">그래프 클릭2</button>
		<br /> <br />
	</div>
	<div>
	
	<!--pie chart가 실제로 그려질 부분-->
	<div id="chart_div"></div>
	<div id="chart_div2"></div>

	
</body>
</html>