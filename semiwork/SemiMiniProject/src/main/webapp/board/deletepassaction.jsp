<%@page import="data.dao.BoardDao"%>
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
<%
  String num=request.getParameter("num");
  String pass=request.getParameter("pass");
  
  BoardDao dao=new BoardDao();
  
  //비밀번호 체크후
  boolean flag=dao.isEqualPass(num, pass);
  
  if(flag){ //맞으면 삭제후 목록으로 이동
	  
	  dao.deleteBoard(num); 
	  response.sendRedirect("../index.jsp?main=board/boardlist.jsp"); 
  }else{%>
	  <script type="text/javascript">
	    alert("비밀번호가 맞지않습니다");
	    history.back();
	  </script>
  <%}
%>
<body>

</body>
</html>