<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ajaxmemo.MemoDto"%>
<%@page import="ajaxmemo.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  MemoDao dao=new MemoDao();
  String num=request.getParameter("num");
  MemoDto dto=dao.getData(num);
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
  
  JSONObject ob=new JSONObject();
  ob.put("num", dto.getNum());
  ob.put("writer", dto.getWriter());
  ob.put("content", dto.getContent());
  ob.put("emot", dto.getEmot());
  ob.put("writeday", sdf.format(dto.getWriteday()));
  
%>

<%=ob.toString()%>