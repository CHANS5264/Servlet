<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<style>
table{
	padding : 0px 50px;
}

</style>
<body>

	<!-- <label>ID  :  </label><input type="text" class="id" placeholder="ID를 입력하세요.">
	<br>
	<label>PASS  :  </label><input type="text" class="pass" placeholder="PassWord를 입력하세요.">
	<br>
	<input type="checkbox">id 기억하기<br>
	<input type="button" value="Login"> -->
<%
// 쿠키값으로 id값 가져오기
String cookieUserId = "";	// 쿠키값이 저장될 변수
String chk = "";	// 쿠키 박스 체크용 변수


Cookie[] cookies = request.getCookies();
if(cookies!=null){
	for(Cookie cookie : cookies){
		if("ID".equals(cookie.getName())){
			cookieUserId = cookie.getValue();	// 쿠키에 저장된 id값 가져오기
			chk = "checked";
		}
	}
}

%>	
	
	
<form action="<%=request.getContextPath() %>/CookieLoginServlet.do" method="post">
 <table>
   <tr>
   	<td>ID : </td>
   	<td><input type="text" name="userid" value="<%=cookieUserId %>" placeholder="ID를 입력하세요."></td>
   </tr>
 	
   <tr>
   	<td>PASS : </td>
   	<td><input type="password" name="pass" placeholder="PassWord를 입력하세요."></td>
   </tr>
   
   <tr>
    <td colspan="2" style="text-align:center"><input type="checkbox" name="chkid" <%=chk %> value="check">id 기억하기</td><br>
   </tr>
   
   <tr>
    <td colspan="2" style="text-align:center">
    <input type="submit" value="Login"></td>
   </tr>
   	
 </table>

</form>
</body>
</html>