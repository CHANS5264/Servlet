
<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src = "<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<title>글 수정</title>
<style>
#but1{
	margin-left : 35%;
}
.listForm{
	width : 70%;
	margin-top : 20px;
	height : 500px;
	margin-left : 20%;
}
.pad{
    width : 20%;
}
hr{
	border : 2px solid lightgray;
	width : 40%;
	padding-left : 200px;
	margin-left : 150px;
}
h2{
	margin-left : 15%;
	padding-left : 220px;
}
#upt{
	padding-bottom : 5%;
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
   
    border-radius: 4px;
    user-select: none;
}
.save{
   color: #333;
   	background-color: #fff;
   	border-color: #ccc;
   
   	
}

</style>
<script>
$(function(){
	$('#list').on('click', function(){
		location.href=('board/index.jsp');
	})
})
</script>
<%
	BoardVO vo = (BoardVO)request.getAttribute("vo");
%>
<body>

<div class="container listForm">
<form class="form-horizontal" action="/webBoard/BoardUpdate.do" >

<div id="upt">
<h2>글 수정</h2>
<hr> 

	<input type="hidden" name = "board_no" value="<%=vo.getBoard_no()%>">
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">제목</label>
    <div class="col-sm-5">
      <input type="text" style="width:600px" class="form-control" id="sub1" name="board_title" value="<%=vo.getBoard_title()%>">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="text" >내용 </label>
    <div class="col-sm-5">
      <textarea class="form-control" rows="35" style="width:600px" id="cont1" name="board_content"><%=vo.getBoard_content().replaceAll("\r\n", "\n")%></textarea>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="text" >작성자</label>
    <div class="col-sm-5">
      <textarea class="form-control" style="width:600px" id="writer" name="board_writer"><%=vo.getBoard_writer()%></textarea>
    </div>
  </div>
  
  <div id="but1">
	<button type="submit" class="save savebtn" id="write">저장</button>
	<button type="button" class="save savebtn" id="list">목록으로</button>
  </div>
</div>
<div class = "pad">
</div>
</form>
 </div>
</body>
</html>