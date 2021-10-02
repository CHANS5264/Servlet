<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC_BOARD 상세보기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src = "<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<!-- Q&A상세보기 JSP -->
<style>
  .table {
    border-collapse: collapse;
    border-top: 1px solid gray;
    width : 100%;
  }  
  .table th {
    color: black;
    background: white;
    text-align: center;
    width : 70px;
    font-weight: normal;
  }
  .table th, .table td {
    padding: 10px;
    border: 1px solid #ddd;
  }
  .table th:first-child, .table td:first-child {
    border-left: 0;
  }
  .table th:last-child, .table td:last-child {
    border-right: 0;
  }
  .table tr td:first-child{
    text-align: center;
  }
  .table caption{caption-side: bottom; display: none;}
  
  #cont{
  	margin-left : 60px;
  	margin-top: 10px;
  	margin-bottom: 30px;
  }

  #sub{
  	width: 100%;
  	margin-bottom: 200px;
  	padding-bottom : 30px;
	height : auto;
  }
  #titlep{
  	font-size: 22px;
  	margin-left : 50px;
  	font-weight: bold;
  	margin-top : 10px;
  }
  #but{
  	margin-left : 35%;
  	margin-top : 20%;
  	margin-bottom : 0%;
  }

#send{
	height : 50px;
	margin-left : 35%;
	margin-top : 10px;
}


#qn{
	border : 1px solid lightgray;
	border-radius: 2em;
	margin-top : 10%;
	margin-left : 30%;
	margin-right : 30%;
	height : 500px;
}
	.savebtn{
		margin : 1px;
		display: inline-block;
	    margin-bottom: 0;
	    font-weight: 400;
	    text-align: center;
	    white-space: nowrap;
	    vertical-align: middle;
	    touch-action: manipulation;
	    cursor: pointer;
	    background-image: none;
	    border: 1px solid transparent;
	    padding: 5px 12px;
	    font-size: 14px;
	    background-color: #3CAEFF;
	    color : white;
	    border-radius: 4px;
	    user-select: none;
	}
	.save{
	   color: #333;
    	background-color: #fff;
    	border-color: #ccc;
    
    	
	}

p{
	margin-left : 10px;
	font-size : 15px;
}

  </style>
<%
	BoardVO vo = (BoardVO)request.getAttribute("detail");

%>

</head>

<script>
$(function(){
	$("#upd").on("click", function(){
		var form = $("#boardForm").get(0);
		form.action = "<%=request.getContextPath()%>/BoardUpdate2.do";
		form.submit(); 
	});
	
	$('#list').on('click', function(){
		location.href= ('board/index.jsp');
	})
	
	$('#del').on('click', function(){
	
		location.href = "<%=request.getContextPath()%>/BoardDelete.do?no=<%=vo.getBoard_no()%>";
		
	})
})
	

</script>

<body>
	<div id="modifyForm" style = "display: none;">
  		<textarea rows="8"  style="width:800px" class="form-control"></textarea><br>
  		<input type="button" id="ok" value="확인" class="btn btn-default"> 
  		<input type="button" id="cancle" value="취소" class="btn btn-default"> 
	</div>

<form id="boardForm" >
	<input type="hidden" id="board_no" name="board_no" value="<%=vo.getBoard_no()%>">
</form>

<div id="sub">
<div id="qn">
<p id = "titlep"><%=vo.getBoard_title().replaceAll(" ", "&nbsp;") %></p>
 <table class="table">
    <tr><th>작성자</th><td id = "id"><%=vo.getBoard_writer() %></td></tr>
    <tr><th>날짜</th><td><%=vo.getBoard_date().substring(0, 10) %></td></tr>	
    <tr><th>조회수</th><td><%=vo.getBoard_cnt() %></td></tr>	
  </table>

<div id="cont"> 
 	<%=vo.getBoard_content().replaceAll("\r\n", "<br>") %>
</div>
		 
		
<div id="but">

	<button type="submit" class="btn btn-default" id="upd">수정</button>
	<button type="submit" class="btn btn-default" id="del">삭제</button>
	<button type="button" class="btn btn-default" id="list">목록으로</button>

</div>
</div>
</div>
</body>
</html>


