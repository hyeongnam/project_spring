<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<style>
body {
	background-image:
		url("http://localhost:8081/phn/resources/img/home.jpg");
		height: 100%; 

	  /* Center and scale the image nicely */
  	background-position: center;
  	background-repeat: no-repeat;
  	background-size: cover;
}

header {
}

h1 {
	color: white;
	text-align: center;
}

p {
	color: red;
	text-align: center;
	font-size: 18px;
	text-align: center;
}

div {
	color: white;
	text-align: center;
	font-size: 18px;
}

</style>
<title>PHN</title>
</head>
<body>
	<header>
		<h1>주식 저평가 추천 프로젝트!!</h1>
		<P>현재시간은 ${serverTime}.</P>
		<div>
			<form action="middle" method="get">
				테마주 선택 <select name="theme" id="phn">
					<option value="1">대표IT주</option>
					<option value="2">바이오주</option>
					<option value="3">교육주</option>
					<option value="4">신소재주</option>
					<option value="5">2차전지주</option>
				</select> <input type="submit" value="클릭">
			</form>
		</div>
	</header>
</body>
</html>
