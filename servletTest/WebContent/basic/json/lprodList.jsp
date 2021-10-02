<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
	아래 버튼을 클릭하면 Oracle의 Lprod 테이블의 전체 목록을 가져와 출력하시오.
	(자료를 가져오는 것은 Servlet에서 처리해서 ajax를 이용해서 가져온다.)
	 서블릿 이름 : LprodListServlet, URL매핑 : /lprod/LprodList.do)
 -->

<script type="text/javascript" src = "<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>

<script type="text/javascript">

$(function(){
	$("#lprodBtn").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/lprod/LprodList.do",
			type : "post",
			success : function(data){
				
				var htmlCode = "<table border='1'>";
				htmlCode += "<tr><td>Lprod_Id</td><td>Lprod_Gu</td><td>Lprod_Nm</td></tr>";
				
				$.each(data, function(i, v){
					
					htmlCode += "<tr><td>" + v.lprod_id + "</td>";
					htmlCode += "<td>" + v.lprod_gu + "</td>";
					htmlCode += "<td>" + v.lprod_nm + "</td></tr>";
					
				})
				htmlCode += "</table>";
				
				$('#result').html(htmlCode);
			},
			dataType : "json"
		});
	});
	
});

</script>

</head>
<body>

<form>
	<input type="button" id="lprodBtn" value="Lprod 자료 가져오기">
</form>
<h2>Lprod 자료 목록</h2>
<div id="result"></div>
</body>
</html>