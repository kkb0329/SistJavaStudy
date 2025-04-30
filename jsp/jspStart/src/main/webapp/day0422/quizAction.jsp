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
	  String name=request.getParameter("s_name");
	  String area=request.getParameter("cbarea");
	  String ipsaday=request.getParameter("ipsaday");
	  String gift=request.getParameter("gift");
	  String food=request.getParameter("food");
	  String [] lang=request.getParameterValues("lang");
	  String b_col=request.getParameter("bg_color");
  %>
  
  <div style="background-color: <%=b_col%>">
    <h3><%=name %> 사원님의 선택결과</h3>
    <br>
    <h5>입사일자: <%=ipsaday %></h5>
    <h5>근무지역: <%=area==null?"국내근무중":"해외근무중" %></h5>
    <h5>원하는 명절선물: </h5>
    <img alt="" src="<%=gift%>" width="100"><br>
    <h5>가장 선호하는 점심메뉴: </h5>
      <img alt="" src="../image/Food/<%=food%>.jpg" width="100">
     <h5>가능언어:
        <%
           if(lang==null){%>
        	   <b>구현가능한 IT언어 없음</b>
           <%}else{
        	   
        	   for(String it:lang){%>
        		   <b><%=it %></b>
        	   <%}%>
        	   총<%=lang.length %>개의 언어사용이 가능합니다
           <%}
     
        %>
     </h5>
  </div>
  
  
</body>
</html>