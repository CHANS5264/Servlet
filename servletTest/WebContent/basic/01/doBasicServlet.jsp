<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Servlet 요청 연습</h1><hr>
	
	<h2>GET방식 요청하기1 ==> 링크 방식</h2>
	<a href="http://localhost/servletTest/servletTest03.do">Get방식 요청</a><br><br>
	
	<h2>GET방식으로 요청하기2 ==> Form태그의 method속성을 생략하거나 'get'으로 설정한 경우</h2>
	<form action="http://localhost/servletTest/servletTest03.do">
		<input type="submit" value="Get방식 요청">
	</form>
	
	<h2>POST방식으로 요청하기 ==> Form태그의 method속성을 생략하거나 'post'으로 설정한 경우</h2>
	<form action="http://localhost/servletTest/servletTest03.do" method="post">
		<input type="submit" value="Post방식 요청">
	</form>
	
	
	
	
	
</body>
</html>