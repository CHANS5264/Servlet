<%@page import="kr.or.ddit.basic.fileupload.UploadDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ImageList</title>
</head>
<body>
<h1>imageList</h1>
<%
   String uploadPath = "d:/contents";

   File fileUploadDir = new File(uploadPath);
   
   if(!fileUploadDir.exists()) {
      fileUploadDir.mkdirs();   
   }

   File[] allFiles = fileUploadDir.listFiles();
   List<UploadDetail> fileList = new ArrayList<UploadDetail>();
%>
<form action = "/servletTest/imageList">
<select name = "image">   
<%
      for(File file : allFiles) {
         if(file.isFile()) {
      UploadDetail detail = new UploadDetail();
      detail.setFileName(file.getName());
      detail.setFileSize((long)Math.ceil(file.length()/1024.0));
      detail.setUploadStatus("Uploaded");
      fileList.add(detail);
   %>   

<option id = "image" value=<%= detail.getFileName()%>><%= detail.getFileName() %></option>
<%
         }
      }
%>
</select>
<button type = "submit">보기</button>
</form>
</body>
</html>