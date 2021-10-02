<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css' rel='stylesheet' type='text/css'>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
.pag1{
	width : 80%;
	margin-left : 45%;
}
.listform{
	width : 100%;
	margin-top : 5%;
	margin-left : 25%;
} 
th{
	text-align : center;
}
.td1{
	text-align : center;
}
#write{
	margin-left : 98%;
}
a:link{
    color : black;	
}
a:visited{
    color : black;
}
hr{
	border-top : 4px double #5F9EA0;
	width : 180px;
	margin-top : 2px;
}
a{
	color : black;
}
#list{
	margin-top: 60px;
}
#listInfo{
    width : 60%;
}
#ch{
	/* font-family: 'Do Hyeon', sans-serif; */
	font-family: 'Noto Sans KR', sans-serif;
	font-size : 37px;
	font-weight : bolder;
	margin-bottom : 1px;
}
#top{
	text-align : center;
	margin-bottom : 30px;
}
#pageList{
	margin-left: 50%;
}
#search{
	margin-left : 65%;
	margin-top : 5%;
}
#sear{
	margin-left : 20%;
}
</style>
<% 
	BoardVO vo = (BoardVO)request.getAttribute("board_title");
%>
<script>
currentPage = 1;

$(function(){
	 readNotice = function(page){
			//Q&A 목록 보기
			$.ajax({
				url : '/webBoard/BoardListServlet.do',
				method : 'post',
				data : {"page" : page},
				success : function(res){
					console.log(res)
					code = '<div class="container listform">';
					code += '	<div id="top">';
					code +=	'	<p id="ch">BOARD</p>';
					code += '	<hr>';
					code += '	</div>';
					code +=	'  <table class="table table-hover">';
					code +=	'    <thead>';
					code +=	'      <tr>';
					code +=	'        <th width="40px" >번호</th>';
					code +=	'        <th width="200px">제목</th>';
					code +=	'        <th width="60px">작성자</th>';
					code +=	'        <th width="60px">날짜</th>';
					code +=	'        <th width="40px">조회수</th>';
					code +=	'      </tr>';
					code +=	'    </thead>';
					code +=	'	    <tbody>';
					
					$.each(res.datas, function(i, v){
						code += '<tr>';
						code += '<td class="td1">' + v.no + '</td>';
						code += '<td><a href = "/webBoard/BoardDetail.do?board_no=' + v.no +'"class = "tt" >' + v.title + '</a></td>';
						code += '<td class="td1">' + v.writer + '</td>';
						code += '<td class="td1">' + v.date.substr(0, 10) + '</td>';
						code += '<td class="td1">' + v.cnt + '</td>';
						code += '</tr>';	
					})
					
					code +=	'    </tbody>';
					code +=	'  </table>';
					code +=	'</div>';
					
					$('#list').html(code);
					
					pages = '<div class="pag1">';
					
					//페이지 리스트 만들기
					pages+='<nav aria-label="Page navigation example">';
					
					//이전버튼 <
					if(res.sp > 1){
						pages+='  <ul class="pagination">';
						pages+='    <li class="pre">';
						pages+='      <a class="before" href="#" aria-label="Previous">';
						pages+='        <span aria-hidden="true">&laquo;</span>';
						pages+='      </a>';
						pages+='   </li>';
						pages+='  </ul>';
					}
					pages+='  <ul class="pagination">';
					//페이지 번호 출력
					for(i=res.sp; i<=res.ep; i++){
						//현재 페이지와 i값이 같은지
						if(currentPage == i){
							pages+='    <li class="page-item"><a class="nowPage" href="#">' + i + '</a></li>';
						}else{
							pages+='    <li><a class="nowPage" href="#">' + i + '</a></li>';
						}
					}
					pages+='  </ul>';
					
					//다음 버튼 만들기 >
					if(res.ep < res.tp){
						pages+='  <ul class="pagination">';
						pages+='    <li class="next">';
						pages+='      <a class="next" href="#" aria-label="Next">';
						pages+='        <span aria-hidden="true">&raquo;</span>';
						pages+='      </a>';
						pages+='    </li>';
						pages+='  </ul>';
					}
					pages+='</nav>';
					pages+='</div>';
					
					$('#pageList').html(pages);
				},
				
				error : function(xhr){
					alert("상태 : " + xhr.status);
				},
				dataType : 'json'
				
			})
		};
		
		readNotice(1);
		
		//페이지번호
		 $("#pageList").on('click', '.nowPage', function(){
			 currentPage = $(this).text().trim();
			 
			 readNotice(currentPage);
			 
		 })
		
		//이전버튼
		 $("#pageList").on('click', '.before', function(){
			 vnext = $('.nowPage').first().text().trim();
			 currentPage = parseInt(vnext) - 1;
			 readNotice(currentPage);
			 
		 })
		 
		 //다음버튼
		 $("#pageList").on('click', '.next', function(){
			 vnext = $('.nowPage').last().text().trim();
			 currentPage = parseInt(vnext) + 1;
			 
			 readNotice(currentPage);
			 
		 })
		 
		 //상세보기
		 $('#list').on('click', '.tt', function(){
		 	vidx = $(this).attr('idx');
		 })
		 
		 $('#write').on('click', function(){
			location.href = '<%=request.getContextPath()%>/BoardinsertForm.do';
	 	 })
		
	 	$('#sear').on('click', function(){
			title = $('#search-title').val();
			console.log(title);
			$.ajax({
				url: '/webBoard/BoardSearch.do',
				type: 'get',
				data: {"board_title": title},
				success: function(res){
					code = "<table border='1'><tr><th class='board_no'>No</th><th class='board_title'>제목</th><th class='board_writer'>작성자</th><th class='board_cnt'>조회수</th></tr>";
					$.each(res, function(i, v){
						no = v.board_no;
						title = v.board_title;
						code += "<tr class='tr-board'><td class='board_no'>" + no + "</td>";
						code += "<td class='board_title'><a class='a-title' onclick=\"location.href='./BoardDetail.jsp?board_no=" + no + "&board_title=" + title + "'\">" + title + "</a></td>";
						code += "<td class='board_writer'>" + v.board_writer + "</td>";
						code += "<td class='board_cnt'>" + v.board_cnt + "</td></tr>";
					});
					code += "</table>";
					code += "<button id='back' type='button'>뒤로가기</button>";
					$('#list').html(code);
				},
				error: function(xhr){
					alert(xhr.status);
				},
				dataType: 'json'
			});
		});
})




</script>

</head>

<body>

<div>
</div>
<div id = "listInfo">
<div id="list"></div>
<div id="pageList"></div>

<button type="button" class="btn btn-default" id="write">글쓰기</button>	

<div class="form-group" id="search">
	<div class="col-sm-5">
	      <input type="text" name="board_title" style="width:200px" class="form-control" id="search-title" placeholder="제목을 입력하세요.">
	</div>
	<button type="submit" class="btn btn-default" id="sear">검색</button>
</div>
</body>
</html>