<%@page import="data.dao.GuestAnswerDao"%>
<%@page import="data.dto.GuestAnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
  request.setCharacterEncoding("utf-8");
  GuestAnswerDto dto=new GuestAnswerDto();
  dto.setNum(request.getParameter("num"));
  dto.setMyid(request.getParameter("myid"));
  dto.setContent(request.getParameter("content"));
  String currentPage=request.getParameter("currentPage");
  
  //db
  GuestAnswerDao dao=new GuestAnswerDao();
  dao.insertGuestAnswer(dto);
  
  //목록
  response.sendRedirect("../index.jsp?main=guest/guestlist.jsp?currentPage="+currentPage);
%>
</body>
</html>