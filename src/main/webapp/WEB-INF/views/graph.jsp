<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js">
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#personal2').click(function() {
	  google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
		  function drawChart() {
			  var  v1= $('#no0').text();
			  var  v2= parseInt($('#st0').text());
			  var  v3= parseInt($('#en0').text());
			  var  v4= parseInt($('#hi0').text());
			  var  v5= parseInt($('#lo0').text());
			  var  v6= $('#no1').text();
			  var  v7= parseInt($('#st1').text());
			  var  v8= parseInt($('#en1').text());
			  var  v9= parseInt($('#hi1').text());
			  var  v10= parseInt($('#lo1').text());
			  var  v11= $('#no2').text();
			  var  v12= parseInt($('#st2').text());
			  var  v13= parseInt($('#en2').text());
			  var  v14= parseInt($('#hi2').text());
			  var  v15= parseInt($('#lo2').text());
			  var  v16= $('#no3').text();
			  var  v17= parseInt($('#st3').text());
			  var  v18= parseInt($('#en3').text());
			  var  v19= parseInt($('#hi3').text());
			  var  v20= parseInt($('#lo3').text());
			  var  v21= $('#no4').text();
			  var  v22= parseInt($('#st4').text());
			  var  v23= parseInt($('#en4').text());
			  var  v24= parseInt($('#hi4').text());
			  var  v25= parseInt($('#lo4').text());
			  var f1 = [v2,v3,v4,v5];
			  var f2 = [v7,v8,v9,v10]; 
			  var f3 = [v12,v13,v14,v15];
			  var f4 = [v17,v18,v19,v20];
			  var f5 = [v22,v23,v24,v25];
			  if (v2 <= v3) {
				  f1.sort(function(v2, v3){return v2 - v3});
				  // 오름차순
			  }
			  else{
				  f1.sort(function(v2, v3){return v3 - v2});
				  // 내림차순
			  }// end if
			  if (v7 <= v8) {
				  f2.sort(function(v7, v8){return v7 - v8});
				  // 오름차순
			  }
			  else{
				  f2.sort(function(v7, v8){return v8 - v7});
				  // 내림차순
			  }// end if
			  if (v12 <= v13) {
				  f3.sort(function(v12, v13){return v12 - v13});
				  // 오름차순
			  }
			  else{
				  f3.sort(function(v12, v13){return v13 - v12});
				  // 내림차순
			  }// end if
			  if (v17 <= v18) {
				  f4.sort(function(v17, v18){return v17 - v18});
				  // 오름차순
			  }
			  else{
				  f4.sort(function(v17, v18){return v17 - v18});
				  // 내림차순
			  }// end if
			  if (v22 <= v23) {
				  f5.sort(function(v22, v23){return v22 - v23});
				  // 오름차순
			  }
			  else{
				  f5.sort(function(v22, v23){return v22 - v23});
				  // 내림차순
			  }// end if
			
		    var data = google.visualization.arrayToDataTable([
		      [ v1,f1[0],f1[1],f1[2],f1[3] ],
		      [ v6,f2[0],f2[1],f2[2],f2[3] ],
		      [ v11,f3[0],f3[1],f3[2],f3[3] ],
		      [ v16,f4[0],f4[1],f4[2],f4[3] ],
		      [ v21,f5[0],f5[1],f5[2],f5[3] ]
		    ], true);
		    var options = {
		    		legend:'none',
		       		bar: { groupWidth: '100%' }, // Remove space between bars.
		            candlestick: {
		              fallingColor: { strokeWidth: 0, fill: '#1614a5' }, // blue
		              risingColor: { strokeWidth: 0, fill: '#a52714' }   // red
		              }
		    };
		    var chart = new google.visualization.CandlestickChart(document.getElementById('chart_div'));
		    chart.draw(data, options);
		  }//enddrawChart		
		});//end click
	});//end ready
</script>
</head>
<body>
	<table border="1">
		<tr>
			<th>종목명</th>
			<th>일자</th>
			<th>시가</th>
			<th>종가</th>
			<th>고가</th>
			<th>저가</th>
		</tr>
		<c:forEach items="${GRAPH}" var="vo" varStatus="s">
			<tr>
				<td>${vo.name}</td>
				<td><label id="no${s.index}">${vo.date}</label></td>
				<td><label id="st${s.index}">${vo.start}</label></td>
				<td><label id="en${s.index}">${vo.end}</label></td>
				<td><label id="hi${s.index}">${vo.high}</label></td>
				<td><label id="lo${s.index}">${vo.low}</label></td>
			</tr>
		</c:forEach>
	</table>
	<!--pie chart가 실제로 그려질 부분-->
	<div id="chart_div"style="width: 900px; height: 500px;"></div>
	<button id="personal2">그래프 클릭2</button>
	<img src="http://localhost:8081/phn/resources/img/5won.png">
<img src="http://localhost:8081/phn/resources/img/100dollar.png">
</body>
</html>