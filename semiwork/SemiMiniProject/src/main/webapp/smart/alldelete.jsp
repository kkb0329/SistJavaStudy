<%@page import="data.dao.SmartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //nums읽는다
  String nums=request.getParameter("nums");
  //,로 분리해서 배열로 담기
  String [] num=nums.split(",");
  //그갯수만큼 delete
  SmartDao dao=new SmartDao();
  
  for(String n:num)
  {
	  dao.deleteSmart(n);
  }
  //목록으로 이동
  response.sendRedirect("../index.jsp?main=smart/selist.jsp");

%>