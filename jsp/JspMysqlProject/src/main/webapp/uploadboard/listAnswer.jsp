<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mysql.cj.xdevapi.JsonArray"%>
<%@page import="uploadboard.UboardAnswerDto"%>
<%@page import="java.util.List"%>
<%@page import="uploadboard.UboardAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String num=request.getParameter("num");
  UboardAnswerDao dao=new UboardAnswerDao();
  List<UboardAnswerDto> list=dao.getAnswerList(num);
  
  JSONArray arr=new JSONArray();
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
  
  for(UboardAnswerDto dto:list)
  {
	  JSONObject ob=new JSONObject();
	  
	  ob.put("idx", dto.getIdx());
	  ob.put("num", dto.getNum());
	  ob.put("nickname", dto.getNickname());
	  ob.put("content", dto.getContent());
	  ob.put("writeday", sdf.format(dto.getWriteday()));
	  
	  arr.add(ob);
  }
%>

<%=arr.toString()%>