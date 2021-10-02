<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>일반적인 경우의 방법</h3>
<img src="<%=request.getContextPath() %>/images/황소윤.jpg"><br>
<hr>
<h3>이미지 폴더가 웹서비스 영역 밖에 있을 경우</h3>
<img src="<%=request.getContextPath() %>/images/imagesView.do?fileName=황소윤.jpg">
</body>
</html>