<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<style>
.but{
	text-align : center;
}
</style>
<body>
<!-- 세션의 값을 확인하여 로그인 관련 정보를 가져온다. -->

<%
	// JSP문서에서 세션은 'session'이라는 이름으로 저장되어 있다.
	String sessionId = (String)session.getAttribute("id");

	// 위의 'id'가 세션에 저장되어 있지 않으면 null이 반환된다.
	
	HttpSession sessions = request.getSession();
	String sessionValue = (String)session.getAttribute("log");
	if(sessionId == null){
		sessionId = "";
	}
	
	
	if(sessionValue == null){


%>


<form action="<%=request.getContextPath() %>/sessionLogin.do" method="post">
<table border='1'>
  <tr>
  	<td>ID : </td>
  	<td><input type="text" value="<%=sessionId%>" name="id"></td>
  </tr>
  
  <tr>
  	<td>PASS : </td>
  	<td><input type="password" name="pass"></td>
  </tr>
  
  <tr>
  	<td colspan="2" class="but"><input type="submit" value="Login" ></td>
  </tr>
</table>
</form>
</body>
</html>
<%
	 }else{
%>
		 <h2><%= sessionId %>님 반갑습니다.</h2><br><br> 
		 <a href='<%=request.getContextPath() %>/sessionLogout.do'>로그아웃</a>
		 </body></html>
<%
	}
		       
%>








