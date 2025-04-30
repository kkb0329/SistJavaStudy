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
   String name=request.getParameter("name");
   String pw=request.getParameter("pass");
   String driverlic=request.getParameter("licdriver");
%>

<h4>결과값 출력<br>
이름: <%=name %><br>
비밀번: <%=pw %><br>
운전면허: <%=driverlic==null?"없음":"있음" %>
</h4>
</body>
</html>