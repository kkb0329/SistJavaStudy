<%@page import="mymall.MymallDao"%>
<%@page import="mymall.MymallDto"%>
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
  request.setCharacterEncoding("utf-8");

  String sangpum=request.getParameter("sangpum");
  String photo=request.getParameter("photo");
  String color=request.getParameter("color");
  int price=Integer.parseInt(request.getParameter("price"));
  String ipgoday=request.getParameter("ipgoday");
  String num=request.getParameter("num");
  
  //dto
  MymallDto dto=new MymallDto();
  dto.setSangpum(sangpum);
  dto.setPhoto(photo);
  dto.setColor(color);
  dto.setPrice(price);
  dto.setIpgoday(ipgoday);
  dto.setNum(num);
  
  //dao
  MymallDao dao=new MymallDao();
  //update호출
  dao.updateMall(dto);
  
  //목록
  response.sendRedirect("detailPage.jsp?num="+num);
%>
</body>
</html>