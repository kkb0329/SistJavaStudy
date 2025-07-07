<%@page import="org.json.simple.JSONObject"%>
<%@page import="data.dao.GuestAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String idx=request.getParameter("idx");
  GuestAnswerDao adao=new GuestAnswerDao();
  String content=adao.getGuestAnswerData(idx);
  
  JSONObject ob=new JSONObject();
  ob.put("idx", idx);
  ob.put("story",content);
%>
<%=ob.toString()%>