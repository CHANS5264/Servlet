<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response객체 연습</title>
</head>
<body>
<h2>forward, sendRedirect 연습</h2>
<hr>
<form method="post" action="/servletTest/ResponseTest01.do"> 
	forward 연습 : <input type="text" name="username">
	<input type="submit" value="확인">
</form>

<hr>

<form method="post" action="/servletTest/ResponseTest02.do">
	sendRedirect 연습 : <input type="text" name="username">
	<input type="submit" value="확인">
</form>


</body>
</html>