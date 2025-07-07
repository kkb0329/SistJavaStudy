<%@page import="data.dao.GuestDao"%>
<%@page import="java.io.File"%>

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
  //num,currentpage
  String num=request.getParameter("num");
  String currentPage=request.getParameter("currentPage");
  
  //dao
   GuestDao dao=new GuestDao();
   
  //num에 해당하는 photo얻기
  String photo=dao.getData(num).getPhoto();
  //save폴더
  String realPath=getServletContext().getRealPath("/save");
  //파일객체생성
  File file=new File(realPath+"\\"+photo);
  //파일삭제
  file.delete();
  
  //db삭제
  dao.deleteGuest(num);
  //목록으로이동
  response.sendRedirect("../index.jsp?main=guest/guestlist.jsp?currentPage="+currentPage);
%>
</body>
</html>