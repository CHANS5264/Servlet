<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 카운터 연습</title>
</head>
<body>
<a href="<%=request.getContextPath() %>/cookieCountServlet.do">cookie count 증가하기</a><br><br>

<a href="<%=request.getContextPath() %>/cookieCountDelServlet.do">cookie count 초기화하기</a><br><br>

</body>
</html>