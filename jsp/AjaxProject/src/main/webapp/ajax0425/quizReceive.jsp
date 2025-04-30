<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   //front에서 보낸 데이타 읽어오기
   String photono=request.getParameter("photono");
	String photofood=request.getParameter("photofood");
	String score1=request.getParameter("score1");
	String score2=request.getParameter("score2");
	String score3=request.getParameter("score3");
	
	//총점...String을 int로 변환
	int tot=Integer.parseInt(score1)+Integer.parseInt(score2)+Integer.parseInt(score3);
	double avg=tot/3.0;
	
	//front형태로 만들엇 front로 보내기
	JSONObject ob=new JSONObject();
	ob.put("photo", "../image/Food/"+photono+".jpg");
	ob.put("photofood", photofood);
	ob.put("tot",tot);
	ob.put("avg",avg);
%>
<%=ob.toString()%>