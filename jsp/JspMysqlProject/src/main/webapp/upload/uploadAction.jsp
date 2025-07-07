<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
  ServletContext context=getServletContext();
  String realFolder=context.getRealPath("save");
  
  System.out.println(realFolder);
  
  int filesize=1024*1024*5;
  
  MultipartRequest multi=null;
  
  try{
  multi=new MultipartRequest(request,realFolder,filesize,"utf-8",new DefaultFileRenamePolicy());
  
	  String name=multi.getParameter("name");
	  String title=multi.getParameter("subject");
	  String uploadFile=multi.getFilesystemName("uploadFile");
	  String originalName=multi.getOriginalFileName("uploadFile");%>
	  
	  <div>
	     <h3>이름:  <%=name %></h3>
	     <h5>제목:  <%=title %></h5>
	     <img alt="" src="../save/<%=uploadFile%>">
	     <h5>원래파일명: <%=originalName %></h5>
	     <button type="button" onclick="location.href='uploadForm.jsp'">다시업로드</button>
	  </div>
	  
  
  <%}catch(Exception e){
	  
  }
%>
</body>
</html>