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
<style>
body {
	background-image:
		url("http://localhost:8081/phn/resources/img/beach.jpg");
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

h4 {
	color: white;
	text-align: center;
}

th {
	padding: 3px;
	text-align: center;
}

td {
	padding: 3px;
	text-align: center;
}
</style>
<script type="text/javascript">
	$(document).ready(
			function() {
				google.charts.load('current', {
					'packages' : [ 'corechart' ]
				});
				google.charts.setOnLoadCallback(drawChart);
				function drawChart() {
					var v1 = $('#no0').text();
					var v2 = parseInt($('#st0').text());
					var v3 = parseInt($('#en0').text());
					var v4 = parseInt($('#hi0').text());
					var v5 = parseInt($('#lo0').text());
					var v6 = $('#no1').text();
					var v7 = parseInt($('#st1').text());
					var v8 = parseInt($('#en1').text());
					var v9 = parseInt($('#hi1').text());
					var v10 = parseInt($('#lo1').text());
					var v11 = $('#no2').text();
					var v12 = parseInt($('#st2').text());
					var v13 = parseInt($('#en2').text());
					var v14 = parseInt($('#hi2').text());
					var v15 = parseInt($('#lo2').text());
					var v16 = $('#no3').text();
					var v17 = parseInt($('#st3').text());
					var v18 = parseInt($('#en3').text());
					var v19 = parseInt($('#hi3').text());
					var v20 = parseInt($('#lo3').text());
					var v21 = $('#no4').text();
					var v22 = parseInt($('#st4').text());
					var v23 = parseInt($('#en4').text());
					var v24 = parseInt($('#hi4').text());
					var v25 = parseInt($('#lo4').text());
					var v26 = $('#no5').text();
					var v27 = parseInt($('#st5').text());
					var v28 = parseInt($('#en5').text());
					var v29 = parseInt($('#hi5').text());
					var v30 = parseInt($('#lo5').text());
					var v31 = $('#no6').text();
					var v32 = parseInt($('#st6').text());
					var v33 = parseInt($('#en6').text());
					var v34 = parseInt($('#hi6').text());
					var v35 = parseInt($('#lo6').text());
					var f1 = [ v2, v3, v4, v5 ];
					var f2 = [ v7, v8, v9, v10 ];
					var f3 = [ v12, v13, v14, v15 ];
					var f4 = [ v17, v18, v19, v20 ];
					var f5 = [ v22, v23, v24, v25 ];
					var f6 = [ v27, v28, v29, v30 ];
					var f7 = [ v32, v33, v34, v35 ];
					if (v2 <= v3) {
						f1.sort(function(v2, v3) {
							return v2 - v3
						});
						// 오름차순
					} else {
						f1.sort(function(v2, v3) {
							return v3 - v2
						});
						// 내림차순
					}// end if
					if (v7 <= v8) {
						f2.sort(function(v7, v8) {
							return v7 - v8
						});
						// 오름차순
					} else {
						f2.sort(function(v7, v8) {
							return v8 - v7
						});
						// 내림차순
					}// end if
					if (v12 <= v13) {
						f3.sort(function(v12, v13) {
							return v12 - v13
						});
						// 오름차순
					} else {
						f3.sort(function(v12, v13) {
							return v13 - v12
						});
						// 내림차순
					}// end if
					if (v17 <= v18) {
						f4.sort(function(v17, v18) {
							return v17 - v18
						});
						// 오름차순
					} else {
						f4.sort(function(v17, v18) {
							return v18 - v17
						});
						// 내림차순
					}// end if
					if (v22 <= v23) {
						f5.sort(function(v22, v23) {
							return v22 - v23
						});
						// 오름차순
					} else {
						f5.sort(function(v22, v23) {
							return v23 - v22
						});
						// 내림차순
					}// end if
					if (v27 <= v28) {
						f6.sort(function(v27, v28) {
							return v27 - v28
						});
						// 오름차순
					} else {
						f6.sort(function(v27, v28) {
							return v28 - v27
						});
						// 내림차순
					}// end if
					if (v32 <= v33) {
						f7.sort(function(v32, v33) {
							return v32 - v33
						});
						// 오름차순
					} else {
						f7.sort(function(v32, v33) {
							return v33 - v32
						});
						// 내림차순
					}// end if

					var data = google.visualization.arrayToDataTable([
							[ v31, f7[0], f7[1], f7[2], f7[3] ],
							[ v26, f6[0], f6[1], f6[2], f6[3] ],
							[ v21, f5[0], f5[1], f5[2], f5[3] ],
							[ v16, f4[0], f4[1], f4[2], f4[3] ],
							[ v11, f3[0], f3[1], f3[2], f3[3] ],
							[ v6, f2[0], f2[1], f2[2], f2[3] ],
							[ v1, f1[0], f1[1], f1[2], f1[3] ] ], true);
					var options = {
						legend : 'none',
						bar : {
							groupWidth : '100%'
						}, // Remove space between bars.
						candlestick : {
							fallingColor : {
								strokeWidth : 0,
								fill : '#1d14a5'
							}, // red
							risingColor : {
								strokeWidth : 0,
								fill : '#a52714'
							}
						// green
						},
						colors : [ 'black' ]
					};
					var chart = new google.visualization.CandlestickChart(
							document.getElementById('chart_div'));
					chart.draw(data, options);
				}//enddrawChart		
			});//end ready
</script>
</head>
<body>
	<center>
		<h4>${ANALYSIS_BIO[0].name }</h4>
		<table border="3">
			<tr>
				<td>일자</td>
				<td>종가</td>
				<td>전일비</td>
				<td>등락률</td>
				<td>거래량</td>
				<td>외인비율</td>
			</tr>
			<c:forEach items="${ANALYSIS_BIO}" var="vo">
				<tr>
					<td>${vo.date}</td>
					<td>${vo.price}</td>
					<c:if test="${vo.updn2 == 1}">
						<td style="color: blue;"><img
							src="http://localhost:8081/phn/resources/img/ico_down.gif">
							${vo.yst}</td>
					</c:if>
					<c:if test="${vo.updn2 == 2}">
						<td style="color: Red;"><img
							src="http://localhost:8081/phn/resources/img/ico_up.gif">
							${vo.yst}</td>
					</c:if>
					<c:if test="${vo.updn2 == 3}">
						<td style="color: black;">${vo.yst}</td>
					</c:if>
					<c:if test="${vo.updn2 == 1}">
						<td style="color: blue;">${vo.updn}</td>
					</c:if>
					<c:if test="${vo.updn2 == 2}">
						<td style="color: Red;">${vo.updn}</td>
					</c:if>
					<c:if test="${vo.updn2 == 3}">
						<td style="color: black;">${vo.updn}</td>
					</c:if>
					<td>${vo.trade}</td>
					<td>${vo.forein}</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<div id="chart_div" style="width: 500px; height: 300px;"></div>
		<input type="button" value="이전페이지로" onClick="history.go(-1)"><br />
		<img src="http://localhost:8081/phn/resources/img/money.png">
		<table border="1" style="visibility: hidden;">
			<tr>
				<th>종목명</th>
				<th>일자</th>
				<th>시가</th>
				<th>종가</th>
				<th>고가</th>
				<th>저가</th>
			</tr>
			<c:forEach items="${GRAPH_BIO}" var="vo" varStatus="s">
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
</body>
</html>