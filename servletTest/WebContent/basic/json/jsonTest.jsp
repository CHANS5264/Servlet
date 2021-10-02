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
			url : "<%=request.getContextPath()%>/JSONTest.do",
			type : "post",
			data : "choice=str",
			success : function(data){
				$('#result').html(data);
			},
			dataType : "json"
		});
	});
	
	//--------------------------------------
	
	$("#arrayBtn").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONTest.do",
			type : "post",
			data : "choice=array",
			success : function(data){
				
				var str = "";
				
				$.each(data, function(i, v){
					str += i + "번째 자료 : " + v + "<br>"
				});
				
				$('#result').html(str);
			},
			dataType : "json"
		});
	});
	
	//--------------------------------------
	
	$("#objBtn").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONTest.do",
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
	
	//--------------------------------------
	
	$("#listBtn").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONTest.do",
			type : "post",
			data : "choice=list",
			success : function(data){
				
				var str = "<h3>List객체 결과</h3>";
				$.each(data, function(i,v){
					str += i + "번째 ID : " + v.id + "<br>";
					str += i + "번째 이름 : " + v.name + "<hr>";
				});
				
				$('#result').html(str);
			},
			dataType : "json"
		});
	});
	
	//--------------------------------------
	
	$("#mapBtn").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/JSONTest.do",
			type : "post",
			data : "choice=map",
			success : function(data){
				
				var str = "<h3>List객체 결과</h3>";
				
				/* 
				//방법1
				//data가 Map이거나 객체일 경우에 변수 i에는 변수명 또는 key값이 문자열로 저장되고
				//변수 v에는 '변수에 저장된 데이터 값'이나 'value값'이 저장된다.
				$.each(data, function(i,v){
					str += i + " : " + v + "<br>";
					
				});
				*/
				
				//방법2
				str += "이름 : " + data.name + "<br>";				 
				str += "전화 : " + data.tel + "<br>";				 
				str += "주소 : " + data.addr + "<br>";				 
				
				$('#result').html(str);
				
			},
			dataType : "json"
		});
	});
	
	
});

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
