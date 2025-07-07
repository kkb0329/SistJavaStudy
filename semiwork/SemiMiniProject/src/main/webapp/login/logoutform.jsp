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
<div style="margin: 50px 100px;">
 <img alt="" src="image2/K-057.png" width="400"><br><br>
 <%
   //세션으로부터 아이디를 얻기
   String myid=(String)session.getAttribute("myid");
 
   //db에서 id에 해당하는 이름얻기
   MemberDao dao=new MemberDao();
   String name=dao.getName(myid);
 
 %>
 <b><%=name %>님 로그인중</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <button type="button" class="btn btn-danger"
 onclick="location.href='login/logoutaction.jsp'">로그아웃</button>
</div>
</body>
</html>