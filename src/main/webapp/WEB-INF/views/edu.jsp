<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<script src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
<style>
body {
	background-image: url("http://localhost:8081/phn/resources/img/beach.jpg");
 	/* Full height */
  	height: 100%; 

	  /* Center and scale the image nicely */
  	background-position: center;
  	background-repeat: no-repeat;
  	background-size: 1200px 1200px;
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
</head>

<body>
<center>
<h4>테마별 주식 분석 테이블(종목별분석은 종목명을 클릭하세요.)</h4>
<table border="3">
<tr>
	<th>종목명</th>
	<th>종가</th>
	<th>거래량</th>
	<th>per</th>
	<th>pbr</th>
	<th>외인비율</th>
	<th>일자</th>
	<th>이슈</th>
	<th>추천순위</th>
</tr>	
<c:forEach items="${EDU}" var="vo">
<tr>
	<td><a href = "name_analysis_edu?name=${vo.name}">${vo.name}</a></td>
	<td>${vo.price}</td>
	<td>${vo.trade}</td>
	<td>${vo.per}</td>
	<td>${vo.pbr}</td>
	<td>${vo.forein}</td>
	<td>${vo.date}</td>
	<td><a href = "https://search.naver.com/search.naver?where=news&query=${vo.name}">${vo.issue}</a></td>
	<td>${vo.rank}</td>
</tr>
</c:forEach>
</table><br/>
<input type="button" value="이전페이지로" onClick="history.go(-1)"><br/>
<img src="http://localhost:8081/phn/resources/img/money.png">
</body>
</html>