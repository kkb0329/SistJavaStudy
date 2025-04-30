<%@page import="gaip.GaipDao"%>
<%@page import="gaip.GaipDto"%>
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

  String name=request.getParameter("name");
  String age=request.getParameter("age");
  String hp=request.getParameter("hp1")+"-"
  			+request.getParameter("hp2")+"-"
		  	+request.getParameter("hp3");
  String birth=request.getParameter("birth");
  String [] lang=request.getParameterValues("lang1");
  
  String my="";
  if(lang==null)
	  my="no";
  else{
	  for(int i=0;i<lang.length;i++){
		  my+=lang[i]+",";
	  }
	  my=my.substring(0, my.length()-1);//마지막,제거
  }
  
  //dto로 값을 묶어서
  GaipDto dto=new GaipDto();
  dto.setName(name);
  dto.setAge(age);
  dto.setHp(hp);
  dto.setBirth(birth);
  dto.setLang(my);
  
  
  //insert메서드 호출
  GaipDao dao=new GaipDao();
  dao.insertGaip(dto);
  
  //목록으로이동
  response.sendRedirect("gaipList.jsp");
%>
</body>
</html>