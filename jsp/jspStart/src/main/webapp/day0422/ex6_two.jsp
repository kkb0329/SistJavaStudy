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
%>
<h2>이문장이 보일까?</h2>
<jsp:forward page="ex6_two_forward.jsp">
  <jsp:param value="이영자" name="name"/>
  <jsp:param value="010-222-5555" name="hp"/>
</jsp:forward>
</body>
</html>