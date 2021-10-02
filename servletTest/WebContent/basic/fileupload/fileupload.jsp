<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet을 이용한 파일 업로드 연습</title>
</head>

<body>
<h1>File Upload 연습</h1>
<h3>파일 선택 창에서 드래그나 'CTRL + Click' 또는 'Shift + Click'으로 여러개 파일 선택 가능</h3>
<!-- 
	파일을 전송할때 <form>태그 구성하는 방법
	1. method는 반드시 'post'이어야 한다.
	2. enctype속성에 'multipart/form-data'를 반드시 지정해야한다.
 -->
<form method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/file/FileUploadServlet.do"><!-- 파일업로드는 무조건 post방식 -->
<table border='1'>
<tr>
	<td>ID : </td>
	<td> <input type="text" name="memid"></td>
</tr>

<tr> 
	<td>파일업로드1 : </td>
	<td> <input type="file" name="fileup1" multiple></td> <!-- multiple은 파일이 여러개 선택가능 없으면 하나 -->
</tr>

<tr>
	<td>파일업로드2 : </td>
	<td> <input type="file" name="fileup2"></td>
</tr>
	<td colspan="2" style="text-align:center;"><input class="but" type="submit" value="파일 업로드하기"></td>
</table>

	
</form>
<br><hr><br>
<a href="<%=request.getContextPath()%>/file/UplodFileList.do">전체 Upload파일 보기</a>















</body>
</html>