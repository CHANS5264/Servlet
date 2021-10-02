<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 데이터 Ajax로 처리하기</title>
<script type="text/javascript" src = "<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
$(function(){
	$("#strBtn").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONTest2.do",
			type : "post",
			data : "choice=str",
			success : function(data){
				$('#result').html(data);
			},
			dataType : "json"
		});
	});
	
	$("#objBtn").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONTest2.do",
			type : "post",
			data : "choice=obj",
			success : function(data){
				
				var str = "<h3>SampleVO객체 결과</h3>";
				str += " ID : " + data.id + "<br>";
				str += " 이름 : " + data.name + "<br>";
				
				$('#result').html(str);
			},
			dataType : "json"
			
		});
	});
	
	
})


</script>
</head>
<body>

<form>
	<input type="button" id="strBtn" value="문자열">
	<input type="button" id="arrayBtn" value="배 열">
	<input type="button" id="objBtn" value="객 체">
	<input type="button" id="listBtn" value="리스트">
	<input type="button" id="mapBtn" value="Map객체">
</form>
<hr>

<h3>응답결과</h3>
<div id="result"></div>
</body>
</html>









