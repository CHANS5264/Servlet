<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<BoardVO> list = (List<BoardVO>)request.getAttribute("boardList");
int spage = (Integer)request.getAttribute("sp");
int epage = (Integer)request.getAttribute("ep");
int tpage = (Integer)request.getAttribute("tp");
String id = (String)request.getAttribute("id");

%>

{
	"tp" : "<%= tpage %>",
	"ep" : "<%= epage %>",
	"sp" : "<%= spage %>",
	"datas" : [

<% 	for(int i = 0; i < list.size(); i++){
		BoardVO vo = list.get(i);
		if(i > 0) out.print(",");

%>
	{
		"no" : "<%= vo.getBoard_no() %>",
		"title" : "<%= vo.getBoard_title() %>",
		"content" : "<%=vo.getBoard_content().replaceAll("\r\n", "<br>") %>",
		"date" : "<%= vo.getBoard_date() %>",
		"cnt" : "<%= vo.getBoard_cnt()%>",
		"writer" : "<%=vo.getBoard_writer() %>"
	
		
		
	}


<%
	}
%>
  ]

}