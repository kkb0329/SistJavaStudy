<%@page import="data.dao.MemberDao"%>
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
  String num=request.getParameter("num");
  String pass=request.getParameter("pass");
  
  //dao
  MemberDao dao=new MemberDao();
  
  //!-- 비번체크후 맞을경우 삭제후 메인으로,틀릴경우 경고 이전페이지로.. 
  boolean b=dao.isEqualPass(num, pass);
  
  if(b){
	  dao.deleteMember(num);%>
	  
	  <script type="text/javascript">
	    alert("회원탈퇴성공~~");
	   	location.href='../index.jsp';
	  </script>
  <%}else{%>
	  <script type="text/javascript">
	  alert("비밀번호가 맞지않습니다");
	  history.back();
	  </script>
  <%}
  
%>
</body>
</html>